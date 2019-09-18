<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>
	
<div class="container">
 
  <table class="table">
    <thead class="thead-light">
      <tr>
      	<th>Academic Year</th>
        <th>Course Id</th>
        <th>Course Name</th>
        <th>Year</th>
        <th>Semester</th>
        <th>Section</th>
        <th>Attendance</th>
      </tr>
    </thead>
    <tbody>
    
     <c:forEach items="${listOfCourse}" var="mapping">
    
      <tr>
      <td>${mapping[5]}</td>
       	<td>${mapping[0]}</td>
        <td>${mapping[1]}</td>
        <td>${mapping[2]}</td>
        <td>${mapping[3]}</td>
        <td>${mapping[4]}</td>
        <td><a class="nav-link" href="${pageContext.request.contextPath}/faculty/attendance/list?cid=${mapping[0]}&year=${mapping[2]}&sem=${mapping[3]}&sec=${mapping[4]}&ayear=${mapping[5]}"><button type="button" class="btn btn-outline-success">Attendance</button></a></td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>
		
		
		
<div style="padding-top: 510px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>