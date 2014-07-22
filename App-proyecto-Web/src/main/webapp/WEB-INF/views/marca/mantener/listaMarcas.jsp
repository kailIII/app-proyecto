<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.marcas" var="label_marcas" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.marca.codigo" var="label_marca_codigo" htmlEscape="false" />
	<spring:message code="label.marca.nombre" var="label_marca_nombre" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_marcas} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_marca_codigo}</th>
				<th>${label_marca_nombre}</th>
			</tr>
		</thead>
		<c:forEach items="${marcas}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/marca/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
		</c:forEach>
	</table>
	<spring:url value="/marca" var="crear_url" htmlEscape="true">
		<spring:param name="form"></spring:param>
	</spring:url>
    <a href="${crear_url}">Registrar Marca</a>
</div>