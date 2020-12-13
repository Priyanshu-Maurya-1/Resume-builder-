<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <center><h1>Resume Form</h1></center>	
<title>ResumeBuilder</title>
	<style type="text/css">
	#k1
	{
		width:100%;
		height:90%;
		border:2px solid black;
	}
	 .centerdiv {
            width: 850px;
            height: 1400px;
            position: absolute;
            top: 50%;
            left: 50%;
            background-color: red;
            transform: translate(-50%, -50%);
            background-image: linear-gradient(25deg, white 50%, rgb(255, 255, 102) 50%);
            box-shadow: 0 1px 6px rgba(0, 0, 0, 0), 0 1px 4px rgba(0, 0, 0, 0);
        }	
	</style>
</head>
<body>
<div class=centerdiv >
<form style="background: #056; opacity: 0.8" id="k1" action="Resume" method="post" enctype="multipart/form-data" >

		<table style="margin-top:90px;color: white; margin-left: 90px;">		
            <tr>
           
            
            <br>
            <br>
            <br>
            <br>
            <td><h1><center>Resume Form</center></h1></td></tr>
            <str>
			<br><td>Passport_Size Photo:</td>
			<td><input type="file" name="file" id="file"></td>
			</tr>
			<tr>
			    <td>FirstName</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
			    <td>LastName</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Mobile number:</td>
				<td><input type="number" maxlength="10" name="mobilenumber"></td>
			</tr>
			<tr>
				<td>D.O.B:</td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><textarea rows = "5" cols = "25" name = "address"></textarea></td>
			</tr>
			<tr>
				<td>
					Gender:
				</td>
				<td><input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="Female">Female<input type="radio" name="gender" value="Transgender">Transgender</td>
			</tr>
			<tr>
				<td>
					Languages:
				</td>
				<td><input type="checkbox" name="languages" value="English">English<input type="checkbox" name="languages" value="Hindi">Hindi<input type="checkbox" name="languages" value="Gujarati">Gujarati</td>
			</tr>
			<tr>
				<td>Objective:</td>
				<td><textarea rows = "3" cols = "35" name = "objective"></textarea></td>
			</tr>
			<tr>
				<td>SSC %:</td>
				<td><input type="number" maxlength="5" name="sscm"></td>
			</tr>
			<tr>
				<td>HSC %:</td>
				<td><input type="number" maxlength="5" name="hscm"></td>
			</tr>
			<tr>
				<td>B-Tech Overall CGPA %:</td>
				<td><input type="text" maxlength="5" name="btechm"></td>
			</tr>
			<tr>
				<td>Programming Skills:</td>
				<td><textarea rows = "3" cols = "20" name = "pskills"></textarea></td>
			</tr>
			<tr>
				<td>Additional Skills:</td>
				<td><textarea rows = "3" cols = "20" name = "askills"></textarea></td>
			</tr>
			<tr>
				<td>Strength:</td>
				<td><textarea rows = "3" cols = "20" name = "strength"></textarea></td>
			</tr>
			<tr>
				<td>Profestional Hobbies:</td>
				<td><textarea rows = "3" cols = "20" name = "phobbies"></textarea></td>
			</tr>
			<tr>
				<td>
					Hobbies:
				</td>
				<td><input type="checkbox" name="hobbies" value="singing">Singing<input type="checkbox" name="hobbies" value="dancing">Dancing<input type="checkbox" name="hobbies" value="travelling">Travelling<input type="checkbox" name="hobbies" value="reading">Reading<input type="checkbox" name="hobbies" value="playing">Playing</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>