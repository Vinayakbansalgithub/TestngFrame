package vb.AutomationFramework;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendReport {

	static void sendmail() {

		String to = "vinayak.bansal@puresoftware.com";

		String from = "vinayak.bansal@puresoftware.com";

		final String username = "vinayak.bansal@puresoftware.com";

		final String password = "ajaybansal";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			// Subject:
			message.setSubject("Testing suit  Report");

			// message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// actual message
			messageBodyPart
					.setText("Appium test report, run on  " + new Date());

			// multipart message
			Multipart multipart = new MimeMultipart();

			// message part
			multipart.addBodyPart(messageBodyPart);

			BuildObjrep.emailBody.append("</tr>");
			BuildObjrep.emailBody.append(" </table>");
			BuildObjrep.emailBody.append("</div>");
			BuildObjrep.	emailBody.append("</body>");

			BuildObjrep.emailBody.append("</html>");
			
			// clear  console
			
			
			String str="<html><head><title>HTML 5 Example by www.techonthenet.com</title></head><body><h1>Heading</h1><p>This is the content.</p></body></html>";

		//	messageBodyPart.setText(BuildObjrep.emailBody.toString());
//messageBodyPart.setText(str);


messageBodyPart.setContent(BuildObjrep.emailBody.toString(), "text/html; charset=utf-8");		

			// attachment
			messageBodyPart = new MimeBodyPart();
			String filename = "D:\\TestReport.html";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
