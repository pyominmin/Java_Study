HashMap
1. 존재하는 회원
import java.util.HashMap;

public class _01_HashMap {

	public static void main(String[] args) {
		//Map은 key - value의 쌍으로 이루어져있다.
		HashMap<String, Integer> hm = new HashMap<>();//key - value의 쌍으로 이루어져있다. 그러므로 들어가는 타입이 2개여야 한다.
		
		hm.put("홍길동", 19);
		hm.put("김길동", 28);
		hm.put("박길동", 45);
		hm.put("백길동", 33);
		
		System.out.println(hm);
		
		int age = hm.get("홍길동");//키값으로 값을 얻는다.//키값이 없을 때 null을 리턴
		System.out.println("홍길동의 나이 : " + age);
		
		age = hm.get("김길동");//키값으로 값을 얻는다.
		System.out.println("김길동의 나이 : " + age);
		
		
		if(hm.containsKey("윤동주")) {
			System.out.println("윤동주는 존재하는 회원입니다.");
		}else {
			System.out.println("윤동주는 존재하지 않습니다.");
		}
	}
		
}

2.아이디 비밀번호

import java.util.HashMap;
import java.util.Scanner;

public class H1 {

	public static void main(String[] args) {
		HashMap<String, String> user = new HashMap<>();
		
			user.put("user1", "password123");
			user.put("user2", "securePass456");
			user.put("admin", "adminPass789");
			
//			System.out.println(user.get("user1"));//key값이 존재하는 경우는 value 값을 얻는다.
//			System.out.println(user.get("user2"));
//			System.out.println(user.get("admin"));
//			System.out.println(user.get("user3"));//key값이 없는 경우 null을 리턴
			Scanner in = new Scanner(System.in);
			System.out.print("검색할 아이디 입력 : ");
			String userId = in.nextLine();
			
			if(user.get(userId) == null) {//key로 얻어온 value가 null이라면?
				System.out.println("검색한 아이디는 존재하지 않습니다.");
			}else {
			System.out.println("검색한 [" + userId + "]의 패스워드는 [" + user.get(userId) + "]입니다.");
			}
			in.close();

			
	}

}

3. 영어 퀴즈


import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class _03_WordQuiz {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		Scanner in = new Scanner(System.in);
		
		hm.put("사과", "apple");
		hm.put("바나나", "banana");
		hm.put("오렌지", "orange");
		hm.put("딸기", "strawberry");
		hm.put("배", "pear");
		
		Set<String> keySet = hm.keySet();//HashMap에서 key값을 담은 집합
		System.out.println(keySet);
		
		int correct = 0;
		for(String key : keySet) {
			System.out.print("\n" + key + "을(를) 영어 단어로 하면?");
			String answer = in.nextLine();
			
			//if(answer == hm.get(key)) {
			if(answer.equals(hm.get(key))) {
				++correct;//정답의 개수 증가
				System.out.println("정답입니다.");
			}else {
				System.out.println("오답입니다.");
			}
		}
		
		
		System.out.println("총 " + hm.size() + "문제 중 정답 [" + correct + "]개");
	}

}

4. key - value 타입 차이

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class _03_WordQuiz {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		Scanner in = new Scanner(System.in);
		
		hm.put("사과", "apple");
		hm.put("바나나", "banana");
		hm.put("오렌지", "orange");
		hm.put("딸기", "strawberry");
		hm.put("배", "pear");
		
		Set<String> keySet = hm.keySet();//HashMap에서 key값을 담은 집합
		System.out.println(keySet);
		
		Collection<String> valueCol = hm.values();//타입이 다르다.
		System.out.println(valueCol);

5. 연상퀴즈
	
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class _04_AssociateQuiz {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		Scanner in = new Scanner(System.in);
		
		hm.put("바늘", "실");
		hm.put("라면", "김치");
		hm.put("피노키오", "제페토");
		hm.put("거짓말", "빅뱅");
		hm.put("연필", "지우개");
		hm.put("책상", "의자");
		hm.put("겨울", "고구마");
		hm.put("봄", "여름");
		hm.put("제주도", "귤");
		hm.put("휴지", "나무");
		hm.put("칫솔", "치약");

		System.out.println("당신이 생각하는 연상 단어를 ㅇ비력하세요(총 문제 수 " + hm.size() +"개)");
		
		int correct = 0;
		Set<String> keySet = hm.keySet();//HashMap에서 key값 얻어옴
		
		for(String key : keySet) {
			System.out.print("\n" + key + "=> ");
			String answer = in.nextLine();
			
			if(answer.equals(hm.get(key))) {//문자열이 같냐??
				++correct;
				System.out.println("[정답]입니다.");
			}else {
				System.out.println("[오답]입니다.");
				System.out.println("정답은 [" + hm.get(key) + "] 입니다.");
			}
		}
		System.out.println("정답 " + correct + "개");
		in.close();
	}

}

	
