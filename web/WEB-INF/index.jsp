<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link href="<c:url value="/WEB-INF/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body class="container">
    <table class="table table-bordered">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Characteristics</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>
                    <a href="<c:url value="${product.id}"/>" class="btn btn-xs btn-info">Show Characteristics</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
