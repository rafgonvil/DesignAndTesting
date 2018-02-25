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

<form:form action="${action}" modelAttribute="userForm">

	<form:hidden path="id" />

	<acme:textbox code="row.name" path="name" />
	<br />
	
	<acme:textbox code="row.surnames" path="surnames" />
	<br />
	
	<acme:textbox code="row.postalAddress" path="postalAddress" />
	<br />
	
	<acme:textbox code="row.phoneNumber" path="phoneNumber" />
	<br />

	<acme:textbox code="row.email" path="email" />
	<br />
	
	<acme:textbox code="row.birthDate" path="birthDate" type="date" />
	<br />
	
	<acme:submit name="save" code="row.save" />

</form:form>
