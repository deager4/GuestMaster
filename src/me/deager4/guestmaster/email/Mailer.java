package me.deager4.guestmaster.email;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer 
{
	private final String username = "rescdesk@gmail.com";
	private final String password = "rescdesk1234";
	private final String recepient = "rescpool@gmail.com";
	
	private Properties props = new Properties();
	private Session session;
	private Message message;
	
	public Mailer()
	{
		
	}
	
	public void sendMail(String messageText, String subject)
	{
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
		});
		try
		{
			message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.recepient));
			message.setSubject(subject);
			message.setText(messageText);
			Transport.send(message);
			System.out.println("sent");
		}
		catch(MessagingException e)
		{
			e.printStackTrace();
		}
	}
}
