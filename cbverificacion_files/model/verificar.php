<?php
	require_once('functions_bd.php');
	$bd=new functions();

	$usuario=$_POST['usr'];
	$password=$_POST['pass'];

	$rsVerify=$bd->verificar($usuario, $password);
	$row=mysqli_fetch_assoc($rsVerify);

	if ($row>0) {
		session_start();
		$_SESSION['user']=$usuario;
		$_SESSION['password']=$password;
		header("location: ../view/addministracion.php");
	} else {
		header("location: ../index.php");
	}
?>