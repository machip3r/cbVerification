<?php
	require_once('../model/functions_bd.php');
	$bd=new functions();

	$no_control=$_GET["no_control"];

	$rsCodigo=$bd->getCodigo($no_control);
	$row=mysqli_fetch_assoc($rsCodigo);

	if ($row>0) {
		$rs=$bd->getCodigo($no_control);

		while ($value=mysqli_fetch_array($rs)) {
			$dato[]=$value;
		}

		echo json_encode($dato);
	} else {
		echo "No hay";
	}
?>