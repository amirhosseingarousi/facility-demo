<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Private Customer Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5">
    <a class="navbar-brand" href="/FacilitiesDemo_war_exploded/privatecustomer/list">Private Customer Management</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>
</header>

<div class="container col-8">
    <div class="card">
        <div class="card-body">
            <c:if test="${customer != null}">
                <form name="customerForm" onsubmit="return validateNationalId()" action="update">
            </c:if>
             <c:if test="${customer == null}">
                <form name="customerForm" onsubmit="return validateNationalId()" action="insert">
             </c:if>

             <caption>
                 <h3 class="mb-4">
                     <c:if test="${customer != null}">
                         Edit Customer
                     </c:if>
                     <c:if test="${customer == null}">
                         Add New Customer
                     </c:if>
                 </h3>
             </caption>
                 <input type="hidden" name="id" value="<c:out value="${customer.id}" />">

                <div class="form-group form-row">
                    <div class="col">
                        <label for="firstName">First name</label>
                        <input type="text" value="<c:out value="${customer.firstName}" />" class="form-control" name="firstName" id="firstName" placeholder="First name" required>
                    </div>
                    <div class="col">
                        <label for="lastName">Last name</label>
                        <input type="text" value="<c:out value="${customer.lastName}" />" class="form-control" name="lastName" id="lastName" placeholder="Last name" required>
                    </div>
                </div>
                <div class="form-group form-row">
                    <div class="col">
                        <label for="fatherName">Father name</label>
                        <input type="text" value="<c:out value="${customer.fatherName}" />" class="form-control" name="fatherName" id="fatherName" placeholder="Father name" required>
                    </div>
                    <div class="col">
                        <label for="dob">Date of Birth</label>
                        <input type="date" value="<c:out value="${customer.dob}" />" class="form-control" name="dob" id="dob" placeholder="Date of Birth" required>
                    </div>
                </div>
                <div class="form-group form-row">
                    <div class="col">
                        <label for="nationalId">National ID</label>
                        <input type="text" value="<c:out value="${customer.nationalID}" />" class="form-control" name="nationalID" id="nationalId" placeholder="National ID" required>
                    </div>
                    <div class="col">
                        <label for="number">Customer number</label>
                        <input type="text" value="<c:out value="${customer.number}" />" class="form-control" name="customerNumber" id="number" placeholder="Customer number" readonly>
                    </div>
                </div>

                <button type="submit" class="btn btn-success mt-3">Save</button>
            </form>
        </div>
    </div>
</div>
<script>
    function validateNationalId() {
        let str = document.forms["customerForm"]["nationalID"].value;

        let flagOne = false
        if(str.length === 10) {
            flagOne = true
        }

        let flagTwo = false;
        let sum = 0;
        let controlNum = Number(str.charAt(str.length-1))

        for (let i = 0; i < str.length - 1; i++) {
            let num = Number(str.charAt(i));
            num *= (10 - i)
            sum += num;
        }

        let remainder = sum % 11
        if (remainder < 2) {
            if (remainder === controlNum) {
                flagTwo = true;
            }
        } else if(controlNum === (11 - remainder)) {
            flagTwo = true;
        }

        if (!flagOne || !flagTwo) {
            alert("National code is invalid")
            return false;
        }

    }
</script>
</body>
</html>
