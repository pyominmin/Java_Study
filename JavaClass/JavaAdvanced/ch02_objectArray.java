

//object 클래스 : 모든 클래스의 부모가되는 클래스 => 최상위 클래스
class Parent{//extends object
	public Parent(int a, double d) {//Parent(Parent this, int a, double d)
		this.a = a;
		this.d = d;
	}
	public int getA() {//int getA(Point this)
		return this.a;
	}
	public double getD() {
		return this.d;
	}
	
	@Override//object의 메서드 재정의
	public String toString() {
		return a + ", " + d;//문자열로 만들어서 리턴
	}
	
	
	//instance variable
	private int a;
	private double d;
}
//-------------------------------------------------------------//child1
class Child1 extends Parent{
	public Child1(char c) {
		super(10, 10.1);
		this.c = c;
	}
	public char getChar() {
		return this.c;
	}
	
	@Override
	public String toString() {
		//this : 자신의 멤버를 접근하기 위한 참조 변수(주소)
		//super : 부모의 멤버를 접근하기 위한 참조 변수(주소)
		return super.toString() + ", " + c;//문자열을 만들어서 리턴//이름이 중복될 떄는 super를 사용해 부모의 문자열 호출
	}
	
	private char c;
}
//-------------------------------------------------------------//child1
class Child2 extends Parent{
	public Child2(int n, double num, String str){
		super(n, num);//부모생성자 호출 => 전달받은 값을 넘김
		this.str = str;
	}
	public String getString() {
		return this.str;
	}
	@Override
	public String toString() {
		return super.toString() + ", " + str;
	}
	private String str;
}




//-------------------------------------------------------------//main

public class _01_ObjectArray {

	public static void main(String[] args) {
//		Parent p1 = null
		//p1 = new Child1('Q');
//		System.out.println("p1 = " + p1.toString());
//		
//		Parent p2 = null 
		//p2 = new Child2(99, 0999.2, "Happy new year");
//		System.out.println("p2 = " + p2.toString());
		
		//참조형 변수가 여러개 필요한 경우 선언 => 인스턴스 생성되는 것이 아니다.
		Parent[] p = new Parent[100];//참조형 변수 2개 생성 > null로 초기화
		
		p[0] = new Child1('Q');//인스턴스 생성
		System.out.println("p1 = " + p[0].toString());
		p[1] = new Child2(99, 0999.2, "Happy new year");//인스턴스 생성
		System.out.println("p2 = " + p[1].toString());
		
		
	}

}
