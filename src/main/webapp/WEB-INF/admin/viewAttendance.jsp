<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>

<div class="container">
 <h3 style="color: green;">${success}</h3>
  <table class="table">
    <thead class="thead-light">
      <tr>
      	<th>Course Id</th>
      	<th>Date</th>
        <th>Course Name</th>
        <th>Attended</th>
        <th>Total</th>
        <th>Update</th>
      </tr>
    </thead>
    <tbody>
    
     <c:forEach items="${list}" var="mapping">
    
      <tr>
        <td>${mapping[0]}</td>
      	<td>${mapping[1]}</td>
        <td>${mapping[2]}</td>
      	<td>${mapping[3]}</td>
        <td>${mapping[4]}</td>
        <td><a href="${pageContext.request.contextPath}/admin/attendance/updateValue?sid=${sid}&cid=${cid}&date=${mapping[1]}&ayear=${ayear}&value=${mapping[4]}"><button type="button" class="btn btn-outline-warning">Update</button></a></td>
       </tr>
     </c:forEach>
    </tbody>
  </table>
</div>

<div align="center" class=" container">
<h3 style="font-family:Lucida Console;color: green;">Attendance Percentage : ${average}</h3>
</div>


<div style="padding-top: 470px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>