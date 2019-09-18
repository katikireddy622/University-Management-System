<%@ page language="java" contentType="text/html; charset=IsO-8859-1"
    pageEncoding="IsO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>
	
	
		<div class="container" align="center">
		<br>
		<br>
		<div class="col-sm-6 col-md-4 border border-primary">
		<br>
		<label style="color: green;"><strong>${message}</strong></label>
		<form:form method="post"
          action="${pageContext.request.contextPath}/admin/course/add" modelAttribute="course">
             <table>
                <tr>
                    <td><form:label path="cid">Course Id</form:label></td>
                    <td><form:input class="form-control" path="cid"/></td>
                    <td style="color: red;"><form:errors path="cid" cssClass = "error"/></td>
                	
                </tr>
                
                <tr>
                    <td><form:label path="cname">Course Name</form:label></td>
                    <td><form:input class="form-control" path="cname"/></td>
                    <td style="color:red"><form:errors path="cname" cssClass = "error"/></td>
                </tr>
                
    
            </table>
            <div  style="padding-top: 15px;">
            <center><button type="submit" class="btn btn-outline-success">Submit</button></center>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form:form>
        <br>
	</div>
	</div>

<div style="padding-top: 350px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>
	
	