import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import ChatRoom from "./components/ChatRoom";
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
   <div className="h-screen flex items-center justify-center bg-gray-100">
        <ChatRoom />
      </div>
    </>
  )
}

export default App
