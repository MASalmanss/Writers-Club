import './App.css'
import AddBook from './components/content/AddBook'
import ListBooksComponents from './components/content/ListBooksComponents'
import Navbar from './components/scaffold/Navbar'
import HomePage from './HomePage'

function App() {

  return (
    <>
      <Navbar/>
      <HomePage/>
      {/* <ListBooksComponents/> */}
      <AddBook/>
    </>
  )
}

export default App
