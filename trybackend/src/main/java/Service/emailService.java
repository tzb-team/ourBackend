package Service;

import Dao.service.CaptchaRespository;
import com.sun.mail.util.MailSSLSocketFactory;
import entity.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

@Service
public class emailService {

    @Autowired
    CaptchaRespository respository;

    private String sendAddress = "2788912409@qq.com";
    private String password = "ChenLi123";
    /**
     *
     * @param receiveAddress
     * @return
     */
    public void send(String receiveAddress)throws Exception{
        char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] code = new char[6];
        for (int i = 0; i < 6; i++) {
            code[i] = codeSequence[(int) (Math.random() * 35)];//其实也许可以用SecureRandom？
        }
        String codeStr = String.valueOf(code);
        sendSimpleMail(sendAddress,password,"验证码",receiveAddress,codeStr);

       respository.updateCaptcha(receiveAddress,codeStr);

    }

    /**
     *
     * @param sendAddress
     * @param password
     * @param subject
     * @param receiveAddress
     * @param content
     */
    private static void sendSimpleMail(String sendAddress, String password, String subject, String receiveAddress, String content)throws AddressException, MessagingException, GeneralSecurityException{
        MimeMessage message = new MimeMessage(init(sendAddress, password));
        message.setFrom(new InternetAddress(sendAddress));// 发件人
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiveAddress));// 收件人
        message.setSubject(subject);// 主题
        message.setText(content);// 内容
        Transport.send(message);
        System.out.println("The message has been sent.");
    }

    private static Session init(final String sendAddress, final String password)
            throws GeneralSecurityException {
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

    private static String getHost(String sendAddress){
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
            return "false";
        }
    }

    public boolean verify(String email,String Captcha){
        Captcha captcha = respository.findByEmail(email);
        return captcha.getCaptcha().equals(Captcha);
    }
}
