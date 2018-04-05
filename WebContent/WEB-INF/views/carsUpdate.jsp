<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragment/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="breadcrumb">
  <a class="breadcrumb-item" href="/cl_car_crm/crm">Home</a>
  <a class="breadcrumb-item" href="/cl_car_crm/Cars">Cars</a>
  <span class="breadcrumb-item active">CarsAdd</span>
</nav>


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <h4></h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="Cars">Home</a></li>
        <li><a href="Cars?function=add">Add car</a></li>
        <li class="active"><a href="Cars?function=update">Update car</a></li>
        <li><a href="Cars?function=delete">Delete car</a></li>
        <li><a href="Cars?function=show">Show worker's orders</a></li>
      </ul><br>
    </div>

<div class="container">    
    <div class="col-sm-10">
				<h3>Updating a car</h3>
				<hr>
			  <form action="CarsAdd" method="post">
			    <div class="form-group">
			      <label for="make">Make:</label>
			      <input type="text" class="form-control" id="make" placeholder="Enter Make" name="make">
			    </div>
			    <div class="form-group">
			      <label for="model">Model:</label>
			      <input type="text" class="form-control" id="model" placeholder="Enter Model" name="model">
			    </div>
			    <div class="form-group">
			      <label for="year">Year:</label>
			      <input type="number" class="form-control" id="year" placeholder="Enter Year" name="year">
			    </div>
			    <div class="form-group">
			      <label for="registration">Registration:</label>
			      <input type="text" class="form-control" id="registration" placeholder="Enter Registration" name="registration">
			    </div>
			    <div class="form-group">
			      <label for="service">Service:</label>
			      <input type="text" class="form-control" id="service" placeholder="Enter Next Service Date yyyy-mm-dd" name="service">
			    </div>
			    <div class="form-group">
			      <label for="client_id">Select a client</label>
			      <br>
			      <select name="client_id" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
							   <option selected>Select client</option>
							   <c:forEach items="${ clients	 }" var="client">
							   <option value="${client.id}">${client.name}, ${client.surname}, ${client.email}, ${client.phone}, ${client.birthDate}</option>
							   </c:forEach>
					 		</select>			
			    </div>
			    <button type="submit" class="btn btn-primary">Add to database</button>
			  </form>
			</div>
		</div>
      <br><br>
      </div>
  </div>

<%@ include file="/WEB-INF/fragment/footer.jsp"%>