package generic_collection;

import java.util.HashMap;
import java.util.Map;

public class CollectionMap {
	public static void main(String[] args) {
		
		// Map 에 데이터 추가
		Map<String, Integer> priceMap = new HashMap<>();
		
		priceMap.put("Apple Macbook Pro", 3_500_000);
		priceMap.put("Samsung Galaxy Book", 1_500_000);
		priceMap.put("LG Gram", 1_700_000);
		
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		priceMap.put("LG Gram", 1_800_000);
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// Map 데이터 조회
		int applePrice = priceMap.get("Apple Macbook Pro");
		System.out.println(applePrice);

		// java.lang.NullPointerException
//		applePrice = priceMap.get("Apple macbook Pro");
//		System.out.println(applePrice);
		
		// Map 데이터 삭제
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		priceMap.remove("Apple Macbook Pro");
		
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// Map 데이터 모두 삭제
		priceMap.clear();
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// Map 비어있는지 확인
		priceMap.put("Apple Macbook Pro", 3_500_000);
		priceMap.put("Samsung Galaxy Book", 1_500_000);
		priceMap.put("LG Gram", 1_700_000);
		
		boolean isEmpty = priceMap.isEmpty();
		System.out.println(isEmpty);
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		priceMap.clear();
		isEmpty = priceMap.isEmpty();
		System.out.println(isEmpty);
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// Map 에 동일한 key가 있는지 확인
		priceMap.put("Apple Macbook Pro", 3_500_000);
		priceMap.put("Samsung Galaxy Book", 1_500_000);
		priceMap.put("LG Gram", 1_700_000);
		
		System.out.println(priceMap);
		System.out.println(priceMap.size());

		if ( !priceMap.containsKey("LG Gram")) {
			priceMap.put("LG Gram", 1_600_000);
		}
		
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// Map 에 동일한 value가 있는지 확인
		priceMap.put("Apple Macbook Pro", 3_500_000);
		priceMap.put("Samsung Galaxy Book", 1_500_000);
		priceMap.put("LG Gram", 1_700_000);
		
		System.out.println(priceMap);
		System.out.println(priceMap.size());

		if ( !priceMap.containsValue(1_700_000)) {
			priceMap.put("LG Gram", 1_600_000);
		}
		
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// Map 복사
		priceMap.put("Apple Macbook Pro", 3_500_000);
		priceMap.put("Samsung Galaxy Book", 1_500_000);
		priceMap.put("LG Gram", 1_700_000);
		
		Map<String, Integer> priceMap2 = new HashMap<>();
		priceMap2.putAll(priceMap);
		
		System.out.println(System.identityHashCode(priceMap));
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
 		
		System.out.println(System.identityHashCode(priceMap2));
		System.out.println(priceMap2);
		System.out.println(priceMap2.size());
	}
}
