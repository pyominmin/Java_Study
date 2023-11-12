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
	
