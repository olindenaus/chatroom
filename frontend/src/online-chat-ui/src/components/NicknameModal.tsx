import React, { useState } from "react";

interface Props {
  onSave: (nickname: string) => void;
}

const NicknameModal: React.FC<Props> = ({ onSave }) => {
  const [nick, setNick] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!nick.trim()) return;
    onSave(nick.trim());
  };

  return (
    <div className="absolute inset-0 bg-black/50 flex items-center justify-center">
      <form
        onSubmit={handleSubmit}
        className="bg-white p-6 rounded-lg shadow-lg flex flex-col gap-3 w-72"
      >
        <h2 className="text-lg font-semibold text-center">
          Choose your nickname
        </h2>
        <input
          type="text"
          className="border rounded-md p-2"
          placeholder="Enter nickname"
          value={nick}
          onChange={(e) => setNick(e.target.value)}
        />
        <button
          type="submit"
          className="bg-blue-500 text-white rounded-md p-2 hover:bg-blue-600"
        >
          Continue
        </button>
      </form>
    </div>
  );
};

export default NicknameModal;
