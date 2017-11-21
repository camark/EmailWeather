package EmailWeather.Weather;

import EmailWeather.Util.EmailUtil;
import EmailWeather.Weather.JsonEntity.HeWeather6;
import EmailWeather.Weather.JsonEntity.WeatherRoot;
import com.alibaba.fastjson.JSON;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.time.LocalDate;

public class EmailEvery {

    private EmailUtil emailUtil=new EmailUtil();

    public void EmailThreeDayWeather() throws java.io.IOException, org.apache.commons.mail.EmailException {
        String weather_json=new HeWeather().GetWeather("淄博");

        if(weather_json.length()>0){
            WeatherRoot root= JSON.parseObject(weather_json,WeatherRoot.class);

            HeWeather6 heWeather6 = root.getHeWeather6().get(0);


            String Weather_Data=RenderToHtml(heWeather6);

            emailUtil.SendMail(Weather_Data, LocalDate.now().toString()+" 天气预报");
        }
        else{
            emailUtil.SendMail("获取天气信息出错！", LocalDate.now().toString()+" 天气预报");
        }
    }

    private String RenderToHtml(HeWeather6 heWeather) throws java.io.IOException{
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("Template");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/weathertemp.html");

        t.binding("data",heWeather.getDaily_forecast());
        String str = t.render();
        //System.out.println(str);

        return str;
    }
}
