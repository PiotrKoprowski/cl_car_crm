<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Car crm</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>
<a class="btn btn-primary" href="/cl_car_crm/crm" role="button" btn-lg>Home</a>
<a class="btn btn-primary" href="/cl_car_crm/workers" role="button" btn-lg>Workers</a>
<a class="btn btn-primary" href="/cl_car_crm/Clients" role="button" btn-lg>Clients</a>
<a class="btn btn-primary" href="/cl_car_crm/Cars" role="button" btn-lg>Cars</a>
<a class="btn btn-primary" href="/cl_car_crm/Orders" role="button" btn-lg>Orders</a>
<a class="btn btn-primary" href="/cl_car_crm/Raprots" role="button" btn-lg>Raports</a>
