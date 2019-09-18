<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>



<div class="container-fluid" align="center">
		
		<label style="color: green;"><strong>${message}</strong></label>
		<form:form method="post"
          action="${pageContext.request.contextPath}/admin/student/add" modelAttribute="student">
             <table>
                <tr>
                    <td><form:label path="sid">Student Id</form:label></td>
                    <td><form:input class="form-control" path="sid"/></td>
                    <td style="color: red;"><form:errors path="sid" cssClass = "error"/></td>
                	
                </tr>
                
                <tr>
                    <td><form:label path="spw">Password</form:label></td>
                    <td><form:password class="form-control" path="spw"/></td>
                    <td style="color:red"><form:errors path="spw" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="sname">
                      Name</form:label></td>
                    <td><form:input class="form-control" path="sname"/></td>
                    <td style="color:red"><form:errors path="sname" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="sphone">Phone</form:label></td>
                    <td><form:input class="form-control" path="sphone"/></td>
                    <td style="color:red"><form:errors path="sphone" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label class="form-check-label" path="sgender">Gender</form:label></td>
                    <td><form:radiobutton class="form-check-input" path="sgender" value="male" label="Male" /> 
             		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<form:radiobutton class="form-check-input" path="sgender" value="female" label="Female" /></td>
                    <td style="color:red"><form:errors path="sgender" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="semail">Email</form:label></td>
                    <td><form:input class="form-control" path="semail"/></td>
                    <td style="color:red"><form:errors path="semail" cssClass = "error"/></td>
                </tr>
                <tr>
                    <td><form:label path="saddress">Address</form:label></td>
                    <td><form:textarea class="form-control" path="saddress" rows="3"/></td>
                    <td style="color:red"><form:errors path="saddress" cssClass = "error"/></td>
                </tr>
                <tr>
                    <td><form:label path="sdob">
                      Dob(DD-MM-YYYY)</form:label></td>
                    <td><form:input class="form-control" path="sdob"/></td>
                    <td style="color:red"><form:errors path="sdob" cssClass = "error"/></td>
                    
                </tr>
                
                <tr>
                    <td><form:label path="sbranch">Branch</form:label></td>
                     	<td><form:select class="form-control" path = "sbranch">
  						       <form:options items = "${branchesList}" />
						   </form:select>
					  </td>
                    <td style="color:red"><form:errors path="sbranch" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="sjyear">Join Year</form:label></td>
                    <td><form:select class="form-control" path = "sjyear">
  						      <form:option value = "2011" label = "Select"/>
  						       <form:options items = "${joinYearList}" />
						   </form:select></td>
                    <td style="color:red"><form:errors path="sjyear" cssClass = "error"/></td>
                </tr>
                <tr>
                    <td><form:label path="spyear">Present Year</form:label></td>
                     	<td><form:select  class="form-control" path = "spyear">
  						      <form:option value = "0" label = "Select"/>
  						       <form:options items = "${presentYearList}" />
						   </form:select>
					  </td>
                    <td style="color:red"><form:errors path="spyear" cssClass = "error"/></td>
                </tr>
                <tr>
                    <td><form:label path="spsem">Present Semester</form:label></td>
                    <td><form:select class="form-control" path = "spsem">
  						      <form:option value = "0" label = "Select"/>
  						       <form:options items = "${presentSemesterList}" />
						   </form:select></td>
                    <td style="color:red"><form:errors path="spsem" cssClass = "error"/></td>
                    
                </tr>
                
                <tr>
                    <td><form:label path="spsec">Present Section</form:label></td>
                    <td><form:select class="form-control" path = "spsec">
  						       <form:options items = "${presentSectionList}" />
						   </form:select></td>
                    <td style="color:red"><form:errors path="spsec" cssClass = "error"/></td>
                </tr>
               
               
               <tr>
                    <td><form:label path="sfname">
                      Father's Name</form:label></td>
                    <td><form:input class="form-control" path="sfname"/></td>
                    <td style="color:red"><form:errors path="sfname" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="sfphone">Father's Phone</form:label></td>
                    <td><form:input class="form-control" path="sfphone"/></td>
                    <td style="color:red"><form:errors path="sfphone" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="sfemail">Father's Email</form:label></td>
                    <td><form:input class="form-control" path="sfemail"/></td>
                    <td style="color:red"><form:errors path="sfemail" cssClass = "error"/></td>
                </tr>
               
               <tr>
                    <td><form:label path="smname">
                      Mother's Name</form:label></td>
                    <td><form:input class="form-control" path="smname"/></td>
                    <td style="color:red"><form:errors path="smname" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="smphone">Mother's Phone</form:label></td>
                    <td><form:input class="form-control"  path="smphone"/></td>
                    <td style="color:red"><form:errors path="smphone" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="smemail">Mother's Email</form:label></td>
                    <td><form:input class="form-control" path="smemail"/></td>
                    <td style="color:red"><form:errors path="smemail" cssClass = "error"/></td>
                </tr>
               
                <tr>
                	<td align="center"><button type="submit" class="btn btn-outline-success">Submit</button></td>
                </tr>
            </table>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form:form>
	
	</div>













<div style="padding-top: 100px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>

