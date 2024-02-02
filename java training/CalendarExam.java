package oop_exam;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExam {
	public static void main(String[] args) {
		
		Calendar nowDateTime = Calendar.getInstance();
		System.out.println(nowDateTime);
		int year = nowDateTime.get(Calendar.YEAR);
		System.out.println(year);
		
		Calendar past = Calendar.getInstance();
		past.set(Calendar.YEAR, 1970);
		past.set(Calendar.MONTH, 0);
		past.set(Calendar.DAY_OF_MONTH, 1);
		past.set(Calendar.HOUR, 0);
		past.set(Calendar.MINUTE, 0);
		past.set(Calendar.SECOND, 0);
		
		past.set(2022, 3-1,1,1,50,17);
		System.out.println(past);
		
		System.out.println(nowDateTime.get(Calendar.YEAR));
		System.out.println(nowDateTime.get(Calendar.MONTH)+1);
		System.out.println(nowDateTime.get(Calendar.DAY_OF_MONTH));
		System.out.println(nowDateTime.get(Calendar.HOUR));
		System.out.println(nowDateTime.get(Calendar.MINUTE));
		System.out.println(nowDateTime.get(Calendar.SECOND));
		System.out.println(nowDateTime.get(Calendar.DAY_OF_WEEK));
		
		Date now = Calendar.getInstance().getTime();
		System.out.println(now);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = format.format(now);
		System.out.println(formatDate);
		
		Calendar nowCal = Calendar.getInstance();
		nowCal.set(2022, 01,01);
		nowCal.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println(nowCal);
		nowCal.add(Calendar.DAY_OF_MONTH, -20);
		System.out.println(nowCal);
		
	}
}
