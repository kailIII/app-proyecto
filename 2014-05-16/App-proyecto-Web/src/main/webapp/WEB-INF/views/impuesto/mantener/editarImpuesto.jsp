<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.impuesto.inexistente" var="impuesto_inexistente" htmlEscape="false" />
	
	<c:if test="${impuesto != null}" var="temImpuesto">
		<c:import url="/WEB-INF/views/impuesto/mantener/formImpuesto.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteImpuesto" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteImpuesto").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temImpuesto}">
		<h3>${impuesto_inexistente}</h3>
	</c:if>
	
</div>