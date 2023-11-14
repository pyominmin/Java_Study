
/*
 * 인터페이스(interface)
 * 1. 추상 클래스의 일종으로 추상 클래스보다 추상화 정도가 높다.
 * 2. 추상메서드만 가능하다. 일반 메서드는 선언 불가 => public abstract
 * 3. 상수만 선언 가능하다. 변수는 불가 => public static final
 */

//abstract class Shape{//추상클래스
interface Shape{
	//public abstract double getArea();//추상 메서드
	double getArea();//추상 메서드// public abstract 생략 가능하다.
}

class Circle implements Shape{//인터페이스 상속
	private double mRadius;

	Circle(double radius){
		mRadius = radius;
	}
	@Override
	public double getArea() {
		return Math.PI * mRadius * mRadius;
	}
	
}

//class Rectangle extends Shape{//상속
class Rectangle implements Shape{//인터페이스 상속
	private double mWidth;
	private double mHeight;
	
	Rectangle(double width, double height){
		mWidth = width;
		mHeight = height;
	}
	@Override //접근 제어가 더 작게 오버라이딩 할 수 없다.(예를들어,public 멤버를 private멤버로 오버라이딩 불가)
	public double getArea() {
		return mWidth * mHeight;
	}
}

public class _01_Interface {

	public static void main(String[] args) {
//		Circle cir = new Circle(5.2);
//		System.out.println("원의 넓이는 " + cir.getArea() + "입니다.");
		
//		Rectangle rec = new Rectangle(4, 2.56);
//		System.out.println("사각형의 넓이는 " + rec.getArea() + "입니다.");
		
		Shape sh = null;//부모 타입의 참조형 변수
		sh = new Circle(5.2);// 부모 타입의 참조형 변수로 자식 인스턴스의 주소를 저장할 수 있다.
		System.out.println("원의 넓이는 " + sh.getArea() + "입니다.");
		
		sh = new Rectangle(4, 2.56);
		System.out.println("사각형의 넓이는 " + sh.getArea() + "입니다.");
		
		
	}

}

1. 인터페이스(interface) 연습문제

//abstract class Shape{//추상클래스
interface Shape{
	//public abstract double getArea();//추상 메서드
	double getArea();//추상 메서드// public abstract 생략 가능하다.
}

interface Resizeable{
	//public abstract void reSize(double factor);//생략 가능
	void reSize(double factor);
}

class Circle implements Shape, Resizeable{//여러개의 인터페이스를 구현할 수 있다.(상속은 다중 상속이 불가)
	private double mRadius;

	Circle(double radius){
		mRadius = radius;
	}
	@Override
	public double getArea() {
		return Math.PI * mRadius * mRadius;
	}
	@Override
	public void reSize(double factor) {
		mRadius = mRadius * factor;
	}
	
}

class Rectangle implements Shape, Resizeable{//인터페이스 상속
	private double mWidth;
	private double mHeight;
	
	Rectangle(double width, double height){
		mWidth = width;
		mHeight = height;
	}
	@Override //접근 제어가 더 작게 오버라이딩 할 수 없다.(예를들어,public 멤버를 private멤버로 오버라이딩 불가)
	public double getArea() {
		return mWidth * mHeight;
	}
	@Override
	public void reSize(double factor) {
		mWidth = mWidth * factor;
		mHeight = mHeight * factor;
	}
	
}



public class _02_Interface {

	public static void main(String[] args) {
		Circle cir = new Circle(5.2);
		System.out.println("원의 넓이는 " + cir.getArea() + "입니다.");
		
		cir.reSize(2);
		System.out.println("원의 넓이는(크기 조절 후) " + cir.getArea() + "입니다.");
		
		Rectangle rec = new Rectangle(4, 2.56);
		System.out.println("사각형의 넓이는 " + rec.getArea() + "입니다.");
		rec.reSize(2);
		System.out.println("사각형의 넓이는(크기 조절 후) " + rec.getArea() + "입니다.");

	}

}
2. 인터페이스(interface) 연습문제
