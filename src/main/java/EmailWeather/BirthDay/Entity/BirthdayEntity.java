package EmailWeather.BirthDay.Entity;

import EmailWeather.BirthDay.LunarCalendar;

import java.time.LocalDate;

public class BirthdayEntity {


    private String Memo;

    public int getLunarMonth() {
        return LunarMonth;
    }

    public void setLunarMonth(int lunarMonth) {
        LunarMonth = lunarMonth;
    }

    public int getLunarDay() {
        return LunarDay;
    }

    public void setLunarDay(int lunarDay) {
        LunarDay = lunarDay;
    }

    private int LunarMonth;
    private int LunarDay;

    public BirthdayEntity(int month,int day, String memo) {

        LunarDay=day;
        LunarMonth=month;
        Memo = memo;
    }



    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public boolean isToday(){
        LunarCalendar calendar=new LunarCalendar();

        LocalDate today=LocalDate.now();

        int year=today.getYear();

        int leap_year=year;

        if(getMemo().contains("老妈")){
            leap_year=year-1;
        }

        int[] rets=LunarCalendar.lunarToSolar(leap_year,getLunarMonth(),getLunarDay(),calendar.IsLeapYear(leap_year));

        return rets[1]==today.getMonth().getValue() &&rets[2]==today.getDayOfMonth();
    }
}
