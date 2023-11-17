*arrayList*



import java.util.ArrayList;
import java.util.Collections;

/*
 * ArrayList : 동적 배열 : 배열의 크기가 늘어난다. 
 * 컬렉션 중 가장 많이 사용된다.
 * 배열로 구현되어 있는데 기본 크기가 10, 16으로 잡힌다.
 * 메모리가 부족한 경우 1.5배 정도 늘어난다.
 * 
 */

public class _01_ArrayList {

	public static void main(String[] args) {
		ArrayList<Double> a3 = new ArrayList<>();
		a3.add(5.1);
		a3.add(34.1);
		a3.add(64.1);
		a3.add(87.1);
		a3.add(26.1);
		a3.add(84.1);
		a3.add(13.1);
		a3.add(10.1);
		a3.add(56.1);
		a3.add(77.1);
		System.out.println("a3 ArrayList : " + a3);
		
		//Collections 인터페이스가 아니다. Collections 클래스
		Collections.sort(a3);
		System.out.println("a3 ArrayList(정렬 후) : " + a3);
		Collections.reverse(a3);
		System.out.println("a3 ArrayList(역순 저장) : " + a3);
		System.out.println();
		//----------------------------------------------------------------------------//
		
		ArrayList<Integer> a1 = new ArrayList<>();//a1의 배열의 크기가 기본적으로 10개가 잡힌다.//ArrayList 생성//메모리 크기 설정 가능
		a1.add(5);//맨 뒤 추가//만약 메모리가 꽉 찬다면 1.5배 정도 늘린다. 이 과정에서 느려진다.
		a1.add(6);//맨 뒤 추가
		a1.add(7);//맨 뒤 추가
		a1.add(8);//맨 뒤 추가
		a1.add(9);//맨 뒤 추가
		a1.add(10);//맨 뒤 추가
		//오버헤드 : 어떤 처리를 하기 위해 들어가는 간접적인 처리 시간, 메모리 등을 말한다.
		//ArrayList 중간 삽입 시 오버헤드가 커진다.
		a1.add(2, 999);//2번째 인덱스에 999추가//중간에 끼워 넣어서 리스트 밀림(단점)
		
		a1.set(1, -3);//1번 인덱스의 값을 -3으로 변경
		
		Integer deVal = a1.remove(1);//0번째 인덱스를 제거 후 삭제된 값을 리턴
		a1.remove(0);//삭제
		a1.remove(Integer.valueOf(10));//Integer타입인 10을 제거하겠다.//값 제거
		
		System.out.println("삭제된 값을 리턴 : " + deVal);
		System.out.println("int형 ArrayList : " + a1);
		
		
		
		System.out.print("for문을 이용한 출력 : ");
		for(int i = 0; i < a1.size(); i++)//리스트의 개수만큼 반복
			System.out.print(a1.get(i) + " ");//배열이 아니므로 get메서드를 이용해 불러온다.//index의 값을 얻어오겠다.
		System.out.println();
		
		System.out.println("int형 ArrayList : " + a1);
		
		//----------------------------------------------------------------------------//
		System.out.println();
		
		
		ArrayList<String> s1 = new ArrayList<>();
		s1.add("apple");
		s1.add("banana");
		s1.add("orange");
		s1.add(1, "pear");
		s1.set(0, "strawbarry");
		
		
		String delVelue = s1.remove(0);
		s1.remove("pear");
		System.out.println("삭제된 값을 리턴 : " + delVelue);
		System.out.println("String형 ArrayList : " + s1);
		
		for(int i = 0; i < s1.size(); i++)//리스트의 개수만큼 반복
			System.out.print(s1.get(i) + " ");//배열이 아니므로 get메서드를 이용해 불러온다.//index의 값을 얻어오겠다.
		System.out.println();

	}

}

1. 연습문제 최댓값 찾기
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.*;

public class _02_FindMax {

	public static int findMax(ArrayList<Integer> list) {
		//ArrayList에서 최댓값을 구해 리턴하는 메서드
		int max = list.get(0);//1. ArrayList에서 첫 번째 값을 최대값으로 설정
		
		for(int i = 1; i < list.size(); i++) {
			if(max < list.get(i)) {
				max = list.get(i);
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ArrayList<Integer> arr = new ArrayList<>();//ArrayList생성(기본 크기10)
		System.out.println("정수 5개를 입력하세요");
		for(int i = 0; i < 5; i++) {
			System.out.print("입력 : ");
			int num = in.nextInt();
			arr.add(num);//맨뒤 추가
		}
		
		int maxValue = findMax(arr);//최댓값을 구하는 메서드 호출
		System.out.println("최댓값 : " + maxValue);
		
		
		in.close();

	}

}

2. 중복제거

import java.util.ArrayList;
import java.util.Scanner;

public class _03_RemoveString {

	public static ArrayList<String> removeDuplicates (ArrayList<String> list) {//unique가 ArrayList<String>타입이기 때문에
		//중복이 제거 된 리스트를 생성 후 리턴
		ArrayList<String> unique = new ArrayList<>();//ArrayList생성
		
		for(int i = 0; i < list.size(); i++) {
			if(unique.contains(list.get(i)) == false){//기존에 저장되지 않은 문자열만 //contains : ArrayList에 객체가 존재하는 경우 true
			unique.add(list.get(i));//unique에 추가
			}
		}
		return unique;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();//리스트를 만들고 싶어서 ArrayList 생성
		
		
		System.out.println("문자열을 입력하세요. 종료하려면 빈 문자열을 입력하세요.");
		while(true) {
			System.out.print("문자열 입력 : ");
			String str = in.nextLine();
			arr.add(str);
			
			if(str.isEmpty()){//문자열이 없다면?? true
				break;
			}
		}
		in.close();
		
		System.out.println("ArrayList : " + arr);
		ArrayList<String> unique = removeDuplicates(arr);//중복된 문자열이 있는 경우 중복된 문자열을 제거 후 새로운 리스트 생성
		System.out.println("ArrayList(중복제거) : " + unique);
	}

}

3. 홀수 리스트

import java.util.ArrayList;
import java.util.Scanner;

public class NumList {

	public static ArrayList<Integer> removeEvenNumber(ArrayList<Integer>list){
		ArrayList<Integer> unique = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) % 2 == 1) {
				unique.add(list.get(i));
			}
		}
		return unique;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer>arr = new ArrayList<>();//ArrayList 생성
		
		System.out.println("정수를 입력하세요. 종료하려면 0을 입력하세요.");
		while(true) {
			System.out.print("입력 : ");
			int num = in.nextInt();
			arr.add(num);
			
			if(num == 0){
				break;
			}
		}
		
		in.close();

		System.out.println("입력된 정수 리스트 : " + arr);
		ArrayList<Integer> unique = removeEvenNumber(arr);
		System.out.println("홀수 리스트 : " + unique);
		
	}

}
​
