<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.authorship.*"%>


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>DOA Inspector</title>

<link href="./resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link href="./resources/bootstrap/css/dashboard.css" rel="stylesheet">
<script src="./resources/assets/js/ie-emulation-modes-warning.js"></script>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">

		<jsp:include page="barra_superior_doainspector.jspf" />


	</div>
</nav>

</head>

<body>
	<div class="container">
		<!-- Example row of columns -->
		<h2 class="sub-header"><%=request.getParameter("author").replaceAll("_"," ") %></h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>File Name</th>
						<th>DOA Value</th>
						
						<th><a href="#" data-toggle="tooltip" data-placement="bottom" title="Texto explicativo">Agree?</a></th>
						<th></th>
					</tr>
				</thead>
				<tbody>

					<%
						ArrayList<DOA> authorsFiles = (ArrayList<DOA>) request.getAttribute("DOAlist");
						for (DOA files : authorsFiles) {
					%>
					<tr>
						<td><%=files.getName()%></td>
						<td><%=files.getDoa()%></td>
						<td>
						  <label class="checkbox-inline"><input type="checkbox" value="yes">Yes</label>
						  <label class="checkbox-inline"><input type="checkbox" value="no">No</label>
						</td>

					</tr>
					<%
						}
					%>

				</tbody>
			</table>
		</div>
	</div>



<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="./resources/assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="./resources/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
