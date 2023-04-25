<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Legal Customer Form</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5">
    <a class="navbar-brand" href="/FacilitiesDemo_war_exploded/privatecustomer/list">Legal Customer Management</a>
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
      <form action="update">
        </c:if>
        <c:if test="${customer == null}">
        <form action="insert">
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
              <label for="companyName">Company name</label>
              <input type="text" value="<c:out value="${customer.companyName}" />" class="form-control" name="companyName" id="companyName" placeholder="Company name" required>
            </div>
            <div class="col">
              <label for="registerDate">Register date</label>
              <input type="date" value="<c:out value="${customer.registerDate}" />" class="form-control" name="registerDate" id="registerDate" placeholder="register date" required>
            </div>
          </div>

          <div class="form-group form-row">
            <div class="col">
              <label for="economicCode">Economic code</label>
              <input type="text" value="<c:out value="${customer.economicCode}" />" class="form-control" name="economicCode" id="economicCode" placeholder="Economic code" required>
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
</body>
</html>
