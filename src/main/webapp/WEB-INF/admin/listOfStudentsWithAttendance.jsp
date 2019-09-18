<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>

<div class="container">
 
  <table class="table">
    <thead class="thead-light">
      <tr>
        <th>Student Id</th>
        <th>Attendance</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${hm}" var="student">
      <tr>
       	<td>${student.key}</td>
        <td>${student.value}</td>
        </tr>
     </c:forEach>
    </tbody>
  </table>
</div>


<div style="padding-top: 470px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>