<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragment/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="breadcrumb">
	<a class="breadcrumb-item" href="/cl_car_crm/crm">Home</a> <a
		class="breadcrumb-item" href="/cl_car_crm/workers">Workers</a> <span
		class="breadcrumb-item active">WorkersDelete</span>
</nav>


<div class="container-fluid">
	<div class="row content">
		<div class="col-sm-2 sidenav">
			<h4></h4>
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="workers">Home</a></li>
				<li><a href="workers?function=add">Add worker</a></li>
				<li><a href="workers?function=update">Update worker</a></li>
				<li class="active"><a href="workers?function=delete">Delete
						worker</a></li>
				<li><a href="workers?function=show">Show worker's orders</a></li>
			</ul>
			<br>
		</div>
		
		<div class="container">
			<div class="col-sm-10">
				<h3>Deleting a worker</h3>
				<hr>
				<form action="WorkersDelete" method="post" class="form-inline">
					<select name="deleteWorker" class="custom-select my-1 mr-sm-2"
						id="inlineFormCustomSelectPref">
						<option selected>Select worker to delete</option>
						<c:forEach items="${ workers }" var="worker">
							<option value="${worker.id}">${worker.name},
								${worker.surname}, ${worker.address}, ${worker.phone},
								${worker.note}, ${worker.man_hour}</option>
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-primary my-1">Delete</button>
				</form>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/fragment/footer.jsp"%>