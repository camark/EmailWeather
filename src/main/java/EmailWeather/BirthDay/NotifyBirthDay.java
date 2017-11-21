package EmailWeather.BirthDay;

import EmailWeather.BirthDay.Entity.BirthdayEntity;
import EmailWeather.Util.EmailUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotifyBirthDay {

    private List<BirthdayEntity> birthdayEntities;
    public NotifyBirthDay() {
        birthdayEntities=new ArrayList<BirthdayEntity>();

        birthdayEntities.add(new BirthdayEntity(11,11,"老爸生日"));
        birthdayEntities.add(new BirthdayEntity(12,25,"老妈生日"));
        birthdayEntities.add(new BirthdayEntity(10,12,"宸羽生日"));
        birthdayEntities.add(new BirthdayEntity(9,27,"朱燕生日"));
        birthdayEntities.add(new BirthdayEntity(11,23,"自己生日"));
        birthdayEntities.add(new BirthdayEntity(4,28,"老妹生日"));
    }

    public void Check() throws org.apache.commons.mail.EmailException{
        EmailUtil emailUtil=new EmailUtil();
        for(BirthdayEntity birthdayEntity:birthdayEntities){
            if(birthdayEntity.isToday()){
                emailUtil.SendMail("<div>"+birthdayEntity.getMemo()+"</div>","生日提醒（"+birthdayEntity.getMemo()+")");
            }
        }
    }
}
