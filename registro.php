<?php

hostname_localhost="localhost";
database_localhost="";
username_localhost="root";
password_localhost="";
json=array();

    if(isset($_GET["nombre"]) && isset($_GET["email"]) isset($_GET["password"]) &&){
        $nombre=$_GET['nombre'];
        $email=$_GET['email'];
        $password=$_GET['password'];

        $conexion = mysqli_connect($hostname_localhost, username_localhost, password_localhost, database_localhost);

        $insert="INSERT INTO usuarios(nombre, email, password) VALUES ('{$nombre}','{$email}','{$password}')";
        $resultado_insert=mysqli_connect($conexion,$insert);

        if($resultado_insert){
            $consulta="SELECT * FROM usuarios WHERE nombre = '{$nombre}'";
            $resultado=mysqli_query($conexion, $consulta);
            if($registro=mysqli_fetch_array($resultado)){
                $json['usuario'][]=$registro;
            }
            mysqli_close($conexion);
            echo json_encode($json);
        }
        else{
            $resulta["nombre"] = 0;
            $resulta["email"] = 'No registra';
            $resulta["password"] = 'No registra';
            $json['usuario'][]=$resulta;
            echo json_encode($json);
        }
    }
    else{
            $resulta["nombre"] = 0;
            $resulta["email"] = 'WS no retorna';
            $resulta["password"] = 'WS no retorna';
            $json['usuario'][]=$resulta;
            echo json_encode($json);
    }

?>