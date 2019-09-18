<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>

<div>
<br>
<h2 align="center" style="font-family: Georgia Italic;color: blue;">Admin Dashboard</h2>
<br>
<h3 align="center" style="font-family:Lucida Console;color: green;">Welcome  ${pageContext.request.userPrincipal.name}</h3>
</div>

<div style="padding-top: 470px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>