<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.deposito.inexistente" var="deposito_inexistente" htmlEscape="false" />
	
	<c:if test="${deposito != null}" var="temDeposito">
		<c:import url="/WEB-INF/views/deposito/mantener/formDeposito.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteDeposito" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteDeposito").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temDeposito}">
		<h3>${deposito_inexistente}</h3>
	</c:if>
	
</div>