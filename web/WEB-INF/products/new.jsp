<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="/products/new" method="post" modelAttribute="product" cssClass="form-inline">
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