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

<div class="container col-5">
    <div class="card">
        <div class="card-body">
            <form action="grant-condition">
                <div class="form-group form-row">
                    <div class="col">
                        <label for="loanName">Loan name</label>
                        <input type="text" class="form-control" name="loanName" id="loanName" placeholder="name" required>
                    </div>
                    <div class="col">
                        <label for="loanRate">Loan rate</label>
                        <input type="number" step="any" class="form-control" name="loanRate" id="loanRate" placeholder="rate" required>
                    </div>
                </div>

                <button type="submit" class="btn btn-success">Next</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
