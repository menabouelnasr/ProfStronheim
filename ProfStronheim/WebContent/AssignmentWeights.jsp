<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment Weights</title>
<style type="text/css">
table{border-color: silver;background-color:white }
table td {border-color:silver;}
body { color: black; background-color: white;  text-align: center; }
h1 {text: blue;}
</style>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
</head>
<body>
<form action="Weights" method="post">
Change the weights of the Assignments below: <br></br>
Homework:<br>
<input type="text" name="Homework"><br>
<br>
Quiz:<br>
<input type="text" name="Quiz"><br>
<br>
Test:<br>
<input type="text" name="Test"><br>
<br>
Project:<br>
<input type="text" name="Project"><br>
<br>
<input href="Weights.java" type=submit name=submit value="Submit"> </input>
<p></p>
</form>
</body>
</html>