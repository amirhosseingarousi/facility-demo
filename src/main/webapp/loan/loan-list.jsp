<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Customer Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5">
        <a class="navbar-brand" href="/FacilitiesDemo_war_exploded/loan/list">Loan Management</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/FacilitiesDemo_war_exploded/">Home <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
    </nav>
</header>

<div class="container col-4">
    <div class="row mb-3">
        <div class="container">
            <h3 class="text-center mb-3">List of Loans</h3>
            <hr class="mb-5">
            <div class="container text-left">
                <a class="btn btn-success" href="<%=request.getContextPath()%>/loan/new" role="button">Add New Loan</a>
            </div>
        </div>
    </div>

    <c:if test="${listLoan.size() == 0}">
        <h3 class="text-center">There is no loan</h3>
    </c:if>

    <c:if test="${listLoan.size() != 0}">
    <table class="table table-striped center">
        <thead class="thead-dark">
        <tr>
            <th class="text-center">Name</th>
            <th class="text-center">Rate</th>
            <th class="text-center">Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="loan" items="${listLoan}">
            <tr>
                <td class="text-center">
                    <c:out value="${loan.name}"/>
                </td>
                <td class="text-center">
                    <c:out value="${loan.rate}"/>
                </td>
                <td class="text-center">
                    <a href="edit?id=<c:out value="${loan.id}" />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value="${loan.id}" />">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
</div>
</body>
</html>
