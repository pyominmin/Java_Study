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

1. 연습문제

class Product{
	public Product(){
		count++;
		mNum = count + 1199;
	}
	
	public Product( String name , String where, int price) {
		this.mPrice = price;
		this.mName = name;
		this.mWhere = where;
		count++;
		mNum = count + 1199;;
	}

	public static int getCount() {
		return count;
	}
	
	
	//getter
	public int getNum() {
		return this.mNum;
	}
	
	public int getPrice() {
		return this.mPrice;
	}
	
	public String getName() {
		return this.mName;
	}
	
	public String getWhere() {
		return this.mWhere;
	}
	
	
	//setter
	public void setNum(int num) {
		this.mNum = num;
	}
	
	public void setName(String name) {
		this.mName = name;
	}
	
	public void setWhere(String where) {
		this.mWhere = where;
	}
	
	public String toString() {
		return mNum + ". " + mName +" " + mWhere + " " + mPrice + "원";
	}
	
	private int mNum = 0, mPrice = 0;
	private String mName = null, mWhere;
	private static int count = 0;
}


public class _06_StaticH1 {

	public static void main(String[] args) {
		Product p1 = new Product("새우깡", "농심(주)", 1900);
		Product p2 = new Product("빼뺴로", "롯데제과", 2200);
		Product p3 = new Product("먹태깡", "농심(주)", 2500);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		
		System.out.println("출고 상품 : " + Product.getCount() + "건");

	}

}

2.연습문제


import java.util.Scanner;

class DynamicIntArray{
	public DynamicIntArray() {
	}
	
	public DynamicIntArray(int size) {
		this.mSize = size;
		numbers = new int[size];
	}
	
	public DynamicIntArray(int begin, int end) {
		this.mBegin = begin;
		this.mEnd = end;
	}
	
	public void  randomize( int begin, int end) {
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * (begin - end +1)) + begin;
 		}
	}
	
	public void display() {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
	
	public int getSearchCount(int searchNum) {
		for(int i = 0; i < mSize; i++) {
			if(numbers[i] == searchNum) {
				Count++;
			}
		}
		return Count;
	}
	
	
	//getter
	public int getSize() {
		return this.mSize;
	}
	
	public int getBegin() {
		return this.getBegin();
	}
	
	public int getEnd() {
		return this.mEnd;
	}
	
	//setter
	
	public void setSize(int size) {
		this.mSize = size;
	}
	
	public void setBegin(int begin) {
		this.mBegin = begin;
	}
	
	public void setEnd(int end) {
		this.mEnd = end;
	}
	
	private int mSize = 0, mBegin = 0, mEnd = 0;
	private int[] numbers;
	private int Count = 0;
}

public class _06_StaticH2 {
	 public static void main(String[] args) {

	Scanner in = new Scanner(System.in);
	
	System.out.print("int형 메모리의 크기 입력 : ");
	int size = in.nextInt();
    
	DynamicIntArray d = new DynamicIntArray(size); //int형의 메모리를 size만큼 할당
    
	int begin, end;
	System.out.println("랜덤 시작 수 입력 : ");
	begin = in.nextInt();
	
	System.out.print("랜덤 끝 수 입력 : ");
	end = in.nextInt();
	
    d.randomize(begin, end); //할당 된 int형의 메모리에 begin ~ end 범위의 랜덤 수 저장
    d.display(); //배열에 저장 된 값 출력
    
    System.out.print("\n검색할 정수 입력 : ");
    int searchNum = in.nextInt();
    System.out.println("검색한 정수의 개수는 " + d.getSearchCount(searchNum) + "개 입니다.");        
    
    in.close();   
}
}
