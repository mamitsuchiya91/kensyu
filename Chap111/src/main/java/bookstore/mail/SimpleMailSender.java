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
		mail.sendMessage("databasetest1991@yahoo.co.jp", "databasetest1991@yahoo.co.jp", "Name", "����", "�{��");
	}
	
	public void sendMessage(String toAddr, String fromAddr, String personName, String subject, String message) throws Exception{
		Properties props = new Properties();
		//���[�����M�v���p�e�B�̍쐬
		props.put("mail.smtp.host", SMTP_HOST);
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.host", SMTP_HOST);
		props.put("mail.from", fromAddr);
		//SMTP�F�ؐݒ�
		props.put("mail.smtp.auth", "true");
		//SMPT�\�P�b�g�|�[�g
		props.put("mail.smtp.socketFactory", SMTP_PORT);
		//SSL�𗘗p����SMTP�T�[�o��SLL�p�̃\�P�b�g�t�@�N�g���[�𗘗p����
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		//SSL�t�H�[���o�b�N
		props.put("mail.smtp.socketFactory.fallback", String.valueOf(false));
		//���[���Z�b�V�������m������
		//�Z�b�V�����m���ݒ��props�Ɋi�[�����
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