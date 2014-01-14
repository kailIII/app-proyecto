<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.empleados" var="label_empleados" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.empleado.nombre" var="label_empleado_nombre" htmlEscape="false" />
	<spring:message code="label.empleado.apellido" var="label_empleado_apellido" htmlEscape="false" />
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_empleados} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_empleado_nombre}</th>
				<th>${label_empleado_apellido}</th>
			</tr>
		</thead>
		<c:forEach items="${empleados}" var="e">
		<tr>
			<td>${e.codigo}</td>
			<td>
				<spring:url value="/empleado/edit/${e.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${e.nombre}">${e.nombre}</a>
			</td>
			<td>${e.apellido}</td>
		</tr>
		</c:forEach>
	</table>
    <a href='<spring:url value="/empleado/form/" htmlEscape="true"/>'>Registrar Empleado</a>
</div>