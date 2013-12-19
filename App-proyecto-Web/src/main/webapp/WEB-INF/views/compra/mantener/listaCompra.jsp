<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.compras" var="label_compras" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	
	<spring:message code="label.compra.fecha" var="label_compra_fecha" htmlEscape="false" />
	<spring:message code="label.proveedor" var="label_proveedor" htmlEscape="false" />
	<spring:message code="label.compra.condicion" var="label_compra_condicion" htmlEscape="false" />
	<spring:message code="label.compra.estado" var="label_compra_estado" htmlEscape="false" />

	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_compras} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_compra_fecha}</th>
				<th>${label_proveedor}</th>
				<th>${label_compra_condicion}</th>
				<th>${label_compra_estado}</th>
			</tr>
		</thead>
		<c:forEach items="${compras}" var="r">
		<tr>
			<td>${r.codigo}</td>
			<td>
				<spring:url value="/compra/edit/${r.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${r.proveedor.nombre}">${r.fechaDocumento}</a>
			</td>
			<td>${r.proveedor.nombre}</td>
			<td>${r.condicion}</td>
			<td>${r.estado}</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/compra/form/" htmlEscape="true"/>'>Registrar Compra</a>
</div>