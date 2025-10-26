import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import axios from 'axios'
import './App.css'


function App() {
  const [count, setCount] = useState(0)
  const [message, setMessage] = useState('Loading...')

  useEffect(() => {
    axios.get('http://localhost:8080/hello')
      .then(res => setMessage(res.data))
      .catch(() => setMessage('Error connecting to backend'))
  }, [])

  return (
    <>
      <div className="min-h-screen bg-gradient-to-br from-blue-500 to-purple-600 flex items-center justify-center">
        <h1 className="text-4xl font-bold text-white">
          Tailwind CSS is Working! 🎉
        </h1>
      </div>
    </>
  )
}

export default App
