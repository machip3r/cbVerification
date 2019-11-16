<?php
	include_once("controller/verificar_login.php");
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="user-scalable=no,width=device-width,initial-scale=1">
	<link rel="stylesheet" type="text/css" href="view/css/cosmo.css">
	<link rel="stylesheet" type="text/css" href="view/css/style.css">
	<title>Login</title>
</head>
<body style="background:url('view/img/bgAdmin.jpg') no-repeat; background-size:100%">
	<center>
		<div id="container">
			<div class="central" id="buttons">
				<br>
				<img src="view/img/userLogin.png" width="30%">
				<br>
				<br>
				<form action="model/verificar.php" method="POST">
					<table id="table-login">
						<tr>
							<td style="padding:10px;">Usuario: </td><td style="padding:10px;"><input type="text" class="form-control" name="usr" placeholder="Usuario" autocomplete="off" autofocus required></td>
						</tr>
						<tr>
							<td style="padding:10px;">Contraseña: </td><td style="padding:10px;"><input type="password" class="form-control" name="pass" placeholder="Contraseña" required></td>
						</tr>
						<tr>
							<td colspan="2" style="padding:10px;"><button type="submit" class="btn btn-secondary" style="width:50%; height:60px;">Ingresar</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</center>
</body>
</html>