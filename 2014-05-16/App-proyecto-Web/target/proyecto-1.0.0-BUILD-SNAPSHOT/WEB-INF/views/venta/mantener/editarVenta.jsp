<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.venta.inexistente" var="venta_inexistente" htmlEscape="false" />
	
	<c:if test="${venta != null}" var="temVenta">
		<c:import url="/WEB-INF/views/venta/mantener/formVenta.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteVenta" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteVenta").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temVenta}">
		<h3>${venta_inexistente}</h3>
	</c:if>
	
</div>