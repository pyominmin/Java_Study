
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

1.아이디 비밀번호

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
