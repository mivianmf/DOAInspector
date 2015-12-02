<!DOCTYPE html>
<html lang="en">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>DOA Inspector</title>

<link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="./resources/bootstrap/css/dashboard.css" rel="stylesheet">
<link href="./resources/bootstrap/css/css_stylish_panel.css" rel="stylesheet">

<script src="./resources/assets/js/ie-emulation-modes-warning.js"></script>

<head>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<jsp:include page="barra_superior_doainspector.jspf" />
	  </div>
	</nav>

</head>

<body>



<div class="container">
  <div class="page-header">
    <h1 class="text-center">Como Visualizar?</h1>
  </div>
  <p class="lead text-center">Descrever aqui as formas de visualização</p>
  <div class="container">
    <div class="row stylish-panel">
      <div class="col-md-4">
        <div>
          <img src="http://lorempixel.com/200/200/abstract/1/" alt="Texto Alternativo" class="img-circle img-thumbnail">
          <h2>TreeMap</h2>
          <p>Pequena descrição treeMap</p>
          <a href="treemap?project=<%= request.getParameter("project") %>" class="btn btn-primary" title="See more">See</a>
        </div>
      </div>
      <div class="col-md-4">
        <div>
          <img src="http://lorempixel.com/200/200/abstract/2/" alt="Texto Alternativo" class="img-circle img-thumbnail">
          <h2>Authors Cloud</h2>
          <p>Descrição authors cloud </p>
          <a href="authors_cloud?project=<%= request.getParameter("project") %>" class="btn btn-primary" title="See more">See</a>
        </div>
      </div>
      <div class="col-md-4">
        <div>
          <img src="http://lorempixel.com/200/200/abstract/3/" alt="Texto Alternativo" class="img-circle img-thumbnail">
          <h2>Authors Search</h2>
          <p>Descrever tabela de arquivos do autor, concorda/descorda</p>
          <a href="search?project=<%= request.getParameter("project") %>" class="btn btn-primary" title="See more">See</a>

        </div>
      </div>
    </div>
    </div>
</div>

	





	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="./resources/assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="./resources/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
