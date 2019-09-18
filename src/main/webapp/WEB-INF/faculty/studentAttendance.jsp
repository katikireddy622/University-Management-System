<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*" %>
    <%@ page import = "javax.servlet.*,java.text.*" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		
		<link href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	    		rel="stylesheet">
		<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<script type="text/javascript">	
		function showAlert(){
  				if($("#myAlert").find("div#myAlert2").length==0){
    					$("#myAlert").append("<div class='alert alert-success alert-dismissable' id='myAlert2'> <button type='button' class='close' data-dismiss='alert'  aria-hidden='true'>&times;</button> Success! Attendance Updated successfully.</div>");
  							}
  						$("#myAlert").css("display", "");
				}
		</script>
		
<title>Faculty Dashboard</title>
</head>
<body>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>
	
	
	<div class="container" style="display:none;" id="myAlert">
        <div class="alert alert-success alert-dismissable" id="myAlert2">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            Success! Attendance Updated successfully.
        </div>
	</div>
	

<div class="container">
<form action="${pageContext.request.contextPath}/faculty/attendance/both" method="Post">
  <input type = "hidden" name = "cid" value = "${cid}"/>
  <input type = "hidden" name = "year" value = "${year}"/>
  <input type = "hidden" name = "sem" value = "${sem}"/>
  <input type = "hidden" name = "ayear" value = "${ayear}"/>
  <input type = "hidden" name = "sec" value = "${sec}"/>
  
  <table class="table">
     <thead class="thead-light">
      <tr>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Present</th>
        <th>Absent</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${listOfStudents}" var="mapping">
      <tr>
       	<td>${mapping[0]}</td>
        <td>${mapping[1]}</td>
        <td>
            <label class="form-check-label" for="prasentList">
                 <input type="checkbox" class="form-check-input" id="prasentList" name="prasentList" value="${mapping[0]}">Prasent
            </label>
        </td>
        <td>
            <label class="form-check-label" for="absentList">
                 <input type="checkbox" class="form-check-input" id="absentList" name="absentList" value="${mapping[0]}">Absent
            </label>
        </td>
      </tr>
     </c:forEach>
     	
    </tbody>
  
  </table>
  
  
  
  <div align="center" >
  
  <div class="col-xs-3">
  		
  		<label for="numberOfClasses">Date & Time:</label>
           		<%
         Date dNow = new Date( );
         SimpleDateFormat ft = 
         new SimpleDateFormat ("E dd-MM-yyyy 'at' hh:mm:ss a");
         out.print( "<h4 style=\"color:violet;\"align=\"center\">" + ft.format(dNow) + "</h4>");
  			    %>
  
  </div>
  </div>
  <div align="center" >
  <div align="center" class="col-sm-4">
           		<label for="numberOfClasses">Enter No Of Classes:</label>
    			<input type="number" class="form-control" id="numberOfClasses" name="numberOfClasses">
  
  </div>
  </div>
  <div style="padding-top: 15px;" align="center">
 <button value="showAlert" onclick="showAlert();" type="submit" class="btn btn-outline-success">Submit</button>
  </div>
  
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 
</form>

</div>
	
	
	
	
<div style="padding-top: 510px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>