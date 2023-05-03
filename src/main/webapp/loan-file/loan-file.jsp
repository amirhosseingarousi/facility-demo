
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Loan File</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js">
    </script>

    <!-- Including Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
    </script>
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

<c:if test="${success != null}">
    <div id="success-alert" class="alert alert-success w-50 ml-3" role="alert">
        <strong>Success!</strong>  ${success}
        <c:remove var="success" scope="session" />
    </div>
</c:if>

<c:if test="${fail != null}">
    <div id="success-alert" class="alert alert-danger w-50 ml-3" role="alert">
            <strong>Fail!</strong> ${fail}
        <c:remove var="fail" scope="session" />
    </div>
</c:if>

    <div class="container col-7">
        <div class="card">
            <div class="card-body">
                <form action="proceed">
                    <div class="form-group row">
                        <label for="customernumber" class="col-sm-3 col-form-label">Customer number</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" value="${customer.number}" name="customerNumber" id="customernumber" placeholder="Customer number">
                        </div>
                        <button type="submit" name="confirm" value="confirm" class="btn btn-primary mb-2">Confirm</button>
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
                            <label for="exampleFormControlSelect1">Loan</label>
                            <select name="loanId" class="form-control" id="exampleFormControlSelect1">
                                <c:forEach var="loan" items="${loanList}">
                                    <option value="${loan.id}"><c:out value="${loan.name}" /></option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group form-row">
                            <div class="col">
                                <label for="amount">Amount</label>
                                <input type="text" class="form-control" name="amount" id="amount" placeholder="amount" required>
                            </div>
                            <div class="col">
                                <label for="period">Period</label>
                                <input type="number" class="form-control" name="period" id="period" placeholder="period" required>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${customer != null}">
                        <button type="submit" name="register" value="register" class="btn btn-success">Register</button>
                    </c:if>
                </form>
            </div>
        </div>
    </div>

<script type="text/javascript">
    $("#success-alert").fadeTo(3000, 500).slideUp(500, function(){
        $("#success-alert").slideUp(500);
    });
</script>
</body>
</html>
