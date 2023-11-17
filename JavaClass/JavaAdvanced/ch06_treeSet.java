*TreeSet

import java.util.TreeSet;

/*
 * TreeSet : Set인터페이스를 구현했다.(중복x, 순서x)
 * 내부적으로 Red - Black Tree로 구현되어 있다.(균형잡힌 Binary Search Tree, BST)
 * 균형 이진 트리기 때문에 검색, 삽입, 삭제하는 효율이 높아진다.
 * 보통의 경우 HashSet을 쓰지만 범위 검색 시 TreeSet 사용
 */
public class _01_TreeSet {//검색이 유리함
	
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(3);
		ts.add(4);
		ts.add(5);
		ts.add(6);
		ts.add(3);
		ts.add(12);
		ts.add(13);
		ts.add(16);
		ts.add(24);
		ts.add(33);
		ts.add(23);
	
		System.out.println("Tree Set : " + ts);
		
		System.out.println("Tree Set : " + ts.subSet(3, 15));//subSet[from포함, to)미포함
	}
}

1. 로또번호
  
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class _02_GeneratorLotto {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet(6);//크기 설정 가능
		Random random =new Random();

		while(hs.size() < 6) {
			int rad = random.nextInt(45) + 1;
			hs.add(rad);
		}
		System.out.println("HashSet Lotto : " + hs);
		//----------------------------------------------//
		
		TreeSet<Integer> ts = new TreeSet<>();//크기 설정 불가능
		while(ts.size() < 6) {
		int rad = random.nextInt(45) + 1;
		ts.add(rad);
		}
		System.out.println("TreeSet Lotto : " + ts);//정렬된 상태를 유지한다.
	}

}

2.
