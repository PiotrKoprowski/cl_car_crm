<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragment/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="breadcrumb">
  <a class="breadcrumb-item" href="/cl_car_crm/crm">Home</a>
  <a class="breadcrumb-item" href="/cl_car_crm/workers">Workers</a>
  <span class="breadcrumb-item active">WorkersUpdate</span>
</nav>


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <h4></h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="workers">Home</a></li>
        <li><a href="workers?function=add">Add worker</a></li>
        <li><a href="workers?function=update">Update worker</a></li>
        <li><a href="workers?function=delete">Delete worker</a></li>
        <li class="active"><a href="workers?function=show">Show worker's orders</a></li>
      </ul><br>
    </div>
    

<div class="container">    
    <div class="col-sm-10">
				<h3>Showing a worker's orders</h3>
				<hr>
					    <form action="WorkersShow" method="post" class="form-inline">  <select name="selectWorker" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
							   <option selected>Select worker</option>
							   <c:forEach items="${ workers }" var="worker">
							   <option value="${worker.id}">${worker.name}, ${worker.surname}, ${worker.address}, ${worker.phone}, ${worker.note}, ${worker.man_hour}</option>
							   </c:forEach>
					 		</select>  <button type="submit" class="btn btn-primary my-1">Select</button>
						</form>
			<br>
			 <table class="table">
		  <thead>
		    <tr>
		      <th>id</th>
		      <th>Order Date</th>
		      <th>Starting Date</th>
		      <th>Problem Description</th>
		      <th>Repair Description</th>
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
		    <td>${order.problemDescription}</td>
		    <td>${order.repairDescription}</td>
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
      <br><br>
      </div>
  </div>
</div>


<%@ include file="/WEB-INF/fragment/footer.jsp"%>