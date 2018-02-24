<%--
 * header.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<a href="#"><img src="images/logo.png" alt="Rendezvous Co., Inc." height="200" width="350"/></a>
</div>

<div>
	<ul id="jMenu">
		<security:authorize access="permitAll">
			<li><a class="fNiv"><spring:message	code="master.page.rendezvous" /></a>
				<ul>
					<li class="arrow"></li>	
					<li><a href="rendezvous/list.do"><spring:message code="master.page.rendezvous.list" /></a></li>	
					<security:authorize access="hasRole('USER')">	
					<li><a href="rendezvous/user/create.do"><spring:message code="master.page.rendezvous.create" /></a></li>	
					</security:authorize>
				</ul>
			</li>
		
		</security:authorize>
	
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		
		<security:authorize access="hasRole('ADMIN')">
			<li><a class="fNiv"></a>
		</security:authorize>
		
		<security:authorize access="hasRole('USER')">	
			<li><a class="fNiv"></a>
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
		</security:authorize>		
		
		<security:authorize access="isAuthenticated()">
			<li><a class="fNiv" href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
		</security:authorize>
				
		
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

<script type="text/javascript">
		function relativeRedir(loc) {	
			var b = document.getElementsByTagName('base');
			if (b && b[0] && b[0].href) {
	  			if (b[0].href.substr(b[0].href.length - 1) == '/' && loc.charAt(0) == '/')
	    		loc = loc.substr(1);
	  			loc = b[0].href + loc;
			}
			window.location.replace(loc);
		}
	</script>

