<%-- Pagina principal da aplicacao, a listagem de mercadorias. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<spring:message code="label.insumos" var="label_insumos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.insumo.nombre" var="label_insumo_nombre" htmlEscape="false" />
<%-- 	<spring:message code="label.insumo.descripcion" var="label_insumo_descripcion" htmlEscape="false" /> --%>
	<spring:message code="label.insumo.umedida" var="label_insumo_umedida" htmlEscape="false" />
<%-- 	<spring:message code="label.insumo.precio" var="label_insumo_precio" htmlEscape="false" /> --%>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_insumos} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_insumo_nombre}</th>
				<th>${label_insumo_umedida}</th>
<%-- 				<th>${label_insumo_cantidad}</th> --%>
<%-- 				<th>${label_insumo_precio}</th> --%>
			</tr>
		</thead>
		<c:forEach items="${insumos}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/insumo/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
			<td>${m.umedida.nombre}</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/insumo/form/" htmlEscape="true"/>'>Registrar Insumos</a>
</div>