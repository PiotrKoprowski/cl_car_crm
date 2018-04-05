<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragment/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="breadcrumb">
  <a class="breadcrumb-item" href="/cl_car_crm/crm">Home</a>
  <span class="breadcrumb-item active">Clients</span>
</nav>


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <h4></h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="Clients">Home</a></li>
        <li><a href="Clients?function=add">Add client</a></li>
        <li><a href="Clients?function=update">Update client</a></li>
        <li><a href="Clients?function=delete">Delete client</a></li>
        <li><a href="Clients?function=show">Show client's orders</a></li>
      </ul><br>
    </div>
    
    
<div class="container">
    <div class="col-sm-10">
      <h3>CLIENTS LIST</h3>
      <hr>
      <h3><b>${alert}</b></h3>
      <br>
		<table class="table">
		  <thead>
		    <tr>
		      <th>Id</th>
		      <th>Name</th>
		      <th>Surname</th>
		      <th>Email</th>
		      <th>Phone</th>
		      <th>Birth Date</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${ clients }" var="client">
		    <tr>
			<th scope="row">${client.id}</th>
		    <td>${client.name}</td>
		    <td>${client.surname}</td>
		    <td>${client.email}</td>
		    <td>${client.phone}</td>
		    <td>${client.birthDate}</td>
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