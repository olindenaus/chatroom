import React, { useEffect, useRef, useState } from "react";
import MessageList from "./MessageList";
import MessageInput from "./MessageInput";
import type { Message } from "../types";
import NicknameModal from "./NicknameModal";
import { Client } from "@stomp/stompjs";

const ChatRoom: React.FC = () => {  
  const [nickname, setNickname] = useState<string | null>(
  localStorage.getItem("nickname")
);
  const clientRef = useRef<Client | null>(null);
  const [messages, setMessages] = useState<Message[]>([]);

  useEffect(() => {
    fetch("/api/messages")
      .then(res => res.json())
      .then((data: Message[]) => setMessages(data))
      .catch(err => console.error("Fetch error:", err));
       const client = new Client({
            brokerURL: "ws://192.168.1.3:8080/api/ws", // direct backend connection
            reconnectDelay: 5000,
            debug: (str) => console.log(str),
          });

          client.onConnect = () => {
            console.log("STOMP connected");
            client.subscribe("/topic/messages", (msg: any) => {
              const body: ChatMessage = JSON.parse(msg.body);
              setMessages((prev) => [...prev, body]);
            });
          };

      client.onWebSocketError = (error) => {
          console.error('Error with websocket', error);
      };

      client.onStompError = (frame) => {
          console.error('Broker reported error: ' + frame.headers['message']);
          console.error('Additional details: ' + frame.body);
      };

          client.activate();
          clientRef.current = client;

          return () => {
            client.deactivate();
          };
  }, []);

  const handleSendMessage = async (text: string) => {
    if (!nickname) return;

    const newMessage: Message = {
      text: text,
      nickname: nickname,
      createdAt: Date.now(),
    };

    if (!text || !nickname || !clientRef.current) return;
     clientRef.current.publish({
       destination: "/app/chat",
       body: JSON.stringify(newMessage),
     });
  };

  const handleNicknameSave = (nick: string) => {
    localStorage.setItem("nickname", nick);
    setNickname(nick);
  };

  return (
    <div className="flex flex-col w-full max-w-md h-[80vh] bg-white shadow-lg rounded-xl overflow-hidden relative">
      {!nickname && (
        <NicknameModal onSave={handleNicknameSave} />
      )}
      <div className="flex-1 overflow-y-auto p-4">
        <MessageList messages={messages} />
      </div>
      <div className="border-t p-2">
        <MessageInput onSend={handleSendMessage} />
      </div>
    </div>
  );
};

export default ChatRoom;
