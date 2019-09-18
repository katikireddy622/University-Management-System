<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
 	   	 <a class="navbar-brand" href="/index">Department Management System</a>
 		 
 		 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		 </button>

  		 <div class="collapse navbar-collapse" id="navbarSupportedContent">
    		<ul class="navbar-nav ml-auto">
     				
     				
     				<li class="nav-item">
            				<a class="nav-link" href="${pageContext.request.contextPath}/dashboard"><button type="button" class="btn btn-outline-primary">Home</button></a>
      				 </li>
     				
     				
     				
     				
  					<li class="nav-item dropdown">
    					<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"><button type="button" class="btn btn-outline-info">My Courses</button></a>
    						<div class="dropdown-menu">
      							<a class="dropdown-item" href="/student/course/">My Course</a>
      						</div>
  					</li>
     				
      
                     <li class="nav-item">
            				
            				<c:url value="/logout" var="logoutUrl" />
								<form id="logout" action="${logoutUrl}" method="post" >
  									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								</form>
							<c:if test="${pageContext.request.userPrincipal.name != null}">
									<a class="nav-link" href="javascript:document.getElementById('logout').submit()"><button type="button" class="btn btn-outline-warning">Logout</button></a>
							</c:if>		
            				
            				
            		 </li>
      				 
      				  
      		 </ul>
  		
  		</div>
	
	</nav>
  		
  		
  		
  		
  		
         
	