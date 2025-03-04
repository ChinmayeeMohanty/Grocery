import axios from "axios"
import { useState,useEffect } from "react"





const GroceryList = () => {
    const [items,setItems]=useState([]);
    useEffect(
        ()=>{
            axios.get("http://localhost:8080/")
            .then(response => setItems(response.data))
            .catch(error=>console.error("error fetching data",error))
        },[]
       
    )
    
    return(
        <>
        <div>
            <h2>Grocery Items</h2>
            <div style={styles.container}>
                    {items.map(item=>(
                    <div key={item.pid} style={styles.card}>
                        <h3>{item.name}</h3>
                        <p>{item.catagory}</p>
                        <p><b>{item.price}</b></p>
                        <button  style={styles.button}>Add cart</button>
                    </div>))}
            </div>
        </div>

        </>
    );
}


const styles={
    container: {
        display: "flex",
        flexWrap: "wrap",
        gap: "20px",
        justifyContent: "center",
        padding: "20px"
      },
      card: {
        backgroundColor: "#f8f9fa",
        padding: "15px",
        borderRadius: "8px",
        boxShadow: "0 4px 8px rgba(0, 0, 0, 0.2)",
        width: "200px",
        textAlign: "center"
      },
      button: {
        backgroundColor: "#28a745",
        color: "white",
        padding: "8px 12px",
        border: "none",
        borderRadius: "5px",
        cursor: "pointer",
        marginTop: "10px"
      }
}





export default GroceryList;