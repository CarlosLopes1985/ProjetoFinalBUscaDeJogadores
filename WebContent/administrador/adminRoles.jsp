<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <jsp:useBean class="br.com.projetofinal.manager.ManagerBean" id="mb"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width-device-width,initial-scale=1.0"/>
  <title> TCC </title>
  
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
  
  <link rel="stylesheet" href="css/materialize.css"/>
</head>
<body style="background-color:black;">

  
  <div class="navbar">
    <nav class="#263238 blue-grey darken-5">
      <div class="nav-wrapper container">
        <a href="#!" class="brand-logo">Logo</a>
        <a href='#!' data-activates="menu-mobile" class="button-collapse right">
          <i class="material-icons">menu</i> </a>

          <ul id="nav-mobile" class="right hide-on-med-and-down">
          </ul>
          </div>
          </nav>
          </div>
			 <div class="row">
              <ul id="slide-out" class="side-nav fixed">
                <li><div class="user-view">
          <div class="background" style="background-color:#263238;">
            
          </div>
          <a href="#!user"><img class="circle" src="img/eu.jpg"></a>
          <a><span class="white-text name"> </span></a>
          <br>
        </div></li>
                <li><a href="profile.jsp"><i class="material-icons">person</i>Perfil</a></li>
                <li><a href="logadoAdministrador.jsp"><i class="material-icons">videogame_asset</i>Cadastrar Jogos</a></li>
                <li><a href="adminPlataformas.jsp"><i class="material-icons">videogame_asset</i>Cadastrar Plataformas</a></li>
                <li><a href="adminJogoxroles.jsp"><i class="material-icons">assignment</i>Consultar Jogos</a></li>
                <li><a href="logout.jsp"><i class="material-icons">exit_to_app</i>Sair</a></li>

    
  </ul>
</div>


</ul>
<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>

</nav>


<ul id='dropdown1' class='dropdown-content'>
  <li><a href="#!">Perfil</a></li>

  <li><a href="#">Cadastrar Jogos</a></li>
  <li><a href="index.html">Sair</a></li>
  <li class="divider"></li>
</ul>




<ul id="menu-mobile" class="side-nav">

</ul>
<div class="row">
  <div class="input-field col s4">
    <div class="card hoverable col s8 offset-s9">
      <div class="card-content black-text">
      <form name="formCadRoles1" method="post" action="../ControleAdministrador?cmd=cadastrarRoles">
        <div class="row">
          <div class="input-field col s9">
            <input id="jogo" name="nomeRoles" type="text" class="validate" required>
            <label for="jogo">Role</label>
          </div>
          </div>
        <button class="btn waves-effect green" type="submit" name="action">Cadastrar
          <i class="material-icons right">save</i>
        </button>
        </form>
      </div>
    </div>
  </div>
  <div class="input-field col s4">
    <div class="card hoverable col s8 offset-s6">
      <div class="card-content black-text">
      <form name="formCadRoles2" method="post" action="../ControleAdministrador?cmd=alterarRoles">
        <div class="row">

          <div class="input-field col s9">
            <select name="idRoles">
              <option value="" disabled selected>Roles</option>
              <c:forEach items="${mb.listaRoles}" var="linha">
  
          <option value="${linha.idRoles}"> ${linha.nome} </option>
        </c:forEach>
            </select>
          </div>
          <div class="input-field col s9">
            <input id="jogo" name="nomeRoles" type="text" class="validate" required>
            <label for="jogo">Role</label>
          </div>
          </div>

        <button class="btn waves-effect red" type="submit" name="action">Alterar
          <i class="material-icons right">visibility_off</i>
        </button>
        </form>



      </div>

    </div>


  </div>
  <div class="input-field col s4">
    <div class="card hoverable col s8 offset-s3">
      <div class="card-content black-text">
     <form name="formCadRoles3" method="post" action="../ControleAdministrador?cmd=alocarJogoRole">
        <div class="row">

          <div class="input-field col s9">
                        
              <select name="idJogos">
              <option disabled selected>Jogo</option>
              <c:forEach items="${mb.listajogos}" var="linha">
  
          <option value="${linha.idJogos}"> ${linha.nomeJogos} </option>
        </c:forEach>
              
  

            </select>
            <select name="idRoles">
              <option disabled selected>Role</option>
             <c:forEach items="${mb.listaRoles}" var="linha">
				<option value="${linha.idRoles}"> ${linha.nome} </option>
			   </c:forEach>
              </select>
          </div>
          </div>

        <button class="btn waves-effect blue" type="submit" name="action">Vincular
          <i class="material-icons right">create
</i>
        </button>
        </form>



      </div>

    </div>


  </div>
</div>
 
</div>















<footer class="page-footer #263238 blue-grey darken-5">
  <div class="container">
    <div class="row">
      <div class="col l4 offset-l2 s12">
        <h5 class="white-text"></h5>
        <h5 class="white-text">Divers�o e Entreteinemento em um s� lugar </h5>
          <p class="grey-text text-lighten-4">Monte suas equipes e organize batalhas com maior iteratividade com seus companheiros.</p>
      </div>
      <div class="col l4 offset-l2 s12">
        <h5 class="white-text">Links</h5>
        <ul>
            <li><a class="grey-text text-lighten-3" href="#!">Novidades</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Dicas</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Lojas</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Promo��es</a></li>
            <li><a class="grey-text text-lighten-3">Contato:dontplayalonegroup@gmail.com</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="footer-copyright">
    <div class="row">
    <a class="grey-text text-lighten-4 center">� 2017 Todos os direitos reservados</a>
           
        
    </div>
  </div>
</footer>




<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>

<script src="js/materialize.js"></script>



<script>
 $(document).ready(function() {
  $('select').material_select();
});
</script>
</body>
</html>