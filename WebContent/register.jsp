<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration</title>
<style>
        * {
            margin: 0;
            padding: 0;
            font-family: 'Cinzel', serif;
        }
        
        .bgimg {
            width: 100%;
            height: 100vh;
            background-image: linear-gradient( 25deg, rgb(255, 255, 102) 50%, white 50%);
        }
        
        .centerdiv {
            width: 450px;
            height: 550px;
            position: absolute;
            top: 50%;
            left: 50%;
            background-color: red;
            transform: translate(-50%, -50%);
            background-image: linear-gradient(25deg, white 50%, rgb(255, 255, 102) 50%);
            box-shadow: 0 1px 6px rgba(0, 0, 0, 0), 0 1px 4px rgba(0, 0, 0, 0);
        }
        
        #profilepic {
            width: 120px;
            height: 120px;
            border-radius: 50%;
            position: relative;
            top: -60px;
            left: calc((350px - 30px)/2);
        }
        
        h2 {
            text-align: center;
            color: black;
            text-transform: uppercase;
            font-size: 1.75em;
            word-spacing: 10px;
            margin-top: -50px;
            margin-bottom: 50px;
            text-shadow: -2px 2px 1px yellow;
        }
        
        .input {
            width: calc(100% - 30%);
            height: 30px;
            display: block;
            margin: auto;
            padding: 0 10px;
            box-sizing: border-box;
        }
        
        ::placeholder {
            letter-spacing: 2px;
            color: burlywood;
        }
        
        button {
            width: calc(100% - 30%);
            height: 30px;
            display: block;
            margin: auto;
            color: white;
            background-color: rgb(255, 255, 102);
            border: none;
            color: black;
        }
        
        .forgot {
            width: calc(100% - 30%);
            height: 30px;
            display: block;
            margin: auto;
            color: white;
            background-color: ;
        }
    </style>
</head>
<body>
	<div class="bgimg">
        <div class="centerdiv">
            <img src="user.png" alt="picture" width="100" height="100vh" id="profilepic">
            <h2>User Registration</h2>
            <form action="Register" method="post">
                <div>
                    <input type="text" name="ccode" class="input" placeholder="Company cod">
                </div>
                <br>
                <div>
                    <input type="text" class="input" placeholder="User name" name="uname">
                </div>
                <br>
                <div>
                    <input type="password" name="password" class="input" placeholder="password">
                </div>
                <br>
                <div>
                    <input type="text" name="email" placeholder="Email" class="input">
                </div>
                <br>
                <div>
                    <input type="number" maxlength="10" name="mobilenumber" placeholder="Mobile No" class="input">
                </div>
                <br>
                <div>
                    <button type="submit" name="submit" value="register">Register</button><br>
                </div>
            </form>


            <br>


        </div>
    </div>
</body>
</html>