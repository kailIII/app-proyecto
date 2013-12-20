<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.ventas" var="label_ventas" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.venta.fecha" var="label_venta_fecha" htmlEscape="false" />
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_ventas} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_venta_fecha}</th>
			</tr>
		</thead>
		<c:forEach items="${ventas}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/venta/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.fecha}">${m.fecha}</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/venta/form/" htmlEscape="true"/>'>Registrar Venta</a>
</div>