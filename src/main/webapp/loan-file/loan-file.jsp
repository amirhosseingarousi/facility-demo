
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Loan File</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5">
        <a class="navbar-brand" href="#">Loan File Management</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/FacilitiesDemo_war_exploded/">Home <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
    </nav>
</header>

    <div class="container">
        <div class="card">
            <div class="card-body">
                <form action="proceed">
                    <div class="form-group row">
                        <label for="customernumber" class="col-sm-2 col-form-label">Customer number</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="customerNumber" id="customernumber" placeholder="Customer number">
                        </div>
                        <button type="submit" class="btn btn-primary mb-2">Confirm</button>
                    </div>

                    <c:if test="${customer != null}">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="firstName">First name</label>
                                <input type="text" value="<c:out value="${customer.firstName}" />" class="form-control" name="minAmount" id="firstName" placeholder="first name" readonly>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="lastName">Last name</label>
                                <input type="text" value="<c:out value="${customer.lastName}" />" class="form-control" name="maxAmount" id="lastName" placeholder="last name" readonly>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${loanList != null}">
                        <div class="form-group col-2">
                            <label for="exampleFormControlSelect1">Loan select</label>
                            <select class="form-control" id="exampleFormControlSelect1">
                                <c:forEach var="loan" items="${loanList}">
                                    <option value="${loan.id}"><c:out value="${loan.name}" /></option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
