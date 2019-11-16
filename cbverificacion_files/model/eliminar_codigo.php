<?php
	require_once('../model/functions_bd.php');
	$bd=new functions();

	if (mysqli_connect_errno()) {
		echo "Error en la conexión de la base de datos";
	} else {
		$query="delete from codigo";
		$bd->execute($query);

		echo "Realizado";
	}
?>