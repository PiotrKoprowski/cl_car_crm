<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragment/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="breadcrumb">
  <a class="breadcrumb-item" href="#">Home</a>
  <span class="breadcrumb-item active">Home</span>
</nav>

<div class="row">
    <div class="col-md-4">
		<div class="card">
		  <div class="card-body">
		    <h4 class="card-title">Tytuł karty</h4>
		  </div>
		  <ul class="list-group list-group-flush">
		    <li class="list-group-item">Pierwszy element listy</li>
		    <li class="list-group-item">Drugi element listy</li>
		    <li class="list-group-item">Trzeci element listy</li>
		  </ul>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card">
		  <div class="card-body">
		    <h4 class="card-title">Tytuł karty</h4>
		  </div>
		  <ul class="list-group list-group-flush">
		    <li class="list-group-item">Pierwszy element listy</li>
		    <li class="list-group-item">Drugi element listy</li>
		    <li class="list-group-item">Trzeci element listy</li>
		  </ul>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card">
		  <div class="card-body">
		    <h4 class="card-title">Tytuł karty</h4>
		  </div>
		  <ul class="list-group list-group-flush">
		    <li class="list-group-item">Pierwszy element listy</li>
		    <li class="list-group-item">Drugi element listy</li>
		    <li class="list-group-item">Trzeci element listy</li>
		  </ul>
		</div>
	</div>
</div>

<div class="container">
<table class="table">
  <thead>
    <tr>
      <th>id</th>
      <th>Order Date</th>
      <th>Starting Date</th>
      <th>Worker id</th>
      <th>Problem Description</th>
      <th>Repair Description</th>
      <th>Status</th>
      <th>Car id</th>
      <th>Full Cost</th>
      <th>Parts Cost</th>
      <th>Worker Man Hour</th>
      <th>Amout Man Hour</th>
      <th>Client id</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${ orders }" var="order">
    <tr>
	<th scope="row">${order.id}</th>
    <td>${order.orderDate}</td>
    <td>${order.startingDate}</td>
    <td>${order.worker_id}</td>
    <td>${order.problemDescription}</td>
    <td>${order.repairDescription}</td>
    <td>${order.status}</td>
    <td>${order.car_id}</td>
    <td>${order.fullCost}</td>
    <td>${order.partsCost}</td>
    <td>${order.workers_manHour}</td>
    <td>${order.amoutManHour}</td>
    <td>${order.client_id}</td>
    </tr>
  </c:forEach>
  </tbody>
  </table>
</div>



<%@ include file="/WEB-INF/fragment/footer.jsp"%>