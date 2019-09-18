<%@ page language="java" contentType="text/html; charset=IsO-8859-1"
    pageEncoding="IsO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="header.jsp"></jsp:include>

<div>
<jsp:include page="navigation.jsp"></jsp:include>
</div>

<br>
<br>

<div class="container">
	<div class="row">
		<div class="col-md-6 border border-info">
			<form role="form"  action="${pageContext.request.contextPath}/admin/student/view" method="get"> 
				
				<div align="center" class="form-group">
					<label for="spyear">
						<h2 style="font-family: Comic Sans MS Bold; color: green;">Present Students</h2>
					</label>
				</div>
				
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
				
				
			<center><button type="submit" class="btn btn-primary">
					Submit
				</button></center>
			</form>
		</div>


		<div class="col-md-6 border border-info">
			<form role="form" action="${pageContext.request.contextPath}/admin/student/viewAlumini" method="get" > 
				
				<div align="center" class="form-group">
					<label for="spyear">
						<h2 style="font-family: Comic Sans MS Bold; color: green;">Alumini Students</h2>
					</label>
				</div>
				
				
				
				<div class="form-group">
					 
					<label for="spyear">
						Joined Year
					</label>
					<select class="form-control" name="sjyear">
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
				
				
				<div class="form-group">
					 
					<label for="spyear">
						Present Year
					</label>
					<select class="form-control" name="spyear">
      					<option value="6">Alumini</option>
  					</select>
				</div>
				
				
				<div class="form-group">
					 
					<label for="spsem">
						Present Semester
					</label>
					<select class="form-control" name="spsem">
      					<option value="3">Alumini</option>
      				</select>
				</div>
				
				<div class="form-group">
					 
					<label for="spsec">
						Present Section
					</label>
					<select class="form-control" name="spsec">
      					<option value="Alumini">Alumini</option>
  					</select>
				</div>
				
				
			<center>	<button type="submit" class="btn btn-primary">
					Submit
				</button></center>
				<br>
			</form>
		</div>
		


		
	</div>
</div>

<div style="padding-top: 80px;" class="panel-footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>



