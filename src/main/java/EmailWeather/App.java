package EmailWeather;

import EmailWeather.JsonEntity.Daily_forecast;
import EmailWeather.JsonEntity.HeWeather6;
import EmailWeather.JsonEntity.WeatherRoot;
import com.alibaba.fastjson.JSON;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws java.io.IOException,org.apache.commons.mail.EmailException
    {
        //System.out.println( "Hello World!" );

        String weather_json=new HeWeather().GetWeather("淄博");

        if(weather_json.length()>0){
            WeatherRoot root= JSON.parseObject(weather_json,WeatherRoot.class);

            HeWeather6 heWeather6 = root.getHeWeather6().get(0);


            String Weather_Data=RenderToHtml(heWeather6);

            SendMail(Weather_Data, LocalDate.now().toString()+" 天气预报");
        }
        else{
            SendMail("获取天气信息出错！", LocalDate.now().toString()+" 天气预报");
        }
    }

    private static String RenderToHtml(HeWeather6 heWeather) throws java.io.IOException{
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("Template");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/weathertemp.html");

        t.binding("data",heWeather.getDaily_forecast());
        String str = t.render();
        //System.out.println(str);

        return str;
    }
    private static void SendMail(String htmlBody,String subject) throws org.apache.commons.mail.EmailException{
        HtmlEmail email = new HtmlEmail();


        email.setHostName("smtp.sina.cn");
        email.setSmtpPort(465);
        String email_user_name = "username@sina.cn";
        String email_user_pass = "userpass"
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
