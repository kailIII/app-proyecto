<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.umedidas" var="label_umedidas" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.umedida.codigo" var="label_umedida_codigo" htmlEscape="false" />
	<spring:message code="label.umedida.nombre" var="label_umedida_nombre" htmlEscape="false" />
	<spring:message code="label.umedida.abreviatura" var="label_umedida_abreviatura" htmlEscape="false" />
	
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_umedidas} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_umedida_codigo}</th>
				<th>${label_umedida_nombre}</th>
				<th>${label_umedida_abreviatura}</th>
			</tr>
		</thead>
		<c:forEach items="${umedidas}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/umedida/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
			<td>${m.abreviatura}</td>
		</tr>
		</c:forEach>
	</table>
	<spring:url value="/umedida" var="crear_url" htmlEscape="true">
		<spring:param name="form"></spring:param>
	</spring:url>
    <a href="${crear_url}">Registrar Unidad de Medida</a>
</div>