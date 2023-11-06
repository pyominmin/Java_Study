주소 복사
1.
class Point{
	public Point() {
		System.out.println("1. 생성자");
	}
	
	public Point(int x, int y) {
		mX = x;
		mY = y;
		System.out.println("2. 생성자");
	}
	public Point(Point ref) {
		mX = ref.mX;
		mY = ref.mY;
		System.out.println("3. 복사 생성자" + System.identityHashCode(ref));
	}
	
	
	public int getX() {
		return mX;
	}
	public int getY() {
		return mY;
	}
	public void setX(int x) {
		mX = x;
	}
	public void setY(int y) {
		mY = y;
	}
	public String toString() {
		return "(" + mX + ", " + mY + ")";
	}
	
	
	//instance variable은 초기화 하지 않을 시 기본값으로 초기화된다.
	private int mX = 0, mY = 0;
}

public class _01_CopyConstructor {

	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point(2, 3);
		//Point p3 = p2;//주소를 대입 //인스턴스 메모리를 공유// 주소를 복사
		Point p3 = new Point(p1);//복사 생성자// 인스턴스를 생성해서 복사//인스턴스를 독립적으로 소유

		p2.setX(100);
		System.out.println("p1" + p1.toString() + System.identityHashCode(p1));
		System.out.println("p2" + p2.toString() + System.identityHashCode(p2));
		System.out.println("p3" + p3.toString() + System.identityHashCode(p3));
	}

}

2.

public class _02_String {

	public static void main(String[] args) {
		int a = 3 + 5;//정수
		char c = 'A' + 32;//문자열 상수 + 정수 literal 상수
		double d = 3.14;
		String s1 = "Hello";//문자열 상수(literal 문자열 상수)
		String s2 = "Hello";
		
		System.out.println("s1의 주소 : " + System.identityHashCode(s1));
		System.out.println("s2의 주소 : " + System.identityHashCode(s2));
		
		//if(s1 == s2) {//주소가 같은가?
		if(s1.equals(s2)) {//올바른 방법
			System.out.println("두 문자열은 같습니다.");
		}else {
			System.out.println("두 문자열은 다릅니다.");
		}
		
		String s3 = new String("apple");//인스턴스의 주소를 가짐// 주소가 다름
		String s4 = new String("apple");
		
		System.out.println("s3의 주소 : " + System.identityHashCode(s3));
		System.out.println("s4의 주소 : " + System.identityHashCode(s4));
		
		//if(s3 == s4) {//주소가 같은가?
		if(s3.equals(s4)) {//두 문자열이 같으면 true, 다르면 false
			System.out.println("두 문자열은 같습니다.");
		}else {
			System.out.println("두 문자열은 다릅니다.");
		}
		
	}

}
