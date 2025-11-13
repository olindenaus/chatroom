import type { Message } from "../types";

interface Props {
  messages: Message[];
}

const MessageList: React.FC<Props> = ({ messages }) => {
  return (
    <div className="space-y-2">
      {messages.map((msg, i) => (
       <div key={i} className="p-2 bg-gray-100 rounded-md">
       <strong className="text-blue-600 mr-2">{msg.nickname}:</strong>
       {msg.text}
     </div>
      ))}
    </div>
  );
};

export default MessageList;
