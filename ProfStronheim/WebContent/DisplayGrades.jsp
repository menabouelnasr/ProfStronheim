<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professor Strongheim's Gradebook</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <style> 
  body {text: white; background-color: white;  text-align: center; }
   p {background-color: white;}
   h2{text:white;}
   </style>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="jumbotron"> 
<div class="container">
  <h1>Professor Strongheim's Gradebook</h1>
</div>
</div>
</nav>
<nav>

</nav>



<form action="Gradebook" method="post">
<br></br>
<p>Please enter the student ID number or assignment type that you are inquiring about <br></br><p>
<br>
Student ID:<br>
<input type="text" name="StudentID"><br>
<br>
Assignment Name:<br>
<input type="text" name="Assignment"><br>
<br>
Type:<br>
<input type="text" name="type"><br>
<br>
Date (MM/DD/YYY):<br>
<input type="text" name="day"><br>
<br>
Grade:<br>
<input type="text" name="grade"><br>
<br>
<input href="Gradebook" type=submit name=submit value="Submit"> </input>
<p></p>
</form>

</body>
</html>