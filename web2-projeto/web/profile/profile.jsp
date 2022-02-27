<%-- 
    Document   : profile
    Created on : Feb 13, 2022, 11:58:57 AM
    Author     : leonardozanotti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt">
 <head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="stylesheet" href="./profile.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 </head>
 <body>
     <div class="wrapper page-extra">
          <nav class="top-section navbar">
               <div class="logo">
                    <h1>Cadastro</h1>
               </div>
          </nav>
          <div class="container">
               <div class="row login ">
                    <div class="col-md-12"> 
                         <br><h1>Meus Dados</h1><br>
                           <form id="form-register" class="form form-register shadow-lg p-3 mb-5 bg-body rounded" method="post" action="#"> 
                              <input type="hidden" name="entity" value="individual"> 
                              <div class="form-content"> 
                                   <div class="row"> 
                                        <div class="col-12"> 
                                             <div class="form-group form-group-first_name"> 
                                                  <label for="first_name">Nome Completo</label> 
                                                  <input type="text" class="form-control form-control-blur" id="first_name" name="first_name" required="required"  minlength="2" value=""> 
                                             </div> 
                                        </div>
                                   </div> 
                                   <div class="row">
                                    <div class="col-12"> 
                                        <div class="form-group form-group-email"> 
                                             <label for="email">E-mail</label>
                                              <input type="email" class="form-control form-control-blur" id="email" name="email" required="required" value=""> 
                                         </div> 
                                    </div>
                               </div>
                              <div class="form-individual"> 
                                   <div class="row"> 
                                        <div class="col-sm-6"> 
                                             <div class="form-group form-group-birthday"> 
                                                  <label for="birthday">Data de nascimento</label>
                                                   <input type="Date" class="form-control form-control-blur" id="birthday" name="birthday" data-mask="00/00/0000"  value="" required="required" maxlength="10"> 
                                              </div> 
                                        </div>  
                                        <div class="col-sm-6 form-individual"> 
                                             <div class="form-group form-group-cpf"> 
                                                  <label for="cpf">CPF</label> 
                                                  <input type="text" class="form-control form-control-blur" id="cpf" name="cpf" required="required" data-mask="000.000.000-00" value="" maxlength="14"> 
                                             </div> 
                                        </div>    
                                   </div> 
                              </div> 
                                      <div class="row"> 
                                        <div class="col-sm-6"> 
                                             <div class="form-group form-group-phone"> 
                                                  <label for="phone">Telefone 1</label> 
                                                  <input type="tel" class="form-control form-control-blur" id="phone" name="phone" required="required" data-mask="(00) 00000-0009" value="" minlength="8" maxlength="15"> 
                                             </div> 
                                        </div> 
                                        <div class="col-sm-6"> 
                                             <div class="form-group form-group-phone"> 
                                                  <label for="phone">Telefone 2</label> 
                                                  <input type="tel" class="form-control form-control-blur" id="phone" name="phone" required="" data-mask="(00) 00000-0009" value="" minlength="8" maxlength="15"> 
                                             </div> 
                                        </div> 
                                   </div> 
                                    <div class="row"> 
                                        <div class="col-sm-6"> 
                                             <div class="form-group form-group-phone"> 
                                                  <label for="text">Logradouro</label> 
                                                  <input type="text" class="form-control form-control-blur" id="street" name="street" required="required"  value="" minlength="8" maxlength="15"> 
                                             </div> 
                                        </div> 
                                        <div class="col-sm-6"> 
                                             <div class="form-group form-group-number"> 
                                                  <label for="number">Número</label> 
                                                  <input type="number" class="form-control form-control-blur" id="number" name="number" required="" value="" minlength="8" maxlength="15"> 
                                             </div> 
                                        </div> 
                                   </div> 
                                   <div class="row"> 
                                        <div class="col-sm-6"> 
                                             <div class="form-group form-group-cep"> 
                                                  <label for="text">Cep</label> 
                                                  <input type="text" class="form-control form-control-blur" id="cep" name="cep" required="required" data-mask="00.000-000" value="" minlength="8" maxlength="15"> 
                                             </div> 
                                        </div> 
                                        <div class="col-sm-6"> 
                                             <div class="form-group form-group-Neigborhood"> 
                                                  <label for="Neigborhood">Bairro</label> 
                                                  <input type="text" class="form-control form-control-blur" id="Neigborhood" name="Neigborhood" required="" value="" minlength="8" maxlength="15"> 
                                             </div> 
                                        </div> 
                                   </div> 
                                   <div class="row"> 
                                        <div class="col-sm-6"> 
                                             <div class="form-group form-group-est"> 
                                                  <label for="text">Estado</label> 
                                                  <select class="custom-select custom-select-blur" id="est" name="est" required="required"> 
                                                       <option value="" disabled="" selected="">Selecione...</option>
                                                       <option value="acre">Acre</option> 
                                                       <option value="alagoas">Alagoas</option>
                                                       <option value="amapá">Amapá</option> 
                                                       <option value="amazonas">Amazonas</option>
                                                       <option value="bahia">Bahia</option> 
                                                       <option value="ceara">Ceará</option>
                                                       <option value="distrito-federal">Distrito Federal</option> 
                                                       <option value="espirito-santo">Espírito Santo</option>
                                                       <option value="goias">Goiás</option> 
                                                       <option value="maranhao">Maranhão</option>
                                                       <option value="mato-grosso">Mato Grosso</option> 
                                                       <option value="mato-grosso-do-sul">Mato Grosso do Sul</option>
                                                       <option value="minas-gerais">Minas Gearais</option> 
                                                       <option value="para">Pará</option>
                                                       <option value="paraiba">Paraíba</option> 
                                                       <option value="parana">Paraná</option>
                                                       <option value="pernambuco">Pernambuco</option> 
                                                       <option value="piaui">Piauí</option>
                                                       <option value="rio-de-janeiro">Rio de Janeiro</option> 
                                                       <option value="rio-grande-do-norte">Rio Grande do Norte</option>
                                                       <option value="rio-grande-do-sul">Rio Grande do Sul</option> 
                                                       <option value="rondônia">Rondônia</option>
                                                       <option value="roraima">Roraima</option> 
                                                       <option value="santa-catarina">Santa Catarina</option>
                                                       <option value="sao-paulo">São Paulo</option> 
                                                       <option value="sergipe">Sergipe</option>
                                                       <option value="tocantins">Tocantins</option> 
                                                  </select>
                                             </div> 
                                        </div> 
                                        <div class="col-sm-6"> 
                                             <div class="form-group form-group-cities"> 
                                                  <label for="text">Cidade</label> 
                                                  <select class="custom-select custom-select-blur" id="city" name="city" required="required"> 
                                                       <option value="" disabled="" selected="">Selecione...</option>
                                                      
                                                  </select>
                                             </div> 
                                        </div> 
                                   </div> 
                                   <div class="row"> 
                                        <div class="col-sm-6"> 
                                             <div class="form-group form-group-cep"> 
                                                  <label for="password">Senha</label> 
                                                  <input type="password" class="form-control form-control-blur" id="password" name="password" required="required" value="" minlength="8" maxlength="15"> 
                                             </div> 
                                        </div> 
                                   </div> 
                                   <br>
                                   <div class="row"> 
                                           <div class="col-sm-3"> 
                                             <a href="portal-cliente.html"
                                                  <button type="submit" class="btn btn-secondary btn-lg btn-block"> Voltar </button>
                                             </a> 
                                        </div> 
                                        <div class="col-sm-3"> 
                                             <a href="#">
                                                  <button type="submit" class="btn btn-info btn-lg btn-block"> Editar </button> 
                                             </a>
                                        </div> 
                                        <div class="col-sm-3">   
                                        </div> 
                                        <div class="col-sm-3" style="text-align: right;"> 
                                             <a href="#">
                                                  <button type="submit" class="btn btn-success btn-lg btn-block"> Salvar </button>
                                             </a> 
                                        </div> 
                                   </div> 
                              </div> 
                         </div> 
                    </form>
               </div>          
          </div>
     </div>
  </body>
</html>