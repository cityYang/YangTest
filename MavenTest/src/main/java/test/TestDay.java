package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDay {
 private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
   public static void main(String[]args){
	   String str = "2016-12-01 00:00:00";
	   try {
		Date date=format.parse(str);
		System.out.println(format.format(date));
		System.out.println(date.getDay()+"");
		System.out.println(date.getDate()+"");
	} catch (ParseException e) {
		e.printStackTrace();
	}
   }
}
