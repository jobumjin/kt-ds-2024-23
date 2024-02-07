package fp_java.ch03.slicing;

import java.util.ArrayList;
import java.util.List;

import fp_java.ch02.stream.vo.Dish;
import fp_java.ch02.stream.vo.Dish.Type;
import fp_java.ch02.stream.vo.DishData;

public class SlicingExample {
	
	public static void main(String[] args) {
		
		// 칼로리가 300보다 큰 음식 중
		// 앞의 2개는 무시하고 나머지는 모두 출력
		List<Dish> menu = DishData.menu;
		
		List<Dish> dishes = new ArrayList<>();
		
		for (Dish dish : menu) {
			if(dish.getCalories() > 300) {
				dishes.add(dish);
			}
		}
		System.out.println(dishes);
		
		for (int i = 0; i < dishes.size(); i++) {
			if(i >= 2) {
				System.out.println(dishes.get(i));
			}
		}
		
		menu.stream()
			.filter( dish -> dish.getCalories() > 300)
			.skip(2)
			.forEach(dish -> System.out.println("Stream: " + dish));
		
		System.out.println("=".repeat(40));
		// 메뉴의 타입이 Dish.Type.MEAT 이거나, Dish.Type.OTHER 인 메뉴 중
		// 가장 앞 2개는 건너띄고
		// 3개만 가져와서 메뉴의 이름을 출력.
		menu.stream()
			.filter(dish -> dish.getType() == Type.MEAT || dish.getType() == Type.OTHER )
			.skip(2)
			.limit(3)
			.forEach(dish -> System.out.println("Stream: " + dish));
		
		
	}
	
}
