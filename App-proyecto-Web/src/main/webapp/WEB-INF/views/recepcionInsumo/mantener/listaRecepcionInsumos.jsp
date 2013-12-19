<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.recepciones" var="label_recepciones" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.recepcion.fecha" var="label_recepcion_fecha" htmlEscape="false" />
	<spring:message code="label.recepcion.proveedor" var="label_recepcion_proveedor" htmlEscape="false" />
	<spring:message code="label.recepcion.empleado" var="label_recepcion_empleado" htmlEscape="false" />
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_recepciones} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_recepcion_fecha}</th>
				<th>${label_recepcion_proveedor}</th>
				<th>${label_recepcion_empleado}</th>
			</tr>
		</thead>
		<c:forEach items="${recepciones}" var="r">
		<tr>
			<td>${r.codigo}</td>
			<td>
				<spring:url value="/recepcion/edit/${r.codigo}" var="edit_url" htmlEscape="true">
					<spring:param name="form"></spring:param>
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${r.fecha}">${r.proveedor}</a>
			</td>
			<td>${r.fecha}</td>
			<td>${r.proveedor}</td>
			<td>${r.empleado}</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/recepcion/form/" htmlEscape="true"/>'>Registrar Recepcion Insumos</a>
</div>