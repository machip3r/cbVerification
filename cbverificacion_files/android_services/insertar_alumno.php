<?php
	require_once('../model/functions_bd.php');
	$bd=new functions();

	$no_control=$_POST["no_control"];
	$usuario=$_POST["usuario"];
	$alumno=$_POST["alumno"];
	$contrasena=$_POST["contrasena"];
	$telefono=$_POST["telefono"];

	if ($usuario!="" && $contrasena!="") {
		if (mysqli_connect_errno()) {
			echo "Error en la conexión de la base de datos";
		} else {
			$query="insert into alumno(no_control, usuario, alumno, contrasena, telefono) values($no_control, '$usuario', '$alumno', '$contrasena', '$telefono') ";
			$bd->execute($query);

			echo "Realizado";
		}
	} else {
		echo "Por favor llena todos los campos";
	}
?>