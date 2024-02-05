package datetime_handler.newapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateExam {
	public static void main(String[] args) {
		LocalDate nowDate = LocalDate.now();
		DateTimeFormatter dateFormatter = 
				DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		String strNowDate = dateFormatter.format(nowDate);
		System.out.println(nowDate);
		System.out.println(strNowDate);
		
		nowDate = LocalDate.of(2022, 1, 1);
		System.out.println(nowDate);
		nowDate = nowDate.plusDays(10);
		nowDate = nowDate.plusMonths(2);
		nowDate = nowDate.plusYears(3);
		dateFormatter = 
				DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		strNowDate = dateFormatter.format(nowDate);
		System.out.println(nowDate);
		System.out.println(strNowDate);
		
		
	}
}
