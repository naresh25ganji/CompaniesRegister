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
<title>Insert title here</title>
</head>
<body>
	<script>
		$(function() {
			$('input[name=registration]').datepicker();
		});
	</script>
	
	<form method="POST" action='CompanyController' name="frmAddCompany">
		Company Corporate ID : <input type="text" readonly="readonly"
			name="companyid" value="<c:out value="${company.id}" />" /> <br />
		Registration Date : <input type="text" name="registration"
			value="<fmt:formatDate pattern="MM/dd/yyyy" value="${company.registrationDate}" />" />
		Company Name : <input
            type="text" name="name"
            value="<c:out value="${company.name}" />" /> <br /> 
        Company Status : <input
            type="text" name="status"
            value="<c:out value="${company.status}" />" /> <br /> 
        Company Class : <input
            type="text" name="companyClass"
            value="<c:out value="${company.companyClass}" />" /> <br /> 
	    Company Category : <input type="text" name="category"
            value="<c:out value="${company.category}" />" /> <br />
        Authorized Capital : <input
            type="text" name="authorizedCapital"
            value="<c:out value="${company.authorizedCapital}" />" /> <br /> 
        Paidup Capital : <input
            type="text" name="paidupCapital"
            value="<c:out value="${company.paidupCapital}" />" /> <br /> 
          State   : <input
            type="text" name="state"
            value="<c:out value="${company.state}" />" /> <br /> 
        Registrar : <input
            type="text" name="registrar"
            value="<c:out value="${company.registrar}" />" /> <br /> 
        Business Activity : <input type="text" name="businessActivity"
            value="<c:out value="${company.businessActivity}" />" /> <br />
        office Address : <input
            type="text" name="officeAddress"
            value="<c:out value="${company.officeAddress}" />" /> <br /> 
        Sub Category : <input
            type="text" name="status"
            value="<c:out value="${company.subCategory}" />" /> <br /> 	
			
		<br /> <input type="submit" value="Submit" />
	</form>
</body>
</html>