<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.cargo.inexistente" var="cargo_inexistente" htmlEscape="false" />
	
	<c:if test="${cargo != null}" var="temCargo">
		<c:import url="/WEB-INF/views/cargo/mantener/formCargo.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteCargo" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteCargo").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temCargo}">
		<h3>${cargo_inexistente}</h3>
	</c:if>
	
</div>