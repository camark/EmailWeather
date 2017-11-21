package EmailWeather.BirthDay;

import junit.framework.Assert;
import junit.framework.TestCase;



public class LunarCalendarTest extends TestCase{

    public void testMonth12(){
        int[] rets=LunarCalendar.lunarToSolar(2016,12,25,new LunarCalendar().IsLeapYear(2016));

        Assert.assertEquals(rets[0],2017);
        Assert.assertEquals(rets[1],1);
        Assert.assertEquals(rets[2],22);
    }

}