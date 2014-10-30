package Client.interfaces;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.pidev.persistence.User;

public class mail {
	public boolean mailblock(User m,String objet ,String message){
		
		 String host = "smtp.gmail.com";
	        Properties props = System.getProperties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", "beji.bouraoui@esprit.tn");
	        props.put("mail.smtp. password", "13402011");
	        props.put("mail.smtp.port", 587);
	        props.put("mail.smtp.auth", "true");
	        Session session = Session.getDefaultInstance(props, null);
	        MimeMessage mimeMessage = new MimeMessage(session);
	        try {

	  String[] to ={m.getE_mail()};
	            mimeMessage.setFrom(new InternetAddress(m.getE_mail()));
	            InternetAddress[] toAddress = new InternetAddress[to.length];
	            for (int i = 0; i < to.length; i++) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }
	            for (int i = 0; i < toAddress.length; i++) {
	                 mimeMessage.addRecipient(javax.mail.Message.RecipientType.TO, toAddress[i]);

	            }
	            
	            mimeMessage.setSubject(objet);
	            mimeMessage.setText(message);
	            Transport transport =session.getTransport("smtp");
	            transport.connect(host, "beji.bouraoui@esprit.tn","13402011");
	             transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients() );
	            transport.close();
	            return true;
	        } catch (MessagingException me) {
	            me.printStackTrace();

	        }
	        return false;
	    }
		
	}
	


