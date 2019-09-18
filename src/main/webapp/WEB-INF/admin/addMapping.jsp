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
		<div class="col-md-6 col-md-4 border border-primary">
		<br>
		<label style="color: green;"><strong>${message}</strong></label>
		<form:form method="post"
          action="${pageContext.request.contextPath}/admin/mapping/add" modelAttribute="mapping">
             <table>
             
                <tr>
                    <td><form:label path="mayear">Academic Year</form:label></td>
                    <td><form:select class="form-control" path = "mayear">
  						       <form:options items = "${prasentAcademicYearList}" />
						   </form:select></td>
                    <td style="color:red"><form:errors path="mayear" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="mfid">Faculty Id</form:label></td>
                    <td><form:select class="form-control" path = "mfid">
  						      
  						       <form:options items = "${facultysList}" />
						   </form:select></td>
                    <td style="color:red"><form:errors path="mfid" cssClass = "error"/></td>
                    
                </tr>
                <tr>
                    <td><form:label path="mcid">Course Id</form:label></td>
                     	<td><form:select class="form-control" path = "mcid">
  						       <form:options items = "${coursesList}" />
						   </form:select>
					  </td>
                    <td style="color:red"><form:errors path="mcid" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="myear">Year</form:label></td>
                     	<td><form:select  class="form-control" path = "myear">
  						      <form:option value = "0" label = "Select"/>
  						       <form:options items = "${presentYearList}" />
						   </form:select>
					  </td>
                    <td style="color:red"><form:errors path="myear" cssClass = "error"/></td>
                </tr>
                <tr>
                    <td><form:label path="msem">Semester</form:label></td>
                    <td><form:select class="form-control" path = "msem">
  						      <form:option value = "0" label = "Select"/>
  						       <form:options items = "${presentSemesterList}" />
						   </form:select></td>
                    <td style="color:red"><form:errors path="msem" cssClass = "error"/></td>
                    
                </tr>
                
                <tr>
                    <td><form:label path="msec">Section</form:label></td>
                    <td><form:select class="form-control" path = "msec">
  						       <form:options items = "${presentSectionList}" />
						   </form:select></td>
                    <td style="color:red"><form:errors path="msec" cssClass = "error"/></td>
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

	
	<div style="padding-top: 200px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>