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

import org.apache.log4j.Logger;

import com.impetus.invc_mgmt.model.Invoice;

// TODO: Auto-generated Javadoc
/**
 * The Class ReminderMail.
 */
public class ReminderMail {

	/** The logger. */
	private static Logger logger = Logger.getLogger(ReminderMail.class);

	/**
	 * Reminder email.
	 * 
	 * @param inv
	 *            the inv
	 */
	public void reminderEmail(Invoice inv) {

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

		try {
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(" your invoice is unpaid please paid ASAP");

			// construct the mime multi part

			MimeMultipart mimeMultipart = new MimeMultipart();

			mimeMultipart.addBodyPart(textBodyPart);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("caseinvoice@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("aparihar60@gmail.com"));
			message.setSubject(" Reminder Invoice Mail");

			message.setContent(mimeMultipart);

			Transport.send(message);

		}

		catch (MessagingException e) {

		} catch (Exception ex) {

			logger.info("Exception");

		}

	}

}
