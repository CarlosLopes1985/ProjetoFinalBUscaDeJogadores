package br.com.projetofinal.controle;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.projetofinal.modelo.Jogos;
import br.com.projetofinal.modelo.Login;
import br.com.projetofinal.modelo.Pessoa;
import br.com.projetofinal.modelo.Plataformas;
import br.com.projetofinal.modelo.Roles;
import br.com.projetofinal.persistence.JogosDao;
import br.com.projetofinal.persistence.LoginDao;
import br.com.projetofinal.persistence.PessoaDao;
import br.com.projetofinal.persistence.RolesDao;
import br.com.projetofinal.util.DataFormate;
import br.com.projetofinal.util.EnviarEmail;
import br.com.projetofinal.util.Logs;
import br.com.projetofinal.validacoes.CadastroUsuario;

@WebServlet("/Controle")
public class Controle extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPessoa;
	private Logs log;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		execute(request, response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * Respons�vel por resgatar as flags das p�ginas e redirecionar as seus
	 * respectivos m�todos
	 * 
	 * @param request
	 * @param response
	 */
	private void execute(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			String cmd = request.getParameter("cmd");

			if(cmd.equalsIgnoreCase("logar"))
				logar(request, response);

			if(cmd.equalsIgnoreCase("gravar"))
				cadastrarPessoas(request, response);

			if(cmd.equalsIgnoreCase("lembrarSenha"))
				lembrarSenha(request, response);

			if(cmd.equalsIgnoreCase("mudarSenha"))
				mudarSenha(request, response);

			if(cmd.equalsIgnoreCase("listarPessoasJogando"))
				listarPessoasJogando(request, response);

			if(cmd.equalsIgnoreCase("consultaJogo"))
				consultaJogo(request, response);
			
			if(cmd.equalsIgnoreCase("validaNomeUsuario"))
				validaNomeUsuario(request, response);
			
			if(cmd.equalsIgnoreCase("validaEmail"))
				validaEmail(request, response);
			
			if(cmd.equalsIgnoreCase("alocarPessoaPlatRoles"))
				alocarPessoaPlataformaRoles(request,response);
				
			if(cmd.equalsIgnoreCase("filtrarJgCadastrados"))
				filtrarJogos(request,response);
			
			if(cmd.equalsIgnoreCase("buscarJogosCadastrados"))
				buscarJogosCadastrados(request,response);
			
			if(cmd.equalsIgnoreCase("montarTabelaJgCadastrados"))
				montarTabelaJgCadastrados(request,response);
			
			if(cmd.equalsIgnoreCase("buscarNomeJogo"))
				buscarNomeJogo( request, response );
			
			if(cmd.equalsIgnoreCase("alterarPlataformaRoles"))
				alterarPlataformaRoles( request, response );
			
			if(cmd.equalsIgnoreCase("updateJogoUsuario"))
				desativarJogos(request, response);
			
			if(cmd.equalsIgnoreCase("alterarJogos"))
				alterarJogos(request, response);
			
			if(cmd.equalsIgnoreCase("validaJogos"))
				validaJogos(request, response);
			
		} catch (Exception e) {
			log.logSaida("execute");
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	private void validaJogos(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		JogosDao jd = new JogosDao();
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		int idJogo = new Integer(request.getParameter("idJogo"));
		
		if( jd.isJogoCadastrado(idJogo, idPessoa)==true ){
			System.out.println("Jogo j� existe");
			resposta.put("resposta", "sucesso");
			response.getWriter().print(resposta);
		}else{
			resposta.put("resposta", "n�o existe");
			response.getWriter().print(resposta);
			System.out.println("jogo n�o existe");
		}
		
		
	}

	private void alterarJogos(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
		
		Integer id = new Integer(request.getParameter("idJogos") );
		
		JogosDao jd = new JogosDao();
		
		List<Jogos> jogos = jd.buscarJogosCadastradosPessoasJogos(idPessoa, id);
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//resposta.put("resposta", "true");
		resposta.put("jogos", jogos);
		
		
		System.out.println(jogos.toString());
		request.setAttribute("jogos", jogos);
		
		request.getRequestDispatcher("usuario/editarJogos.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void alterarPlataformaRoles(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		try {
			 PessoaDao pd = new PessoaDao();
			 
			 Jogos jogos = new Jogos();
			 Roles roles = new Roles();
			 Plataformas plataforma = new Plataformas();
			 Pessoa pessoa = new Pessoa();
			 
			 Integer id = new Integer(request.getParameter("jogos"));
			 jogos.setIdJogos(id);
			System.out.println("-------------->"+id);
			 roles.setIdRoles(new Integer(request.getParameter("funcao")));
			
			 plataforma.setIdPlataforma(new Integer(request.getParameter("plataforma")));
			 
			 pessoa.setIdPessoa(idPessoa);
			 
			 pd.alterarPessoaJogoPlataforma(pessoa, jogos, roles, plataforma);
			 
			 response.sendRedirect("usuario/jogosCadastrados.jsp");
			 request.setAttribute("msg", "Pessoa alocada com sucesso!!!");
			 System.out.println("Dados alterados");
		} catch (Exception e) {
			System.out.println("Deu merda!!!!");
			request.setAttribute("msg", "ERRO: Pessoa j� esta alocada nas devidas roles, plataformas e jogo!!!");
			response.sendRedirect("usuario/escolherJogos.jsp");
		}
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws JSONException 
	 */
	private void desativarJogos(HttpServletRequest request, HttpServletResponse response) throws JSONException {
		
		JSONObject resposta =  new JSONObject();
		
		try {

			int     idJogo = new Integer(request.getParameter("idNumero"));
			boolean status = new Boolean(request.getParameter("situacao"));
			boolean bStatus;

			if ( status == false )
				 bStatus = true;
			else
				 bStatus = false;

			JogosDao jd = new JogosDao( );

			jd.desativarJogos(idJogo, bStatus, idPessoa);

			resposta.put("resposta", "sucesso");
			response.getWriter().print(resposta);

		} catch (Exception e) {
			
			resposta.put("resposta", "false");
			
			throw new IllegalArgumentException("Deu Merda aki!!!");
			
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void buscarNomeJogo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int idJogo = new Integer(request.getParameter("idJogo"));
		
		JogosDao jd = new JogosDao();
		
		String nomeJogo = jd.buscarNomeJogo(idJogo);
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		resposta.put("resposta", "true");
		resposta.put("nomeJogo", nomeJogo);

		System.out.println(resposta.toString());
		
		response.getWriter().print(resposta);
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void montarTabelaJgCadastrados(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		JogosDao jd = new JogosDao();
		
		List<Jogos>jogoscadastrados = jd.buscarJogosCadastradosPessoas(idPessoa);
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		resposta.put("resposta", "true");
		resposta.put("listaJogosCadastrados", jogoscadastrados);

		System.out.println(resposta.toString());
		
		response.getWriter().print(resposta);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void buscarJogosCadastrados(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		JogosDao jd = new JogosDao();
		
		if (request.getParameter("idJogos") == null) {
			jd.buscarJogosCadastradosPessoas(idPessoa);
			System.out.println("Passou aki");
		} else {
			int idJogos = new Integer(request.getParameter("idJogos"));
			jd.buscarJogosCadastradosPessoasJogos(idPessoa, idJogos);
			System.out.println("Passou ali");
		}

	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void filtrarJogos(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(idPessoa);
			JogosDao jd = new JogosDao();
			
			List<Jogos> listaJogos = jd.listarJogosPessoas(pessoa);
			System.out.println("--------"+pessoa.getIdPessoa());
			JSONObject resposta = new JSONObject();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			resposta.put("resposta", "true");
			resposta.put("listaJg", listaJogos);

			System.out.println(resposta.toString());
			
			response.getWriter().print(resposta);

			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * Respos�vel por alocar as pessoas nas plataformas, roles e jogos
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void alocarPessoaPlataformaRoles(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			 PessoaDao pd = new PessoaDao();
			 
			 Jogos jogos = new Jogos();
			 jogos.setIdJogos(new Integer(request.getParameter("jogo")));
			 System.out.println(new Integer(request.getParameter("jogo")));
			
			 Roles roles = new Roles();
			 roles.setIdRoles(new Integer(request.getParameter("funcao")));
			 System.out.println(new Integer(request.getParameter("funcao")));
			
			 Plataformas plataforma = new Plataformas();
			 plataforma.setIdPlataforma(new Integer(request.getParameter("plataforma")));
			 System.out.println(new Integer(request.getParameter("plataforma")));
			 
			 Pessoa pessoa = new Pessoa();
			 pessoa.setIdPessoa(idPessoa);
			 
			 pd.alocarPessoaJogoPlataforma(pessoa, jogos, roles, plataforma);
		
			 response.sendRedirect("usuario/escolherJogos.jsp");
			 request.setAttribute("msg", "Pessoa alocada com sucesso!!!");
		} catch (Exception e) {
			System.out.println("Deu merda!!!!");
			request.setAttribute("msg", "ERRO: Pessoa j� esta alocada nas devidas roles, plataformas e jogo!!!");
			response.sendRedirect("usuario/escolherJogos.jsp");
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void consultaJogo(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Jogos jogos = new Jogos();
			JogosDao jd = new JogosDao();
			RolesDao rd = new RolesDao();

			jogos.setIdJogos(new Integer(request.getParameter("idJogo")));

			System.out.println("IdJogos: " + jogos.getIdJogos());

			List<Plataformas> listaJogosPlataformas = jd.findAllJogo(jogos
					.getIdJogos());
		
			List<Roles> listaJogosRoles = rd.findAllJogoRoles(jogos
					.getIdJogos());

			for (int i = 0; i < listaJogosPlataformas.size(); i++) {
				System.out.println("listaJogosPlataformas[" + i + "] = " + listaJogosPlataformas.get(i));
			}
			
			for (int i = 0; i < listaJogosRoles.size(); i++) {
				System.out.println("listaJogosRoles[" + i + "] = " + listaJogosRoles.get(i));
			}
			
			JSONObject resposta = new JSONObject();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			resposta.put("resposta", "true");
			resposta.put("listaJR", listaJogosRoles);
			resposta.put("listaJP", listaJogosPlataformas);

			System.out.println(resposta.toString());
			
			response.getWriter().print(resposta);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void validaNomeUsuario(HttpServletRequest request,
			HttpServletResponse response) {

		CadastroUsuario validaCad = new CadastroUsuario();
		
		try {
			
			String nomeUsuario = request.getParameter("nomeUsuario");

			JSONObject resposta = new JSONObject();

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			if (validaCad.ifExistsNomeUsuario(nomeUsuario) == true) {
				resposta.put("existe", "sim");
			} else {
				resposta.put("existe", "nao");
			}
			
			response.getWriter().print(resposta);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void validaEmail(HttpServletRequest request,
			HttpServletResponse response) {

		CadastroUsuario validaCad = new CadastroUsuario();
		
		try {
			
			String email = request.getParameter("email");

			JSONObject resposta = new JSONObject();

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			if (validaCad.ifExistsEmail(email) == true) {
				resposta.put("existe", "sim");
			} else {
				resposta.put("existe", "nao");
			}
			
			response.getWriter().print(resposta);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listarPessoasJogando(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		PessoaDao pessoaDao = new PessoaDao();

		try {

			// List<Pessoa> pessoa = pessoaDao.findAllPessoasJogando();

			// response.setContentType("application/json");

			int plataforma = Integer.parseInt( request.getParameter("plataforma") );
			System.out.println("Plataforma = " + plataforma);
			int jogo       = Integer.parseInt( request.getParameter("jogo")       );
			System.out.println("Jogo = " + jogo);
			int role       = Integer.parseInt( request.getParameter("funcao")     );
			System.out.println("Role = " + role);
			
			JSONObject resposta = new JSONObject();
			
			resposta.put("pessoas", pessoaDao.findAllPessoasJogando(role, jogo, plataforma) );

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			System.out.println(resposta.toString());
			
			response.getWriter().print(resposta);
			
		} catch (Exception e) {
			System.out.println("Erro = " + e);
		}
	}

	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void mudarSenha(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Login login = new Login();
			LoginDao ld = new LoginDao();

			login.setSenha(request.getParameter("senha"));
			login.setPalavraChave(request.getParameter("chave"));

			ld.updateSenha(login);

			request.setAttribute("msg", "senha alterada com sucesso!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void lembrarSenha(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			EnviarEmail em = new EnviarEmail();
			LoginDao ld = new LoginDao();
			String email = request.getParameter("email");

			if (ld.findByEmail(email) == true) {
				em.enviarGmail(email);
				request.setAttribute("msg", "Email enviado com sucesso!!!");
			} else {
				request.setAttribute("msg", "Email inv�lido!!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void cadastrarPessoas(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			Login        login        = new Login();
			Pessoa      pessoa        = new Pessoa();
			PessoaDao       pd        = new PessoaDao();
			LoginDao        ld        = new LoginDao();
			DataFormate     df        = new DataFormate();
			EnviarEmail     em        = new EnviarEmail();
			
			// Resgata os atributos da pessoa
			String nomeUsuario = request.getParameter("nomeUsuario");
			
			//Valida se nome do us�rio existe no sistema
			pessoa.setNomeUsuario(nomeUsuario);
			
			Date data = df.converte(request.getParameter("dataNascimento"));
			pessoa.setDataNascimento(data);
			pessoa.setSexo(request.getParameter("sexo"));
			pessoa.setLogin(login);

			// Resgata os atributos do login
			String email = request.getParameter("email");
			
			//Valida se o email existe no sistema
			login.setEmail(email);
			
			login.setSenha(request.getParameter("senha"));
			login.setPalavraChave(em.gerarPalavraChave());

			ld.createLogin(login);
			pd.gravarPessoa(pessoa);

			request.setAttribute("msg", "Usu�rio Cadastrado com Sucesso!!!");

			response.sendRedirect("index.html");

		} catch (Exception e) {
			log.logSaida("cadastrarPessoas");
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void logar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		HttpSession session = null; // sess�o nula

		try {
			Login l = new Login();

			l.setEmail(email);
			l.setSenha(senha);

			session = request.getSession(true);

			Login resp = new LoginDao().findByLogin(l);
			LoginDao ld = new LoginDao();
			
			if (resp == null) {

				JSONObject resposta = new JSONObject();
				
				resposta.put("resposta", "true");
				
				response.getWriter().print(resposta);
				
				request.getRequestDispatcher("index.html").forward(request, response);
				
			} else if (resp != null) {
				if (resp.getPerfil().equalsIgnoreCase("usuario")) {
					
					session.setAttribute("usuario", resp);
					
					Pessoa pessoa = ld.findAllLogin(resp.getIdLogin( ));
					
					idPessoa = pessoa.getIdPessoa();
					
					session.setAttribute("pessoa", pessoa);
							
					response.sendRedirect("usuario/logadoUsuario.jsp");
					
				} else if (resp.getPerfil().equalsIgnoreCase("administrador")) {

					session.setAttribute("usuario", resp);
					
					Pessoa pessoa = ld.findAllLogin(resp.getIdLogin( ));
					
					idPessoa = pessoa.getIdPessoa();
					
					session.setAttribute("pessoa", pessoa);
					
					response.sendRedirect("administrador/logadoAdministrador.jsp");

				} else {

					session.setAttribute("usuario", null);

					request.setAttribute("msg", "Usuario inv�lido!!!");
					System.out.println("Passoiu aki 2");
					request.getRequestDispatcher("index.html").forward(request, response);
				//	response.sendRedirect("/index.html");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
