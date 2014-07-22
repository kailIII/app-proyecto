<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<spring:message code="label.pedidos" var="label_pedidos" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.pedido.estado" var="label_pedido_estado" htmlEscape="false" />
	<spring:message code="label.pedido.fecha" var="label_pedido_fecha" htmlEscape="false" />
	<spring:message code="label.pedido.fechaVencimiento" var="label_pedido_fechaVencimiento" htmlEscape="false" />
	<spring:message code="label.pedido.proveedor" var="label_pedido_proveedor" htmlEscape="false" />
	
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="button.actualizar" var="button_actualizar" htmlEscape="false" />
	
	<div>
		<h3>${label_pedidos} <small> ${label_listado}</small></h3>	
	</div>
	
	<div id="mysearch"><br/></div>
    <br/>   

    <div>
		<table id="list"><tr><td/></tr></table> 
	</div>
	
	<div id="pager"></div>
	
	<script type="text/javascript">
	$(function(){      
	      $("#list").jqGrid({
	        url:'/proyecto/pedido/lista',
	        datatype: 'json',
	        mtype: 'GET',
	        colNames:['#', '${label_pedido_estado}', '${label_pedido_fecha}', '${label_pedido_fechaVencimiento}', '${label_pedido_proveedor}'],
	        colModel :[ 
	          {name:'postDateString', index:'postDate', width:85, align:'center'},
	          {name:'subject', index:'subject', width:115}, 
	          {name:'shortBody', index:'shortBody', width:240, sortable:false}, 
	          {name:'categoryId', index:'categoryId', width:80, align:'center'}, 
// 	          {name:'subCategoryId', index:'subCategoryId', width:80, align:'center', sortable:false},  
// 	          {name:'createdBy', index:'createdBy', width:80, sortable:false} 
	        ],
	        jsonReader : {
	            root:"entryData",
	            page: "currentPage",
	            total: "totalPages",
	            records: "totalRecords",
	            repeatitems: false,
	            id: "id"
	        },      
	        pager: '#pager',
	        rowNum:10,
	        rowList:[10,20,30],
	        sortname: 'postDateString',
	        sortorder: 'desc',
	        viewrecords: true,
	        gridview: true,
	        height: 450,
	        caption: '${labelBlogPostingEntries}',
	        onSelectRow: function(id){ 
	        	document.location.href ="/springblog/blogs/" + id;
	        }
	      });   
	      
	      $('#mysearch').jqGrid('filterGrid', '#list', { 
	    	  filterModel: [
	    	    {label: '${labelSubject}', name: 'subject'},
	    	    {label: '${labelCategory}', name: 'categoryId', stype: 'select', surl: '/springblog/categories/listforsearch'},
	    	    {label: '${labelFromPostDate}', name: 'fromPostDate', stype: 'text'},
	    	    {label: '${labelToPostDate}', name: 'toPostDate', stype: 'text'}
	    	  ],
	    	  formtype: 'vertical',
	    	  enableSearch: true,
	    	  enableClear: true,
	    	  autosearch: false
	      });
	      
	      $('#sg_fromPostDate').datepicker({ dateFormat: 'yy-mm-dd' });
	      $('#sg_toPostDate').datepicker({ dateFormat: 'yy-mm-dd' });    
	       
	    });
	</script>
	
</div>