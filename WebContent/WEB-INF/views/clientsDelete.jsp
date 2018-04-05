<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragment/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="breadcrumb">
  <a class="breadcrumb-item" href="/cl_car_crm/crm">Home</a>
  <a class="breadcrumb-item" href="/cl_car_crm/workers">Clients</a>
  <span class="breadcrumb-item active">ClientsDelete</span>
</nav>


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <h4></h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="Clients">Home</a></li>
        <li><a href="Clients?function=add">Add client</a></li>
        <li><a href="Clients?function=update">Update client</a></li>
        <li class="active"><a href="Clients?function=delete">Delete client</a></li>
        <li><a href="Clients?function=show">Show client's orders</a></li>
      </ul><br>
    </div>
    

<div class="container">    
    <div class="col-sm-10">
	<h3>Deleting a client</h3>
	<hr>
	    <form action="ClientsDelete" method="post" class="form-inline">  <select name="deleteClient" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
			   <option selected>Select client to delete</option>
			   <c:forEach items="${ clients	 }" var="client">
			   <option value="${client.id}">${client.name}, ${client.surname}, ${client.email}, ${client.phone}, ${client.birthDate}</option>
			   </c:forEach>
	 		</select>  <button type="submit" class="btn btn-primary my-1">Select</button>
		</form>
      <br><br>
      </div>
  </div>
  </div>
  </div>

<%@ include file="/WEB-INF/fragment/footer.jsp"%>