<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Grant Condition Form</title>
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

    <div class="container mb-5 col-7">
        <div class="card">
            <div class="card-body">
                <form action="insert" method="post">
                    <div>
                        <input type="hidden" name="loanName" value="<c:out value="${name}" />">
                        <input type="hidden" name="loanRate" value="<c:out value="${rate}" />">
                    </div>
                    <div class="form-row mb-3">
                        <label for="conditionName" class="col-sm-2 col-form-label">Name</label>
                        <input type="text" class="form-control" name="conditionName" id="conditionName" placeholder="name" required>
                    </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="minAmount">Minimum Contract Amount</label>
                        <input type="text" class="form-control" name="minAmount" id="minAmount" placeholder="amount" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="maxAmount">Maximum Contract Amount</label>
                        <input type="text" class="form-control" name="maxAmount" id="maxAmount" placeholder="years" required>
                    </div>
                </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="minPeriod">Minimum Contract Period</label>
                            <input type="number" class="form-control" name="minPeriod" id="minPeriod" placeholder="years" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="maxPeriod">Maximum Contract Period</label>
                            <input type="number" class="form-control" name="maxPeriod" id="maxPeriod" placeholder="years" required>
                        </div>
                    </div>

                    <div class="row mt-3">
                        <button type="submit" name="save" value="condition" class="btn btn-success ml-4 mr-2">Save</button>
                        <button type="submit" name="save" value="loan" class="btn btn-success">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="container col-8">
        <table class="table table-striped center">
            <thead class="thead-dark">
                <tr>
                    <th class="text-center">Name</th>
                    <th class="text-center">Min Amount</th>
                    <th class="text-center">Max Amount</th>
                    <th class="text-center">Min Period</th>
                    <th class="text-center">Max Period</th>
                </tr>
            </thead>

            <tbody>
            <c:forEach var="condition" items="${listCondition}">
                <tr>
                    <td class="text-center">
                        <c:out value="${condition.name}"/>
                    </td>
                    <td class="text-center">
                        <c:out value="${condition.minAmount}"/>
                    </td>
                    <td class="text-center">
                        <c:out value="${condition.maxAmount}"/>
                    </td>
                    <td class="text-center">
                        <c:out value="${condition.minYear}"/>
                    </td>
                    <td class="text-center">
                        <c:out value="${condition.maxYear}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
