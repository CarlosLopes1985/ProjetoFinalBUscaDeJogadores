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
  
<script>

function filtraRolesPlataformas(value) {
	
	var dados = {cmd: "consultaJogo", idJogo: value};
	$bool = null;	
	
	if (value != null) {
		$.ajax({
			type: "POST",
			url: "../Controle",
			data: dados,
			dataType: "json",
            success: function (data) {
            	
            	if (data.resposta == "true") {
	               	
            		$('#funcao').material_select('destroy');
            		
            		$('#funcao').removeAttr('disabled');
	                $('#funcao').empty().append('<option value="0" disabled="disabled" selected="selected">Fun��o a ser encontrada</option>');
	                
	                for (i in data.listaJR) {
	                	
	                    $('#funcao').append('<option value="' + data.listaJR[i].idRoles + '">' + data.listaJR[i].nome + '</option>');
	                }
	                
	                $('#funcao').material_select();
	                $('#plataforma').material_select('destroy');
	                
	               	$('#plataforma').removeAttr('disabled');
	                $('#plataforma').empty().append('<option value="0" disabled="disabled" selected="selected">Plataforma</option>');
	                
	                for (i in data.listaJP) {
	                    $('#plataforma').append('<option value="' + data.listaJP[i].idPlataforma + '">' + data.listaJP[i].nomePlataforma + '</option>');
	                }
	                
	                $('#plataforma').material_select();
	                
            	}
            	
            },
	    	error: function (XMLHttpRequest, textStatus, errorThrown) {
	            
	    		html = '<h3>XMLHttpRequest</h3>';
	            for (i in XMLHttpRequest) {
	                if (i != "channel")
	                    html += i + " : " + XMLHttpRequest[i] + "<br>";
	            }
	
	            html += '<h3>textStatus</h3>';
	            html += textStatus;
	
	            html += '<h3>errorThrown</h3>';
	            html += errorThrown;
	            $("#respostaerro").html("<pre>" + html + "</pre>");
	
	        }
		});
	}
	
}

</script>
  
</head>
<body style="background-color:#78909c;">

  
  <div class="navbar">
    <nav class="#263238 blue-grey darken-5">
      <div class="nav-wrapper container">
        <a href="#!" class="brand-logo">Logo</a>
        
          <a data-activates="menu-mobile" class="button-collapse left">
        <i class="material-icons">menu</i> </a>


          <ul id="nav-mobile" class="right hide-on-med-and-down">




            
            <div class="row">
              <ul id="slide-out" class="side-nav fixed">
                <li><div class="user-view">
          <div class="background" style="background-color:#263238;">
            
          </div class="row">
          <a href="#!user"><img class="circle" src="img/eu.jpg"></a>
          <a href="#!name"><span class="white-text name"> ${pessoa.nomeUsuario}</span></a>
          <br>
        </div></li>
                <li><a href="profile.jsp"><i class="material-icons">person</i>Perfil</a></li>
                <li><a href="escolherJogos.jsp"><i class="material-icons">videogame_asset</i>Escolher jogos</a></li>
                <li><a href="jogosCadastrados.jsp"><i class="material-icons">videogame_asset</i>Jogos Cadastrados</a></li>
                
                <li><a href="logout.jsp"><i class="material-icons">exit_to_app</i>Sair</a></li>
    
  </ul>
</div>

    

</div>


</ul>

</div>
</nav>



<div>
<div class="row">
  <div class="input-field col s4 offset-s3">
    <div class="card hoverable col s12 m12">
      <div class="card-content black-text">
      <span class="card-title">Consulta de Jogos</span>



	<form method="post" action="../Controle?cmd=listarPessoasJogando">
      <!-- <form> -->
          <div class="row">
            <div class="input-field col m8 s12">
              
            </div>

          </div>

          <div class="row">
            <div class="input-field col m8 s12">
             <input type="text" class="form-control" name="nome" value="${jogos.nomeJogos}" id="nome">
              
                   </div>
          </div>
          <div class="row">
            <div class="input-field col m8 s12">
              <select id="funcao" type="text" class="validate" name="funcao">
                <option value="" disabled="disabled" selected="selected">Fun��o a ser encontrada</option>
              </select>
            </div>
          </div>

          <div class="row">
            
              <div class="input-field col m8 s12">
                <select id="plataforma" type="text" class="validate" name="plataforma">
           <!-- <select> -->
                    <option value="" disabled="disabled" selected="selected">Plataforma</option>
	             </select>
              </div>
           
          </div>

        <button class="btn waves-effect #263238 blue-grey darken-5" type="submit" name="action">Buscar
          <i class="material-icons right">send</i>
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

<script>

$(document).ready(function() {
	
	html = "";
	
    var list = ${pessoas};
    $.each(list, function( index, value ) {
		html += '<tr id="' + value.idPessoa + '">';
	    html += '<td>Sem Foto</td>';
	    html += '<td>' + value.nomeUsuario + '</td>';
	    html += '<td>estrelinhas</td>';
	    html += '<td>chat</td>';
		html += '</tr>';
	});
    $("#corpoTabela").append(html);
});

</script>

</body>
</html>