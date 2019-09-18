<%@ page language="java" contentType="text/html; charset=IsO-8859-1"
    pageEncoding="IsO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>
		
		<div class="container-fluid" align="center">
		
		<label style="color: green;"><strong>${message}</strong></label>
		<form:form method="post"
          action="${pageContext.request.contextPath}/admin/faculty/add" modelAttribute="faculty">
             <table>
                <tr>
                    <td><form:label path="fid">Faculty Id</form:label></td>
                    <td><form:input class="form-control" path="fid"/></td>
                    <td style="color: red;"><form:errors path="fid" cssClass = "error"/></td>
                	
                </tr>
                
                <tr>
                    <td><form:label path="fpw">Password</form:label></td>
                    <td><form:password class="form-control" path="fpw"/></td>
                    <td style="color:red"><form:errors path="fpw" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="fdes">Designation</form:label></td>
                     	<td><form:select class="form-control" path = "fdes">
  						       <form:options items = "${designationList}" />
						   </form:select>
					  </td>
                    <td style="color:red"><form:errors path="fdes" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="fname">Name</form:label></td>
                    <td><form:input class="form-control" path="fname"/></td>
                    <td style="color:red"><form:errors path="fname" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label class="form-check-label" path="fgender">Gender</form:label></td>
                    <td><form:radiobutton class="form-check-input" path="fgender" value="male" label="Male" /> 
             		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<form:radiobutton class="form-check-input" path="fgender" value="female" label="Female" /></td>
                    <td style="color:red"><form:errors path="fgender" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="fdob">
                      Dob(DD-MM-YYYY)</form:label></td>
                    <td><form:input class="form-control" path="fdob"/></td>
                    <td style="color:red"><form:errors path="fdob" cssClass = "error"/></td>
                    
                </tr>
                
                <tr>
                    <td><form:label path="fphone">Phone</form:label></td>
                    <td><form:input class="form-control" path="fphone"/></td>
                    <td style="color:red"><form:errors path="fphone" cssClass = "error"/></td>
                </tr>
                
                
                <tr>
                    <td><form:label path="femail">Email</form:label></td>
                    <td><form:input class="form-control" path="femail"/></td>
                    <td style="color:red"><form:errors path="femail" cssClass = "error"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="fbranch">Branch</form:label></td>
                     	<td><form:select class="form-control" path = "fbranch">
  						       <form:options items = "${branchesList}" />
						   </form:select>
					  </td>
                    <td style="color:red"><form:errors path="fbranch" cssClass = "error"/></td>
                </tr>
                
                
                
                <tr>
                    <td><form:label path="faddress">Address</form:label></td>
                    <td><form:textarea class="form-control" path="faddress" rows="3"/></td>
                    <td style="color:red"><form:errors path="faddress" cssClass = "error"/></td>
                </tr>
                
                
                
                
               
              
                <tr>
                	<td><button type="submit" class="btn btn-outline-success">Submit</button></td>
                </tr>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </table>
        </form:form>
	
	</div>

	
<div style="padding-top: 210px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>	