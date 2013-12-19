<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.lote.inexistente" var="lote_inexistente" htmlEscape="false" />
	
	<c:if test="${lote != null}" var="temLote">
		<c:import url="/WEB-INF/views/lote/mantener/formLote.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteLote" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteLote").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temLote}">
		<h3>${lote_inexistente}</h3>
	</c:if>
	
</div>