예외처리(Exception)

컴파일 에러 : 컴파일 시에 발생하는 에러
런타임 에러 : 컴파일은 되지만 실행 시에 발생하는 에러
  에러(Error) : 메모리 부족이나 스택오버플로우와 같이 복구할 수 없는 심각한 오류
  예외(Exception) : 프로그래머에 의해 개발 단계에서 미리 막을 수 있는 오류
논리적 에러 : 컴파일되고 실행되긴 하지만, 프로그램의 의도와 다르게 동작하는 에러로 개발자의 논리적인 오류로 인해 발생


 1. Arithmetic Exception
  
import java.util.Scanner;
//import java.lang.*;


public class _01_Exeption {

	public static void main(String[] args) {
		//Arithmetic Exception
		
		Scanner in = new Scanner(System.in);
		System.out.print("나눗셈을 할 두 수 입력(공백 구분) : ");
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		in.close();
		
		System.out.println("나눗셈의 몫은 " + n1 / n2 + "입니다.");

		System.out.println("**************************");
		System.out.println("**************************");
		System.out.println("**************************");
		System.out.println("**************************");
	}

}
0으로 나누었을 때
 java.lang.ArithmeticException: / by zero 오류가 노출됨.


0으로 나눈 뒤 나머지 명령이라도 실행하기 위해 try로 묶어준다.
//--------------------------------------------------------------------------------------------// 


import java.util.Scanner;
//import java.lang.*;


public class _01_Exeption {

	public static void main(String[] args) {
		//Arithmetic Exception
		
		Scanner in = new Scanner(System.in);
		System.out.print("나눗셈을 할 두 수 입력(공백 구분) : ");
		
		try {//오류가 발생할 수 있는 지역을 try로 묶는다.
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		System.out.println("나눗셈의 몫은 " + n1 / n2 + "입니다.");
		}catch(ArithmeticException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("**************************");
		System.out.println("**************************");
		System.out.println("**************************");
		System.out.println("**************************");
		System.out.println("**************************");
		System.out.println("**************************");
		System.out.println("**************************");
		
		in.close();
	}

}

2. ArrayIndexOutOfBoundsException
public class _02_Exception {

	public static void main(String[] args) {
		//ArrayIndexOutOfBoundsException
		
		int []a = {10, 20, 30, 40, 50};
		
		for(int i = 0; i <= 5; i++) {//배열을 넘었기 때문에 생긴 에러// (i < 5)배열이 4까지 있기 때문
			System.out.println(a[i] + " ");
		}
		System.out.println();
	}

}
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
	
try로 묶어준다.
//--------------------------------------------------------------------------------------------// 


public class _02_Exception {

	public static void main(String[] args) {
		// ArrayIndexOutOfBoundsException

		int[] a = { 10, 20, 30, 40, 50 };

		try {
			for (int i = 0; i <= 5; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}
	}

}

3.ArrayIndexOutOfBoundsException

//ArrayIndexOutOfBoundsException
//int형 메모리를 할당하는 클래스
class IntArray{
	
	public IntArray(int size) {
		capacity = size;//배열의 최대 용량 저장
		arr = new int [capacity];//배열을 할당
		System.out.println("생성자 => 인스턴스 생성 시 호출");
	}
	
	public void displayArray() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public void setAt(int index, int value) {
		arr[index] = value;
	}
	
	private int[] arr;// = null
	private int capacity;//할당된 최대 크기
}

public class _03_Exception {

	public static void main(String[] args) {
		IntArray ia = new IntArray(5);//인스턴스 생성
		
		//ia.arr[3] = 999;//err : private 멤버는 접근 불가능
		ia.setAt(3, 999);
		ia.setAt(0, -78);
		ia.setAt(5, 1234);
		
		ia.displayArray();
	}

}
//--------------------------------------------------------------------------------------------// throw로 묶어준다.

class IntArray{
	
	public IntArray(int size) {
		capacity = size;//배열의 최대 용량 저장
		arr = new int [capacity];//배열을 할당
		System.out.println("생성자 => 인스턴스 생성 시 호출");
	}
	
	public void displayArray() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public void setAt(int index, int value) {
		if(index < 0 || index >= 5) {//범위를 벗어난 인덱스가 들어올 경우
			throw new ArrayIndexOutOfBoundsException("배열의 범위를 벗어났어!");
		}
		arr[index] = value;
	}
	
	private int[] arr;// = null
	private int capacity;//할당된 최대 크기
}

public class _03_Exception {

	public static void main(String[] args) {
		IntArray ia = new IntArray(5);//인스턴스 생성
		
		try {
		//ia.arr[3] = 999;//err : private 멤버는 접근 불가능
		ia.setAt(3, 999);
		ia.setAt(0, -78);
		ia.setAt(5, 1234);
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}
		ia.displayArray();
	}

}
