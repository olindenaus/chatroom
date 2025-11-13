import React from "react";
import { Message } from "../types";

interface Props {
  messages: Message[];
}

const MessageList: React.FC<Props> = ({ messages }) => {
  return (
    <div className="space-y-2">
      {messages.map((msg, i) => (
        <div key={i} className="p-2 bg-gray-100 rounded-md">
          {msg.text}
        </div>
      ))}
    </div>
  );
};

export default MessageList;
