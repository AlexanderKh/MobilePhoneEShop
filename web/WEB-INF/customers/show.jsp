<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>
  Hello, ${customer.name} ${customer.surname}
  <span class="pull-right">from ${customer.account}</span>
</h3>
<hr>
<c:if test="${hasUnresolvedPurchase}">
    <h4>
        You have unresolved purchase
        <a href="${customer.id}/purchases/${unresolvedPurchaseID}" class="btn btn-success">Resolve</a>
    </h4>
    <hr>
</c:if>
<table class="table table-condensed table-bordered">
  <tr>
    <th>Date</th>
    <th>Purchase sum</th>
  </tr>
  <c:forEach var="purchase" items="${purchases}">
    <tr>
      <td>${purchase.date}</td>
      <td>${purchase.sum}</td>
        <td>
            <a href="<c:url value="${purchase.id}"/>" class="btn btn-xs btn-info">Show</a>
        </td>
    </tr>
  </c:forEach>
</table>
