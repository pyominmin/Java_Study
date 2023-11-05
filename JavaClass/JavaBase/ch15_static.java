/*static
 * 
 * this : 메서드를 호출한 인스턴스를 참조하는 변수
 * 
 * this는 왜 있어?? 모든 인스턴스 메서드를 공유하기 때문이다.
 * 
 */


//점의 좌표를(x, y) 관리하는 클래스
class Point{
	public Point(){//public Point(Point this)
		++count;//좌표의 개수를 1씩 증가(좌표의 개수를 알기 위해)
	}
	
	public Point(int x, int y){//public Point(Point this, int x, int y)
		this.mX = x;
		this.mY = y;
		++count;//좌표의 개수를 1씩 증가
	}
	
	
	//getter
	public int getX() {//public int getX(Point this)
		return this.mX;
	}
	
	public int getY() {
		return this.mY;
	}
	
	public static int getCount() {
		//mX = 10; // error : 정적 멤버 메서드에서 instance variable의 접근 불가능
		//미리 할당된 메모리이기 때문에 새로 생성되는 변수는 사용할 수 없다.
		//정적멤버는 정적멤버끼리 호출할 수 있다.
   		//ex 이순신 장군은 우리에 대해 모른다.
		return count;
		
	}
	
	//setter
	public void setX(int x) {
		this.mX = x;
	}
	
	public void setY(int y) {
		this.mY = y;
	}
	
	public String toString() {
		return"(" + this.mX + "," + this.mY + ")";//출력 구문을 문자열로 만들어서 리턴
	}
	
	private int mX = 0, mY = 0;
	//static은 main함수가 실행되기 전에 딱 한번 메모리에 잡힌다.// 인스턴스 생성 시 할당되는 메모리가 아니다.(인스턴스와 상관없다)
	//마치 모든 인스턴스가 공유하는 것 처럼 사용할 수 있다.
	private static int count = 0;//정적멤버 변수(static 변수)//메인이 실행되기 전에 한번만 잡힌다.
	
}

public class _05_this_static {

	public static void main(String[] args) {
		
		// static이 붙은 메서드는 클래스 명으로 메서드를 호출할 수 있다.
		//왜냐하면 인스턴스가 생성되지 않아도 메모리가 할당되었기 때문이다.
		//일반적으로는 클래스의 이름으로 호출한다.
		System.out.println("생성된 좌표의 개수는 " + Point.getCount() + "입니다.");
		
		Point p1 = new Point();//인스턴스 생성 시 생성자 호출
		Point p2 = new Point(2, 3);//인스턴스 생성 시 생성자 호출
		Point p3 = new Point(10, 20);
		Point p4 = new Point(100, 200);
		Point p5 = new Point(-10, -20);
		
		
		System.out.println("p1" + p1.toString());
		System.out.println("p1" + p2.toString());
		System.out.println("p1" + p3.toString());
		System.out.println("생성된 좌표의 개수는 " + p1.getCount() + "개 입니다.");
	}

}
