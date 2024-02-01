package generic_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionHomework {
	
	public static List<Integer> getLottoGame(){
		
		List<Integer> lottoNumber = new ArrayList<>();
			
			for (int i = 0; lottoNumber.size() < 6; i++) {
				int randomNumber = (int)(Math.random()*45+1);
				// Random 클래스 import시키기
	//			Random random = new Random();
	//			int number = random.nextInt(45)+1;
				if ( ! lottoNumber.contains(randomNumber)) {
					lottoNumber.add(randomNumber);				
				}
			}
			return lottoNumber;
	
		
	}
	
	
	public static void main(String[] args) {
		
		//5게임 만들어보기
		List<List<Integer>> lottoNumberSet = new ArrayList<>();
		
			// 숫자가 디죽박죽인게 불편해서 추가했어요!
		// 애노테이션 안쓰고 하는법 -> lottoNumber.sort( (e1, e2) -> e1 - e2 );
		List<Integer> lottoNumber = null;
		for (int i = 0; i < 5; i++) {
			lottoNumber = getLottoGame();
			lottoNumberSet.add(lottoNumber);
		}
//			System.out.println(lottoNumber);
		for (List<Integer> lottoNumbers : lottoNumberSet) {
			Collections.sort(lottoNumbers);
			System.out.println(lottoNumbers);
		}

	}
	
}