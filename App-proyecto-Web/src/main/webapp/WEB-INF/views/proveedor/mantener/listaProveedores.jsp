<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.proveedores" var="label_proveedores" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.proveedor" var="label_proveedor" htmlEscape="false" />
	<spring:message code="label.proveedor.direccion" var="label_proveedor_direccion" htmlEscape="false" />
	<spring:message code="label.proveedor.telefono" var="label_proveedor_telefono" htmlEscape="false" />
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_proveedores} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_proveedor}</th>
				<th>${label_proveedor_direccion}</th>
				<th>${label_proveedor_telefono}</th>
			</tr>
		</thead>
		<c:forEach items="${proveedores}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/proveedor/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
			<td>${m.direccion}</td>
			<td>${m.telefono}</td>
		</tr>
		</c:forEach>
	</table>
	<spring:url value="/proveedor" var="crear_url" htmlEscape="true">
		<spring:param name="form"></spring:param>
	</spring:url>
    <a href="${crear_url}">Registrar Proveedor</a>
</div>