<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.pedidos" var="label_pedidos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.pedido.fecha" var="label_pedido_fecha" htmlEscape="false" />
	<spring:message code="label.pedido.proveedor" var="label_pedido_proveedor" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_pedidos} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_pedido_fecha}</th>
				<th>${label_pedido_proveedor}</th>
			</tr>
		</thead>
		<c:forEach items="${pedidos}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/pedido/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.fecha}">${m.proveedor}</a>
			</td>
			<td>${m.fecha}</td>
			<td>${m.proveedor}</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/pedido/form/" htmlEscape="true"/>'>Registrar Pedido</a>
</div>