<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.proveedor.inexistente" var="proveedor_inexistente" htmlEscape="false" />
	
	<c:if test="${proveedor != null}" var="temProveedor">
		<c:import url="/WEB-INF/views/proveedor/mantener/formProveedor.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteProveedor" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteProveedor").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temProveedor}">
		<h3>${proveedor_inexistente}</h3>
	</c:if>
	
</div>