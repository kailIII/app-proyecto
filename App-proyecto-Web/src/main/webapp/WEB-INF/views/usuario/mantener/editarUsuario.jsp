<%-- Pagina de edicao de mercadoria. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.usuario.inexistente" var="usuario_inexistente" htmlEscape="false" />
	
	<c:if test="${usuario != null}" var="temUsuario">
		<c:import url="/WEB-INF/views/usuario/mantener/formUsuario.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteUsuario" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteUsuario").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temUsuario}">
		<h3>${usuario_inexistente}</h3>
	</c:if>
	
</div>