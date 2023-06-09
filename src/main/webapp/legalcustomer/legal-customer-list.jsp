<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Legal Customer Management</title>
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
    <a class="navbar-brand" href="#">Legal Customer Management</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/FacilitiesDemo_war_exploded/">Home <span class="sr-only">(current)</span></a>
        </li>
      </ul>

      <form action="search" class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" name="name" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
</header>

<div class="container">
<c:if test="${success != null}">
  <div id="success-alert" class="alert alert-success w-50 ml-3" role="alert">
    <strong>Success!</strong>  ${success}
    <c:remove var="success" scope="session" />
  </div>
</c:if>
</div>

<div class="container col-8">
  <div class="row">
    <div class="container mb-3">
      <h3 class="text-center mb-4">List of Customers</h3>
      <hr>
      <div class="container text-left mt-5">
        <a class="btn btn-success" href="legal-customer-form.jsp" role="button">Add New Customer</a>
      </div>
    </div>
  </div>

  <c:if test="${listCustomer.size() == 0}">
    <h3 class="text-center">There is no customer</h3>
  </c:if>

  <c:if test="${listCustomer.size() != 0}">
  <table class="table table-striped center">
    <thead class="thead-dark">
      <tr>
        <th class="text-center">Company name</th>
        <th class="text-center">Register date</th>
        <th class="text-center">Economic code</th>
        <th class="text-center">Number</th>
        <th class="text-center">Actions</th>
      </tr>
    </thead>

    <tbody>
    <c:forEach var="customer" items="${listCustomer}">
      <tr>
        <td class="text-center">
          <c:out value="${customer.companyName}"/>
        </td>
        <td class="text-center">
          <c:out value="${customer.registerDate}"/>
        </td>
        <td class="text-center">
          <c:out value="${customer.economicCode}"/>
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

<script type="text/javascript">
  $("#success-alert").fadeTo(3000, 500).slideUp(500, function(){
    $("#success-alert").slideUp(500);
  });
</script>
</body>
</html>
