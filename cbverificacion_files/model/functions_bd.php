<?php
	class functions{
		private $conexion;

		function __construct(){
            //$this->conexion=mysqli_connect("localhost", "root", "laboratorio", "verificacion");
            //$this->conexion=mysqli_connect("localhost", "root", "caps2300", "verificacion");
            $this->conexion=mysqli_connect("localhost", "id5607173_cesaraxel24", "caps2001", "id5607173_moviles");
		}

		public function desconectar(){
			mysqli_close($this->conexion);
		}

		public function execute($query) {
        	$rs=mysqli_query($this->conexion, $query);
			return $rs;
		}

		public function getAllAlumno(){
			$query="select * from alumno ";
			$rs=mysqli_query($this->conexion, $query);
			return $rs;
		}

		public function getAllCodigo(){
			$query="select a.codigo, a.no_control, b.alumno from codigo a inner join alumno b on(a.no_control=b.no_control) ";
			$rs=mysqli_query($this->conexion, $query);
			return $rs;
		}

		public function verificar($usuario, $password){
			$query="select * from administrador where usuario='$usuario' and contrasena='$password' ";
			$rs=mysqli_query($this->conexion, $query);
			return $rs;
		}

		public function verificarAlumno($usuario){
			$query="select no_control, contrasena from alumno where usuario='$usuario' ";
			$rs=mysqli_query($this->conexion, $query);
			return $rs;
		}

		public function getCodigo($no_control){
			$query="select codigo from codigo where no_control=$no_control ";
			$rs=mysqli_query($this->conexion, $query);
			return $rs;
		}
	}
?>