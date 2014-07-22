<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<spring:message code="label.productos" var="label_productos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	
	<spring:message code="label.producto.codigo" var="label_producto_codigo" htmlEscape="false" />
	<spring:message code="label.producto.nombre" var="label_producto_nombre" htmlEscape="false" />
	<spring:message code="label.producto.cantidad" var="label_producto_cantidad" htmlEscape="false" />
	<spring:message code="label.producto.precio" var="label_producto_precio" htmlEscape="false" />
	<spring:message code="label.producto.subtotal" var="label_producto_subtotal" htmlEscape="false" />
	
		<table class="table table-bordered" id="tabla">
			<thead>
				<tr>
					<th><input id="checkBoxAll" type="checkbox"/></th>
					<th>${label_producto_nombre}</th>
					<th>${label_producto_cantidad}</th>
				</tr>
			</thead>
			<c:forEach items="${productos}" var="m">
				<tr id="tr_${m.codigo}">
					<td id="td_${m.codigo}">
						<input id="id_${m.codigo}" name="id_producto" type="checkbox" value="${m.codigo}"/> 
					</td>	
					<td>${m.nombre}</td>
					<td>
						<input id="cantidad_${m.codigo}" type="number" name="id_cantidad[]" min="0" class="input-small"/>
					</td>
				</tr>
			</c:forEach>
		</table>
</div>