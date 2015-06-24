<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-bordered">
        <tr>
            <th>Brand</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Characteristics</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.brand}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>
                    <form action="/products/${product.id}/delete"
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