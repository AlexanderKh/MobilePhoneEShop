<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-bordered">
    <tr>
        <th>Name</th>
        <th>Parameter</th>
    </tr>
    <c:forEach var="characteristic" items="${characteristics}">
        <tr>
            <td>${characteristic.name}</td>
            <td>${characteristic.parameter}</td>
        </tr>
    </c:forEach>
</table>