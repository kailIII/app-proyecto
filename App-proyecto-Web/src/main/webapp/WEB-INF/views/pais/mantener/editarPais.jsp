<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.pais.inexistente" var="pais_inexistente" htmlEscape="false" />
	
	<c:if test="${pais != null}" var="temPais">
		<c:import url="/WEB-INF/views/pais/mantener/formPais.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deletePais" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deletePais").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temPais}">
		<h3>${pais_inexistente}</h3>
	</c:if>
	
</div>