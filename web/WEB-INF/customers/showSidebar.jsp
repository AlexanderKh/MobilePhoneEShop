<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${!hasUnresolvedPurchase}">
    <a href="purchases/new" class="text-center list-group-item list-group-item-success">Buy</a>
</c:if>