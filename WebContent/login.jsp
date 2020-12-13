<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login form</title>

    <link href="https://fonts.googleapis.com/css2?family=Cinzel&display=swap" rel="stylesheet">
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
            width: 350px;
            height: 500px;
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
            left: calc((350px - 120px)/2);
        }
        
        h2 {
            text-align: center;
            color: black;
            text-transform: uppercase;
            font-size: 2em;
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
            <h2>User login</h2>
            <form action="Login" method="post">
                <div>
                    <input type="text" class="input" placeholder="User name" name="uname">
                </div>
                <br>
                <div>
                    <input type="password" class="input" placeholder="Enter password" name="password">
                </div>
                <br>
                <div>
                    <button type="submit" name="submit" value="login"> LOGIN</button><br>
                </div>
            </form>
            <form action="register.jsp" action="post">
                <div>
                    <button type="submit" name="submit" value="login">Register</button><br>
                </div>
            </form>
            <form action="ResumeBuilder.jsp" method="post">
                <div>
                    <button type="submit" name="submit" value="login">ResumeBuilder</button>
                </div>
            </form>

            <br>


        </div>
    </div>
</body>
</html>