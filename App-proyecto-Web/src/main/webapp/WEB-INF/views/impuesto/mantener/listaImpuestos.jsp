<%-- Pagina principal da aplicacao, a listagem de mercadorias. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<spring:message code="label.impuestos" var="label_impuestos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.impuesto.codigo" var="label_impuesto_codigo" htmlEscape="false" />
	<spring:message code="label.impuesto.nombre" var="label_impuesto_nombre" htmlEscape="false" />
	<spring:message code="label.impuesto.abreviatura" var="label_impuesto_abreviatura" htmlEscape="false" />
	<spring:message code="label.impuesto.porcentaje" var="label_impuesto_porcentaje" htmlEscape="false" />
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_impuestos} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_impuesto_codigo}</th>
				<th>${label_impuesto_nombre}</th>
				<th>${label_impuesto_abreviatura}</th>
				<th>${label_impuesto_porcentaje}</th>
			</tr>
		</thead>
		<c:forEach items="${impuestos}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/impuesto/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
			<td>${m.abreviatura}</td>
			<td>${m.porcentaje}</td>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/impuesto/form/" htmlEscape="true"/>'>Registrar Impuesto</a>
</div>