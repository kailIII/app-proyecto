<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.tpersona.inexistente" var="tpersona_inexistente" htmlEscape="false" />
	
	<c:if test="${tpersona != null}" var="temTpersona">
		<c:import url="/WEB-INF/views/tpersona/mantener/formTpersona.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteTpersona" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteTpersona").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temTpersona}">
		<h3>${tpersona_inexistente}</h3>
	</c:if>
	
</div>