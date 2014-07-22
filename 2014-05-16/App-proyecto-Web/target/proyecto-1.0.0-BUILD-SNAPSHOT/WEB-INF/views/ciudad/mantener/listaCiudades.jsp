<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.ciudades" var="label_ciudades" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.ciudad.codigo" var="label_ciudad_codigo" htmlEscape="false" />
	<spring:message code="label.ciudad.nombre" var="label_ciudad_nombre" htmlEscape="false" />
	<spring:message code="label.ciudad.abreviatura" var="label_ciudad_abreviatura" htmlEscape="false" />
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_ciudades} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_ciudad_codigo}</th>
				<th>${label_ciudad_nombre}</th>
				<th>${label_ciudad_abreviatura}</th>
			</tr>
		</thead>
		<c:forEach items="${ciudades}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/ciudad/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
			<td>${m.abreviatura}</td>
		</tr>
		</c:forEach>
	</table>
    <a href='<spring:url value="/ciudad/form/" htmlEscape="true"/>'>Registrar Ciudad</a>
</div>