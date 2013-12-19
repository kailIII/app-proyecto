<%-- Pagina principal da aplicacao, a listagem de mercadorias. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.usuarios" var="label_usuarios" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.usuario.nombre" var="label_usuario_nombre" htmlEscape="false" />
	<spring:message code="label.usuario.login" var="label_usuario_login" htmlEscape="false" />
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_usuarios} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>${label_usuario_nombre}</th>
				<th>${label_usuario_login}</th>
			</tr>
		</thead>
		<c:forEach items="${usuarios}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/usuario/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
			<td>${m.login}</td>
<%-- 			<td><fmt:formatNumber value="${m.precio}" type="currency"/></td> --%>
		</tr>
		</c:forEach>
	</table>
	<br/>
    <a href='<spring:url value="/usuario/form/" htmlEscape="true"/>'>Registrar Usuario</a>
</div>