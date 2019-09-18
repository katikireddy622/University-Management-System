<%@ page language="java" contentType="text/html; charset=IsO-8859-1"
    pageEncoding="IsO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>
	
<div class="container">
 
  <table class="table">
    <thead class="thead-light">
      <tr>
        <th>Course Id</th>
        <th>Course Name</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${listOfCourses}" var="course">
      <tr>
       	<td>${course.cid}</td>
        <td>${course.cname}</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>



<div style="padding-top: 510px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>