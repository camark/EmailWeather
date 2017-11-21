package EmailWeather.Util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {
    public void SendMail(String htmlBody,String subject) throws org.apache.commons.mail.EmailException{
        HtmlEmail email = new HtmlEmail();


        email.setHostName("smtp.sina.cn");
        email.setSmtpPort(465);
        String email_user_name = "cxxxxxxxxxxxxx@sina.cn";
        String email_user_pass = "fxxxxxxxxxxxxxxxxxxx";
        email.setAuthenticator(new DefaultAuthenticator(email_user_name,email_user_pass));
        email.setSSLOnConnect(true);

        email.addTo("gongming@ebara.cn", "Gongming");
        email.setFrom(email_user_name, "camark");
        email.setSubject(subject);


        // set the html message
        email.setCharset("UTF-8");
        email.setHtmlMsg(htmlBody);

        // set the alternative message
        email.setTextMsg("Weather Report");

        // send the email
        email.send();
    }
}
