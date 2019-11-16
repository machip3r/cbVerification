<?php
	require_once('../model/functions_bd.php');
	$bd=new functions();

	$codigo=$_POST["codigo"];
	$no_control=$_POST["no_control"];

	if (mysqli_connect_errno()) {
		echo "Error en la conexión de la base de datos";
	} else {
		$query="insert into codigo(codigo, no_control) values('$codigo', $no_control) ";
		$bd->execute($query);
			
		echo "Realizado";
	}
?>