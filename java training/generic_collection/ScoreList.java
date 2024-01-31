
package generic_collection;

public class ScoreList<T> {

	/**
	 * ScoreList가 관리할 배열
	 */
	private Object[] scoreArray;
	
	/**
	 * 배열 내에 들어있는 아이템들의 수<br/>
	 * 배열의 길이와는 관계가 없다.
	 */
	private int size;

	public ScoreList() {
		this.scoreArray = new Object[2];
	}
	
	/**
	 * scoreArray 배열에 값을 추가한다.
	 * @param score 제네릭에 할당된 타입의 인스턴스 혹은 값
	 */
	public void add(T score) {
		if( size >= scoreArray.length) {
			Object[] tempScoreArray = new Object[scoreArray.length + 2];
			System.arraycopy(scoreArray, 0, tempScoreArray, 0, scoreArray.length);
			scoreArray = tempScoreArray;
		}
		scoreArray[size] = score;
		size += 1;
	}
	
	/**
	 * scoreArray 배열에서 index에 할당된 값을 반환.
	 * @param index 반환시킬 배열의 인덱스
	 * @return 인덱스에 들어있는 인스턴스 혹은 값
	 */
	// @SuppressWarnings("unchecked") 이 어노테이션은 경고등을 지워준다..ㅎㅎ
	public T get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
		return (T) scoreArray[index];
	}
	
	/**
	 * scoreArray 배열에 인스턴스 혹은 값이 들어있는 개수.
	 * <pre>
	 * 	int[] scoreArray = new int[100];
	 * 	scoreArray[0] = 100;
	 * 	scoreArray[1] = 100;
	 * </pre>
	 * size()의 결과는 2가 반환된다.
	 * @return scoreArray 배열에 인스턴스 혹은 값이 들어있는 개수.
	 */
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ScoreList[");
		for (int i = 0; i < size; i++) {
			sb.append(scoreArray[i] + ", ");
		}
		sb.append(" ]");
		return sb.toString();
	}
	
}
