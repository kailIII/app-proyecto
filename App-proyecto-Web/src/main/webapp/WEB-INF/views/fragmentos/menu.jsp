<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<div class="row">
	<ul class="nav nav-list">
		<li>
			<label class="tree-toggle nav-header">Movimientos</label>
				<ul class="nav nav-list tree">
             		<li><a href="../pedido/listado">Pedidos</a></li>
                	<li><a href="../recepcion/listado">Recepcion</a></li>
                	<li><a href="../compra/listado">Compras</a></li>
                	<li><a href="../venta/listado">Ventas</a></li>
                	<li><a href="../formula/listado">Formulas</a></li>
             		<li><a href="../produccion/listado">Produccion</a></li>
				</ul>
		</li>
		<li class="divider"></li>
		<li>
			<label class="tree-toggle nav-header">RR.HH</label>
				<ul class="nav nav-list tree">
					<li><a href="../cargo/listado">Cargos</a></li>
             		<li><a href="../empleado/listado">Empleado</a></li>
				</ul>
		</li>
		<li class="divider"></li>
		<li>
			<label class="tree-toggle nav-header">Registros</label>
				<ul class="nav nav-list tree">
					<spring:url value="/tpersona" var="crear_url_tipoPersona" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_tipoPersona}">Tipo Persona</a></li>
                	<spring:url value="/cliente" var="crear_url_cliente" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_cliente}">Clientes</a></li>
					<spring:url value="/proveedor" var="crear_url_proveedor" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_proveedor}">Proveedores</a></li>
					<spring:url value="/producto" var="crear_url_producto" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_producto}">Productos</a></li>
					<spring:url value="/umedida" var="crear_url_umedida" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_umedida}">U. Medida</a></li>
					<spring:url value="/marca" var="crear_url_marca" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_marca}">Marcas</a></li>
					<spring:url value="/grupo" var="crear_url_grupo" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_grupo}">Grupos</a></li>
                	<spring:url value="/impuesto" var="crear_url_impuesto" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_impuesto}">Impuestos</a></li>
                	<spring:url value="/lote" var="crear_url_lote" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_lote}">Lotes</a></li>
                	<spring:url value="/deposito" var="crear_url_deposito" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_deposito}">Depositos</a></li>
                	<spring:url value="/ciudad" var="crear_url_ciudad" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_ciudad}">Ciudades</a></li>
                	<spring:url value="/dep" var="crear_url_dep" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_dep}">Departamentos</a></li>
                	<spring:url value="/pais" var="crear_url_pais" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_pais}">Pais</a></li>
                	<spring:url value="/usuario" var="crear_url_usuario" htmlEscape="true">
						<spring:param name="list"></spring:param>
					</spring:url>
                	<li><a href="${crear_url_usuario}">Usuarios</a></li>
				</ul>
		</li>
	</ul>
	
</div>