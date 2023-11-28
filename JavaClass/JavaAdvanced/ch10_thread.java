
//프로그램(program) : 명령어의 집합
//프로세스(process) : 실행중인 프로그램 => 메모리할당 받는다.
					//자원 + 스레드(한 개 이상)
//멀티프로세싱(Multi processing)
//멀티태스킹(Multi tasking) : 마치 모든 프로그램이 동시에 실행되는 것처럼 사용할 수 있다.
//스레드(Thread) : 프로세스내에서 동시에 여러 작업을 수행할 수 있다.
				//할당받은 자원을 이용해서 실제 작업을 수행한다.
//다중스레드(Multi Thread) : 스레드가 2개 이상 존재하는 경우를 말하며 프로그램의 성능을 향상시킬 수 있다.


class MyThread extends Thread{
	//Thread 클래스의 run 메소드 Override
	//스레드가 실행됐을 때 수행되는 작업을 run메서드에 정의한다.
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(getName() + "value = " + i);//getName - 스레드 이름 : [Thread - 번호]
		}
	}
}
public class _01_MyThread {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		t1.start();//스레드 생성 => start 메서드내에서 run 메서드 호출
		t2.start();
	}

}


1. runnable

class MyRunnable implements Runnable {// Runnable 구현
	public void run() {
		for(int i = 0; i < 5; i++) {
			// Thread.currentThread() => 현재 실행중인 스레드의 주소를 리턴
								//클래스명.static메서드 => Thread의 멤버를 가져다 쓰고 싶은 경우 
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);//실습을 위해 1초씩 느리게 만든다.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class _02_MyRunnable {

	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable();
		Thread t1 = new Thread(r1);

		MyRunnable r2 = new MyRunnable();
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}

}

2.SingleThread

public class _03_SingleThread {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 1000; i++) {
			System.out.print("-");
		}
		System.out.println();
		long endTime = System.currentTimeMillis();
		
		System.out.println("실행시간 : " + (endTime - startTime));
		
		for(int i = 0; i < 1000; i++) {
			System.out.print("|");
		}
		System.out.println();
		
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime));
	}

}

3. MultiThread

class MultiThread extends Thread{
	@Override
	public void run() {//실제 수행 작업
		for(int i = 0; i < 1000; i++) {
			System.out.print("|");
		}
		System.out.println();
		
		System.out.println("실행시간 : " + (System.currentTimeMillis() - _04_MultiThread.startTime));
	}
}

public class _04_MultiThread {
	
	//정적변수 : 인스턴스 생성 없이 클래스명으로 접근 가능
	static long startTime;
	
	public static void main(String[] args) {
		startTime = System.currentTimeMillis();
		
		MultiThread m1 = new MultiThread();
		m1.start(); //스레드 생성 => start메서드 내에서 run메서드 호출
		
		for(int i = 0; i < 1000; i++) {
			System.out.print("-");
		}
		System.out.println();
		long endTime = System.currentTimeMillis();
		
		System.out.println("실행시간 : " + (endTime - startTime));
		
	}

}

4. MultiThread

class PrintCharThread extends Thread{
	PrintCharThread(char _ch, int _count){
		ch = _ch;
		count = _count;
	}
	@Override
	public void run() {
		//스레드가 처리 할 명령
		for(int i = 0; i < count; i++) {
			System.out.print(ch);
		}
		System.out.println("\nRun Time" + (System.currentTimeMillis() - _05_MultiThread.startTime));
	}
	
	private char ch;
	private int count;
}

public class _05_MultiThread {

	static long startTime;//정적멤버
	
	public static void main(String[] args) {
		startTime = System.currentTimeMillis();
		PrintCharThread t1 = new PrintCharThread('*', 800);
		PrintCharThread t2 = new PrintCharThread('@', 800);

		t1.start();
		t2.start();
	}

}

5. MultiThread

import javax.swing.JOptionPane;

class PrintCharThread_02 extends Thread{
	PrintCharThread_02(char _ch, int _count){
		ch = _ch;
		count = _count;
	}
	@Override
	public void run() {
		//스레드가 처리 할 명령
		for(int i = 0; i < count; i++) {
			System.out.print(ch);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	private char ch;
	private int count;
}

public class _06_MultiThread {

	public static void main(String[] args) {
		PrintCharThread_02 th = new PrintCharThread_02('#', 30);
		th.start();
		
		String input = JOptionPane.showInputDialog("스레드는 뭔가요?");//다이얼로그 박스 생성
		System.out.println("입력 받은 내용은 " + input + "입니다.");
	}

}

6. MultiThread

import javax.swing.JOptionPane;

class MultiThread_03 extends Thread{
	private String threadData;
	
	public MultiThread_03(String data) {
		threadData = data;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(threadData + "count = " + i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}

public class _07_MultiThread {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("스레드로 전달 할 데이터를 입력 하세요.");
		System.out.println("입력 데이터: " + input);

		MultiThread_03 th = new MultiThread_03(input);
		th.start();//스레드 실행
		
		int score = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력하세요."));
		System.out.println("입력 점수: " + score);
	}

}

7. MultiThread
	
import javax.swing.JOptionPane;

class MultiThread_04 extends Thread{	
	public void run() {
		for(int i = 0; i <=100; i++) {
			System.out.println(i);
			try {
				sleep(1000);//100ms마다 출력
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class _08_MultiThread {

	public static void main(String[] args) {
		//스레드 시작		
		MultiThread_04 th = new MultiThread_04();
		th.start();

		//다이얼로그 상자에 입력 받아 출력
		String name = JOptionPane.showInputDialog("이름을 입력하세요.");
		System.out.println("이름 : " + name);
		
		int age =  Integer.parseInt(JOptionPane.showInputDialog("나이를 입력하세요."));
		System.out.println("나이 : " + age);
		
		String gender = JOptionPane.showInputDialog("성별을 입력하세요.");
		System.out.println("성별 : " + gender);

	}

}

8. MultiThread
	
import javax.swing.JOptionPane;

class OddNumberThread extends Thread {
	private int maxNumber;

	public OddNumberThread(int num) {
		maxNumber = num;
	}

	@Override
	public void run() {
		for (int i = 0; i <= maxNumber; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}
	}
	
}

public class _09_OddNumberThread {

	public static void main(String[] args) {
		
		//다이얼로그 상자 표시
		int maxNumber = Integer.parseInt(JOptionPane.showInputDialog("최대 숫자를 입력하세요: "));
		
		//스레드 시작
		OddNumberThread OddNumberThread = new OddNumberThread(maxNumber);
		OddNumberThread.start();//maxNumber보다 작거나 같은 수를 모두 출력
		
		//다이얼로그에서 입력 받은 정보 출력
		System.out.println("입력받은 수" + maxNumber);

	}

}
