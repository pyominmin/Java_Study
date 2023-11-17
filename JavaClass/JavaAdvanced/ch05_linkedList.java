*LinkedList
import java.util.LinkedList;

/*
 * Array 
 * 1. RandomAcess 가능 (임의의 접근 가능)
 * 2. 맨 앞에 요소를 끼워넣으면 뒤로 한칸씩 밀려나며 오버헤드가 심해질 수 있다.
 * 3. 중간값을 삽입하거나 삭제할 수 없다.
 * 
 * Linked(이중연결 리스트)
 * 1.참조형 변수를 만들어줘야 한다.
 * RandomAcess 불가능
 * 웬만해서는 arraylist를 사용하지만 중간에 값을 넣어야 하는 경우 linkedlist를 사용해야 한다.
 * 
 * 
 */

public class _01_LinkedList {

	
	
	public static void main(String[] args) {
		LinkedList<String> list1 = new LinkedList<>();
		list1.add("Java");
		list1.add("Python");
		list1.add("C++");
		list1.add("Spring");
		list1.add("Ruby");
		list1.add("Jsp");
		
		//요소변경
		list1.set(1, "Javascript");
		list1.remove();//첫 번째 요소 제거
		System.out.println("LinkedList : " + list1);
		
		list1.remove(3);//네 번째 요소 제거
		System.out.println("LinkedList : " + list1);
		
		list1.remove("Jsp");//특정 값의 요소 제거
		System.out.println("LinkedList : " + list1);
		
		//첫 번째 요소값 얻어오기
		String str = list1.get(0);
		System.out.println("첫 번째 요소의 값은 : " + str);

		//저장된 요소의 개수 리턴
		int count = list1.size();
		System.out.println("저장된 원소의 개수 : " + count);
		
		//Collection.contains(특정값) : 컬렉션에 특정값이 존재하면 true, 없으면 false
		//boolean isExist = list1.contains("C");
		//if(isExist) {
		if(list1.contains("C")) {
			System.out.println("존재하는 문자열입니다.");
		}else {
			System.out.println("존재하지 않는 문자열입니다.");
		}
		System.out.print("\n반복문을 이용한 요소 출력");
		for(int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
		
		
		System.out.print("foreach(범위 기반 for문)으로 출력 : ");
		//list1의 요소를 elem로 반복하며 접근하겠다.
		for(String elem : list1) {//elem라는 이름으로 각각의 요소에 접근하겠다.
			System.out.print(elem + " ");
		}
		System.out.println();
		
		
		int[] arr = {1, 2, 3, 4, 5};
		for(int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		double[] num = {1.1, 2.2, 3.3};
		for(double d : num) {
			System.out.print(d + " ");
		}
		System.out.println();
		
		//-------------------------------------------------------------//
		LinkedList<Integer> list2 = new LinkedList<>();
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		
		
		//첫 번째 요소 뺴내기
		int extract = list2.peek();
		System.out.println("첫 번쨰 요소 : " + extract);
		System.out.println("LinkedList : " + list2);
		
		//첫 번째 요소 빼낸 후, 리스트에서 제거
		int extract2 = list2.poll();
		System.out.println("첫 번쨰 요소 : " + extract2);
		System.out.println("LinkedList : " + list2);
	}

}
1. 연습문제 Reverse

import java.util.LinkedList;

public class _02_Reverse {

	public static void reverseLinkedList(LinkedList<String> list) {//list.size() - 1
		String temp;
		// 저장된 요소의 개수 구하기
		int size = list.size();
		
		for(int i = 0; i < size / 2; i++) {
			//앞쪽 요소와 뒤쪽 요소를 교환
			temp = list.get(i);
			list.set(i, list.get(size - 1 - i));
			list.set(size - 1 - i, temp);
			
		}
//		temp = list.get(0);
//		list.set(0, list.get(5));
//		list.set(5, temp);
//		
//		temp = list.get(1);
//		list.set(1, list.get(4));
//		list.set(4, temp);
//		
//		temp = list.get(2);
//		list.set(2, list.get(3));
//		list.set(3, temp);
		
		
	}
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.add("I");
		list.add("J");
		list.add("K");
		list.add("L");
		list.add("M");
		list.add("N");
		list.add("O");
		
		System.out.println("Original LinkedList : " + list);
		
		reverseLinkedList(list);//역순 저장
		
		System.out.println("Reversed LinkedList : " + list);

	}
	

}

2. 연습문제 
