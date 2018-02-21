<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add Company</title>
<link rel="stylesheet" href="css/company.css" type="text/css"></link>
</head>
<body>
	<script>
		$(function() {
			$('input[name=registration]').datepicker();
		});
	</script>

	<div class="title">
		<h1>Add New Company</h1>
	</div>
	<div class="breadcrumb">
		<a href="CompanyController?action=home">Home</a> / Add Company
	</div>

	<form method="POST" action='CompanyController' name="frmAddCompany">
		<div class="data">
			<span class="label">Company Corporate ID : </span> <input type="text"
				readonly="readonly" name="companyid"
				value="<c:out value="${company.id}" />" />
		</div>
		<div class="data">
			<span class="label">Registration Date : </span> <input type="text"
				name="registration"
				value="<fmt:formatDate pattern="MM/dd/yyyy" value="${company.registrationDate}" />" />
		</div>
		<div class="data">
			<span class="label">Company Name :</span> <input type="text"
				name="name" value="<c:out value="${company.name}" />" />
		</div>
		<div class="data">
			<span class="label">Company Status : </span> <input type="text"
				name="status" value="<c:out value="${company.status}" />" />
		</div>
		<div class="data">
			<span class="label">Company Class : </span> <input type="text"
				name="companyClass"
				value="<c:out value="${company.companyClass}" />" />
		</div>
		<div class="data">
			<span class="label">Company Category : </span> <input type="text"
				name="category" value="<c:out value="${company.category}" />" />
		</div>
		<div class="data">
			<span class="label">Authorized Capital :</span> <input type="text"
				name="authorizedCapital"
				value="<c:out value="${company.authorizedCapital}" />" />
		</div>
		<div class="data">
			<span class="label">Paidup Capital : </span> <input type="text"
				name="paidupCapital"
				value="<c:out value="${company.paidupCapital}" />" />
		</div>
		<div class="data">
			<span class="label">State : </span> <input type="text" name="state"
				value="<c:out value="${company.state}" />" />
		</div>
		<div class="data">
			<span class="label">Registrar : </span> <input type="text"
				name="registrar" value="<c:out value="${company.registrar}" />" />
		</div>
		<div class="data">
			<span class="label">Business Activity :</span> <input type="text"
				name="businessActivity"
				value="<c:out value="${company.businessActivity}" />" />
		</div>
		<div class="data">
			<span class="label">office Address : </span> <input type="text"
				name="officeAddress"
				value="<c:out value="${company.officeAddress}" />" />
		</div>
		<div class="data">
			<span class="label">Sub Category : </span> <input type="text"
				name="status" value="<c:out value="${company.subCategory}" />" />
		</div>

		<input class="submitButton" type="submit" value="Submit" />
	</form>
</body>
</html>