<?php
	include_once('../controller/verificar_usuario.php');
?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="user-scalable=no,width=device-width,initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/cosmo.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Administración</title>
</head>
<body style="background:url('img/bgAdmin.jpg') no-repeat; background-size:100%">
	<center>
		<div id="container">
			<div class="central" id="buttons">
				<table id="table-button">
					<tr>
						<td style="padding:10px;"><h1>¿Qué deseas hacer?</h1></td>
					</tr>
					<tr>
						<td style="padding:10px;"><a href="alumnos.php"><button type="button" class="btn btn-secondary" style="width:100%; height:70px;">Ver Alumnos</button></a></td>
					</tr>
					<tr>
						<td style="padding:10px;"><a href="codigos.php"><button type="button" class="btn btn-secondary" style="width:100%; height:70px;">Ver Códigos</button></a></td>
					</tr>
					<tr>
						<td style="padding:10px;"><a href="../controller/cs.php"><button type="button" class="btn btn-danger" style="width:100%; height:70px;">Salir</button></a></td>
					</tr>
				</table>
			</div>
		</div>
	</center>
</body>
</html>