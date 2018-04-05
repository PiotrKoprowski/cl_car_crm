<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragment/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="breadcrumb">
  <a class="breadcrumb-item" href="/cl_car_crm/crm">Home</a>
  <a class="breadcrumb-item" href="/cl_car_crm/workers">Clients</a>
  <span class="breadcrumb-item active">ClientsAdd</span>
</nav>


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <h4></h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="Clients">Home</a></li>
        <li class="active"><a href="Clients?function=add">Add client</a></li>
        <li><a href="Clients?function=update">Update client</a></li>
        <li><a href="Clients?function=delete">Delete client</a></li>
        <li><a href="Clients?function=show">Show client's orders</a></li>
      </ul><br>
    </div>

<div class="container">    
    <div class="col-sm-10">
				<h3>Adding a client</h3>
				<hr>
			  <form action="ClientsAdd" method="post">
			    <div class="form-group">
			      <label for="name">Name:</label>
			      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
			    </div>
			    <div class="form-group">
			      <label for="surname">Surname:</label>
			      <input type="text" class="form-control" id="surname" placeholder="Enter Surname" name="surname">
			    </div>
			    <div class="form-group">
			      <label for="surname">Email:</label>
			      <input type="email" class="form-control" id="address" placeholder="Enter Email" name="email">
			    </div>
			    <div class="form-group">
			      <label for="surname">Phone:</label>
			      <input type="tel" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
			    </div>
			    <div class="form-group">
			      <label for="surname">Birth Date</label>
			      <input type="text" class="form-control" id="birthDate" placeholder="Enter Date yyyy-mm-dd" name="birthDate">
			    </div>
			    <button type="submit" class="btn btn-primary">Add to database</button>
			  </form>
			</div>
		</div>
      <br><br>
      </div>
  </div>

<%@ include file="/WEB-INF/fragment/footer.jsp"%>