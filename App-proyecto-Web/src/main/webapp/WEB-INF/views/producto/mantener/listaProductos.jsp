<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.productos" var="label_productos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.producto.nombre" var="label_producto_nombre" htmlEscape="false" />
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_productos} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_producto_nombre}</th>
			</tr>
		</thead>
		<c:forEach items="${productos}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/producto/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<spring:url value="/producto" var="crear_url" htmlEscape="true">
		<spring:param name="form"></spring:param>
	</spring:url>
    <a href="${crear_url}">Registrar Producto</a>
</div>