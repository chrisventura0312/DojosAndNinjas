<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col">
                <h1 class="text-center mb-4">Dojo Details</h1>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <h2 class="text-center">Students in ${dojo.name}</h2>
            </div>
        </div>
        <div class="table-responsive d-flex justify-content-center">
            <table class="table table-bordered mt-4" style="max-width: 50%">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Age</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dojo.ninjas}" var="ninja">
                        <tr>
                            <td>${ninja.firstName}</td>
                            <td>${ninja.lastName}</td>
                            <td>${ninja.age}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
    </div>
    <div class="col text-center">
        <a href="/" class btn btn-primary>Back to Home</a>
    </div>
    <div class="row mt-5">
        <div class="col text-center">
            <a href="/ninjas/new" class="btn btn-primary">Add New Ninja</a>
        </div>
    </div>
</body>
</html>
