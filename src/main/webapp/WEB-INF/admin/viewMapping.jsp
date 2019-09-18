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
        <th>Academic Year</th>
        <th>Faculty Id</th>
        <th>Faculty Name</th>
        <th>Course Id</th>
        <th>Course Name</th>
        <th>Year</th>
        <th>Sem</th>
        <th>Sec</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${listOfObjectsMapping}" var="mapping">
      <tr>
        <td>${mapping[8]}</td>
       	<td>${mapping[0]}</td>
        <td>${mapping[1]}</td>
        <td>${mapping[2]}</td>
        <td>${mapping[3]}</td>
        <td>${mapping[4]}</td>
        <td>${mapping[5]}</td>
        <td>${mapping[6]}</td>
        <td><a href="${pageContext.request.contextPath}/admin/mapping/delete?mid=${mapping[7]}"><button type="button" class="btn btn-outline-danger">Delete</button></a></td>
        </tr>
     </c:forEach>
    </tbody>
  </table>
</div>


<div style="padding-top: 510px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>