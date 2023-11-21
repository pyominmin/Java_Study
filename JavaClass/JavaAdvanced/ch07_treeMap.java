*TreeMap

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class _01_Treemap {

	public static void main(String[] args) {
		//HashMap과 같지만 key값을 기준으로 정렬된 상태를 유지한다.
		TreeMap<Integer, String> student = new TreeMap<>();
		
		student.put(3, "홍길동");
		student.put(1, "장보고");
		student.put(4, "이순신");
		student.put(5, "유관순");
		student.put(2, "김길동");
		
		//System.out.println(student);
		System.out.println("첫 번째 key:" + student.firstKey());
		Integer fk = student.firstKey();
		System.out.println("첫 번째 key:" + fk);
		System.out.println("마지막 key:" + student.lastKey());
		System.out.println("첫 번째 Entry:" + student.firstEntry());
		Entry<Integer, String> fe = student.firstEntry();
		System.out.println("첫 번째 Entry:" + fe);
		System.out.println("마지막 Entry:" + student.lastEntry());
		
		Set<Integer> id = student.keySet();
		for(int no : id) {
			System.out.println("번호 " + no + ". 이름: " + student.get(no));
		}
	}

}
