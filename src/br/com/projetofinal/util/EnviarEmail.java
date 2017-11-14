package br.com.projetofinal.util;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.projetofinal.persistence.LoginDao;

public class EnviarEmail{
	
	/**
	 * Gera token aleat�rio para mudan�a de senha
	 * @return
	 */
	public String gerarPalavraChave(){
		
		UUID uuid = UUID.randomUUID();
		String myRandom = uuid.toString();
		String resultado = (myRandom.substring(0,8));
		
		return resultado;
	}
	
	/**
	 * Respos�vel por montar a mensagem que ser� enviada ao usu�rio
	 * @return
	 */
	public StringBuffer montarEmail(String codRecuperacao){

		StringBuffer sb = new StringBuffer();
		
		sb.append("<!DOCTYPE html>");
		sb.append("<html><head><h1 align=center>Mudan�a de Senha</h1>");
		sb.append("<h3>Clique no link abaixo para mudar a sua senha </h3>");
		sb.append("<body>");
		sb.append("<a href= http://localhost:8089/TCCDPA25-10-2017/mudarSenha.jsp> Mudar senha </a>");
		sb.append("<br/>");
		sb.append("<br/>");
		sb.append("<h1>");
		sb.append("Seu c�digo de recupera��o �: "+ codRecuperacao );
		sb.append("</h1>");
		sb.append("</body>");
		sb.append("</html>");        
	    
		sb.toString();
		
		return sb;
	}
    
	/**
	 * Respons�vel pelo envio da mensagem para o usu�rio com a palavra chave
	 * @param email
	 * @return true ou false.. False para n�o enviado e true para enviado com sucesso
	 * @throws Exception 
	 */
    public boolean enviarGmail(String email) throws Exception {
        boolean retorno = false;
        LoginDao ld = new LoginDao();
        
        String palavraChave = ld.buscarCodRecuperacao(email);
        
        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.googlemail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory" );
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465" );

        Session s = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication("dontplayalonegroup@gmail.com", "TccDpa2017");//email e senha usu�rio 
                    }
                });

        //compose message  
        try {
            MimeMessage message = new MimeMessage(s);
            message.setFrom(new InternetAddress("dontplayalonegroup@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            EnviarEmail em = new EnviarEmail();
            message.setSubject("Recupera��o de senha");
            message.setContent(em.montarEmail(palavraChave).toString(), "text/html; charset=utf-8");
            
            //send message  
            Transport.send(message);

            retorno = true;

        } catch (MessagingException e) {
            retorno = false;
            e.printStackTrace();
        }
      
        return retorno;
    }
}
