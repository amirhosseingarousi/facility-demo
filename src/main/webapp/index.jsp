
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#"></a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <div class="dropdown">
                        <button class="btn btn-primary btn-lg dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Customer
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/privatecustomer/list">Private Customer</a>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/legalcustomer/list">Legal Customer</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item active">
<%--                    <a class="nav-link" href="<%=request.getContextPath()%>/privatecustomer/list">Private Customer <span class="sr-only">(current)</span></a>--%>
                </li>
                <li class="nav-item active">
                    <div class="dropdown">
                        <button class="btn btn-primary btn-lg dropdown-toggle" type="button" id="dropdownMenuButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Loan
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/loan/list">Loan</a>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/loan-file/loan-file.jsp">Loan File</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item active">
<%--                    <a class="nav-link" href="<%=request.getContextPath()%>/legalcustomer/list">Legal Customer <span class="sr-only">(current)</span></a>--%>
                </li>
                <li class="nav-item active">
<%--                    <a class="nav-link" href="<%=request.getContextPath()%>/loan/list">Loan <span class="sr-only">(current)</span></a>--%>
                </li>
                <li class="nav-item active">
<%--                    <a class="nav-link" href="<%=request.getContextPath()%>/loan-file/loan-file.jsp">Loan File<span class="sr-only">(current)</span></a>--%>
                </li>
            </ul>
        </div>
    </nav>
</header>
</body>
</html>
