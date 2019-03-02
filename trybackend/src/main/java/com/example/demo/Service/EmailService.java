package com.example.demo.Service;

import com.example.demo.Dao.CaptchaRepo;
import com.example.demo.Entity.MailCaptcha;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Calendar;
import java.util.Properties;

@Service
public class EmailService {

    @Autowired
    CaptchaRepo repo;

    @Value("${sendAddress}")
    String sendAddress;

    @Value("${mailPassword}")
    String password;
    public void insertCode(String emailAddress) throws GeneralSecurityException, MessagingException, Exception {
        char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] code = new char[6];
        for (int i = 0; i < 6; i++) {
            code[i] = codeSequence[(int) (Math.random() * 35)];//其实也许可以用SecureRandom？
        }
        String codeStr = String.valueOf(code);

        MailCaptcha mailCaptcha = new MailCaptcha();
        mailCaptcha.setEmailAddress(emailAddress);
        mailCaptcha.setCaptcha(codeStr);
        repo.save(mailCaptcha);
        sendSimpleMail("验证码",emailAddress,codeStr);
    }
    private void sendSimpleMail(String subject, String receiveAddress, String content) throws GeneralSecurityException, MessagingException, Exception {
        MimeMessage message = new MimeMessage(init(sendAddress, password));
        message.setFrom(new InternetAddress(sendAddress));// 发件人
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiveAddress));// 收件人
        message.setSubject(subject);// 主题
        message.setText(content);// 内容
        Transport.send(message);
        System.out.println("The message has been sent.");
    }

    /**
     * @param sendAddress
     * @param password
     * @return
     * @throws GeneralSecurityException
     * @throws Exception                继续上抛host未找到问题
     */
    private static Session init(final String sendAddress, final String password)
            throws GeneralSecurityException, Exception {
        String host = getHost(sendAddress);// 邮件服务器
        Properties properties = System.getProperties();// 系统设置
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();// SSL
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        Session session = Session.getDefaultInstance(properties, new Authenticator() {// 授权
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendAddress, password);
            }
        });
        return session;
    }

    /**
     * @param sendAddress
     * @return
     * @throws Exception host未找到
     */
    private static String getHost(String sendAddress) throws Exception {
        if (sendAddress.endsWith("@smail.nju.edu.cn")) {
            return "smtp.exmail.qq.com";
        } else if (sendAddress.endsWith("@qq.com")) {
            return "smtp.qq.com";
        } else if (sendAddress.endsWith("@126.com")) {
            return "smtp.126.com";
        } else if (sendAddress.endsWith("@163.com")) {
            return "smtp.163.com";
        } else if (sendAddress.endsWith("@sina.com")) {
            return "smtp.sina.com.cn";
        } else if (sendAddress.endsWith("@sohu.com")) {
            return "smtp.sohu.com.cn";
        } else if (sendAddress.endsWith("@139.com")) {
            return "smtp.139.com";
        } else {
            throw new Exception("Unknown Host.");
        }
    }

    public boolean checkCode(String emailAddress, String code) {
        MailCaptcha mailCaptcha = repo.findByEmailAddress(emailAddress);
        return mailCaptcha.getCaptcha().equals(code);
    }
}
