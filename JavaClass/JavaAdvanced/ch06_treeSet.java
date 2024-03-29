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

3. 과일 가격순 정렬(Comparable)

import java.util.TreeSet;

class Fruit implements Comparable<Fruit>{
	
	public Fruit(String name, int price){
		mName = name;
		mPrice = price;
	}
	
	@Override//object class
	public String toString() {
		return mName + " => " + mPrice + "원";//문자열을 만들어서 리턴
	}
	
	@Override//compareble 인터페이스//정렬기준
	public int compareTo(Fruit other) {
		if(mPrice == other.mPrice) {//값이 같으면 0
			return 0;
		}else if(mPrice < other.mPrice){//비교값이 크면 음수
			return -1;
		}else {//비교값이 작다면 양수
			return 1;
		}
	}
	
	private String mName;
	private int mPrice;
}

public class _04_FruitPriceSort {

	public static void main(String[] args) {
//		Fruit f1 = new Fruit("사과", 1200);
//		Fruit f2 = new Fruit("배", 2300);
//		Fruit f3 = new Fruit("귤", 600);
//		Fruit f4 = new Fruit("딸기", 3600);
		
		TreeSet<Fruit> ts = new TreeSet<>();
//		ts.add(f1);
//		ts.add(f2);
//		ts.add(f3);
//		ts.add(f4);
		ts.add(new Fruit("사과", 1200));
		ts.add(new Fruit("배", 2300));
		ts.add(new Fruit("귤", 600));
		ts.add(new Fruit("딸기", 3600));
		
		System.out.println("TreeSet : " + ts);
		System.out.println("\n* 가격 순 과일 메뉴 출력*");
		for(Fruit fru : ts) {
			System.out.println(fru);
		}
	}

}

4. 성적순

import java.util.Scanner;
import java.util.TreeSet;

class Student implements Comparable<Student>{
	public Student(String name, int score) {
		mName = name;
		mScore = score;
	}
	
	@Override
	public String toString() {
		return mName + " " + mScore;
	}
	
	@Override
	public int compareTo(Student other) {
		if(mScore == other.mScore) {
			return 0;
		}else if(mScore < other.mScore) {
			return -1;
		}else {
			return 1;
		}
	}
	
	public String getName() {
		return mName;
	}
	
	public int getScore() {
		return mScore;
	}
	
	private String mName;
	private int mScore;
}

public class _05_H1 {

	public static void main(String[] args) {
		TreeSet<Student> st = new TreeSet<>();
		Scanner in = new Scanner(System.in);
		String name;
		int score;

		while (true) {
			System.out.print("학생 이름과 성적을 입력 하세요.(공백 구분) : ");
			name = in.next();
			score = in.nextInt();
			
			if (score < 0 || score > 100) {
				System.out.println("입력을 종료합니다.");
				break;
			}
			
			st.add(new Student(name, score));
		}

		System.out.println("\n[성적순 출력]");
		for (Student stu : st) {
			System.out.println(stu);
		}

		System.out.println("\n몇 점 이상인 점수만 출력 하시겠습니까?");
		int num = in.nextInt();

		System.out.println("/n[" + num + "점 이상인 학생 출력]");
		for (Student stu : st) {
			if (stu.getScore() >= num) {
				System.out.println(stu);
			}

		}

	}
}
