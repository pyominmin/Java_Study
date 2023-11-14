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

