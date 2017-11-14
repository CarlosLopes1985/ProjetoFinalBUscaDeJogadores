package br.com.projetofinal.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import br.com.projetofinal.validacoes.CadastroUsuario;

@WebServlet("/ControleValidacoes")
public class ControleValidacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request,HttpServletResponse response) {

		String cmd = request.getParameter("cdm");

		
	}

	

	// private void validaJogos(HttpServletRequest request,
	// HttpServletResponse response) {
	//
	// CadastroUsuario validaCad = new CadastroUsuario();
	//
	// try {
	//
	// String email = request.getParameter("email");
	//
	// JSONObject resposta = new JSONObject();
	//
	// response.setContentType("application/json");
	// response.setCharacterEncoding("UTF-8");
	//
	// if (validaCad.ifExistsEmail(email) == true) {
	// resposta.put("existe", "sim");
	// } else {
	// resposta.put("existe", "nao");
	// }
	//
	// response.getWriter().print(resposta);
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	//
	// }
}
