<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragment/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="breadcrumb">
  <a class="breadcrumb-item" href="/cl_car_crm/crm">Home</a>
  <a class="breadcrumb-item" href="/cl_car_crm/workers">Workers</a>
  <span class="breadcrumb-item active">WorkersAdd</span>
</nav>


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <h4></h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="workers">Home</a></li>
        <li class="active"><a href="workers?function=add">Add worker</a></li>
        <li><a href="workers?function=update">Update worker</a></li>
        <li><a href="workers?function=delete">Delete worker</a></li>
        <li><a href="workers?function=show">Show worker's orders</a></li>
      </ul><br>
    </div>

<div class="container">    
    <div class="col-sm-10">
				<h3>Adding a worker</h3>
				<hr>
			  <form action="WorkersAdd" method="post">
			    <div class="form-group">
			      <label for="name">Name:</label>
			      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
			    </div>
			    <div class="form-group">
			      <label for="surname">Surname:</label>
			      <input type="text" class="form-control" id="surname" placeholder="Enter Surname" name="surname">
			    </div>
			    <div class="form-group">
			      <label for="surname">Address:</label>
			      <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address">
			    </div>
			    <div class="form-group">
			      <label for="surname">Phone:</label>
			      <input type="tel" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
			    </div>
			    <div class="form-group">
			      <label for="surname">Note:</label>
			      <input type="text" class="form-control" id="note" placeholder="Enter Note" name="note">
			    </div>
			    <div class="form-group">
			      <label for="surname">Man Hour:</label>
			      <input type="number" step="0.01" class="form-control" id="man_hour" placeholder="Enter Man Hour" name="man_hour">
			    </div>
			    <button type="submit" class="btn btn-primary">Add to database</button>
			  </form>
			</div>
		</div>
      <br><br>
      </div>
  </div>

<%@ include file="/WEB-INF/fragment/footer.jsp"%>