<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%-- <c:url var="hotelsUrl" value="/hotels"/> get ${hotelsUrl}--%>
<form:form id="searchForm" modelAttribute="searchCriteria" action="" method="" cssClass="inline ajaxForm">
    <span class="errors span-18">
    	<form:errors path="*"/>
    </span>
	<fieldset>
		<legend>Busqueda</legend>
		<div class="span-8">
			<label for="searchString">Filtro:</label>
			<form:input id="searchString" path="searchString"/>
		</div>
		<div class="span-6">
			<div>
				<label for="pageSize">Resultados Mostrados:</label>
				<form:select id="pageSize" path="pageSize">
					<form:option label="5" value="5"/>
					<form:option label="10" value="10"/>
					<form:option label="20" value="20"/>
				</form:select>
			</div>
		</div>
		<div class="span-3 last">
			<button id="find" type="submit">Buscar</button>
		</div>		
    </fieldset>
</form:form>
