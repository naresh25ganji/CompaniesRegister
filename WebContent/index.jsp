<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/home.css" type="text/css"></link>
</head>
<body>
	<div class="title">
		<h1>Company Registration</h1>
	</div>
	<div class="selectOption">select an option to proceed</div>
	<div class="options">
		<div class="option">
			<a href="CompanyController?action=insert">Add Company</a>
		</div>
		<div class="option">
			<a href="CompanyController?action=listCompany">List All Companies</a>
		</div>
		<div class="option">
			<a href="CompanyController?action=import">Import Company List
				From from CSV</a>
		</div>
	</div>
</body>
</html>