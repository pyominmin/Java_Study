*TreeSet

import java.util.TreeSet;
//first(): TreeSet에서 첫 번째(가장 작은) 요소를 반환합니다.
//last(): TreeSet에서 마지막(가장 큰) 요소를 반환합니다.
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

2. 문자열 입력

import java.util.Scanner;
import java.util.TreeSet;

//first(): TreeSet에서 첫 번째(가장 작은) 요소를 반환합니다.
//last(): TreeSet에서 마지막(가장 큰) 요소를 반환합니다.
//그러므로 범위 기반으로 출력해야 한다.
public class _03_StringSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TreeSet<String> ts = new TreeSet<>();

		System.out.println("문자열 입력(종료하려면 \"exit\" 누르면 종료)");

		while (true) {
			System.out.print("문자열 입력 : ");
			String str = in.nextLine();

			// if(str == "exit") {//주소가 같다
			// if(str.equals("exit")) {
			if (str.equalsIgnoreCase("exit")) {// 대소문자 구별x
				break;// 반복문 탈출
			}
			//저장 하기 전에 exit는 나가게 한다.
			ts.add(str);// 정렬된 상태 유지, 중복 문자열은 추가하지 않는다.

		}
		in.close();

		System.out.println("\n\n*문자열 출력(오름차순 정렬)*\n");
		for (String str : ts) {//범위 기반으로 출력해야 한다.
			System.out.println(str);
		}
	}
}

