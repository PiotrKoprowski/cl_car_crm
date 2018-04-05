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
        <li class="active"><a href="workers">Home</a></li>
        <li><a href="workers?function=add">Add worker</a></li>
        <li><a href="workers?function=update">Update worker</a></li>
        <li><a href="workers?function=delete">Delete worker</a></li>
        <li><a href="workers?function=show">Show worker's orders</a></li>
      </ul><br>
    </div>
    
    
<div class="container">
    <div class="col-sm-10">
      <h3>WORKERS LIST</h3>
      <hr>
      <h3><b>${alert}</b></h3>
      <br>
		<table class="table">
		  <thead>
		    <tr>
		      <th>Id</th>
		      <th>Name</th>
		      <th>Surname</th>
		      <th>Address</th>
		      <th>Phone</th>
		      <th>Note</th>
		      <th>Man Hour</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${ workers }" var="worker">
		    <tr>
			<th scope="row">${worker.id}</th>
		    <td>${worker.name}</td>
		    <td>${worker.surname}</td>
		    <td>${worker.address}</td>
		    <td>${worker.phone}</td>
		    <td>${worker.note}</td>
		    <td>${worker.man_hour}</td>
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