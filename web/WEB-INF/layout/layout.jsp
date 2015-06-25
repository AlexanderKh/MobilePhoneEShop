<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="include"/>
</head>
<body class="container">
<tiles:insertAttribute name="header" />
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="list-group nav sidebar-nav">
                <tiles:insertAttribute name="sidebar" />
            </div>
            <hr>
            <div class="list-group nav sidebar-nav">
                <tiles:insertAttribute name="active" />
            </div>
        </div>
        <div class="col-sm-9 col-md-10">
            <tiles:insertAttribute name="body" />
        </div>
    </div>
    <footer>
        Виконали ШЕВА І САНЬОК
    </footer>
</body>
</html>