<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>
<br>
<br>

<div align="center" class="container">
		<div class="col-sm-6 col-md-4 border border-primary">
			<form role="form" method="get" action="${pageContext.request.contextPath}/admin/attendance/view"> 
				<br>
				<div class="form-group">
					  <label for="rollNumber">Roll Number :</label>
					  <input type="text" placeholder="Enter Roll Number" class="form-control" name="rollNumber" id="rollNumber" required="required">
				</div>
				
				<div class="form-group">
					 
					<label for="cList">
						Course :
					</label>
					
					
				<select class="form-control" name="cList">
      				<c:forEach var ="cList" items="${coursesList}">
                        <option value="${cList.key}">${cList.value}</option>
                    </c:forEach>	
      					
  				</select>
				</div>
			
				
				<div class="form-group">
					 
					<label for="ayear">
						Academic Year
					</label>
					<select class="form-control" name="ayear">
      					<option value="2012">2012</option>
      					<option value="2013">2013</option>
      					<option value="2014">2014</option>
      					<option value="2015">2015</option>
      					<option value="2016">2016</option>
      					<option value="2017">2017</option>
      					<option value="2018">2018</option>
      					<option value="2019">2019</option>
      					<option value="2020">2020</option>
      					<option value="2021">2021</option>
      					<option value="2022">2022</option>
      					<option value="2023">2023</option>
      					<option value="2024">2024</option>
      					<option value="2025">2025</option>
      					<option value="2026">2026</option>
  					</select>
				</div>		
				
				<button type="submit" class="btn btn-outline-success">
					Submit
				</button>
			</form>
			<br>
		</div>


		
	</div>
</div>
	
<div style="padding-top: 470px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>