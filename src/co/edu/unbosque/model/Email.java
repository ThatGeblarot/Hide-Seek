package co.edu.unbosque.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
* La clase Email contiene la informacion de clave y usuario que pertene al correo donde
* se envia el correo ademas se encuentra la información para logear y usar el correo de donde se envia 
* para cada tipo de requerimiento del programa
* @author Alberto Ortega
*/
public class Email {
	private Session mailSession;

	/*
	 * Este es el constructor de la clase Email
	 */
	public Email() {
		setMailServerProperties();
	}

	public void setMailServerProperties() {
		Properties emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", "587");
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		mailSession = Session.getDefaultInstance(emailProperties, null);
	}

	public MimeMessage draftEmailMessage(String[] emails, String subject, String body)
			throws AddressException, MessagingException {
		String[] toEmails = emails;
		String emailSubject = subject;
		String emailBody = body;
		MimeMessage emailMessage = new MimeMessage(mailSession);
		/**
		 * Set the mail recipients
		 */
		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}
		emailMessage.setSubject(emailSubject);
		/**
		 * If sending HTML mail
		 */
		emailMessage.setContent(emailBody, "text/html");
		/**
		 * If sending only text mail
		 */
		// emailMessage.setText(emailBody);// for a text email
		return emailMessage;
	}

	public void sendEmail(String[] emails, String subject, String body) throws AddressException, MessagingException {
		/**
		 * Sender's credentials
		 */
		String fromUser = "forestsoftwarecompany@gmail.com";
		String fromUserEmailPassword = "HideSeek*2020";

		String emailHost = "smtp.gmail.com";
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		/**
		 * Draft the message
		 */
		MimeMessage emailMessage = draftEmailMessage(emails, subject, body);
		/**
		 * Send the mail
		 */
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}
}
