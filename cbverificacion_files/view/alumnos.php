<?php
	include_once('../controller/verificar_usuario.php');
	require_once('../model/functions_bd.php');
	$bd=new functions();
	$rsAlumno=$bd->getAllAlumno();
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="user-scalable=no,width=device-width,initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/cosmo.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Alumnos</title>
</head>
<body>
	<center>
		<div id="container">
			<div class="central" id="alumno">
				<h1>Alumnos</h1>
				<table id="table-alumno" class="table table-hover">
					<thead>
						<th>No_Control</th>
						<th>Alumno</th>
						<th>Teléfono</th>
					</thead>
					<?php
						while ($value=mysqli_fetch_array($rsAlumno)) {
							echo "<tr>";
							echo "<td>".$value[0]."</td>";
							echo "<td>".$value[2]."</td>";
							echo "<td>".$value[4]."</td>";
					  		echo "</tr>";
						}
					?>
					<tr>
						<td colspan="4"><a href='addministracion.php'><button type="button" class="btn btn-secondary" style="margin-top:20px; width:50%; height:50px;">Regresar</button></a></td>
					</tr>
				</table>
			</div>
		</div>
	</center>
</body>
</html>