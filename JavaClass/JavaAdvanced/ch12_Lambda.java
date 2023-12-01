*람다
//class LambdaEx{
//	int max(int a, int b) {
//		return a > b ? a : b;
//	}
//	
//	//람다함수 정의 방법//(매개변수) -> 명령
//	1. (int a, int b) -> {return a > b ? a : b;}//return 구문이 있을 시 중괄호({})는 생략 불가능
//	2. (int a, int b) -> { a > b ? a : b;}//연산식의 결과를 리턴하는 경우 return 구문은 생략 가능
//	3. (int a, int b) -> a > b ? a : b//중괄호도 생략 가능 : 끝에 세미콜론을 쓸 수 없다.
//	4. (a, b) -> a > b ? a : b//매개 변수의 타입을 생략할 수 있다. 이때, 타입은 추론되어 결정한다. 
//	
////------------------------------------------------------------------------------------------//

//	double square(int n) {
//		return n * n;
//	}
//	1. (int n) -> {return n * n;}
//	2. (int n) -> n * n
//	3. n -> n * n
//	//------------------------------------------------------------------------------------------//

//	void display(String name, int age) {
//		System.out.println(name + " : " + age);
//	}
//	
//	1. (String name, int age) -> {System.out.println(name + " : " + age);}
//	2.(String name, int age) -> System.out.println(name + " : " + age)
//	(name, age) -> System.out.println(name + " : " + age)

//	//------------------------------------------------------------------------------------------//
//	
//	void printChar(char ch, int count) {
//		for(int i = 0; i < count; i++) {
//			System.out.println(ch);
//		}
//	}
//	1. (char ch, int count) -> {for(int i = 0; i < count; i++) {
//		System.out.println(ch);
//		}
//	}
//}

public class _05_Lambda {

	public static void main(String[] args) {
		//Runnable 상속 받는 익명 객체를 정의 
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello World");
			}
			
		};
		r1.run();
		
		//람다
		Runnable r2 = () -> System.out.println("Hello World");
		r2.run();
	}

}

1. 람다

/*
 * 
 * 함수형 인터페이스(FunctionalInterface)
 * 
 * 1. 단 하나의 추상 메서드만을 갖는 인터페이스를 말한다.
 * 2. 함수형 인터페이스는 람다 표현식을 활용하기 위한 목적으로 도입되었다.
 * 3. @FunctionalInterface을 붙이면 함수형 인터페이스가되어 람다를 위해 만들어진 인터페이스임을 알 수 있다.
 */


@FunctionalInterface
interface MyInterface{
	//인터페이스의 모든 메서드는 추상 메서드이다.
	/*public abstract 생략*/ void fun();
}

public class _06_Lambda {

	public static void main(String[] args) {
		
		MyInterface m1 = new MyInterface(){

			@Override
			public void fun() {
				System.out.println("old way: lambda test!");
				
			}
			
		};
		m1.fun();
		
		//---------------------------------------------------------------------//
		
		//람다 표현식
		MyInterface m2 = () -> System.out.println("lambda way: lambda test!");
		m2.fun();
	}

}

2.람다
//void printChar(char ch, int count) {
//	for(int i = 0; i < count; i++) {
//		System.out.println(ch);
//	}
//}

	interface CharPrinter{
		void printChar(char ch, int count);
	}

	public class _07_Lambda {

		public static void main(String[] args) {
		
		CharPrinter p1 = new CharPrinter() {

			@Override
			public void printChar(char ch, int count) {
				for(int i = 0; i < count; i++) {
					System.out.print(ch);
				}
				System.out.println();
			}
			
	};
		System.out.println("익명 클래스를 이용한 방법");	
		p1.printChar('*', 50);
		
		
		CharPrinter p2 = (char ch, int count) -> {
			for(int i = 0; i < count; i++){
				System.out.print(ch);
		}
		System.out.println();
		};
		System.out.println("람다 표현식을 이용한 방법 : ");
		p2.printChar('#', 100);
	}

}
