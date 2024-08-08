import './App.css'
import ListBooksComponents from './components/content/ListBooksComponents'
import Navbar from './components/scaffold/Navbar'
import HomePage from './HomePage'

function App() {

  return (
    <>
      <Navbar/>
      <HomePage/>
      <ListBooksComponents/>
    </>
  )
}

export default App
