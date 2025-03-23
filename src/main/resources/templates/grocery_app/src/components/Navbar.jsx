import React from 'react'
import {Link } from "react-router-dom"

function Navbar() {
  return (
    <nav>
      <Link to="/">Home</Link>
      <Link to="/products">ProductDetails</Link>
      <Link to="/checkout">Checkout</Link>
    </nav>
  )
}

export default Navbar
