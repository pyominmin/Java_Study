private에 대해서

class Missile {
	
	public Missile() {
		//생성자 : 아무 명령도 수행하지 않는다.
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

1. 
