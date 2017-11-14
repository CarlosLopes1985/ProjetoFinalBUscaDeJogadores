package br.com.projetofinal.validacoes;

import br.com.projetofinal.persistence.Dao;

public class CadastroUsuario extends Dao {
	
	/**
	 *  Respons�vel de validar se o nomeUsuario informado existe ou n�o
	 * @param nomeUsuario
	 * @return
	 */
	public boolean ifExistsNomeUsuario(String nomeUsuario){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from pessoa where nomeUsuario = ?" );
			stmt.setString(1, nomeUsuario);
			rs = stmt.executeQuery();
			
			if( rs.next() )
				bOk = true;
			else
				bOk = false;
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return bOk;
	}
	
	/**
	 * Respons�vel de validar se o email informado existe ou n�o
	 * 
	 * @param email
	 * @return
	 */
	public boolean ifExistsEmail(String email){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from login where email = ?" );
			stmt.setString(1, email);
			
			rs = stmt.executeQuery();
			
			if( rs.next() )
				bOk = true;
			else
				bOk = false;
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return bOk;
	}
	
	
	
	public static void main(String[] args) {
		
		CadastroUsuario cd = new CadastroUsuario();
		
		if( cd.ifExistsNomeUsuario("carloslopes") == true ){
			System.out.println("Nome existe");
		}else 
			System.out.println("N�o existe!!!");
		
	}
	
}
