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

2. getter

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
		if (hour >= 0 && hour <= 23) {
			mHour = hour;
		}
		if (minute >= 0 && minute <= 59) {
			mMinute = minute;
		}
		if (second >= 0 && second <= 59) {
			mSecond = second;
		}
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
	
	private int mHour = 0, mMinute = 0, mSecond = 0; //생성하면서 0으로 세팅
}


public class _02_Time {

	public static void main(String[] args) {
		Time t1 = new Time(13, 23, 57);//인스턴스 생성
		Time t2 = new Time(9, 18, 12);
		Time t3 = new Time();
		
		//t3.mHour = 23;//error : private 멤버는 클래스 외부에서 접근 불가능
		t3.setHour(23);//setter
		t3.setMinute(45);//setter
		
		//System.out.println(t1.mHour + "시" + t1.mMinute + "분" + t1.mSecond + "초" );//private 멤버여서 꺼내올 수 없다.
		System.out.println(t1.getHour() + "시" + t1.getMinute() + "분" + t1.getSecond() + "초" );
		System.out.println(t2.getHour() + "시" + t2.getMinute() + "분" + t2.getSecond() + "초" );
		System.out.println(t3.getHour() + "시" + t3.getMinute() + "분" + t3.getSecond() + "초" );
	}

}
