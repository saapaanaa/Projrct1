package Controller;

import java.io.IOException;
import java.net.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

	public class Mail3
	{	
		public static void main(String[] args) 
		{
			String toemail="abcvijabc@gmail.com";
			String fromemail="abcbtmabc@gmail.com";
			String password="abc@btm19";
			String sub="Reset Password";
			String msg="http://localhost:9090/BANKAPP/resetpassword.html";
			//http://localhost:9090/BANKAPP/
			
			//http://localhost:9090/BANKAPP/resetpassword.html
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true");
	        
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(fromemail, password);
	                    }
	                });
	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("fromemail"));
	            message.addRecipient(Message.RecipientType.TO,new InternetAddress(toemail));
	            message.setSubject(sub);
	            message.setText(msg);
	            Transport.send(message);
	            System.out.println("Mail Sent Successfully");
	        } 
	        catch (MessagingException e)
	        {
	            e.printStackTrace();
	        }
	    }

	}



