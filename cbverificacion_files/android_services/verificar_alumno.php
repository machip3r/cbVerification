<?php
	require_once('../model/functions_bd.php');
	$bd=new functions();

	$usuario=$_GET["usuario"];
	$dato=array();

	$rsVerify=$bd->verificarAlumno($usuario);
	$row=mysqli_fetch_assoc($rsVerify);

	if ($row>0) {
		$rs=$bd->verificarAlumno($usuario);

		while ($value=mysqli_fetch_array($rs)) {
			$dato[]=$value;
		}

		echo json_encode($dato);
	} else {
		echo "El usuario no existe";
	}
?>