<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h3>
  Select product you want to buy
</h3>
<table class="table table-bordered">
  <tr>
    <th>Brand</th>
    <th>Name</th>
    <th>Price</th>
  </tr>
  <c:forEach var="product" items="${possibleProducts}">
    <tr>
      <td>${product.brand}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>
        <form action="/customers/${customerID}/purchases/${purchaseID}/orders/new"
              method="post"
              style="margin-bottom: 0px">
          <input type="hidden" name="productID" value="${product.id}">
          <button type="submit"
                  class="btn btn-xs btn-default">
            Buy
          </button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>