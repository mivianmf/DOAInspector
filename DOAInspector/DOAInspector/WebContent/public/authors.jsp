<!DOCTYPE html>
<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.*"%>
<html lang="en">
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
<link rel="stylesheet" href="./resources/d3/css/select2.css">
<style type="text/css">
body {
	padding: 40px;
}
</style>


<script src="./resources/assets/js/ie-emulation-modes-warning.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="./resources/d3/js/select2.js"></script>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">

		<jsp:include page="barra_superior_doainspector.jspf" />
	</div>
</nav>

</head>

</head>

<body>
	</br>

	<nav class="navbar navbar-inverse">


		<div class="content">
			<div class="row">
				<div class="col-md-12 col-md-12 col-md-12 col-md-12">
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
						</br> <label class="control-label" for="cest" id="selectAuthors">
							Authors:</label> <select id="select2" style="width: 300px">
							<%
								ArrayList<String> authors = (ArrayList<String>) request.getAttribute("map");
								for (String author : authors) {
							%>

							<option value='<%=author.replaceAll(" ", "_")%>'><%=author.replaceAll("_", " ")%></option>
							<%
								}
							%>
						</select> </select>
						</br>
						</br>
					</div>
				</div>
			</div>
		</div>
	</nav>


<!-- 	<IFRAME src="http://www.bufaloinfo.com.br" width="" height="350" scrolling="no" frameborder="0" align="center"></IFRAME>
 -->
 	<iframe  name="iframe_a"></iframe>

	<a id="link" href="author_files?project<%=request.getParameter("project")%>=&author=" target="iframe_a">teste</a> 


</body>
<script>


	$(function() {
		// turn the element to select2 select style
		$('#select2').select2({
			placeholder : "Select an author",
			allowClear : true
		});
	});

	$('#select2').change(function() {
		
		var data = $('#select2').select2('data');
		var x = data.id;
		alert(x);
		var y = document.getElementById("link").href;
		var w = y+x;
		alert(w);
	
		document.getElementById("link").href = w;
		
	});

	document.getElementById("selectAuthors").style.color = "white";
</script>

</html>