<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">

<head>

<!-- stylesheets -->
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/d3/css/select2.css">
<style type="text/css">
body {
	padding: 40px;
}
</style>

<!-- scripts -->
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="./resources/d3/js/select2.js"></script>

<script>
	$(function() {
		// turn the element to select2 select style
		$('#select2').select2({
			placeholder : "Select an author",
			allowClear : true
		});
	});
</script>
</head>

<body>

	<p>
		<select id="select2" style="width: 300px">


			<%
				ArrayList<String> authors = (ArrayList<String>) request.getAttribute("map");
				for (String author : authors) {
			%>

			<option value="<%=author%>"><%=author.replaceAll("_", " ")%></option>

			<%
				}
			%>
		</select>
	</p>
</body>

</html>

















<%-- <!DOCTYPE html>
<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.authorship.*"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>DOA Inspector</title>

<link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<script src="./resources/assets/js/ie-emulation-modes-warning.js"></script>

<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">

			<jsp:include page="barra_superior_doainspector.jspf" />
		</div>
	</nav>

  <link rel="stylesheet" href="./resources/d3/css/select2.css">
  <style type="text/css">
  body {
    padding: 40px;
  }
  </style>

  <!-- scripts -->
  <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
  <script src="./resources/d3/js/select2.js"></script>

  <script>
    $(function(){
      // turn the element to select2 select style
      $('#select2').select2();
    });
  </script>


</head>

<body>
</br>
</br>
</br>
</br>  
  <select id="select2" style="width:300px">
  <%
						ArrayList<String> authors = (ArrayList<String>) request.getAttribute("map");
						for (String author : authors) {
					%>
					
					  <option value="<%=author%>"><%=author.replaceAll("_", " ")%></option>
						
					<%
						}
					%>
  
</select>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="./resources/assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="./resources/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
 --%>