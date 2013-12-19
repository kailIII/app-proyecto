<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.producto.inexistente" var="producto_inexistente" htmlEscape="false" />
	
	<c:if test="${producto != null}" var="temProducto">
		<c:import url="/WEB-INF/views/producto/mantener/formProducto.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteProducto" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteProducto").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temProducto}">
		<h3>${producto_inexistente}</h3>
	</c:if>
	
</div>