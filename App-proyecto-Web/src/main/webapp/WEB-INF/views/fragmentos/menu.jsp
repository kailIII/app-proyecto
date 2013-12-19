<%-- Fragmento com trecho utilizado no menu de navegacao. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- <div> -->
	
	<spring:message code="label.insumos" var="label_insumos" htmlEscape="false" />
	<spring:message code="menu.lista" var="menu_lista" htmlEscape="false" />
	<spring:message code="menu.incluir" var="menu_incluir" htmlEscape="false" />
	<spring:message code="menu.sobre" var="menu_sobre" htmlEscape="false" />
	
<!-- 	<ul class="nav nav-list" style="padding-top: 15px;"> -->
<!-- 		<li> -->
<%-- 			<em>${label_insumos}</em> --%>
<!-- 		</li> -->
<!-- 		<li> -->
<%-- 			<a href="/inputs/list">${menu_lista}</a> --%>
<!-- 		</li> -->
<!-- 		<li> -->
<%-- 			<a href="/inputs/form">${menu_incluir}</a> --%>
<!--         </li> -->
<!-- 		<li class="divider"></li>  -->
<!-- 		<li> -->
<%-- 			<em>${label_insumos}</em> --%>
<!-- 		</li> -->
<!-- 		<li> -->
<%-- 			<a href="/inputs/list">${menu_lista}</a> --%>
<!-- 		</li> -->
<!-- 		<li> -->
<%-- 			<a href="/inputs/form">${menu_incluir}</a> --%>
<!--         </li>  -->
<!-- 	</ul>	 -->

	<div class="row">
<!--   	<div class="span3"> -->
<!-- 	<div class="well"> -->
	<ul class="nav nav-list">
		<li>
			<label class="tree-toggle nav-header">Movimientos</label>
				<ul class="nav nav-list tree">
             		<li><a href="../pedido/listado">Pedidos</a></li>
                	<li><a href="#">Recepcion</a></li>
                	<li><a href="../compra/listado">Compras</a></li>
                	<li><a href="#">Ventas</a></li>
				</ul>
		</li>
		<li class="divider"></li>
		<li>
			<label class="tree-toggle nav-header">Produccion</label>
				<ul class="nav nav-list tree">
					<li><a href="../formula/listado">Formulas</a></li>
             		<li><a href="#">Confeccionar</a></li>
				</ul>
		</li>
		<li class="divider"></li>
		<li>
			<label class="tree-toggle nav-header">Registros</label>
				<ul class="nav nav-list tree">
             		<li><a href="../insumo/listado">Insumos</a></li>
             		<li><a href="../umedida/listado">U.Medidas</a></li>
                	<li><a href="../producto/listado">Productos</a></li>
                	<li><a href="../marca/listado">Marcas</a></li>
                	<li><a href="../clasificacion/listado">Clasificaciones</a></li>
                	<li><a href="../grupo/listado">Grupos</a></li>
                	<li><a href="../impuesto/listado">Impuestos</a></li>
                	<li><a href="../lote/listado">Lotes</a></li>
                	<li><a href="../proveedor/listado">Proveedores</a></li>
                	<li><a href="../deposito/listado">Depositos</a></li>
                	
                	<li><a href="../ciudad/listado">Ciudades</a></li>
                	<li><a href="../departamento/listado">Departamentos</a></li>
                	<li><a href="../pais/listado">Paises</a></li>
                	<li><a href="../usuario/listado">Usuarios</a></li>
				</ul>
		</li>
	</ul>
	
</div>