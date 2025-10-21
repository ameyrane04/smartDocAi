import { useState, useEffect } from 'react'
import axios from 'axios';
import './App.css'

function App() {
  const [message, setMessage] = useState('Loading...')

  useEffect(() => {
    axios.get('http://localhost:8080/hello')
      .then(res => setMessage(res.data))
      .catch(() => setMessage("error connecting to backend."));

  }, [])

  return (
    <>
      <div style={{ textAlign: 'center', marginTop: '2rem' }}>
        <h1>{message}</h1>
      </div>
    </>
  )
}

export default App
