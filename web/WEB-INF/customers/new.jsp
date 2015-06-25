<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form action="/customers/new" method="post"
           modelAttribute="customer"
           cssClass="form-horizontal">
    <div class="form-group">
        <label for="name">Name</label>
        <form:input path="name" cssClass="form-control" />
    </div>
    <div class="form-group">
        <label for="surname">Price</label>
        <form:input path="surname" cssClass="form-control" />
    </div>
    <div class="form-group">
        <label for="account">Quantity</label>
        <form:input path="account" cssClass="form-control" />
    </div>
    <div class="form-group">
        <form:button class="btn btn-success">Add</form:button>
    </div>
</form:form>