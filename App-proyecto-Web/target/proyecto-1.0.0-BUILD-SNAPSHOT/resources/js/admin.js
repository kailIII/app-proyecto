/**
 * @author Rodrigo Garcete
 * @since 02/01/2014
 */

function addItemAjaxPost() {
   		// get the form values
		var id = $('#id_${m.codigo}').val();
   		var nombre = $('#nombre').val();
		var cantidad = $('#cantidad').val();
		//var boton = '<button id="btnEliminar" title="Quitar Item del Pedido" class="btn btn-danger"onclick="quitarItemAjaxPost()">Quitar</button>';
		
		alert('Valor: ' + id);
		alert('Valor: ' + nombre);
		alert('Valor: ' + cantidad);
		
		//carga la tabla
		//addProducto(id, nombre, cantidad);
		
		$.ajax({
			type: "POST",
			url: "/pedido/addItem",
			data: "id=" + id + "&cantidad=" + cantidad,
			success: function(response){
			// we have the response
			//$('#info').html(response);
			//$('#id').val('');
		    $('#cantidad').val('');
		 },
	     error: function(e){
		 	alert('Error: ' + e);
	     }
		 });
	}
	
	function quitarItemAjaxPost() {
   		// get the form values
		var id = $('#id_${m.codigo}').val();
   		//var nombre = $('#nombre').val();
		var cantidad = $('#cantidad').val();
		//var boton = '<button id="btnEliminar" title="Quitar Item del Pedido" class="btn btn-danger"onclick="quitarItemAjaxPost()">Quitar</button>';
		
		alert('Valor: ' + id);
// 		alert('Valor: ' + nombre);
 		alert('Valor: ' + cantidad);
		
		//eliminar de la tabla, PENDIENTE
		//eliminarProducto(id, nombre, cantidad, boton);
		
		$.ajax({
			type: "POST",
			url: "/pedido/quitarItem",
			data: "id=" + id + "&cantidad=" + cantidad,
			success: function(response){
			// we have the response
			//$('#info').html(response);
			//$('#id').val('');
		    $('#cantidad').val('');
		 },
	     error: function(e){
		 	alert('Error: ' + e);
	     }
		 });
	}
	
	function eliminarProducto(idP, nombre, cantidadP, boton){
		var tr = '<tr>';
		tr+='<td>'+idP+'</td>';
		tr+='<td>'+nombre+'</td>';
		tr+='<td>'+cantidadP+'</td>';
		tr+='<td>'+boton+'</td>';
		
		lista.push({id:idP, nombre:nombre, cantidad:cantidadP, boton:boton});
		
		$('#table_pedido').append(tr);	
	}