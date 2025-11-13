import React, { useEffect, useState } from "react";
import MessageList from "./MessageList";
import MessageInput from "./MessageInput";
import type { Message } from "../types";
import NicknameModal from "./NicknameModal";

const ChatRoom: React.FC = () => {  
  const [nickname, setNickname] = useState<string | null>(
  localStorage.getItem("nickname")
);
  const [messages, setMessages] = useState<Message[]>([]);

  useEffect(() => {
    fetch("/api/messages")
      .then(res => res.json())
      .then((data: Message[]) => setMessages(data))
      .catch(err => console.error("Fetch error:", err));
  }, []);

  const handleSendMessage = async (text: string) => {
    if (!nickname) return;

    const newMessage: Message = {
      text,
      nickname,
      createdAt: Date.now(),
    };

    try {
      await fetch("/api/messages", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newMessage),
      });
      setMessages(prev => [...prev, newMessage]);
    } catch (error) {
      console.error("Failed to send message:", error);
    }
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
