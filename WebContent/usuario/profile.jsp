<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width-device-width,initial-scale=1.0">
  <title> TCC </title>
  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!-- Materialize CSS-->
  <link rel="stylesheet" href="css/materialize.css">
</head>
<body style="background-color:#78909c;">

  <!--Header-->
  <div class="navbar">
    <nav class="#263238 blue-grey darken-5">
      <div class="nav-wrapper container">
        <a href="#!" class="brand-logo">Logo</a>
      </div>
      </nav>
    </div>


    <!--Header-->




    <div class="row">
      <ul id="slide-out" class="side-nav fixed">
        <li><div class="user-view">
          <div class="background" style="background-color:#263238;">
            
          </div>
          <a href="#!user"><img class="circle" src="img/eu.jpg"></a>
          <a href="#!name"><span class="white-text name"> ${pessoa.nomeUsuario}</span></a>
          <br>
        </div></li>
        <li><a href="logadoUsuario.jsp"><i class="material-icons">search</i>Busca de Jogadores</a></li>
                <li><a href="escolherJogos.jsp"><i class="material-icons">videogame_asset</i>Escolher jogos</a></li>
                <li><a href="jogosCadastrados.jsp"><i class="material-icons">videogame_asset</i>Jogos Cadastrados</a></li>
                
                <li><a href="logout.jsp"><i class="material-icons">exit_to_app</i>Sair</a></li>

    <!--Subheader-><li><div class="divider"></div></li>
    <li><a class="subheader">Subheader</a></li>
    <li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
    <!---->





  </div>


  <!-- Dropdown Trigger -->


  <!-- Dropdown Structure -->




  <!-- MEnu Mobile-->


  <div class="row">
    <div class="input-field col s5 offset-s5">
      <div class="card hoverable">
        <div class="card-content black-text">

          <span class="card-title">Perfil</span>

          <div class="row">
            <form action="#">
              <div class="file-field input-field">
                <div class="btn">
                  <span>Foto</span>
                  <input type="file">
                </div>
                <div class="file-path-wrapper">
                  <input class="file-path validate" type="text">
                </div>
              </div>
            </form>
          </div>
		 
		 <form method="post" action="alterarDadosProfile">
          <div class="row">
            <div class="input-field col s4">
              <input id="nome" type="text" class="validate" name="nomeUsuario">
              <label for="nome">Nome</label>
            </div>
          </div>

          <div class="row">
            <div class="input-field col s4">
              <input id="password" type="password" class="validate" required>
              <label for="password">Senha Antiga</label>
            </div>


            <div class="input-field col s4 offset-s1">
              <input id="confpassword" type="password" class="validate" required>
              <label for="confpassword">Senha Nova</label>
            </div>
          </div>


          <br/><br/>
          <button class="btn waves-effect #263238 blue-grey darken-5" type="submit" name="action">Salvar
            <i class="material-icons right">send</i>
          </button>
	

		</form>
        </div>


      </div>

    </div>

  </div>










  <!--Footer-->

 <footer class="page-footer #263238 blue-grey darken-5">
  <div class="container">
    <div class="row">
      <div class="col l4 offset-l2 s12">
        <h5 class="white-text"></h5>
        <h5 class="white-text">Diversão e Entreteinemento em um só lugar </h5>
          <p class="grey-text text-lighten-4">Monte suas equipes e organize batalhas com maior iteratividade com seus companheiros.</p>
      </div>
      <div class="col l4 offset-l2 s12">
        <h5 class="white-text">Links</h5>
        <ul>
            <li><a class="grey-text text-lighten-3" href="#!">Novidades</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Dicas</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Lojas</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Promoções</a></li>
            <li><a class="grey-text text-lighten-3">Contato:dontplayalonegroup@gmail.com</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="footer-copyright">
    <div class="row">
    <a class="grey-text text-lighten-4 center">© 2017 Todos os direitos reservados</a>
           
        
    </div>
  </div>
</footer>
  <!--Footer-->





  <!--Jquery-->
  <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
  <!-- Materialize JS-->
  <script src="js/materialize.js"></script>

  <script>
//menu mobile
$(".button-collapse").sideNav();
</script>

<script>
 $(document).ready(function() {
  $('select').material_select();
});
</script>



</body>
</html>