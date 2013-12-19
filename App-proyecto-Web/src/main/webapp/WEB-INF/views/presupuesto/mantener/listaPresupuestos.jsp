<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.presupuestos" var="label_presupuestos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.presupuesto.codigo" var="label_presupuesto_codigo" htmlEscape="false" />
	<spring:message code="label.presupuesto.nombre" var="label_presupuesto_nombre" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_presupuestos} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_presupuesto_codigo}</th>
				<th>${label_presupuesto_nombre}</th>
			</tr>
		</thead>
		<c:forEach items="${presupuestos}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/presupuesto/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.fecha}</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/presupuesto/form/" htmlEscape="true"/>'>Registrar Presupuesto</a>
</div>