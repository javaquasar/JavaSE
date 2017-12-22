package final_work;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args)
    {
        Calendar c = new GregorianCalendar(2013, 11, 25);//календарь на 25.11.2013
        System.out.println(c.get(Calendar.MONTH));//11
        System.out.println(c.get(Calendar.YEAR));//2013
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));//4
        System.out.println(c.get(Calendar.DAY_OF_WEEK));//4
        System.out.println(c.get(Calendar.DAY_OF_YEAR));//359
        System.out.println(c.get(Calendar.DAY_OF_MONTH));//25
    }
}