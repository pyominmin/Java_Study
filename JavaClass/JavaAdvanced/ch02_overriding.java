abstract class
 여러 클래스를 나누어 추상 메서드를 만들어보자
  
1. 도형 출력
//abstract class : 추상 메서드를 한 개 이상 포함한 클래스를 말한다.
abstract public class Figure {
	public Figure(int height, char ch) {
		mHeight = height;
		mCh = ch;
		System.out.println("부모 Figure 생성자");
	}
	
	//abstract method(추상메서드)
	abstract public void draw();
//		System.out.println("자식 클래스에서 상속받아 오버라이드 해서 그려라!!");
//	}
	
	//getter
	public int getHeight() {
		return mHeight;
	}
	
	public char getCharacter() {
		return mCh;
	}
	//setter
	public void setHeight(int height) {
		mHeight = height;
	}
	
	public void setCharacter(char ch) {
		mCh = ch;
	}
	
	//instance variable : 초기화 하지 않을 시 기본값으로 초기화
	protected int mHeight;// = 0;
	protected char mCh;// = '\0';//널문자
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*출력
import java.util.Scanner;

public class FigureDraw {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Figure fi = null;//부모의 참조형 변수 선언
		
		
		
		while(true) {
			System.out.println("\n\n\t\t*** 도형 그리기 ***\n");
			System.out.println("1. 직각 삼각형   2. 피라미드   3. 사각형   4. 다이아몬드   0. 종료");
			System.out.print("도형 선택 : ");
			int choice = in.nextInt();
			in.nextLine();
			
			if(choice == 0) {
				in.close();
				return;//main함수 종료
			}
			
			System.out.print("높이 입력 : ");
			int height = in.nextInt();
			in.nextLine();//버퍼에 남아있던 엔터 가져오기
			System.out.print("출력 문자 입력 :");
			char ch = in.nextLine().charAt(0);
			
			switch(choice) {
			case 1:
				//부모의 참조변수는 자식 인스턴스의 주소를 저장할 수 있다.
				fi = new RightTriangle(height, ch);//직각 삼각형 인스턴스 생성
				break;
			case 2:
				fi = new Piramid(height, ch);
				break;
			case 3:
				fi = new Rectangle(height, ch);
				break;
			case 4:
				fi = new Diamond(height, ch);
				break;
			default:
			continue;//반복문의 끝으로 이동
			}
			fi.draw();//다양한 도형을 출력할 수 있다.
		}

		
		
	}

}
*피라미드

public class Piramid extends Figure{
	public Piramid(int he, char ch) {
		super(he, ch);// 부모 생성자 호출
		System.out.println("자식 Piramid 생성자");
		
	}
	@Override
	public void draw() {
		for(int i = 1; i <= mHeight; i++) {
			for(int j = 1; j <= mHeight - i; j++) {
				System.out.println(" ");
			}
			for(int k = 1; k <= (2 * i) - 1; k++) {
				System.out.print(mCh);
			}
			System.out.println("");
		}
		
	}
	
}
*사각형

public class Rectangle extends Figure {
	public Rectangle(int h, char c) {
		super(h, c);// 부모 생성자 호출
		System.out.println("자식 Rectangle 생성자");
		
	}

	@Override
	public void draw() {
		// 부모의 protected멤버는 자유롭게 접근 가능
		for (int i = 0; i < mHeight; i++) {
			for (int j = 0; j <= mHeight; j++) {
				System.out.print(mCh);
			}
			System.out.println();
		}
	}

}
*삼각형

public class RightTriangle extends Figure {
	public RightTriangle(int height, char c){
		super(height, c);
		System.out.println("자식 Rectangle 생성자");
	}
	@Override
	public void draw() {
		//부모의 protected멤버는 자유롭게 접근 가능
		for(int i = 0; i < mHeight; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(mCh);
			}
			System.out.println();
		}
	}
	
}
*다이아몬드

public class Diamond extends Figure {
	public Diamond(int hei, char cha) {
		super(hei, cha);
		System.out.println("자식 다이아몬드 생성자");
	}
	
	@Override
	public void draw() {
		for(int i = 1; i <= mHeight; i++) {
			for(int j = 1; j <= mHeight - i; j++) {
				System.out.println(" ");
			}
			for(int k = 1; k <= (2 * i) - 1; k++) {
				System.out.print(mCh);
			}
			System.out.println("");
		}
		for(int l = mHeight - 1; l > 0; l--) {
			for(int m = mHeight - l; m > 0; m--) {
				System.out.println(" ");
			}
			for(int n = 2 * l - 1; n > 0; n--) {
				System.out.print(mCh);
			}
			System.out.println("");
		}
	}
	
}

