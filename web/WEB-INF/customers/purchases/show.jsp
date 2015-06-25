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
            <td>${order.purchase.brand}</td>
            <td>${order.purchase.name}</td>
            <td>${order.price}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<h4>
    Total sum is ${purchase.sum}
</h4>
<c:if test="${purchase.date == null}">
    <form action="end" method="post"
          class="form-control">
        <button type="submit" class="btn btn-danger">END</button>
    </form>
    <br>
    <form action="new" method="get"
          class="form-control">
        <button type="submit" class="btn btn-success">Add product</button>
    </form>
</c:if>