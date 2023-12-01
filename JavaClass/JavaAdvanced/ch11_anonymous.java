Anonymous(익명 클래스)

  //
////추상클래스 : 추상 메서드를 한 개 이상 포함한 클래스
//abstract class Vehicle{
//	abstract void start(); //추상메서드 : 정의부가 없이 선언부만 존재하는 메서드
//	
//	void stop() {
//		System.out.println("Vehicle stop!");
//	}
//}
//
//class Bus extends Vehicle{
//
//	@Override
//	void start() {
//		System.out.println("Bus start!");
//	}
//	
//}
//
//public class _01_Anonymous {
//
//	public static void main(String[] args) {
//		//부모의 참조형 변수로 자식 인스턴스의 주소를 저장할 수 있다.
//		Vehicle v = new Bus();
//		
//		v.start();
//		v.stop();
//
//	}
//
//}

package chap34_anonymous;

//추상클래스 : 추상 메서드를 한 개 이상 포함한 클래스
abstract class Vehicle{
	abstract void start(); //추상메서드 : 정의부가 없이 선언부만 존재하는 메서드
	
	void stop() {
		System.out.println("Vehicle stop!");
	}
}

//class Bus extends Vehicle{
//
//	@Override
//	void start() {
//		System.out.println("Bus start!");
//	}
//	
//}

public class _01_Anonymous {

	public static void main(String[] args) {
		//익명 클래스 생성 : Vehicle 상속받는 클래스를 생성
		Vehicle v = new Vehicle() {
			@Override
			void start() {
				System.out.println("Bus start!");
			}
		};
		
		v.start();
		v.stop();

	}

}

2. 익명 클래스
  
//인터페이스 : 추상메서드로만 이뤄진 클래스
interface Task{
	/*public abstract*/ void execute();
}

//class Test implements Task{
//
//	@Override
//	public void execute() {
//		System.out.println("Execute Task");
//		
//	}
//	
// }

public class _02_Anonymous {

	public static void main(String[] args) {
		Task t = new Task() {
			@Override
			public void execute() {
				System.out.println("Execute Task");
			}

		};
		t.execute();

	}
}

3. 익명클래스
