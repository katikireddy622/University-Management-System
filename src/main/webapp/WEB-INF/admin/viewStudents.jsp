<%@ page language="java" contentType="text/html; charset=IsO-8859-1"
    pageEncoding="IsO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>


<div class="container-fluid">
 
  <table class="table">
    <thead class="thead-light">
      <tr>
        <th>Id</th>
        <th>Password</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Dob</th>
        <th>Branch</th>
        <th>Year</th>
        <th>Sem</th>
        <th>Sec</th>
        <th>Update</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${listOfStudents}" var="student">
      <tr>
       	<td>${student.sid}</td>
        <td>${student.spw}</td>
        <td>${student.sname}</td>
        <td>${student.semail}</td>
        <td>${student.sphone}</td>    
        <td>${student.saddress}</td>
        <td>${student.sdob}</td>
        <td>${student.sbranch}</td>
        <td>${student.spyear}</td>
        <td>${student.spsem}</td>
        <td>${student.spsec}</td>
        <td><a href="${pageContext.request.contextPath}/admin/student/update?sid=${student.sid}"><button type="button" class="btn btn-outline-warning">Update</button></a></td>
        <td><a href="${pageContext.request.contextPath}/admin/student/delete?sid=${student.sid}&spyear=${student.spyear}&spsec=${student.spsec}&spsem=${student.spsem}"><button type="button" class="btn btn-outline-danger">Delete</button></a></td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>

<div style="padding-top: 510px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>
