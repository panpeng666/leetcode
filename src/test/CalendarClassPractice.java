package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
日历类个人练习
 */
public class CalendarClassPractice {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sf1=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String datetime = sf2.format(new Date());
        System.out.print(datetime);
        System.out.print(new SimpleDateFormat("hh:mm:ss").format(new Date()));

        String a = "1999-10-10";
        String b= "2000-10-10 09:23:09";
        Date c = sf1.parse(a);
        Date d = sf2.parse(b);
        System.out.println(a);
        System.out.println(b);

        GregorianCalendar cl= new GregorianCalendar();
        Date e = cl.getTime();
        GregorianCalendar cl1= new GregorianCalendar();
        cl1.setTime(e);
    }
    enum a{
        UI,OO,PP,J解决就
    }

}
