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

public class _03_Anonymous {

	public static void main(String[] args) {
		//Runnable를 상속받는 클래스 : 익명클래스
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " : " + i);
				}
				
			}
			
		};
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();

	}

}


4. 익명클래스

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class _04_Anonymous {

	public static void main(String[] args) {
		JFrame frame = new JFrame("익명 클래스 테스트");
		JButton button = new JButton("Click me!");
		
		//ActionListener를 상속받는 클래스 : 익명클래스
		ActionListener ac = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼을 클릭했습니다.");
			}
			
		};
		
		button.addActionListener(ac);
		
		frame.setSize(300, 300);
		frame.getContentPane().add(button);
		frame.setVisible(true);
	}

}
