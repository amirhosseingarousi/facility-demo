<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5">
        <a class="navbar-brand" href="#">Private Customer Management</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/FacilitiesDemo_war_exploded/">Home <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
    </nav>
    </header>

<div class="container col-9">
    <div class="row">
        <div class="container mb-3">
            <h3 class="text-center mb-4">List of Customers</h3>
            <hr>
            <div class="container text-left mt-5">
                <a class="btn btn-success" href="private-customer-form.jsp" role="button">Add New Customer</a>
            </div>
        </div>
<%--        href="<%=request.getContextPath()%>/privatecustomer/new"--%>
    </div>

    <c:if test="${listCustomer.size() == 0}">
        <h3 class="text-center">There is no customer</h3>
    </c:if>

    <c:if test="${listCustomer.size() != 0}">
    <table class="table table-striped center">
        <thead class="thead-dark">
            <tr>
                <th class="text-center">First name</th>
                <th class="text-center">Last name</th>
                <th class="text-center">Date of birth</th>
                <th class="text-center">Number</th>
                <th class="text-center">Actions</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="customer" items="${listCustomer}">
                <tr>
                    <td class="text-center">
                        <c:out value="${customer.firstName}"/>
                    </td>
                    <td class="text-center">
                        <c:out value="${customer.lastName}"/>
                    </td>
                    <td class="text-center">
                        <c:out value="${customer.dob}"/>
                    </td>
                    <td class="text-center">
                        <c:out value="${customer.number}"/>
                    </td>
                    <td class="text-center">
                        <a href="edit?id=<c:out value="${customer.id}" />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value="${customer.id}" />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </c:if>
</div>
</body>
</html>
