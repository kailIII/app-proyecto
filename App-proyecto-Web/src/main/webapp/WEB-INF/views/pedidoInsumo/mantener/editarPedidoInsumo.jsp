<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.pedido.inexistente" var="pedido_inexistente" htmlEscape="false" />
	
	<c:if test="${pedido != null}" var="temPedidoInsumo">
		<c:import url="/WEB-INF/views/pedidoInsumo/mantener/formPedidoInsumo.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deletePedidoInsumo" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deletePedidoInsumo").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temPedidoInsumo}">
		<h3>${pedido_inexistente}</h3>
	</c:if>
	
</div>