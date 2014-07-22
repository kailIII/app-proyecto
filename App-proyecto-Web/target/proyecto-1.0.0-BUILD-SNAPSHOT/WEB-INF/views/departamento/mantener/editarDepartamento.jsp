<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.departamento.inexistente" var="departamento_inexistente" htmlEscape="false" />
	
	<c:if test="${departamento != null}" var="temDepartamento">
		<c:import url="/WEB-INF/views/departamento/mantener/formDepartamento.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteDepartamento" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteDepartamento").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temDepartamento}">
		<h3>${departamento_inexistente}</h3>
	</c:if>
	
</div>