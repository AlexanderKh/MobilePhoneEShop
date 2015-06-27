<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!hasUnresolvedPurchase}">
    <form action="/customers/${customer.id}/purchases/new"
          style="margin-bottom: 0px"
          method="post">
        <button type="submit"
                class="text-center list-group-item list-group-item-success btn-block">
            Buy
        </button>
    </form>
</c:if>