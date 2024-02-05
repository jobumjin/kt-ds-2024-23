package datetime_handler.newapi;

import java.time.LocalDate;
import java.time.YearMonth;

public class LocalDateExam2 {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		
		//전체 요일
		System.out.println(now.getDayOfWeek().name()); // LocalDate, LocalDateTime 사용
		
		YearMonth yearMonth = YearMonth.from(now);
		//이번달의 첫번째 달 구하기
		LocalDate firstDay = yearMonth.atDay(1); // LocalDate, LocalDateTime 사용
		System.out.println(firstDay);
		System.out.println(firstDay.getDayOfWeek().name());
		
		//이번달의 마지막 날 구하기
		LocalDate lastDay = yearMonth.atEndOfMonth(); // LocalDate, LocalDateTime 사용
		System.out.println(lastDay);
		System.out.println(lastDay.getDayOfWeek().name());
		
		//이번달 총 며칠인지 구하기
		int lengthOfDays = now.lengthOfMonth();
		System.out.println(lengthOfDays);
		
		//이번 해는 총 며칠인지 구하기
		int lengthOfYears = now.lengthOfYear();
		System.out.println(lengthOfYears);
	}
}
