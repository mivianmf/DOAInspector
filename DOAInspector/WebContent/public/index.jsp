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

<link href="./resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link href="./resources/bootstrap/css/dashboard.css" rel="stylesheet">
<script src="./resources/assets/js/ie-emulation-modes-warning.js"></script>

<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">

			<jsp:include page="barra_superior_doainspector.jspf" />
			<jsp:include page="barra_superior_login.jspf" />
		</div>
	</nav>

</head>

<body>


	<div class="jumbotron">
		<div class="container">
			<h1>DOA Inspector</h1>
			<p>Texto explicativo sobre o DOA Inspector</p>
		</div>
	</div>

	<jsp:include page="listagem_sistemas.jspf" />
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="./resources/assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="./resources/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
