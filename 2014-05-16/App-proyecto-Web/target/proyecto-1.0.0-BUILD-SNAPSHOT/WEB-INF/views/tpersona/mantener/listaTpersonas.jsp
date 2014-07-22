<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.tpersonas" var="label_tpersonas" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.tpersona.codigo" var="label_tpersona_codigo" htmlEscape="false" />
	<spring:message code="label.tpersona.nombre" var="label_tpersona_nombre" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_tpersonas} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_tpersona_codigo}</th>
				<th>${label_tpersona_nombre}</th>
			</tr>
		</thead>
		<c:forEach items="${tpersonas}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/tpersona/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/tpersona/form/" htmlEscape="true"/>'>Registrar Tipo Persona</a>
</div>