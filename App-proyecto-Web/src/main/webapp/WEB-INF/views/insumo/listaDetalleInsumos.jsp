<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.insumos" var="label_insumos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	
	<spring:message code="label.insumo.codigo" var="label_insumo_codigo" htmlEscape="false" />
	<spring:message code="label.insumo.nombre" var="label_insumo_nombre" htmlEscape="false" />
	<spring:message code="label.insumo.umedida" var="label_insumo_umedida" htmlEscape="false" />
	<spring:message code="label.insumo.cantidad" var="label_insumo_cantidad" htmlEscape="false" />
	<spring:message code="label.insumo.precio" var="label_insumo_precio" htmlEscape="false" />
	<spring:message code="label.insumo.subtotal" var="label_insumo_subtotal" htmlEscape="false" />
	
	<div class="table-responsive">
		<table class="table table-bordered" id="tabla" >
			<thead>
				<tr>
					<th>${label_insumo_codigo}</th>
					<th>${label_insumo_nombre}</th>
					<th>${label_insumo_umedida}</th>
					<th>${label_insumo_cantidad}</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${insumos}" var="m">
			<tr>
				<td>
					<input id="id" type="number" value="${m.codigo}"/> 
<%-- 					_${m.codigo} _${m.codigo} --%>
				</td>	
				<td>${m.nombre}</td>
				<td>${m.umedida.abreviatura}</td>
				<td><input id="cantidad" type="number" min="0"/></td>
				<td><button class="btn btn-info"onclick="addItemAjaxPost()" title="Agregar Item al Pedido">Agregar</button></td>
				<td><button class="btn btn-danger"onclick="quitarItemAjaxPost()" title="Quitar Item del Pedido">Quitar</button></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>