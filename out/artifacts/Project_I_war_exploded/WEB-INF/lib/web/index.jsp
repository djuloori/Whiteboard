<!DOCTYPE html>

<html lang="en-US">
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">
    <link rel = "stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script type="text/javascript" src="js/login.js"> </script>
    <script>
        $(document).ready(function(){
            onReady();
        });
    </script>
</head>
<body >
<%
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
%>
<div id="login">
  <form>
    <Center><h1><font color="white" style="font-family: cursive;"><i class="fa fa-pencil-square-o" style="font-size: 29px; text-align:center; padding-left: 10px; color: white;" aria-hidden="true" ></i> WHITEBOARD </font> </h1></Center>
        <span class="fontawesome-user"></span>
        <input  type="text" id = "username" name="username" placeholder="Username" required>
        <span class="fontawesome-lock"></span>
        <input type="password" id = "password" name="password" placeholder="Password" required>
        <input type="button" id = "signin" value="Login">
        <a href="signup.jsp" class="submit" style="padding-left: 85px;color: white;">Click here to Register!</a>
  </form>
</div>
</body>
</html>
