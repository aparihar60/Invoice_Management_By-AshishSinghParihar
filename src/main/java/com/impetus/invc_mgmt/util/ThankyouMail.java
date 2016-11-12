package com.impetus.invc_mgmt.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.invc_mgmt.model.Invoice;







/**
 * The Class ThankyouMail.
 */
public class ThankyouMail {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ThankyouMail.class);
	/** The tinvoice list. */
	 
	/** The invoice svc. */
	
	

	/**
	 * Instantiates a new thankyou mail.
	 */
	public ThankyouMail() {
		
	
	}
		
		/**
		 * Thanks email.
		 *
		 * @param invoice the invoice
		 */
		public void thanksEmail(Invoice invoice) 
		{
			LOGGER.info("In Thanks Mail Method !!!!");
			LOGGER.info("Invoice Client is : "+invoice.getClient().getClientfname());
			final String username = "caseinvoice@gmail.com";
			final String password = "caseinvoice08";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});
			
			
			try{
				MimeBodyPart textBodyPart = new MimeBodyPart();
				            textBodyPart.setText("Thankyou  your invoice is paid..!");
				                             
		
				                        //construct the mime multi part
				            
				                        MimeMultipart mimeMultipart = new MimeMultipart();
				            
				                        mimeMultipart.addBodyPart(textBodyPart);
				            
				                        
				                        
				                        Message message = new MimeMessage(session);
				            			message.setFrom(new InternetAddress("caseinvoice@gmail.com"));
				            			message.setRecipients(Message.RecipientType.TO,
				            					InternetAddress.parse(invoice.getClient().getClientemail()));
				            			message.setSubject(" Thankyou Invoice Mail");

				            			message.setContent(mimeMultipart);

				            			Transport.send(message);

				            			LOGGER.info("ThankyouMail Done");


			}
			
			catch(MessagingException e) {
				
			}	
			catch(Exception ex) {
			
				           
			
				        }


		
			 
	    }
}