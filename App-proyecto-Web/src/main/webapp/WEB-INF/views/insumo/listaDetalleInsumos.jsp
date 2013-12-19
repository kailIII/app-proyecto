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
	
		<table class="table table-hover" id="tabla">
			<thead>
				<tr>
					<th><input id="checkAll" onclick="checkTodos(this.id,'tabla');" type="checkbox" name="checkAll" title="Seleccionar Todos" value="1"/></th>
					<th>${label_insumo_codigo}</th>
					<th>${label_insumo_nombre}</th>
					<th>${label_insumo_umedida}</th>
					<th>${label_insumo_cantidad}</th>
				</tr>
			</thead>
			<c:forEach items="${insumos}" var="m">
			<tr>
				<td><input type="checkbox" name="seleccion" value="1"/></td>
				<td>${m.codigo}</td>
				<td>${m.nombre}</td>
				<td>${m.umedida.abreviatura}</td>
				<td><input type="text" name="cantidad" title="cantidad de insumo para el pedido"></td>
			</tr>
			</c:forEach>
		</table>
</div>

<script>
	function checkTodos (id,pID) {	 
		$( "#" + pID + " :checkbox").attr('checked', $('#' + id).is(':checked')); 
	}
</script>