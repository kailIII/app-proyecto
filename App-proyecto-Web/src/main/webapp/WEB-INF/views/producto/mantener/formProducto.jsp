<%-- 
     Fragmento com o formulario de preenchimento com os dados da mercadoria.
     Utilizado pela pagina de inclusao e edicao de mercadoria.
     O formulario de mercadorias utiliza o plugin Validation do JQuery, para validar os inputs.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.producto" var="label_insumo" htmlEscape="false" />
<spring:message code="label.producto.nombre" var="label_producto_nombre" htmlEscape="false" />
<spring:message code="label.producto.descripcion" var="label_producto_descripcion" htmlEscape="false" />
<spring:message code="label.producto.cantidad" var="label_producto_cantidad" htmlEscape="false" />
<spring:message code="label.producto.precio" var="label_producto_precio" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="producto" class="form-horizontal" id="frmProducto">
	<input type="hidden" name="id" value="${producto.codigo}" />
	<fieldset>
   		<legend><h3>${label_producto} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_producto_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_producto_descripcion}</label>
    		<div class="controls">
    			<form:input path="descripcion" class="input-large"/>
    			<form:errors path="descripcion" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_producto_cantidad}</label>
    		<div class="controls">
    			<form:input path="cantidad" class="input-small" id="cantidad" />
    			<form:errors path="cantidad" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_producto_precio}</label>
    		<div class="controls">
    			<form:input path="precio" class="input-small"/>
    			<form:errors path="precio" cssClass="alert alert-error" />
    		</div>
   		</div>
   	</fieldset>
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/home"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmProducto").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	cantidad: { required: true, number: true },
				precio: { required: true, moneda: true }
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmProducto").submit(); });

    $.validator.addMethod("moneda",
    	function(value, element) {
    		return this.optional(element) || /^-?(?:\d+|\d{1,3}(?:.\d{3})+)?(?:\,\d+)?$/.test(value);
    	}, 'Valor invalido para moneda');
});
</script>