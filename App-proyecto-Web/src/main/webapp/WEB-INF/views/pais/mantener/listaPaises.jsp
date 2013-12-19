<%-- Pagina principal da aplicacao, a listagem de mercadorias. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>

	<spring:message code="label.paises" var="label_paises" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.pais.codigo" var="label_pais_codigo" htmlEscape="false" />
	<spring:message code="label.pais.nombre" var="label_pais_nombre" htmlEscape="false" />
	<spring:message code="label.pais.abreviatura" var="label_pais_abreviatura" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_paises} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_pais_codigo}</th>
				<th>${label_pais_nombre}</th>
				<th>${label_pais_abreviatura}</th>
			</tr>
		</thead>
		<c:forEach items="${paises}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/pais/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
			<td>${m.abreviatura}</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/pais/form/" htmlEscape="true"/>'>Registrar Pais</a>
</div>