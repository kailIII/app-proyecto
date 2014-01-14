<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.empleado.inexistente" var="empleado_inexistente" htmlEscape="false" />
	
	<c:if test="${empleado != null}" var="temEmpleado">
		<c:import url="/WEB-INF/views/empleado/mantener/formEmpleado.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteEmpleado" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteEmpleado").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temEmpleado}">
		<h3>${empleado_inexistente}</h3>
	</c:if>
	
</div>