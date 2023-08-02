<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div class="container mt-5 " style="max-width:400px">
        <h1 class="text-center mb-4">Create New Ninja</h1>
        <form:form action="/ninjas/add" method="post" modelAttribute="ninja">
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <form:errors path="firstName" cssClass="text-danger" /> 
                <form:input path="firstName" id="firstName" class="form-control" />
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <form:errors path="lastName" cssClass="text-danger" />
                <form:input path="lastName" id="lastName" class="form-control" />
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <form:errors path="age" cssClass="text-danger" /> 
                <form:input path="age" id="age" class="form-control" />
            </div>
            <div class="form-group">
                <label for="dojo">Select Dojo:</label>
                <form:errors path="dojo.id" cssClass="text-danger" /> 
                <form:select path="dojo.id" id="dojo" class="form-control">
                    <form:option value="" label="Select a Dojo" />
                    <form:options items="${dojos}" itemValue="id" itemLabel="name" />
                </form:select>
            </div>
            <div class="text-center mt-4">
                <input type="submit" value="Create Ninja" class="btn btn-primary" />
            </div>
            <div class="text-center mt-4">
                <a href="/" class="btn btn-secondary">Back to Home</a>
            </div>
        </form:form>
    </div>
</body>
</html>
