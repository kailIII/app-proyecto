<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.departamentos" var="label_departamentos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.departamento.codigo" var="label_departamento_codigo" htmlEscape="false" />
	<spring:message code="label.departamento.nombre" var="label_departamento_nombre" htmlEscape="false" />
	<spring:message code="label.departamento.abreviatura" var="label_departamento_abreviatura" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_departamentos} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_departamento_codigo}</th>
				<th>${label_departamento_nombre}</th>
				<th>${label_departamento_abreviatura}</th>
			</tr>
		</thead>
		<c:forEach items="${departamentos}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/departamento/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
			<td>${m.abreviatura}</td>
		</tr>
		</c:forEach>
	</table>
	
	<br/>
    <a href='<spring:url value="/departamento/form/" htmlEscape="true"/>'>Registrar Departamento</a>
</div>