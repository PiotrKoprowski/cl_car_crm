<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragment/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="breadcrumb">
  <a class="breadcrumb-item" href="/cl_car_crm/crm">Home</a>
  <span class="breadcrumb-item active">Workers</span>
</nav>


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <h4></h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="Cars">Home</a></li>
        <li><a href="Cars?function=add">Add car</a></li>
        <li><a href="Cars?function=update">Update car</a></li>
        <li><a href="Cars?function=delete">Delete car</a></li>
        <li><a href="Cars?function=show">Show worker's orders</a></li>
      </ul><br>
    </div>
    
    
<div class="container">
    <div class="col-sm-10">
      <h3>CARS LIST</h3>
      <hr>
      <h3><b>${alert}</b></h3>
      <br>
		<table class="table">
		  <thead>
		    <tr>
		      <th>Id</th>
		      <th>Make</th>
		      <th>Model</th>
		      <th>Year</th>
		      <th>Registration</th>
		      <th>Service</th>
		      <th>Client_id</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${ cars }" var="car">
		    <tr>
			<th scope="row">${car.id}</th>
		    <td>${car.make}</td>
		    <td>${car.model}</td>
		    <td>${car.year}</td>
		    <td>${car.registration}</td>
		    <td>${car.service}</td>
		    <td>${car.client_id}</td>
		    </tr>
		  </c:forEach>
		  </tbody>
		  </table>
		</div>
      <br><br>
      </div>
  </div>
</div>


<%@ include file="/WEB-INF/fragment/footer.jsp"%>