<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.presupuesto.inexistente" var="presupuesto_inexistente" htmlEscape="false" />
	
	<c:if test="${presupuesto != null}" var="temPresupuesto">
		<c:import url="/WEB-INF/views/presupuesto/mantener/formPresupuesto.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deletePresupuesto" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deletePresupuesto").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temPresupuesto}">
		<h3>${presupuesto_inexistente}</h3>
	</c:if>
	
</div>