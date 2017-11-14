<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
</head>
<body>
 <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="#">DPA</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
       <!-- Button trigger modal -->
       <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
        Entrar
      </button></li>
     </ul>
  </div>
</nav>
<form class="form-horizontal" name="formCadastro" method="post" action="Controle?cmd=mudarSenha">
   <div class="container">
    <div class="row">
    <div class="form-group col-md-6">
     <label for="mudarSenha" class="col-form-label">Digite sua senha</label>
     <input type="password" name="senha" class="form-control" id="senha">
    </div>
    </div>  
   
   <div class="row">
    <div class="form-group col-md-6">
     <label for="mudarSenha" class="col-form-label">Confirmar Senha</label>
     <input type="password" name="confirmarSenha" class="form-control" id="confirmarSenha">
    </div>
    </div>  
   
   <div class="row">
    <div class="form-group col-md-6">
     <label for="mudarSenha" class="col-form-label">Digite a palavra chave</label>
     <input type="text" name="chave" class="form-control" id="lembrarSenha">
    </div>
    
    </div>  
   
    
    <button type="submit" class="btn btn-primary">Enviar Email</button>
	</div>
 </form>

<footer class="container-fluid text-center foot">

  <div class="copyrights">
    <p class="white-txt">Don't Play Alone © 2017
      <br><br>
      <img class="footimg" src="" alt="Logo">
    </p>
    <hr class="dark-line">
    <a class="link" href="#">Contact Us</a>
    <a class="link" href="#">Privacy Policy</a>
    <a class="link" href="#">Terms e Conditions</a>
    <br><br>
    <p class="white-txt small">
      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare elit odio, eu imperdiet ligula ullamcorper sed.
    </p>
  </div>
</footer>
</body>
</html>