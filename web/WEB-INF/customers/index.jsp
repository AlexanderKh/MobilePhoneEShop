<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-bordered">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Account</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.surname}</td>
                <td>${customer.account}</td>
                <td>
                    <a href="<c:url value="/customers/${customer.id}"/>" class="btn btn-xs btn-info">Purchases</a>
                </td>
                <td>
                    <form action="/customers/${customer.id}/delete"
                          style="margin-bottom: 0px"
                          method="post">
                        <button type="submit"
                                class="btn btn-xs btn-danger"
                                onclick="return confirm('Are you sure?')">
                            Delete
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>