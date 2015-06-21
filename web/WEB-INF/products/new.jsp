<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form action="/products/new" method="post"
           modelAttribute="product"
           cssClass="form-horizontal">
    <div class="form-group">
        <label for="brand">Brand</label>
        <%--<form:select path="brand" cssClass="form-control" items="${brands}" />--%>
        <select id="brand" name="brand" class="form-control" >
            <c:forEach var="brand" items="${brands}">
                <option value="${brand.id}">${brand.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="name">Name</label>
        <form:input path="name" cssClass="form-control" />
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <form:input path="price" cssClass="form-control" />
    </div>
    <div class="form-group">
        <label for="quantity">Quantity</label>
        <form:input path="quantity" cssClass="form-control" />
    </div>
    <div class="form-group">
        <form:button class="btn btn-success">Add</form:button>
    </div>
</form:form>