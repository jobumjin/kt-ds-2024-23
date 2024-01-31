package generic_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionHomework {
	public static void main(String[] args) {
		
		List<Integer> lottoNumber = new ArrayList<>();
		
		for (int i = 0; lottoNumber.size() < 6; i++) {
			int randomNumber = (int)(Math.random()*45+1);
			if ( ! lottoNumber.contains(randomNumber)) {
				lottoNumber.add(randomNumber);				
			}
		}
		// 숫자가 디죽박죽인게 불편해서 추가했어요!
		Collections.sort(lottoNumber);
		System.out.println(lottoNumber);
		
	}
}