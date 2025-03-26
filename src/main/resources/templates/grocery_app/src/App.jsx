
import './App.css'
import Navbar from './components/Navbar'
import GroceryForm from './components/GroceryForm'
import GroceryList from './components/GroceryList'
import ProductDetails from './pages/ProductDetails'
import CheckOut from './pages/CheckOut'
import { Route,Routes } from 'react-router-dom'
function App() {
 

  return (
    <>
    <Navbar/>
     <Routes>
      <Route path='/' element={<GroceryList/>}/>
      <Route path='/product/:id' element={<ProductDetails/>}/>
      <Route path='/checkout' element={<CheckOut/>}/>
     </Routes>
      <GroceryForm/>
    </>
  )
}

export default App
