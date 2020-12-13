<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body style="color:red">
<h1>hi ${message}!!! We Welcome you...</h1>
<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "userdb";
String userId = "root";
String password = "";
String savePath="D:\\eclipse-workspace\\User\\WebContent\\Images\\";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table>
<tr bgcolor="#A52A2A">
<td><b>ID</b></td>
<td><b>Image</b></td>
<td><b>FirstName</b></td>
<td><b>LastName</b></td>
<td><b>Email</b></td>
<td><b>MobileNumber</b></td>
<td><b>DOB</b></td>
<td><b>Address</b></td>
<td><b>Gender</b></td>
<td><b>Languages</b></td>
<td><b>Objective</b></td>
<td><b>Ssc Marks</b></td>
<td><b>Hsc marks</b></td>
<td><b>Btech Cgpa</b></td>
<td><b>Proffestional Skills</b></td>
<td><b>Additional Skills</b></td>
<td><b></b>Strength</td>
<td><b>Professional Hobbies</b></td>
<td><b>Hobbies</b></td>
</tr>
<%
try{  
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM resumeinfo";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
String filename=savePath+resultSet.getString("fileName");
%>
<tr bgcolor="#DEB887">
<td><%=resultSet.getString("id") %></td>
<td> <img alt="UserImage" name="imguser" id="imguser" src="Class-registration.jpg"/> </td>
<td><%=resultSet.getString("firstname") %></td>
<td><%=resultSet.getString("lastname") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("mobilenumber") %></td>
<td><%=resultSet.getString("D.o.b") %></td>
<td><%=resultSet.getString("Address") %></td>
<td><%=resultSet.getString("Gender") %></td>
<td><%=resultSet.getString("Languages") %></td>
<td><%=resultSet.getString("objective") %></td>
<td><%=resultSet.getString("Sscmarks") %></td>
<td><%=resultSet.getString("Hscmarks") %></td>
<td><%=resultSet.getString("btechmarks") %></td>
<td><%=resultSet.getString("proffskills") %></td>
<td><%=resultSet.getString("Addskills") %></td>
<td><%=resultSet.getString("Strength") %></td>
<td><%=resultSet.getString("Proffhobbies") %></td>
<td><%=resultSet.getString("hobbies") %></td>
</tr>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>