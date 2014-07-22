<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.produccion.inexistente" var="produccion_inexistente" htmlEscape="false"/>
	
	<c:if test="${produccion != null}" var="temProduccion">
		<c:import url="/WEB-INF/views/produccion/mantener/formProduccion.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteProduccion" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteProduccion").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temProduccion}">
		<h3>${produccion_inexistente}</h3>
	</c:if>
	
</div>