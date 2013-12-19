<%-- Pagina principal da aplicacao, a listagem de mercadorias. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<spring:message code="label.proveedores" var="label_proveedores" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.proveedor.nombre" var="label_proveedor_nombre" htmlEscape="false" />
	<spring:message code="label.proveedor.apellido" var="label_proveedor_apellido" htmlEscape="false" />
	<spring:message code="label.proveedor.direccion" var="label_proveedor_direccion" htmlEscape="false" />
	<spring:message code="label.proveedor.telefono" var="label_proveedor_telefono" htmlEscape="false" />
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_insumos} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_proveedor_nombre}</th>
				<th>${label_proveedor_apellido}</th>
				<th>${label_proveedor_direccion}</th>
				<th>${label_proveedor_telefono}</th>
			</tr>
		</thead>
		<c:forEach items="${proveedores}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/proveedor/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
			<td>${m.apellido}</td>
			<td>${m.direccion}</td>
			<td>${m.telefono}</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/proveedor/form/" htmlEscape="true"/>'>Registrar Proveedor</a>
</div>