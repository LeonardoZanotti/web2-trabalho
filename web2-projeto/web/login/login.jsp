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
         <form action="" method="post">
            <div class="img-container">
              <img src="../img/user.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <div class="input-label">
                    <label for="username"><b>Login</b></label>
                    <br>
                    <input type="text" placeholder="Login" name="username" required>
                </div>
                <div class="input-label">
                    <label for="password"><b>Senha</b></label>
                    <br>
                    <input type="password" placeholder="Senha" name="password" required>
                </div>

                <div class="buttons">
                    <p>Não possui conta? <a href="">Registre-se!</a></p>
                    <button class="btn btn-primary" type="submit">Login</button>
                </div>
            </div>
        </form> 
    </body>
</html>
