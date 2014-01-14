<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>

	<spring:message code="label.cargos" var="label_cargos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.cargo.codigo" var="label_cargo_codigo" htmlEscape="false" />
	<spring:message code="label.cargo.nombre" var="label_cargo_nombre" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_cargos} <small> ${label_listado}</small></h3>
	</div>
	
<%-- 	<c:import  --%>
<%-- 	   		url="/WEB-INF/views/fragmentos/search.jsp"> --%>
<%-- 	</c:import> --%>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_cargo_codigo}</th>
				<th>${label_cargo_nombre}</th>
			</tr>
		</thead>
		<c:forEach items="${cargos}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/cargo/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/cargo/form/" htmlEscape="true"/>'>Registrar Cargo</a>
</div>