<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>

<br>
<br>

<div align="center" class="container">
		<div class="col-sm-6 col-md-4 border border-primary">
			<form role="form" method="get" action="${pageContext.request.contextPath}/hod/attendance/viewPresentAttendance"> 
				<br>
				<div class="form-group">
					 
					<label for="spyear">
						Present Year
					</label>
					<select class="form-control" name="spyear">
      					<option value="1">1</option>
      					<option value="2">2</option>
      					<option value="3">3</option>
      					<option value="4">4</option>
      					<option value="5">5</option>
  					</select>
				</div>
				
				
				<div class="form-group">
					 
					<label for="spsem">
						Present Semester
					</label>
					<select class="form-control" name="spsem">
      					<option value="1">1</option>
      					<option value="2">2</option>
  					</select>
				</div>
				
				<div class="form-group">
					 
					<label for="spsec">
						Present Section
					</label>
					<select class="form-control" name="spsec">
      					<option value="A">A</option>
      					<option value="B">B</option>
      					<option value="C">C</option>
      					<option value="D">D</option>
      					<option value="E">E</option>
  					</select>
				</div>
				
				
				<button type="submit" class="btn btn-outline-success">
					Submit
				</button>
			</form>
			<br>
		</div>


		
	</div>





<div style="padding-top: 470px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>