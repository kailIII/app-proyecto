<%-- Pagina de edicao de mercadoria. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.marca.inexistente" var="marca_inexistente" htmlEscape="false" />
	
	<c:if test="${marca != null}" var="temMarca">
		<c:import url="/WEB-INF/views/marca/mantener/formMarca.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteMarca" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteMarca").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temMarca}">
		<h3>${marca_inexistente}</h3>
	</c:if>
	
</div>