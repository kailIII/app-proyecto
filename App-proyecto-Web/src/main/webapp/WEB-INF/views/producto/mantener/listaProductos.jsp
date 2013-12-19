<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.productos" var="label_productos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.producto.codigo" var="label_producto_codigo" htmlEscape="false" />
	<spring:message code="label.producto.nombre" var="label_producto_nombre" htmlEscape="false" />
	<spring:message code="label.producto.descripcion" var="label_producto_descripcion" htmlEscape="false" />
	<spring:message code="label.producto.cantidad" var="label_producto_cantidad" htmlEscape="false" />
	<spring:message code="label.producto.precio" var="label_producto_precio" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div style="border-bottom: 1px solid #E5E5E5;">
		<h3>${label_productos} <small> ${label_listado}</small></h3>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${label_producto_codigo}</th>
				<th>${label_producto_nombre}</th>
				<th>${label_producto_descripcion}</th>
				<th>${label_producto_cantidad}</th>
				<th>${label_producto_precio}</th>
			</tr>
		</thead>
		<c:forEach items="${productos}" var="m">
		<tr>
			<td>${m.codigo}</td>
			<td>
				<spring:url value="/producto/edit/${m.codigo}" var="edit_url" htmlEscape="true">
				</spring:url>
				<a href="${edit_url}" title="${label_editar} ${m.nombre}">${m.nombre}</a>
			</td>
			<td>${m.descripcion}</td>
			<td>${m.cantidad}</td>
			<td><fmt:formatNumber value="${m.precio}" type="number"/></td>
		</tr>
		</c:forEach>
	</table>
	
	<br/>
    <a href='<spring:url value="/producto/form/" htmlEscape="true"/>'>Registrar Producto</a>
	
</div>