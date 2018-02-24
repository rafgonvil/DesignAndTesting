
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<jsp:useBean id="now" class="java.util.Date" scope="page"/>

<display:table name="rendezvouses" id="row" requestURI="${requestURI }">

	<jstl:if test="${row.deleted == false and row.momentRendezvous lt now}">
	
		<display:column titleKey="row.name" property="name"/>
		<display:column titleKey="row.description" property="description"/>
		<display:column class="borderBlue" titleKey="row.momentRendezvous" property="momentRendezvous" format="{0,date,dd/MM/yyyy}"/>
		<display:column titleKey="row.picture" property="picture"/>
		<display:column titleKey="row.latitude" property="latitude"/>
		<display:column titleKey="row.longitude" property="longitude"/>
		<c:if test="${row.adultOnly == true}">
	        <spring:message code="boolean.yes" var="yes"/>
			<display:column value="${yes}" titleKey="row.adultOnly"/>
	    </c:if>
	    <c:if test="${row.adultOnly == false}">
	         <spring:message code="boolean.no" var="no"/>
			<display:column value="${no}" titleKey="row.adultOnly"/>
	    </c:if>
    </jstl:if>
    
     <jstl:if test="${row.deleted == false and row.momentRendezvous ge now}">
		<display:column titleKey="row.name" property="name"/>
		<display:column titleKey="row.description" property="description"/>
		<display:column titleKey="row.momentRendezvous" property="momentRendezvous" format="{0,date,dd/MM/yyyy}"/>
		<display:column titleKey="row.picture" property="picture"/>
		<display:column titleKey="row.latitude" property="latitude"/>
		<display:column titleKey="row.longitude" property="longitude"/>
		<c:if test="${row.adultOnly == true}">
	        <spring:message code="boolean.yes" var="yes"/>
			<display:column value="${yes}" titleKey="row.adultOnly"/>
	    </c:if>
	    <c:if test="${row.adultOnly == false}">
	         <spring:message code="boolean.no" var="no"/>
			<display:column value="${no}" titleKey="row.adultOnly"/>
	    </c:if>
    </jstl:if>
    
    
    <jstl:if test="${row.deleted == true and row.momentRendezvous lt now}">
		<display:column class="backgroundOrange" titleKey="row.name" property="name"/>
		<display:column class="backgroundOrange" property="description"/>
		<display:column class="backgroundOrange borderBlue" property="momentRendezvous" format="{0,date,dd/MM/yyyy}"/>
		<display:column class="backgroundOrange" property="picture"/>
		<display:column class="backgroundOrange" property="latitude"/>
		<display:column class="backgroundOrange" property="longitude"/>
		<c:if test="${row.adultOnly == true}">
	        <spring:message code="boolean.yes" var="yes"/>
			<display:column class="backgroundOrange" value="${yes}" titleKey="row.adultOnly"/>
	    </c:if>
	    <c:if test="${row.adultOnly == false}">
	         <spring:message code="boolean.no" var="no"/>
			<display:column class="backgroundOrange" value="${no}" titleKey="row.adultOnly"/>
	    </c:if>
    </jstl:if>
    
    <jstl:if test="${row.deleted == true and row.momentRendezvous ge now}">
		<display:column class="backgroundOrange" titleKey="row.name" property="name"/>
		<display:column class="backgroundOrange" property="description"/>
		<display:column class="backgroundOrange" property="momentRendezvous" format="{0,date,dd/MM/yyyy}"/>
		<display:column class="backgroundOrange" property="picture"/>
		<display:column class="backgroundOrange" property="latitude"/>
		<display:column class="backgroundOrange" property="longitude"/>
		<c:if test="${row.adultOnly == true}">
	        <spring:message code="boolean.yes" var="yes"/>
			<display:column class="backgroundOrange" value="${yes}" titleKey="row.adultOnly"/>
	    </c:if>
	    <c:if test="${row.adultOnly == false}">
	         <spring:message code="boolean.no" var="no"/>
			<display:column class="backgroundOrange" value="${no}" titleKey="row.adultOnly"/>
	    </c:if>
    </jstl:if>
	
	
</display:table>