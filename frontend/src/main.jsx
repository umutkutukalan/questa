import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'

import './index.css'
import Post from './components/Post/Post.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Post />
  </StrictMode>,
)
