*생성자가 어떻게 호출되는지?

public이 붙은 클래스는 단 하나여야 한다.
  

import java.util.Scanner;

class Dummy{
	//class명과 동일한 메서드는 생성자이다(constructor)
	//인스턴스 생성 시 내부적으로 호출되는 메서드(직접x)
	//instance variable의 초기화 담당
	//1. class명과 같다.
	//2. 리턴타입이 없다(오직 메서드명만 존재하는 메서드)
	//3. 생성자를 만들지 않아도 자동으로 생성자가 생긴다. 하지만 인스턴스(iv)를 초기화 해주기 위해 사용한다.
	//4. 생성자는 매개변수를 가질 수 있다.(오버로딩이 가능하다.)
	Dummy(){//매개변수가 없을 때는 1번 생성자 호출
		a = 0;
		b = 0;
		c = 0;
		System.out.println("1.생성자");
		
	}
	
	Dummy(int _a){//매개변수가 있을 때는 2번 생성자 호출
		a = _a;
		b = 0;
		c = 0;
		System.out.println("2.생성자");
		
	}
	
	Dummy(int _a, int _b){
		a = _a;
		b = _b;
		c = 0;
		System.out.println("3.생성자");
		
	}
	
	Dummy(int _a, int _b, int _c){
		a = _a;
		b = _b;
		c = _c;
		System.out.println("4.생성자");
		
	}
	public int a, b, c;
}

class DoSomething{
	DoSomething(){
	System.out.println("1. DoSomething 생성자");
	}
	
	DoSomething(char _a, char _b, int _c, int _d){
		System.out.println("2. DoSomething 생성자");
		}
	DoSomething(String _a, int _b){
		System.out.println("3. DoSomething 생성자");
		}
	DoSomething(int _a, int _b, String _c){
		System.out.println("4. DoSomething 생성자");
		}
	
	
	public int a, b, c, d;
}

class DoNothing{
	DoNothing(int n1, int n2, int n3, int n4, int n5){
			System.out.println("1. DoNothing 생성자");
		}
		
	public int a, b, c, d, e;
}

public class _01_Constructor {

	public static void main(String[] args) {
		Dummy d1 = new Dummy();//인스턴스(객체 = 클래스에서 나온 변수) 생성
		Dummy d2 = new Dummy(98);//인스턴스 생성 시 인수 전달
		Dummy d3 = new Dummy(1, 2);
		Dummy d4 = new Dummy(1, 2, 3);
		
		DoSomething s1 = new DoSomething();
		DoSomething s2 = new DoSomething('R', 'T', 5, 10);
		DoSomething s3 = new DoSomething("apple", 25);
		DoSomething s4 = new DoSomething(78, 25, "할아버지");
		
		DoNothing n1 = new DoNothing(3, 4, 5, 6, 7);
		
		
		Scanner in =new Scanner(System.in);
		//Scanner = 클래스 , in = 참조형 변수 , new Scanner = 인스턴스
		
		in.close();
	}

}
