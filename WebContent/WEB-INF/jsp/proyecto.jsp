<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="es" xml:lang="es" xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <title>Temblores en el Mundo</title>
  <link href="./resource/style.css" media="screen" rel="stylesheet" type="text/css" />
  <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>

<body>

<h1 align="center">Programacion Orientada a Aspectos | Proyecto Final</h1>
<table align="center" width:100%">
<tr>
<td style="width:20%">
</td>
<td style="width:30%" valign="top">
<b> Componentes de la aplicacion:</b> <br>
Framework: Spring Tool Suite Version: 3.5.1 <br>
Eclipse Kepler SR2 (4.3.2) <br>
Lenguaje: Java con uso de AOP <br>
Base de datos: NoSQL, Couch DB <br>
Datos: Json USGS Feeds Magnitude>2.5 <br>
Servidor Web: Tomcat 6 <br>
Front-end: Librerias Javascript D3.js
</td>
<td style="width:30%" valign="top">
<b>Presentado por:</b> <br>
Alumno: Manuel Gerardo Bolanos <br>
Matricula: A01339809 <br>
Grupo: 1 <br>
Carrera: Especialidad en Ingeniería de Software
</td>
<td style="width:20%">
</td>
</tr>
<tr align="justify">
  <!-- Content begin -->
  <svg id="map"></svg>
  <!-- Content end -->

  <!-- Dependencies begin-->
  <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.0.0/moment.min.js"></script>
  <!-- d3 -->
  <script src="http://d3js.org/d3.v3.min.js"></script>
  <script src="http://d3js.org/d3.geo.projection.v0.min.js"></script>
  <script src="http://d3js.org/topojson.v0.min.js"></script>
  <!-- Dependencies end-->

  <script src="./resource/app.js" type="text/javascript">
  </script>
  </tr>
</table>

</body>
</html>