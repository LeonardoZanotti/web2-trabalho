<%-- 
    Document   : profile
    Created on : Feb 13, 2022, 11:58:57 AM
    Author     : leonardozanotti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <link rel="stylesheet" href="./profile.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <nav class="top-section navbar">
            <div class="logo d-flex align-items-center justify-content-between">
                <div class="logo d-flex align-items-center">
                    <img src="../img/coroa-logo.png" icons/placeholder.svg width="80px" background="#777" color="#777" text=" " title=" " >
                    <p class="mt-3">Perfil</p>
                </div>
                <a class="logout-btn" href="../login/login.jsp">Logout</a>
           </div>
        </nav>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Edogaru</span><span class="text-black-50">edogaru@mail.com.my</span><span> </span></div>
                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Editar perfil</h4>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-12"><label class="labels">Nome completo</label><input type="text" class="form-control" placeholder="Nome completo" value=""></div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-12"><label class="labels">E-mail</label><input type="text" class="form-control" placeholder="E-mail" value=""></div>
                            <div class="col-md-12"><label class="labels">Telefone</label><input type="text" class="form-control" placeholder="Telefone" value=""></div>
                            <div class="col-md-12"><label class="labels">CPF</label><input type="text" class="form-control" placeholder="CPF" value=""></div>
                            <div class="col-md-10"><label class="labels">Endereço</label><input type="text" class="form-control" placeholder="Endereço" value=""></div>
                            <div class="col-md-2"><label class="labels">Número</label><input type="number" class="form-control" placeholder="000" value=""></div>
                            <div class="col-md-12"><label class="labels">Complemento</label><input type="text" class="form-control" placeholder="Complemento" value=""></div>
                            <div class="col-md-12"><label class="labels">CEP</label><input type="text" class="form-control" placeholder="CEP" value=""></div>
                            <div class="col-md-6"><label class="labels">Estado</label><input type="text" class="form-control" placeholder="Estado" value=""></div>
                            <div class="col-md-6"><label class="labels">Cidade</label><input type="text" class="form-control" value="" placeholder="Cidade"></div>
                            <div class="col-md-12"><label class="labels">Bairro</label><input type="text" class="form-control" placeholder="Bairro" value=""></div>
                        </div>
                        <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Save Profile</button></div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center experience"><span>Alterar senha</span></div><br>
                        <div class="col-md-12"><label class="labels">Senha</label><input type="password" class="form-control" placeholder="Senha" value=""></div> <br>
                        <div class="col-md-12"><label class="labels">Confirmar senha</label><input type="password" class="form-control" placeholder="Confirmar senha" value=""></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
