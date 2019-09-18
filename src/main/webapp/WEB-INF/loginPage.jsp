<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=IsO-8859-1"
    pageEncoding="IsO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="IsO-8859-1">
<title>Login Page</title>

		<link href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	    		rel="stylesheet">
		<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<link href="/css/custom.css" rel="stylesheet">
		
</head>
<body onload='document.loginForm.username.focus();'>

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
 		 <a class="navbar-brand" href="/index">Department Management System</a>
 		 
 		 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		 </button>

  		 <div class="collapse navbar-collapse" id="navbarSupportedContent">
    		<ul class="navbar-nav ml-auto">
     				
      
                     <li class="nav-item">
            				<a class="nav-link" href="<c:url value='/loginPage' />"><button type="button" class="btn btn-outline-info">Login</button></a>
      				 </li>
      				 
      				  
      		 </ul>
  		
  		</div>
	
	</nav>
		
 

		
<div class="container pt-3">
  <div class="row justify-content-sm-center">
    <div class="col-sm-6 col-md-4">

		<div class="form-group" align="center">
    				<label style="color: red;"><strong>${error}</strong></label>
    				<label style="color: green;"><strong>${message}</strong></label>
        </div>
      <div class="card border-info text-center">
        <div class="card-header">
          Sign in to continue
        </div>
        <div class="card-body">
    
  
          <form  action="<c:url value='/loginPage' />" method="post" class="form-signin">
            <input type="text" name="username" class="form-control mb-2" placeholder="Enter Your User Id" required autofocus>
            <input type="password" name="password" class="form-control mb-2" placeholder="Enter Your Password" required>
            <button class="btn btn-lg btn-primary btn-block mb-1" type="submit">Sign in</button>
           
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />    
          </form>
        </div>
      </div>
      
    </div>
  </div>
</div>

<div style="padding-top: 290px;" class="panel-footer">
<footer class="page-footer font-small blue">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2018 Copyright:
    <a href="#"> KATIKI REDDY RAHUL REDDY</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
</div>

</body>
</html>	








