<body onload="window.refresh" onunload="window.refresh">
<%
try{
	
	//Invalidando a Sess�o
	 session.setAttribute("usuario",null);
	 session.invalidate(); //apaga a sess�o
	 
	 //Limpando a Mem
	 response.setHeader("Pragma","no-cache");
	 response.setHeader("Cache-Control","no-cache");
	 response.setDateHeader("Expires",0);
	 response.setDateHeader("max-age",0);
	 out.print("Logout Conclu�do");

}catch(Exception ex){
	ex.printStackTrace();
}
%>
<a href="../index.html">Voltar</a>
</body>