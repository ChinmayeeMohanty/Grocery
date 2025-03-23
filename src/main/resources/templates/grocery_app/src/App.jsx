
import './App.css'
import GroceryList from './components/GroceryList'
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
      <GroceryList/>
    </>
  )
}

export default App
