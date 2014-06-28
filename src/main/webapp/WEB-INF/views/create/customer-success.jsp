<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="customer.form.title"/></title>
</head>
<body>

<h1><spring:message code="customer.form.title"/></h1>
<form:form method="POST" modelAttribute="entity">

	<div>
		<form:label path="name"><spring:message code="customer.form.label.name"/>:</form:label>
        <form:input path="name" id="name" type="text"/>                        
    </div>
    
	<div>
		<button type="submit" ><spring:message code="customer.form.submit"/></button>
	</div>
	
</form:form>
</body>
</html>