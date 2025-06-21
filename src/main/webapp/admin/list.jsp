<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.example.grocery.model.GroceryItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin || GroceryItem</title>
</head>
<body>
    <h1>GroceryItem Management</h1>

    <table border="1">
        <thead>
            <tr>
                <th>pid</th>
                <th>name</th>
                <th>category</th>
                <th>price</th>
                <th>stocks</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<GroceryItem> items = (List<GroceryItem>) request.getAttribute("groceryItems");
                if (items != null) {
                    for (GroceryItem item : items) {
            %>
                <tr>
                    <td><%= item.getPid() %></td>
                    <td><%= item.getName() %></td>
                    <td><%= item.getCatagory() %></td>
                    <td><%= item.getPrice() %></td>
                    <td><%= item.getStocks() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="5">No Grocery Items Found</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
