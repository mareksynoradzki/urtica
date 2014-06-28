<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<tiles:insertDefinition name="frontedlayout">
<tiles:putAttribute name="body">

<h1><spring:message code="customer.list.title"/></h1>
<table cellspacing="15">
	<tr>
		<th><spring:message code="customer.list.name"/></th>
		<th><spring:message code="customer.list.chief"/></th>
		<th><spring:message code="customer.list.actions"/></th>
	</tr>
	<c:forEach items="${entities}" var="customer">
	<tr>
		<td><c:out value="${customer.name}"/></td>
		<td><c:out value="${customer.chief.name}"/></td>
		<td>
			<a href="<s:url value="/customer/update/${customer.id}"/>"><spring:message code="button.update"/></a>
			<a href="<s:url value="/customer/delete/${customer.id}"/>"><spring:message code="button.delete"/></a>
		</td>
	</tr>
	</c:forEach>

</table>
<div>
	<a href="<s:url value="/customer/create"/>"><spring:message code="button.add"/></a>
</div>
</tiles:putAttribute>
</tiles:insertDefinition>