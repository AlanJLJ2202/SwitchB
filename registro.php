<?php
$hostname_localhost="localhost";
$database_localhost="id18601609_pruebadb";
$username_localhost="id18601609_root";
$password_localhost="Switch12345*";
$json=array();

    if(isset($_GET["nombre"]) && isset($_GET["email"]) && isset($_GET["password"])){
        $nombre=$_GET['nombre'];
        $email=$_GET['email'];
        $password=$_GET['password'];

        $conexion = mysqli_connect($hostname_localhost, $username_localhost, $password_localhost, $database_localhost);

        $insert="INSERT INTO Usuarios(nombre, email, password) VALUES ('{$nombre}','{$email}','{$password}')";
        $resultado_insert=mysqli_query($conexion,$insert);

        if($resultado_insert){
            $consulta="SELECT * FROM Usuarios WHERE nombre = '{$nombre}'";
            $resultado=mysqli_query($conexion, $consulta);
            if($registro=mysqli_fetch_array($resultado)){
                $json['Usuarios'][]=$registro;
            }
            mysqli_close($conexion);
            echo json_encode($json);
        }
        else{
            $resulta["nombre"] = 0;
            $resulta["email"] = 'No registra';
            $resulta["password"] = 'No registra';
            $json['Usuarios'][]=$resulta;
            echo json_encode($json);
        }
    }
    else{
            $resulta["nombre"] = 0;
            $resulta["email"] = 'WS no retorna';
            $resulta["password"] = 'WS no retorna';
            $json['Usuarios'][]=$resulta;
            echo json_encode($json);
    }

?>