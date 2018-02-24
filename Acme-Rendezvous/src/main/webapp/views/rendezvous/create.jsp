<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>
 
<%
Date now = new Date();
SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
String date = df.format(now);
pageContext.setAttribute("now", date);
%>

<form:form action="${action}" modelAttribute="rendezvousForm">

		<acme:textbox code="row.name" path="name" />
		<br />
		
		<acme:textbox code="row.description" path="description" />
		<br />
		
		<acme:textbox code="row.momentRendezvous" path="momentRendezvous" type="date" min="${now}" />
		<br />
		
		<acme:textbox code="row.picture" path="picture" />
		<br />

		<acme:textbox code="row.latitude" path="latitude" />
		<br />
		
		<acme:textbox code="row.longitude" path="longitude" />
		<br />
		
		<acme:checkbox code="row.adultOnly" path="adultOnly"/>
		
		<acme:submit name="save" code="row.save" />
		<acme:cancel url="rendezvous/list.do" code="row.cancel" />

</form:form>
