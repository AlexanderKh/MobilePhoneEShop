<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${purchase.date != null}">
    <h3>
        Products bought on ${purchase.date}
    </h3>
    <hr>
</c:if>
<table class="table table-condensed table-bordered">
    <tr>
        <th>Brand</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.product.brand}</td>
            <td>${order.product.name}</td>
            <td>${order.price}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<h4>
    Total sum is ${purchase.sum}
</h4>
<c:if test="${purchase.date == null}">
    <c:if test="${isCommitable}">
        <form action="/customers/${customer.id}/purchases/${purchase.id}/end" method="post"
              class="form-group">
            <button type="submit" class="btn btn-danger">Order</button>
        </form>
        <form action="/customers/${customer.id}/purchases/${purchase.id}/clear" method="post"
              class="form-group">
            <button type="submit" class="btn btn-warning">Clear</button>
        </form>
    </c:if>
    <form action="/customers/${customer.id}/purchases/${purchase.id}/orders/new" method="get"
          class="form-group">
        <button type="submit" class="btn btn-success">Add new product to basket</button>
    </form>
</c:if>