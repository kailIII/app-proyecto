<%-- Pagina de edicao de mercadoria. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.cliente.inexistente" var="cliente_inexistente" htmlEscape="false" />
	
	<c:if test="${cliente != null}" var="temCliente">
		<c:import url="/WEB-INF/views/cliente/mantener/formCliente.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteCliente" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteCliente").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temCliente}">
		<h3>${cliente_inexistente}</h3>
	</c:if>
	
</div>