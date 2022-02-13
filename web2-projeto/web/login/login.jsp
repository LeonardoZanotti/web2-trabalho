<%-- 
    Document   : login
    Created on : Feb 13, 2022, 11:11:20 AM
    Author     : leonardozanotti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="./login.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
         <div class="wrapper fadeInDown">
            <div id="formContent">
              <!-- Tabs Titles -->

              <!-- Icon -->
              <div class="fadeIn first">
                <img src="../img/user.png" id="icon" alt="User Icon" />
              </div>

              <!-- Login Form -->
              <form>
                <input type="text" id="login" class="fadeIn second" name="login" placeholder="Login">
                <input type="text" id="password" class="fadeIn third" name="login" placeholder="Senha">
                <input type="submit" class="fadeIn fourth" value="Log In">
              </form>

              <!-- Remind Passowrd -->
              <div id="formFooter">
                 Não possui conta?
                <a class="underlineHover" href="../register/register.jsp">Registre-se!</a>
              </div>

            </div>
          </div>
    </body>
</html>
