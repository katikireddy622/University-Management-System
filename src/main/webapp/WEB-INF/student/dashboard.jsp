<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>

<div>
<br>
<h2 align="center" style="font-family: Georgia Italic;color: blue;">Student Dashboard</h2>
<br>
<h3 align="center" style="font-family:Lucida Console;color: green;">Welcome  ${pageContext.request.userPrincipal.name}</h3>
</div>
<br>
<br>
<center><div align="center" class="col-lg-4" style="background-color:#FCF6F1;">

<h3 style="font-family: Trebuchet MS Bold;">Present Sem Attendance</h3>
<a class="nav-link" href="${pageContext.request.contextPath}/student/attendance/presentSem"><button type="button" class="btn btn-secondary">Click Here..</button></a>
   <strong> <h2 style="font-family: Trebuchet MS Bold; color: orange;">${attendance}</h2> </strong>
</div></center>
<br>
<div class="container progress">
    <div class="progress-bar progress-bar-striped progress-bar-animated" style="width:${attendance}%"></div>
  </div>
<div style="padding-top: 250px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>