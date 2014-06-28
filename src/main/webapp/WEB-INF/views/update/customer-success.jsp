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

<h1><spring:message code="customer.edit.title"/></h1>
<form:form method="POST" modelAttribute="entity">

	<div>
		<form:label path="name"><spring:message code="customer.form.label.name"/>:</form:label>
        <form:input path="name" id="name" type="text"/>                        
    </div>
    <div>
    	<form:label path="chief.id"><spring:message code="customer.form.label.chief"/>:</form:label>
<%--     	<form:select path="chief.id" items="${chiefList}" itemLabel="name" itemValue="id" /> --%>
    	
    	<form:select path="chief.id" id="chief.id">
      			<form:option value="" selected="selected" />
                <form:options items="${chiefList}" itemValue="id" itemLabel="name"/>
         </form:select>
    </div>
    
	<div>
		<button type="submit" ><spring:message code="customer.form.submit"/></button>
	</div>
	
</form:form>
</body>
</html>