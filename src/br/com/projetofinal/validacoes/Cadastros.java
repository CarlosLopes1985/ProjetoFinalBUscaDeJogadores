package br.com.projetofinal.validacoes;

import br.com.projetofinal.persistence.Dao;

public class Cadastros extends Dao {
	
	/** Responsável de validar se o jogo informado já existe no sistema
	 * 
	 * @param email
	 * @return
	 */
	public boolean ifExistsJogos(String NomeJogos){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from Jogos where nomeJogo = ?" );
			stmt.setString(1, NomeJogos );
			
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
	
	/** Responsável de validar se o jogo informado já existe no sistema
	 * 
	 * @param email
	 * @return
	 */
	public boolean ifExistsPlataformas(String nomePlataformas){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from Platafaormas where nomePlataformas = ?" );
			stmt.setString(1, nomePlataformas );
			
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
	
	/** Responsável de validar se o jogo informado já existe no sistema
	 * 
	 * @param email
	 * @return
	 */
	public boolean ifExistsRoles(String nomeRoles){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from Jogos where nomeJogo = ?" );
			stmt.setString(1, nomeRoles );
			
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
	
	
}
