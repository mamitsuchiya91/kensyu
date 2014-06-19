package bookstore.mail;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SimpleMailSender {
	private static Logger log = Logger.getLogger(SimpleMailSender.class.getName());
	private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private final String SMTP_PORT = "465";
	private final String AUTH_USER_NAME = "databasetest1991@yahoo.co.jp";
	private final String AUTH_PASSWORD = "test1234";
	private static final String SMTP_HOST = "smtp.mail.yahoo.co.jp";
	
	public static void main(String argv[]) throws Exception{
		SimpleMailSender mail = new SimpleMailSender();
		mail.sendMessage("databasetest1991@yahoo.co.jp", "databasetest1991@yahoo.co.jp", "Name", "件名", "本文");
	}
	
	public void sendMessage(String toAddr, String fromAddr, String personName, String subject, String message) throws Exception{
		Properties props = new Properties();
		//メール送信プロパティの作成
		props.put("mail.smtp.host", SMTP_HOST);
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.host", SMTP_HOST);
		props.put("mail.from", fromAddr);
		//SMTP認証設定
		props.put("mail.smtp.auth", "true");
		//SMPTソケットポート
		props.put("mail.smtp.socketFactory", SMTP_PORT);
		//SSLを利用するSMTPサーバはSLL用のソケットファクトリーを利用する
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		//SSLフォールバック
		props.put("mail.smtp.socketFactory.fallback", String.valueOf(false));
		//メールセッションを確立する
		//セッション確立設定はpropsに格納される
		Session session = Session.getDefaultInstance(props, new Authenticator()
				{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return (new PasswordAuthentication(AUTH_USER_NAME , AUTH_PASSWORD));
			}
				});
		session.setDebug(true);
		MimeMessage mimeMsg = new MimeMessage(session);
		mimeMsg.setRecipients(Message.RecipientType.TO, toAddr);
		InternetAddress fromHeader = new InternetAddress(fromAddr, personName);
		mimeMsg.setFrom(fromHeader);
		mimeMsg.setSubject(subject, "UTF-8");
		mimeMsg.setSentDate(new Date());
		mimeMsg.setText(message, "UTF-8");
		Transport.send(mimeMsg);
	}
}