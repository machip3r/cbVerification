<?php
	session_start();
	$user=$_SESSION["user"];
	$password=$_SESSION["password"];
	if (!isset($user) && !isset($password)) {
		header("Location: ../index.php");
	}
?>