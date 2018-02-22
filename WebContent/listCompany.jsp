<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Companies</title>
<link rel="stylesheet" href="css/listCompany.css" type="text/css"></link>
</head>
<body>
	<div class="title">
		<h1>Companies List</h1>
	</div>
	<div class="breadcrumb">
		<a href="CompanyController?action=home">Home</a> / Companies List
	</div>
	<table border=1>
		<thead>
			<tr>
				<th>Corporate Identification Number</th>
				<th>Registration Date</th>
				<th>Company Name</th>
				<th>Company Status</th>
				<th>Company Class</th>
				<th>Company Category</th>
				<th>Authorized Capital</th>
				<th>Paidup Capital</th>
				<th>Registered State</th>
				<th>Registrar of Companies</th>
				<th>Principal Business Activity</th>
				<th>Registered Office Address</th>
				<th>Sub Category</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${companies}" var="company">
				<tr>
					<td><c:out value="${company.id}" /></td>
					<td><fmt:formatDate pattern="yyyy-MMM-dd"
							value="${company.registrationDate}" /></td>
					<td><c:out value="${company.name}" /></td>
					<td><c:out value="${company.status}" /></td>
					<td><c:out value="${company.companyClass}" /></td>
					<td><c:out value="${company.category}" /></td>
					<td><c:out value="${company.authorizedCapital}" /></td>
					<td><c:out value="${company.paidupCapital}" /></td>
					<td><c:out value="${company.state}" /></td>
					<td><c:out value="${company.registrar}" /></td>
					<td><c:out value="${company.businessActivity}" /></td>
					<td class="address"><c:out value="${company.officeAddress}" /></td>
					<td><c:out value="${company.subCategory}" /></td>
					<td><a
						href="CompanyController?action=edit&companyId=<c:out value="${company.id}"/>">Update</a></td>
					<td><a
						href="CompanyController?action=delete&companyId=<c:out value="${company.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="CompanyController?action=insert">Add Company</a>
	</p>
	<p class="csvImport">
		<a href="CompanyController?action=import">Import from CSV</a>
	</p>
</body>
</html>