import axios from 'axios'
import React,{useState} from 'react'
function GroceryForm() {
   const [groceryItem,setGroceryItem] = useState({
      name:" ",
      catagory:" ",
      price:" ",
      stocks:" ",
   })
   const handleChange = (e) => { 
    setGroceryItem({...groceryItem,[e.target.name]:e.target.value})
   }
   const handleSubmit = async(e) => { 
    e.preventDefault()
    try
    { 
        await axios.post("http://localhost:8080/add",groceryItem);
       alert("item added successfully");
       setGroceryItem({name:" ",catagory:" ",price:" ",stocks:" "});
    }
    catch(error){
        alert("Error adding item");
    }
   }

  return (
  <form onSubmit={handleSubmit}>
    <label for='name' >Product Name</label>
    <input type='text' id='name' name='name' value ={groceryItem.name} onChange={handleChange} required/><br/><br/>
    <label for="catagory" >Catagory</label>
    <input type='text' id='catagory' name='catagory'  value ={groceryItem.catagory} onChange={handleChange} required/><br/><br/>
    <label for="price" >Price</label>
    <input type='text' id='price' name='price'  value ={groceryItem.price} onChange={handleChange} required/><br/><br/>
    <label for="stocks" >Stocks</label>
    <input type='text' id='stocks' name='stocks'  value ={groceryItem.stocks} onChange={handleChange} required/><br/><br/>
    <button type='submit'>Add Item</button>
  </form>
  )
}

export default GroceryForm
