1. 접근 제어자
/*
접근 제어자(Access Modifier)
public : 어디서든 접근 가능
private : 자신의 클래스내에서만 접근 가능
default : (접근 제어자를 명시하지 않을 시/생략하면 default) : 자신의 클래스 + 같은 패키지

*/
class Missile {
	
	public Missile() {
		//생성자 : 아무 명령도 수행하지 않는다. => 디폴트 생성자
		//이 경우 생성자를 정의하지 않아도 된다.
		//컴파일러가 내부적으로 생성하기 때문이다.
		
	}
	public void cheakPw(String inputPw) {
		// if(password == inputPw)//String 클래스는 == 연산자로 문자열 비교 불가
		if (password.equals(inputPw)) {//equals 메서드를 이용해서 문자열 비교
			fire();
		} else {
			error();
		}
	}
	//private 접근 제어 : 클래스 내에서만 접근 가능
	private void fire() {
		System.out.println("Fire");
	}

	private void error() {
		System.out.println("Fail");
	}

	private String password = "0000";
}

public class _01_AccessModifier {
	
	public static void main(String[] args) {
		Missile m1 = new Missile();
		m1.cheakPw("0000");
		//m1.fire(); //error : private 멤버는 클래스 외부에서 접근 불가능
	}

}

2. getter, setter, toString

//시간 클래스
class Time{
	public Time(){//이 생성자를 만들면 //Time t3 = new Time();를 생성했을 때 기본값으로 나온다.
		//기본값 생성자
		mHour = 0;
		mMinute = 0;
		mSecond = 0;
		System.out.println("1번 생성자");
	}
	
	public Time(int hour, int minute, int second) {
//		if (hour >= 0 && hour <= 23) {
//			mHour = hour;
//		}
		setHour(hour);//메서드 호출
		
//		if (minute >= 0 && minute <= 59) {
//			mMinute = minute;
//		}
		
		setMinute(minute);//메서드 호출
		
//		if (second >= 0 && second <= 59) {
//			mSecond = second;
//		}
		
		setSecond(second);//메서드 호출
		
		System.out.println("2번 생성자");
	}
	//getter : instance variable의 값을 리턴(private를 접근하는 변수)
	public int getHour() {
		return mHour;
	}
	
	public int getMinute() {
		return mMinute;
	}
	
	public int getSecond() {
		return mSecond;
	}
	
	//setter : instance variable의 값을 설정
	public void setHour(int hour) {//아무 값을 집어넣지 못하게 유효성 체크 필요
		if(hour >= 0 && hour <= 23) {//유효성 체크
		mHour = hour;
		}
	}
	public void setMinute(int minute) {//아무 값을 집어넣지 못하게 유효성 체크 필요
		if(minute >= 0 && minute <= 59) {//유효성 체크
			mMinute = minute;
		}
	}
	public void setSecond(int second) {//아무 값을 집어넣지 못하게 유효성 체크 필요
		if(second >= 0 && second <= 59) {//유효성 체크
			mSecond = second;
		}
	}
	
	public String toString() {
		return mHour + ":" + mMinute + ":" + mSecond;
	}
	
	public void increaseSecond(int increase) {
		mSecond += increase;
		
		mMinute = mMinute + mSecond / 60;//분을 증가
		mSecond = mSecond % 60;//나머지를 초로
		
		mHour = mHour + mMinute / 60;//시간을 증가
		mMinute = mMinute % 60;//나머지만 분이된다
		
		mHour = mHour % 24;//24시간제
	}
	
	private int mHour = 0, mMinute = 0, mSecond = 0; //생성하면서 0으로 세팅
}


public class _02_Time {

	public static void main(String[] args) {
		Time t1 = new Time(14, 23, 57);//인스턴스 생성
		Time t2 = new Time(9, 18, 12);
		Time t3 = new Time();
		
		System.out.println("t1 = " + t1.toString());
		System.out.println("t2 = " + t1.toString());
		System.out.println("t3 = " + t1.toString());
		
		//t3.mHour = 23;//error : private 멤버는 클래스 외부에서 접근 불가능
		t3.setHour(23);//setter
		t3.setMinute(45);//setter
		
		//System.out.println(t1.mHour + "시" + t1.mMinute + "분" + t1.mSecond + "초" );//private 멤버여서 꺼내올 수 없다.
		System.out.println(t1.getHour() + "시" + t1.getMinute() + "분" + t1.getSecond() + "초" );
		System.out.println(t2.getHour() + "시" + t2.getMinute() + "분" + t2.getSecond() + "초" );
		System.out.println(t3.getHour() + "시" + t3.getMinute() + "분" + t3.getSecond() + "초" );
		
		System.out.println("t1 = " + t1.toString());
		t1.increaseSecond(3611);
		System.out.println("t1 + 3600초 = " + t1.toString());
	}

}
2-1 getter, setter, toString

class Alpha{
	public Alpha(int count) {
		mLetter = new char[count];//생성자 : 전달받은 크기로 char형의 배열 생성
		mLetterSize = count;
		System.out.println("생성자 : 전달받은 크기로 char형의 배열 생성");
	}
	
	public void randomize(int num) {
		int begin = 0;
		if(num == 1) {
			begin = 65;
		}else if(num == -1) {
			begin = 97;
		}else {
			return;//함수 종료//값을 안쓰면 void
		}
		
		for(int i = 0; i < mLetterSize; i++) {
			int n = ((int)(Math.random() * 26) + begin);
				mLetter[i] = (char)n;//유니코드에 해당하는 문자로 저장
			}
		
		
//		if(num == 1) {
//			for(int i = 0; i < mLetterSize; i++) {
//			int n = ((int)(Math.random() * 26) + 65);
//				mLetter[i] = (char)n;//유니코드에 해당하는 문자로 저장
//			}
//		}else if(num == -1){
//			for(int i = 0; i < mLetterSize; i++) {
//			int n = ((int)(Math.random() * 26) + 97);
//			mLetter[i] = (char)n;
//			}
//		}else {
//			
//		}
		
	}
	
	public void display() {//display :배열에 저장된 모든 값을 출력 
		System.out.println("***랜덤하게 저장된 문자 출력***");
		for(int i = 0; i < mLetterSize; i++) {
			System.out.print(mLetter[i] + " ");
		}
		System.out.println();
	}
	
	public int getSize() {
		return mLetterSize;
	}
	
	private char[] mLetter = null;
	private int mLetterSize = 0;
}

public class _04_AlphaCount {

	public static void main(String[] args) {
		Alpha al = new Alpha(5);//인스턴스 생성 시 개수 전달
		al.randomize(1);
		al.display();
		System.out.println("배열의 크기는 " + al.getSize() + "입니다.");

	}

}
2-2 getter, setter, toString

class Date{

	public boolean isLeapYear(int year) {
		//4년마다 한번씩 돌아오는 해, 100년마다 돌아오는 해는 평년
		if(year % 4 == 0 && year % 100 != 0) {
			return true;
		}else if(year % 400 == 0) {//400년마다 돌아오는 해는 다시 윤년
			return true;	
		}else {
			return false;
		}
	}
	
	public int getCurrentDays(int month) {
		int[] month12 = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//배열은 0부터 시작하므로 0번방을 더미로 채워 널는다 보통 0을 줌
		if(isLeapYear(mYear)){//윤년이면?
			month12[2] = 29;
		}else {
			month12[2] = 28;
		}
		return month12[month];
	}
	
	public Date(){//기본 생성자를 꼭 만들어야 아무 값을 안넣었을 때 기본값을 넣어준다.
//		mYear = 1900;
//		mMonth = 1;
//		mDay = 1;
	
	}
	
	public String toString() {
		return mYear + "/" + mMonth + "/" + mDay;//문자열을 만들어서 리턴(대표 출력 구문)
	}
	
	public Date(int year, int month, int day){
		if(year >= 1) {
		mYear = year;
		}
		if(month >= 1 && month <= 12) {
		mMonth = month;
		}
		if(day >= 1 && day <= getCurrentDays(mMonth)) {//최대 일수는 월에 따라 달라져야 한다.
		mDay = day;
		}
		
		}
	public int getYear() {
		return mYear;
	}
	public int getMonth() {
		return mMonth;
	}
	public int getDay() {
		return mDay;
	}
		
		public void setYear(int year) {
			if(year >= 1) {
				mYear = year;
			}
		}
		
		public void setMonth(int month) {
			if(month >= 1 && month <= 12) {
				mMonth = month;
			}
		}
		
		public void setDay(int day) {
			if(day >= 1 && day <= getCurrentDays(mMonth)) {
				mDay = day;
			}
			
		}
		
		
//		public void increase100days() {//100일 계산 메서드
//			mDay += 99;//오늘부터 1일
//			
//			while(mDay - getCurrentDays(mMonth) > 0) {//최대 일수를 뺄 수 있어?
//				mDay = mDay - getCurrentDays(mMonth);
//				mMonth++;
//				
//				if(mMonth == 13) {
//					mMonth = 1;//1월로 변경
//					mYear ++;
//				}
//			}
//		}
		
		public void increaseDays(int increaseDays) {
			mDay += (increaseDays - 1);//오늘부터 1일
			
			while(mDay - getCurrentDays(mMonth) > 0) {//최대 일수를 뺄 수 있어?
				mDay = mDay - getCurrentDays(mMonth);
				mMonth++;
				
				if(mMonth == 13) {
					mMonth = 1;//1월로 변경
					mYear ++;
				}
			}
		}
	
	private int mYear = 1900, mMonth = 1, mDay = 1;
}

public class _03_Date {

	public static void main(String[] args) {
		Date d1 = new Date(2000, 2, 30);
		Date d2 = new Date(2004, 12, 27);
		
		d1.setDay(29);//d1의 일을 29일로 변경
		
		System.out.println("d1 = " + d1.getYear() + "/" + d1.getMonth() + "/" + d1.getDay());
		System.out.println("d2 = " + d2.getYear() + "/" + d2.getMonth() + "/" + d2.getDay());
		System.out.println("d1 = " + d1.toString());
		
		Date d3 = new Date(2023, 11, 2);
		System.out.println("오늘의 날짜는 " + d3.toString() + "입니다.");
		//d3.increase100days();
		d3.increaseDays(100); 
		System.out.println("오늘 만난 사람과 100일은 " + d3.toString()+ "입니다.");
		
		Date d4 = new Date(2023, 11, 2);
		d4.increaseDays(1000); 
		System.out.println("오늘 만난 사람과 1000일은 " + d4.toString()+ "입니다.");
	}

}
