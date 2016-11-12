package com.impetus.invc_mgmt.util;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.invc_mgmt.model.Invoice;
import com.impetus.invc_mgmt.model.InvoiceDetail;

// TODO: Auto-generated Javadoc
/**
 * The Class MailInvoice is responsible to send a mail to client.
 */
public class MailInvoice {

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(MailInvoice.class);

	/**
	 * Invoice email.
	 * 
	 * @param invoice
	 *            the invoice
	 * @param list
	 *            the list
	 */
	public void invoiceEmail(Invoice invoice, List<InvoiceDetail> list) {

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
		ByteArrayOutputStream outputStream = null;
		PDFInvoice pdfinvoice = new PDFInvoice();

		try {
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Please check recipent of Invoice");
			outputStream = new ByteArrayOutputStream();

			pdfinvoice.invoicePdf(outputStream, invoice, list);
			byte[] bytes = outputStream.toByteArray();

			// construct the pdf body part

			DataSource dataSource = new ByteArrayDataSource(bytes,
					"application/pdf");

			MimeBodyPart pdfBodyPart = new MimeBodyPart();

			pdfBodyPart.setDataHandler(new DataHandler(dataSource));
			pdfBodyPart.setFileName("invoice.pdf");

			// construct the mime multi part

			MimeMultipart mimeMultipart = new MimeMultipart();

			mimeMultipart.addBodyPart(textBodyPart);

			mimeMultipart.addBodyPart(pdfBodyPart);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("caseinvoice@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(invoice.getClient().getClientemail()));
			message.setSubject("Invoice Mail");

			message.setContent(mimeMultipart);

			Transport.send(message);

		}

		catch (MessagingException e) {

		} catch (Exception ex) {

			logger.info(ex + "");

		}

	}

}
