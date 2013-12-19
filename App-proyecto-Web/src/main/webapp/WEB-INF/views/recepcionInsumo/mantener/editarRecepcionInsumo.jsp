<%-- Pagina de edicao de mercadoria. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.recepcion.inexistente" var="recepcion_inexistente" htmlEscape="false" />
	
	<c:if test="${recepcion != null}" var="temRecepcion">
		<c:import url="/WEB-INF/views/recepcionInsumo/mantener/formRecepcionInsumo.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteRecepcion" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteRecepcion").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temRecepcion}">
		<h3>${recepcion_inexistente}</h3>
	</c:if>
	
</div>