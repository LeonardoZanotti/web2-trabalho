<%-- 
    Document   : home
    Created on : Feb 27, 2022, 5:54:06 PM
    Author     : leonardozanotti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt">
 <head>
     <meta charset="UTF-8"/>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Home</title>
     <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
     <link rel="stylesheet" type="text/css" href="./home.css">
 </head>
 <body>
     <div class="wrapper page-extra">
          <nav class="top-section navbar">
               <div class="logo d-flex align-items-center justify-content-between">
                    <img src="../img/coroa-logo.png" icons/placeholder.svg width="80px" background="#777" color="#777" text=" " title=" " >
                    <a class="logout-btn" href="../login/login.jsp">Logout</a>
               </div>
          </nav>
          <div class="container">
               <div class="row login">
                    <div class="col-md-12"> 
                         <br><h1>Seja bem vinda(o)!</h1>
                    </div>
          <div class="container marketing">

            <!-- Three columns of text below the carousel -->
           <br>
           <div class="row">
              <div class="col-lg-4">
                 <svg xmlns="http://www.w3.org/2000/svg" width="50%" height="60%" fill="currentColor" class="bi bi-envelope-plus-fill" viewBox="0 0 16 16">
                    <path d="M.05 3.555A2 2 0 0 1 2 2h12a2 2 0 0 1 1.95 1.555L8 8.414.05 3.555ZM0 4.697v7.104l5.803-3.558L0 4.697ZM6.761 8.83l-6.57 4.026A2 2 0 0 0 2 14h6.256A4.493 4.493 0 0 1 8 12.5a4.49 4.49 0 0 1 1.606-3.446l-.367-.225L8 9.586l-1.239-.757ZM16 4.697v4.974A4.491 4.491 0 0 0 12.5 8a4.49 4.49 0 0 0-1.965.45l-.338-.207L16 4.697Z"/>
                    <path d="M16 12.5a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0Zm-3.5-2a.5.5 0 0 0-.5.5v1h-1a.5.5 0 0 0 0 1h1v1a.5.5 0 0 0 1 0v-1h1a.5.5 0 0 0 0-1h-1v-1a.5.5 0 0 0-.5-.5Z"/>
                  </svg>
                <h2>Novo Atendimento</h2>
                <p><a class="btn btn-secondary" href="novo-atendimento.html">Novo &raquo;</a></p>
              </div>

              <!-- /.col-lg-4 -->
              <div class="col-lg-4">
                <svg xmlns="http://www.w3.org/2000/svg" width="50%" height="60%" fill="currentColor" class="bi bi-headset" viewBox="0 0 16 16">
                  <path d="M8 1a5 5 0 0 0-5 5v1h1a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V6a6 6 0 1 1 12 0v6a2.5 2.5 0 0 1-2.5 2.5H9.366a1 1 0 0 1-.866.5h-1a1 1 0 1 1 0-2h1a1 1 0 0 1 .866.5H11.5A1.5 1.5 0 0 0 13 12h-1a1 1 0 0 1-1-1V8a1 1 0 0 1 1-1h1V6a5 5 0 0 0-5-5z"/>
                </svg>
                 <h2>Meus Atendimentos</h2>
                <p><a class="btn btn-secondary" href="atendimentos-abertos.html">Visualizar &raquo;</a></p>
              </div>

              <!-- /.col-lg-4 -->
              <div class="col-lg-4">
                <svg xmlns="http://www.w3.org/2000/svg" width="50%" height="60%" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                  <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                </svg>

                <h2>Meus Dados</h2>
                <p><a class="btn btn-secondary" href="meus-dados.html">Visualizar &raquo;</a></p>
              </div><!-- /.col-lg-4 -->
            </div><!-- /.row -->

               </div>          
          </div>
     </div>
     <div class="wrapper page-extra">
          <div class="container">
               <div class="row login">
                    <div class="col-md-12"> 
                         <br><h1>Histórico de Atendimentos</h1>
                    </div>
               </div>          
          </div>
     </div>
 </body>
</html>