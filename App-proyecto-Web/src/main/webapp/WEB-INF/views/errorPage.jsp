<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<spring:message code="msg.erro.procesamiento" var="msg_erro_procesamiento" htmlEscape="false" />
	<spring:message code="msg.erro.descripcion" var="msg_erro_descripcion" htmlEscape="false" />
	<spring:message code="msg.erro.detalles" var="msg_erro_detalles" htmlEscape="false" />
	
	<h2>${msg_erro_procesamiento}</h2>
    <p>${msg_erro_descripcion}</p>
    
    <c:if test="${not empty exception}">
	<div>
		<h4>${msg_erro_detalles}</h4>
		
		<div class="alert-message error">
			<p><c:out value="${exception.localizedMessage}" /></p>
		</div>
		
		<div id="exception">
		<c:forEach items="${exception.stackTrace}" var="trace">
			<c:out value="${trace}" />
			<br />
		</c:forEach>
		</div>
	</div>
    </c:if>
</div>