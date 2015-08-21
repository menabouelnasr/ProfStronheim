<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
table{border-color: silver;background-color:white }
table td {border-color:silver;}
body { color: black; background-color: white;  text-align: center; }
h1 {text: blue;}
</style>
<title>Gradebook Table</title>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
</head>
<body>
<form action="GradebookOutput" method="post">
<p></p>
<p> What would you like to view: </p>
<p>
A) all assignments by student <br>
<input type="text" placeholder="student Id" name="A"><br>
<p></p>
B) All assignment of a particular type by student <br>
<input type="text" placeholder="assignment type" name="B"><br>
<p></p>
C) all assignments for particular type for a particular student<br>
<input type="text" placeholder="assignment type" name="C2" >
<input type="text" placeholder="student ID" name="C"></input><br>
<p></p>
D) average for student<br>
<input type="text" placeholder="student ID" name="D"><br>
<p></p>
E) highest and lowest grade for assignment<br>
<input type="text" placeholder="assignment type" name="E"><br>
<p></p>
F) done </p><br>
<input href="GradebookOutput" type=submit name=display value="A"> </input>
<input href="GradebookOutput" type=submit name=display value="B"> </input>
<input href="GradebookOutput" type=submit name=display value="C"> </input>
<input href="GradebookOutput" type=submit name=display value="D"> </input>
<input href="GradebookOutput" type=submit name=display value="E"> </input>
<input href="GradebookOutput" type=submit name=display value="F"> </input>
</form>


</body>
</html>