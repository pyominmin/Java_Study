1. 사각형 클래스
class Rectangle{
	//instance method : 멤버함수
	public Rectangle(){
		System.out.println("1. 부모 생성자");
	}
	
	public Rectangle(double width, double length){
		mWidth = width;
		mLength = length;
		System.out.println("2. 부모 생성자");
	}
	
	public Rectangle(Rectangle other){
		mWidth = other.mWidth;
		mLength = other.mLength;
		System.out.println("3. 부모 복사 생성자");
	}
	
	//gtter : instance variable 값을 리턴
	public double getWidth() {
		return mWidth;
	}
	public double getLength() {
		return mLength;
	}
	//setter : instance variable의 값을 변경
	public void setWidth(double width) {
		mWidth = width;
	}
	public void setLength(double length) {
		mLength = length; 
	}
	
	//instance variable : 멤버변수
	private double mWidth = 0, mLength = 0;//가로 세로
}

public class _01_Reference {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();//인스턴스 생성//1번 생성자 호출
		Rectangle r2 = new Rectangle(3.8, 9.2);//인스턴스 생성 시 인수 전달//2번 생성자 호출
		//Rectangle r3 = null;//널참조 : 참조하는 인스턴스가 없는 경우
		//Rectangle r3 = r2;//참조형 변수의 대입은 주소 대입//생성자가 호출되지 않는다.//인스턴스의 공유
		Rectangle r3 = new Rectangle(r2);//인스턴스 생성 시 인스턴스 전달, 각각의 메모리 소유//인스턴스는 new 다음에 작성해야 생성된다.//3번 생성자 호출// 각각의 인스턴스 소유
		
		System.out.println("주소값 : "+ System.identityHashCode(r1) +", r1 width : " + r1.getWidth() + ", length : " + r1.getLength());
		System.out.println("주소값 : "+ System.identityHashCode(r2) +", r2 width : " + r2.getWidth() + ", length : " + r2.getLength());
		System.out.println("주소값 : "+ System.identityHashCode(r3) +", r3 width : " + r3.getWidth() + ", length : " + r3.getLength());
	}

}

2. Polymorphism
//부모 클래스의 참조 변수로 자식 인스턴스를 참조할 수 있다.
//오버로딩 : 메서드의 이름은 같지만 매개변수의 타입이나 개수가 다르면 다른 매서드로 간주한다.
//오버라이딩 : 메서드의 원형이 완벽히 같은 메서드의 정의 부분을 재정의 한다. => 상속에서 사용 부모클래스의 대부분의 기능이 일치하는 경우 일치하지 않은 기능만 재정의 해서 사용할 수 있다.


class Rectangle{
	//instance method : 멤버함수
	public Rectangle(){
		System.out.println("1. 부모 생성자");
	}
	
	public Rectangle(double width, double length){
		mWidth = width;
		mLength = length;
		System.out.println("2. 부모 생성자");
	}
	
	public Rectangle(Rectangle other){
		mWidth = other.mWidth;
		mLength = other.mLength;
		System.out.println("3. 부모 복사 생성자");
	}
	
	//gtter : instance variable 값을 리턴
	public double getWidth() {
		return mWidth;
	}
	public double getLength() {
		return mLength;
	}
	//setter : instance variable의 값을 변경
	public void setWidth(double width) {
		mWidth = width;
	}
	public void setLength(double length) {
		mLength = length; 
	}
	
	//instance variable : 멤버변수
	private double mWidth = 0, mLength = 0;//가로 세로
}
//-------------------------------------------------------------------------//Box클래스
class Box extends Rectangle{//Rectangle 상속
	public Box(){
		//자식 클래스의 생성자에서는 부모 생성자를 호출한다.
		//super();//부모 생성자를 호출
		System.out.println("1. 자식 생성자");
	}
	public Box(double width, double length, double height){
		//자식 클래스의 생성자에서는 부모 생성자를 호출한다.
		//super();//명시적으로 호출하지 않을 시 내부적으로 호출되는 생성자 명령
		super(width, length);//부모 생성자를 호출
		mHeight = height;
		System.out.println("2. 자식 생성자");
	}
	
	public double getHeight() {
		return mHeight;
	}
	
	public void setHeight(double height) {
		mHeight = height;
	}
	
	public Box(Box ref){
		super(ref);
		mHeight = ref.mHeight;
		System.out.println("3. 자식 복사 생성자");
	}
	
	private double mHeight = 0;
}


//-------------------------------------------------------------------------//main
public class _02_Polymorphism {

	public static void main(String[] args) {
		Box b1 = new Box();//인스턴스 생성 -> 생성자 호출
		Box b2 = new Box(3, 4, 5);//인스턴스 생성
		Box b3 = new Box(b2); 
		Box b4 = null;
		b4 = b3;
		
		Rectangle r1 = null;
		r1 = b3;//자식 참조형 변수는 부모에 대입 가능
		//부모의 멤버에만 접근 가능(자식 고유의 멤버에는 접근 불가능)
		
		System.out.println("주소값 : "+ System.identityHashCode(b2) +", r1 width : " + b2.getWidth() + ", length : " + b2.getLength() + ", height" + b2.getHeight());
	}

}

3. overriding
