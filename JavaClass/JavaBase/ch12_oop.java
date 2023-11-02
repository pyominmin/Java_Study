객체지향
object orianted progrem(oop)
1. 객체
2. 클래스
3. 추상화
4. 캡슐화
5. 다형성
6. 상속성

ex,데이터 - 눈은 2개 코길이 2, 몸무게 1톤, 다리 4개, 귀 2개
    기능 - 과자를 코로 받음, 코로 샤워함

코끼리라는 객체를 가지고 프로그래밍을 할 때 코끼리의 데이터적인 표현은 변수로 표현한다(weight, lengs, eyes) , 기능적인 표현(코로 샤워, 코로 받기)은 메서드로(함수) 한다.
데이터 표현과 기능 표현을 합친 것이 class이다.

class elephant{//클래스는 코끼리가 아니라 코끼리에 대한 정의 이다.(추상화 작업)// 코끼리는 main에서 elephant라는 변수를 선언해야 생긴다.
double weight;
int nose length;
int eyes;
int feet;
}
void eat(int apple){
eat apple
}
void shower(int water){
shower with water
}
main{// 실제 변수를 선언해야 코끼리가 생성된다. //클래스에서 나온 변수를 객체라고 한다.
elephant e1; (코끼리 1)
elephant e2; (코끼리 2)

}

//클래스는 객체를 뽑아내기 위한 틀이다.
*추상화 작업(핵심만 뽑아내는 것) -> 지하철 노선표는 현실세계와 똑같이 그려놓은 것이 아니라 핵심이 되는 부분만 뽑아서 놓은 것이다.

ex, 붕어빵 - 붕어빵 틀에 재료를(슈크림, 팥, 딸기잼 등) 넣는다. 1. 빠르게 2. 균일하게 만들 수 있다.
붕어빵 틀 - 클래스
붕어빵의 변수 
딸기잼 - 붕어빵1(변수)객체
슈크림 - 붕어빵2(변수)객체

ex, 아파트 설계도 - 클래스// 설계도가 없으면 엉망으로 건설하지만 있다면 균일하게 건설할 수 있다.
아파트 - 객체
아파트의 중요한 부분을 뽑아내는 것(추상화)

ex, 가루약
알약 안의 성분을 다 분석해서 먹지 않고 감기약 이라는 이름을 보고 약을 먹는다.
감기약의 성분을 다 분석하고 먹을 필요가 없다.

*캡슐화
클래스 안에서 기능을 동작하게 만들어놓고 공개정보를 통해 다른 개발자가 클래스에 접근할 수 있도록 한다.

*객체지향 프로그램
세세하게 코드를 짜지 않고 클래스들을 블록을 맞추듯이 끼워서 코드를 프로그래밍을 하는 방식
 - 빠르게 개발할 수 있다. 요즘 대부분 캡슐화가 되어있다.
그러므로 모든 객체지향 프로그래밍의 단위는 클래스이다. 즉 클래스 안에 있는 변수에 메모리가 할당된다.

*지금부터는 클래스를 이용해서 디자인을 할 것이다.
*클래스로 프로그래밍을 하는 이유는 대형 프로잭트를 하기 위한 것이다. 
*자바 파일 하나당 클래스 하나(public class는 단 하나만 존재해야 한다.)가 좋다.


1. 클래스로 프로그래밍

//동일 파일 내에 클래스가 2개 이상인 경우 public 클래스는 단 하나만 존재해야 한다.
//public 클래스는 파일명과 일치해야 한다.(대소문자 구별)

//삼각형 클래스
class Triangle{//클래스 안에서 선언된 변수를 instance variable(iv)이라고 한다.
	
	//Triangle 가방에는 모든 기능과 데이터들이 들어가는데 데이터들은 iv 이고, 기능들은 im이다.
	//instance method(im)은 클래스 내에서 선언된 메서드(함수)
	//Triangle 가방을 만들려면 iv와 im이 필요하다.
	//iv = base, height
	//im = setTriangle, getArea
	
	public double base = 0, height = 0;//public 공개된 멤버다.
	
	public void setTriangle(double _base, double _height) {//매개변수를 받아서 base와 height를 초기화해준다.
		base = _base;//클래스에서 선언된 변수 (iv)
		height = _height;
	}
	
	public double getArea() {
		double area = base * height / 2;
		return area;//area는 지역변수
	}


	public double getHypotenuse() {
		return Math.sqrt(base * base + height * height);
	}
}


public class _01_Triangle {//파일 이름하고 같은 애가 public

	public static void main(String[] args) {
		//만들어진 삼각형 클래스를 가져다 쓰자 
		Triangle t1 = new Triangle();//변수 선언x, 객체 생성//t1은 Triangle()클래스의 주소를 가지게된다.
		t1.setTriangle(3.8, 9.2);//값 설정
		System.out.println("t1의 삼각형의 넓이는" + t1.getArea() + "입니다.");
		System.out.println("t1삼각형의 빗변의 길이는" + t1.getHypotenuse() + "입니다.");

		Triangle t2 = new Triangle();//instance(객체 생성)
		t2.setTriangle(8, 13);
		System.out.println("t2의 삼각형의 넓이는" + t2.getArea() + "입니다.");
		System.out.println("t2삼각형의 빗변의 길이는" + t2.getHypotenuse() + "입니다.");
		
		double b, h;
		Scanner in = new Scanner(System.in);
		System.out.print("밑변 입력 : ");
		b = in.nextDouble();
		System.out.print("높이 입력 : ");
		h = in.nextDouble();
		in.close();
		
		Triangle t3 = new Triangle();//instance 생성
		t3.setTriangle(b, h);//입력 값을 전달
		System.out.println("t3의 삼각형의 넓이는" + t3.getArea() + "입니다.");
		System.out.println("t3삼각형의 빗변의 길이는" + t3.getHypotenuse() + "입니다.");
	}

}
//객체와 instance는 같다고 본다. 우린 객체라고 잘 부르지 않고 instance라고 부른다.

1-2 원의 넓이 구하기


import java.util.Scanner;

class Circle{
	
	//instance variable(iv)
	public double mRadius = 0;//클래스의 변수는 m을 많이 붙여준다.//지역변수와 구분하기 위함
	public final double mPI = 3.141592;//변허지 않는 값은 상수(final)로 저장
	
	public void setRadius(double radius) {
		mRadius = radius;
	}
	
	public double getRArea() {//원위 둘레
		return mPI * mRadius * mRadius;
	}
	
	public double getCircumference() {//원의 넓이
		return 2 * mPI * mRadius;
	}
	
	
}

//파일명과 동일한 클래스가 public 클래스가 되어야 한다.
public class _02_Circle {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		//클래스 멤버 접근 시 => 인스턴스.멤버
		
		
		c1.setRadius(8.3);
		System.out.println("원의 넓이는 " + c1.getRArea() + "입니다.");
		System.out.println("원의 둘레는 " + c1.getCircumference() + "입니다.");
		
		Scanner in = new Scanner(System.in);
		double rad;
		System.out.print("반지름 입력 : ");
		rad = in.nextDouble();
		in.close();
		
		Circle c2 = new Circle();
		c2.setRadius(rad);
		System.out.println("원의 넓이는 " + c2.getRArea() + "입니다.");
		System.out.println("원의 둘레는 " + c2.getCircumference() + "입니다.");

		
	}

}

1-3 사다리꼴의 넓이


import java.util.Scanner;

class Troperzoid{
	
	public double mTop, mBottom, mHeight;
	
	public void setTroperzoid(double top, double bottom, double height) {
		mTop = top;
		mBottom = bottom;
		mHeight = height;
		
	}
	
	public double getTroperzoid() {
		return ((mTop + mBottom) * mHeight / 2);
		
	}
	
}


public class _03_Troperzoid {

	public static void main(String[] args) {
		Troperzoid t1 = new Troperzoid();
		t1.setTroperzoid(3, 5, 8);
		System.out.printf("사다리꼴의 넓이는 %.3f", t1.getTroperzoid());
		System.out.println("");
		
		Troperzoid t2 = new Troperzoid();
		Scanner in = new Scanner(System.in);
		System.out.print("윗변, 밑변,  높이 입력 : ");
		double t = in.nextDouble();
		double b = in.nextDouble();
		double h = in.nextDouble();
		t2.setTroperzoid(t, b, h);
		in.close();
		System.out.printf("사다리꼴의 넓이는 %.3f", t2.getTroperzoid());
	}

}

1-4 연산


class Calculator{
	//연산 횟수 체크
	int[] count = new int[6];
	
	
	public double getSume(double n1, double n2) {
		count[0]++;
		return n1 + n2;
	}
	public double getSub(double n1, double n2) {
		count[1]++;
		return n1 - n2;
	}
	public double getMul(double n1, double n2) {
		count[2]++;
		return n1 * n2;
	}
	public double getDiv(double n1, double n2) {
		count[3]++;
		return n1 / n2;
	}
	
	public double getPower(int x, int y) {
		count[4]++;
		double result = 1;
		
		for(int i = 1; i <= y; i++) {
			result = result * x;
			
			return result;
		}
		return result;
	}
	
	public double getPowerOfTwo(int y) {
		count[5]++;
		double result = 1;
		
		for(int i = 1; i <= y; i++) {
			result = result * 2;
			
			return result;
		}
		return result;
	}
	
	void showOpCount() {
		System.out.println("\n\t ***연산 횟수 출력***\n\n");
		System.out.printf("덧 셈은 : %3d\n", count[0]);
		System.out.printf("뺄 셈은 : %3d\n", count[1]);
		System.out.printf("곱 셈은 : %3d\n", count[2]);
		System.out.printf("나눗셈은 : %3d\n", count[3]);
		System.out.printf("x ^ y : %3d\n", count[4]);
		System.out.printf("2 ^ y : %3d\n", count[5]);
		
	}
	
}


public class _04_Calculator {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		System.out.println("두 수의 합 = " + cal.getSume(3.4, 2.2));
		System.out.println("두 수의 합 = " + cal.getDiv(3.4, 2.2));
		System.out.println("두 수의 합 = " + cal.getSume(3.4, 2.2));
		System.out.println("두 수의 합 = " + cal.getSub(3.4, 2.2));
		System.out.println("두 수의 합 = " + cal.getPowerOfTwo(3));
		cal.showOpCount();
	}

}

2. 평문 회문(boolean)

import java.util.Scanner;

public class _12_palindrome {

	public static boolean isPalindrome(String str) {
		int len = str.length();// 문자열의 길이 구하기

		for (int i = 0; i < len / 2; i++) {// 비교 횟수는 문자열의 반만큼 나누면 판별 가능
			//if (str[i] != str[len - 1 - i]) {// 0-5, 1-4, 2-3 //문자가 같지 않다면 평문
			if(str.charAt(i) != str.charAt(len -1 - i)){//문자가 같지 않다면 평문
				return false;//호출한 곳으로 돌아간다.(함수의 종료)
			}
		}
		return true;//모든 글자가 같다면? 회문
}
	
	public static void main(String[] args) {
		String str;
		Scanner in = new Scanner(System.in);
		System.out.print("문자열을 입력 : ");
		str = in.nextLine();
		in.close();
		
		if(isPalindrome(str)){//회문이면 trye, 평문이면 false리턴
			System.out.println("회문입니다.");
		}else {
			System.out.println("평문입니다.");
		}
	
	}

}

