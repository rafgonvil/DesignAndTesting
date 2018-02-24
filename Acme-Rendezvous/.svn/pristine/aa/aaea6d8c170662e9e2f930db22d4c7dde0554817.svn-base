
<%@ tag language="java" body-content="empty" %>

<%-- Taglibs --%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%-- Attributes --%> 
 
<%@ attribute name="code" required="true" %>
<%@ attribute name="field" required="true" %>


<%@ attribute name="suffix" required="false" %>
<jstl:if test="${suffix == null}">
	<jstl:set var="suffix" value="" />
</jstl:if>

<%@ attribute name="url" required="false" %>
<jstl:if test="${url == null}">
	<jstl:set var="url" value="" />
</jstl:if>

<%@ attribute name="labelWidth" required="false" %>
<jstl:if test="${labelWidth == null}">
	<jstl:set var="labelWidth" value="15%" />
</jstl:if>

<%-- Definition --%>

<tr>
	<td style="font-weight:bold" width="${labelWidth}">
		<spring:message code="${code}" />: 
	</td>
	<td>
		<jstl:if test="${url!= null && url != '' && url.length()>0}">
			<a href="<jstl:out value='${url}' />" target="_blank"><jstl:out value="${field}" />
			<jstl:if test="${suffix!=null || suffix!='' || suffix.length()!=0}">
				${suffix}
			</jstl:if>
			</a>
		</jstl:if>
		
		<jstl:if test="${url==null || url=='' || url.length()==0}">
			<jstl:out value="${field}" />
			<jstl:if test="${suffix!=null || suffix!='' || suffix.length()!=0}">
				${suffix}
			</jstl:if>
		</jstl:if>
	</td>
</tr>
