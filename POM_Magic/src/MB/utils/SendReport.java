package MB.utils;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import MB.core.TestCore;

/**
 * @author vinayak  bansal
 *
 * Tag: Send report table format
 */
public class SendReport {

	public static void sendmail() throws Exception {

		String tolist = "vinayak.bansal@puresoftware.com";
				//"harpreet.singh@rategain.com,yogesh.kumar@rategain.com,rizwankhan@rategain.com,kumar.pradeep@rategain.com,vinayak.bansal@puresoftware.com";
		
		List<String> Sendtolist = new ArrayList<String>();
		StringTokenizer todetail = new StringTokenizer(tolist, ",");
		
		
		while (todetail.hasMoreTokens()) {
			Sendtolist.add(todetail.nextToken());
		}
		
		/*tanuj.kumar1@rategain.com
		Rategain@12345
		*/

		String from = "vinayak.bansal@puresoftware.com";

		final String username = "vinayak.bansal@puresoftware.com";

		final String password="";
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25");
		// 587

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			
			for (int i = 0; i < Sendtolist.size(); i++) {
				// System.out.println(Constant.tolist.get(i));
				message.addRecipients(Message.RecipientType.TO,
						InternetAddress.parse(Sendtolist.get(i)));

			}
			
			
			/*message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));*/

			// Subject:
			message.setSubject("Automation Run Report");

			// message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// actual message
			messageBodyPart
					.setText("Test report, run on  " + new Date());

			// multipart message
			Multipart multipart = new MimeMultipart();

			// message part
			multipart.addBodyPart(messageBodyPart);
			
			
			
			
			
			

			TestCore.emailBody.append("</tr>");
			TestCore.emailBody.append(" </table>");
			
			
			TestCore.emailBody.append("</div>");
			
			TestCore.emailBody.append("<div>");
			
	/*		
			TestCaseRunner.emailBody.append("<tr>");
			TestCaseRunner.emailBody.append(" <th style='padding:5px'>Thanks & Regards</th>");
			TestCaseRunner.emailBody.append("</tr>");
			TestCaseRunner.emailBody.append("<tr>");

			TestCaseRunner.emailBody.append(" <th style='padding:5px'>Puresoftware Pvt. Ltd</th>");
			TestCaseRunner.emailBody.append("</tr>");*/


			TestCore.emailBody.append("</div>");
			TestCore.	emailBody.append("</body>");

			TestCore.emailBody.append("</html>");
			
			// clear  console
			
			
		//	String str="<html><head><title>HTML 5 Example by www.techonthenet.com</title></head><body><h1>Heading</h1><p>This is the content.</p></body></html>";

		//	messageBodyPart.setText(TestCaseRunner.emailBody.toString());
		//messageBodyPart.setText(str);


			messageBodyPart.setContent(TestCore.emailBody.toString(), "text/html; charset=utf-8");		

			// attachment
			messageBodyPart = new MimeBodyPart();
		//	String filename = "D:\\TestReport.html";
			
			
			
			Thread.sleep(6000);
			
			String filename=System.getProperty("user.dir")+"\\test-output\\Relevent-report\\MyOwnReport.html";
			DataSource source = new FileDataSource(filename);
			
			messageBodyPart.setDataHandler(new DataHandler(source));
			
			Date date= new Date();
			
			
			messageBodyPart.setFileName(date+"_"+source.getName());
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
