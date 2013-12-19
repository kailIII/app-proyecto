<%-- Pagina principal da aplicacao, a listagem de mercadorias. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<spring:message code="label.insumos" var="label_insumos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	
	<spring:message code="label.produccion.fecha" var="label_produccion_fecha" htmlEscape="false" />
	<spring:message code="label.produccion.formula" var="label_produccion_formula" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_producciones} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_produccion_fecha}</th>
				<th>${label_produccion_formula}</th>
			</tr>
		</thead>
		<c:forEach items="${producciones}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/produccion/edit/${m.codigo}" var="edit_url" htmlEscape="true">
					<spring:param name="form"></spring:param>
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.fecha}">${m.formula}</a>
			</td>
			<td>${m.fecha}</td>
			<td>${m.formula}</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/produccion/form/" htmlEscape="true"/>'>Registrar Produccion</a>
</div>