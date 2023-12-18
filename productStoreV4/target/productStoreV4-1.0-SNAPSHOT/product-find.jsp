<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Product</h2>
<table>
    <tr>
        <th>productID</th>
        <th>productName</th>
        <th>price</th>
        <th>quantity</th>

    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.productID}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>

        </tr>
    </c:forEach>
</table>