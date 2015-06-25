<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form action="/products/new" method="post"
           modelAttribute="product"
           cssClass="form-group">
    <div class="form-group">
        <label for="brand">Brand</label>
        <form:input path="brand" cssClass="form-control" />
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
        <form:button class="btn btn-success">Add</form:button>
    </div>
</form:form>