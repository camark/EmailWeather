package EmailWeather;

import EmailWeather.BirthDay.LunarCalendar;
import EmailWeather.BirthDay.NotifyBirthDay;
import EmailWeather.Weather.EmailEvery;
import EmailWeather.Weather.JsonEntity.HeWeather6;
import EmailWeather.Weather.JsonEntity.WeatherRoot;
import EmailWeather.Weather.HeWeather;
import com.alibaba.fastjson.JSON;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws java.io.IOException,org.apache.commons.mail.EmailException
    {
        //System.out.println( "Hello World!" );

        //EmailThreeDayWeather();

//        int[] ret= LunarCalendar.lunarToSolar(2017,10,12,false);
//
//        System.out.println(ret[0]+"-"+ret[1]+"-"+ret[2]);

        NotifyBirthDay notifyBirthDay=new NotifyBirthDay();
        notifyBirthDay.Check();

        EmailEvery emailEvery=new EmailEvery();
        emailEvery.EmailThreeDayWeather();
    }



}
