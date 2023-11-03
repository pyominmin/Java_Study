*생성자가 어떻게 호출되는지?

public이 붙은 클래스는 단 하나여야 한다.
  

import java.util.Scanner;

class Dummy{
	//class명과 동일한 메서드는 생성자이다(constructor)
	//인스턴스 생성 시 내부적으로 호출되는 메서드(직접x)
	//instance variable의 초기화 담당
	//1. class명과 같다.
	//2. 리턴타입이 없다(오직 메서드명만 존재하는 메서드)
	//3. 생성자를 만들지 않아도 자동으로 생성자가 생긴다. 하지만 인스턴스(iv)를 초기화 해주기 위해 사용한다.
	//4. 생성자는 매개변수를 가질 수 있다.(오버로딩이 가능하다.)
	Dummy(){//매개변수가 없을 때는 1번 생성자 호출
		a = 0;
		b = 0;
		c = 0;
		System.out.println("1.생성자");
		
	}
	
	Dummy(int _a){//매개변수가 있을 때는 2번 생성자 호출
		a = _a;
		b = 0;
		c = 0;
		System.out.println("2.생성자");
		
	}
	
	Dummy(int _a, int _b){
		a = _a;
		b = _b;
		c = 0;
		System.out.println("3.생성자");
		
	}
	
	Dummy(int _a, int _b, int _c){
		a = _a;
		b = _b;
		c = _c;
		System.out.println("4.생성자");
		
	}
	public int a, b, c;
}

class DoSomething{
	DoSomething(){
	System.out.println("1. DoSomething 생성자");
	}
	
	DoSomething(char _a, char _b, int _c, int _d){
		System.out.println("2. DoSomething 생성자");
		}
	DoSomething(String _a, int _b){
		System.out.println("3. DoSomething 생성자");
		}
	DoSomething(int _a, int _b, String _c){
		System.out.println("4. DoSomething 생성자");
		}
	
	
	public int a, b, c, d;
}

class DoNothing{
	DoNothing(int n1, int n2, int n3, int n4, int n5){
			System.out.println("1. DoNothing 생성자");
		}
		
	public int a, b, c, d, e;
}

public class _01_Constructor {

	public static void main(String[] args) {
		Dummy d1 = new Dummy();//인스턴스(객체 = 클래스에서 나온 변수) 생성
		Dummy d2 = new Dummy(98);//인스턴스 생성 시 인수 전달
		Dummy d3 = new Dummy(1, 2);
		Dummy d4 = new Dummy(1, 2, 3);
		
		DoSomething s1 = new DoSomething();
		DoSomething s2 = new DoSomething('R', 'T', 5, 10);
		DoSomething s3 = new DoSomething("apple", 25);
		DoSomething s4 = new DoSomething(78, 25, "할아버지");
		
		DoNothing n1 = new DoNothing(3, 4, 5, 6, 7);
		
		
		Scanner in =new Scanner(System.in);
		//Scanner = 클래스 , in = 참조형 변수 , new Scanner = 인스턴스
		
		in.close();
	}

}

1. 생성자 연습

class StudentInfo{
	StudentInfo(String name, String phone, String stNo, String major){
		//instance method(클래스 내에서 선언된 메서드/함수) 관행상 위에
		//생성자의 목적 : instance variable의 초기화
		mName = name;
		mPhone = phone;
		mStNo = stNo;
		mMajor = major;
		System.out.println("생성자 호출 : instance variable의 초기화");
	}
	
	public void showStudentInfo() {
		System.out.println("학과 : " + mMajor);
		System.out.println("학법 : " + mName);
		System.out.println("이름 : " + mName);
		System.out.println("연락처 : " + mPhone);
		System.out.println();
	}
		//instance variable(클래스 안에서 선언된 변수) 관행상 아래에
	public String mName = null;//주소값 없음(널포인터)//가르키는 대상이 없다.
	public String mPhone = null;
	public String mStNo = null;
	public String mMajor = null;	
	}
	


public class _02_StudentInfo {

	public static void main(String[] args) {
		StudentInfo s1 = new StudentInfo("홍길동", "010-888-9999", "000288987", "컴퓨터과학과");
		StudentInfo s2 = new StudentInfo("장보고", "010-777-9999", "000188987", "실용음악과");
		StudentInfo s3 = new StudentInfo("이순신", "010-666-9999", "000388987", "간호학과");
		StudentInfo s4 = new StudentInfo("유관순", "010-555-9999", "000488987", "교육학과");
		StudentInfo s5 = new StudentInfo("고길동", "010-444-9999", "000588987", "통계학과");
		
		System.out.println("\n\n\t*** 학생 정보 출력 ***\n");
		
		s1.showStudentInfo();
		s2.showStudentInfo();
		s3.showStudentInfo();
		s4.showStudentInfo();
		s5.showStudentInfo();
	}

}

2. 생성자 연습

class StudentScore{
	 public StudentScore(String stNo, int data, int algo, int java){
		mStNo = stNo;
		mData = data;
		mAlgo = algo;
		mJava = java;
		mAver = (mData + mAlgo + mJava) / 3;
		StudentRank();//등급 계산 메서드 호출
	
	}
	
	
	public void StudentRank() {
		if(mAver >=90 && mAver <= 100) {
			mRank = 'A';
		}else if(mAver >=80) {
			mRank = 'B';
		}else if(mAver >= 70) {
			mRank = 'C';
		}else if(mAver >=60) {
			mRank = 'D';
		}else {
			mRank = 'F';
		}
		
	}
	
	public void showTitle() {
		System.out.printf("%-10s %8s %8s %8s %8s %5s\n", "학번", "자료구조", "알고리즘", "자바", "평균", "등급");
	}
	
	public void showStudentScore(){
		
		System.out.printf("%-10s %8d %8d %8d %15.2f %5c\n", mStNo, mData, mAlgo, mJava, mAver, mRank);
//		System.out.println("학번 : " + mStNo);
//		System.out.println("자료구조 점수 : " + mData);
//		System.out.println("알고리즘 점수 : " + mAlgo);
//		System.out.println("자바 점수 : " + mJava);
//		System.out.println("평균 : " + mAver);
//		System.out.println("등급 : " + mRank);
		System.out.println();
	}
	
	
	public String mStNo = null;
	public int mData = 0, mAlgo = 0, mJava = 0;
	public double mAver = 0;
	public char mRank = '\0';//널문자 \0
	
}


public class _03_StudentScore {

	public static void main(String[] args) {
		StudentScore s1 = new StudentScore("00288987", 80, 90, 70);
		StudentScore s2 = new StudentScore("00384887", 60, 40, 50);
		StudentScore s3 = new StudentScore("00484887", 60, 80, 70);
		
		s1.showTitle();
		s1.showStudentScore();
		s2.showStudentScore();
		s3.showStudentScore();
	}

}
3. 생성자 연습

import java.util.Scanner;

class RightTriangle{
	public RightTriangle() {
		base = 0;
		height = 0;
		System.out.println("1.생성자 호출");
	}


	public RightTriangle(double _base, double _height) {
		base = _base;
		height = _height;
		System.out.println("2.생성자 호출");
	}
	
	public double getArea() {
		double area = base * height / 2;
		return area;
	}
	
	public double getHypotenuse() {
		return Math.sqrt(base * base + height * height);
	}
	public double base, height;
}

public class _04_Triangle {

	public static void main(String[] args) {
		RightTriangle t1 = new RightTriangle();
		System.out.println("t1의 삼각형의 넓이는" + t1.getArea() + "입니다.");
		System.out.println("t1삼각형의 빗변의 길이는" + t1.getHypotenuse() + "입니다.");
		
		RightTriangle t2 = new RightTriangle(8, 13);
		System.out.println("t2의 삼각형의 넓이는" + t2.getArea() + "입니다.");
		System.out.println("t2삼각형의 빗변의 길이는" + t2.getHypotenuse() + "입니다.");
		
		double b, h;
		Scanner in = new Scanner(System.in);
		System.out.print("밑변 입력 : ");
		b = in.nextDouble();
		System.out.print("높이 입력 : ");
		h = in.nextDouble();
		in.close();
		
		RightTriangle t3 = new RightTriangle(b, h);//instance 생성
		System.out.println("t3의 삼각형의 넓이는" + t3.getArea() + "입니다.");
		System.out.println("t3삼각형의 빗변의 길이는" + t3.getHypotenuse() + "입니다.");
	}

}

4. 생성자 연습

import java.util.Scanner;

public class _05_DigitSum {
	
	public static int CalculateDigitSum(String numStr) {
		int total = 0;
		for(int i = 0; i < numStr.length(); i++) {
			//수 형태의 문자를 실제 수로 변환
			int digit = numStr.charAt(i) - 48;
			total = total + digit;//numStr[i];
		}
		return total;
	}

	public static void main(String[] args) {
		String str;
		Scanner in = new Scanner(System.in);
		do {
		System.out.print("정수 입력(최대 16자리) : ");
		str = in.nextLine();
		
		//matches
		}while(str.length() > 16 || str.matches(".*[A-Za-z].*"));
			
		//CalculateDigitSum메서드 : 문자열 자릿수의 합을 구해 리턴
		//int sum = CalculateDigitSum(str);
		//System.out.println("입력 받은 문자열의 합계 " + sum + "입니다.");
		System.out.println("입력 받은 문자열의 합계 " + CalculateDigitSum(str) + "입니다.");
		in.close();
	}

}
