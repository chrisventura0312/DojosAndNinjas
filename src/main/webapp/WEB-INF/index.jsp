<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col">
                <h1 class="text-center">Dojos and Ninjas</h1>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <h2 class="text-center">Dojos</h2>
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-bordered mt-4">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dojos}" var="dojo">
                        <tr>
                            <td>${dojo.name}</td>
                            <td>
                                <a href="/dojos/${dojo.id}" class="btn btn-primary btn-sm">Show</a>
                                <form action="/dojos/${dojo.id}" method="post" style="display: inline;">
                                    <input type="hidden" name="_method" value="delete">
                                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="form mt-4">
            <div class="row">
                <div class="col text-center">
                    <h3>Add a Dojo</h3>
                </div>
            </div>
            <div class="dojoForm" style="max-width: 300px;">
                <form:form action="/dojos/add" modelAttribute="dojo">
                    <div class="form-group">
                        <form:errors path="name" cssClass="text-danger" />
                        <form:input path="name" placeholder="Name" class="form-control" />
                    </div>
                    <button type="submit" class="btn btn-primary">Add</button>
                </form:form>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col text-center">
                <a href="/ninjas/new" class="btn btn-primary">Add New Ninja</a>
            </div>
        </div>
    </div>
</body>
</html>
