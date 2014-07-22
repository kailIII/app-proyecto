<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>	
	<spring:message code="label.clientes" var="label_clientes" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.cliente.codigo" var="label_cliente_codigo" htmlEscape="false" />
	<spring:message code="label.cliente" var="label_cliente" htmlEscape="false" />
	<spring:message code="label.cliente.telefono" var="label_cliente_telefono" htmlEscape="false" />
	<spring:message code="label.cliente.celular" var="label_cliente_celular" htmlEscape="false" />
	<spring:message code="label.cliente.email" var="label_cliente_email" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_clientes} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_cliente_codigo}</th>
				<th>${label_cliente}</th>
				<th>${label_cliente_telefono}</th>
				<th>${label_cliente_celular}</th>
				<th>${label_cliente_email}</th>
			</tr>
		</thead>
		<c:forEach items="${clientes}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/cliente/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre} ${m.apellido}</a>
			</td>
			<td>${m.telefono}</td>
			<td>${m.celular}</td>
			<td>${m.email}</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/cliente/form/" htmlEscape="true"/>'>Registrar Cliente</a>
</div>