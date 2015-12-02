<!DOCTYPE html>
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
<link href="./resources/bootstrap/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./resources/d3/css/jqcloud.css" />

<script src="./resources/assets/js/ie-emulation-modes-warning.js"></script>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<jsp:include page="barra_superior_doainspector.jspf" />
		</div>
	</nav>


</head>

<body>
	<div class="container">
</br>
</br>
</br>

<style>
#title h2 {
   color:white;
}
</style>

		<h2 class="sub-header" id="title"><%=request.getParameter("project")%> - Authors</h2>
</div>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.js"></script>
    <script type="text/javascript" src="./resources/d3/js/jqcloud.js"></script>
    <script type="text/javascript">
     
    var word_list =  <%=(String)request.getAttribute("json")%>
      $(function() {
        $("#my_favorite_latin_words").jQCloud(word_list);
      });
   
      document.getElementById("title").style.color = "gray";
      
      </script>

 <div id="my_favorite_latin_words" align="center" style="width: 1100px; height: 500px;"></div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="./resources/assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="./resources/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
