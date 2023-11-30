1. 프로세스 (Process):

프로세스란 실행 중인 프로그램의 인스턴스다. 프로그램을 실행하면 OS로부터 자원(메모리)을 할당 받아 프로세스가 된다. 각각의 프로세스는 독립적으로 실행되며, 각자의 메모리 공간을 가지고 있다. 프로세스는 자원과 스레드(Thread)로 구성 되는데 이때 스레드는 프로세스의 자원을 이용해서 실제 작업을 수행하는 역할을 한다. 따라서 모든 프로세스는 반드시 한 개 이상의 스레드를 갖고 있다. 

​

2. 멀티 프로세스 (Multiprocessing):

멀티 프로세싱은 여러 개의 프로세스가 동시에 실행되는 것을 의미한다. 각 프로세스는 독립적으로 실행되기 때문에 여러 작업을 병렬로 처리할 수 있다.

​

3. 멀티태스킹 (Multitasking):

멀티태스킹은 단일 시스템에서 여러 작업이 동시에 실행되는 것을 의미한다. 시분할 시스템에서 여러 작업들이 번갈아가면서 실행되는 것을 말한다. 예를 들면, 사용자가 웹 셔핑을 하면서 음악 듣고, 이메일 확인 할 수 있다.

​

4. 스레드 (Thread):

스레드는 프로세스 내에서 실행되는 작은 실행 단위를 말한다. 하나의 프로세스 내에서 여러 개의 스레드가 동시에 실행될 수 있다. 예를 들면, 워드 프로세서 작업 시 문서의 철자 검사를 하면서 이미지나 표, 텍스트를 편집할 수 있다. 

​

5. 멀티스레딩 (Multithreading):

멀티스레딩은 하나의 프로세스 내에서 여러 스레드가 동시에 실행되는 것을 말한다. 스레드 간에는 메모리를 공유하므로 데이터 공유와 통신이 더 쉽다. 예를 들면, 웹 브라우저에서 페이지를 로드하는 동안, 별도의 스레드에서 이미지를 미리 다운로드하여 화면에 표시하는 것. 이로써 사용자는 페이지를 볼 때 이미지가 더 빨리 표시될 수 있다.

​

6. 멀티프로그래밍 (Multiprogramming):

멀티프로그래밍은 메모리에 여러 개의 프로그램이 동시에 적재되어, CPU가 어떤 프로그램을 실행할지를 결정하는 시스템이다. 이는 CPU의 사용 효율을 높이는 데 도움이 된다.

​


스레드는 아래와 같은 예를 들어 설명할 수 있다.

​

1. 일꾼 (Worker):

스레드는 하나의 큰 작업을 여러 작은 작업으로 나누어 처리하는 일꾼으로 비유할 수 있다. 여러 명의 일꾼이 동시에 다양한 작업을 수행하면 전체 작업이 빠르게 완료될 수 있다.

​

2. 스포츠 팀의 선수들:

각 스레드는 하나의 선수로 생각할 수 있다. 여러 선수들이 팀을 이루어 각자의 역할을 수행하면서 전체 경기를 완성하는 것과 같다.

​

3. 주방에서의 조리자들:

주방에서 각 조리자가 특정 요리를 담당하는 것을 생각해볼 수 있다. 각 스레드는 특정 작업을 담당하면서 전체 요리가 준비되도록 하는 구조와 같다.

​

4. 작업 단위 (Task Unit):

스레드는 어떤 큰 작업을 수행하는 과정에서 각각의 작은 작업 단위로 비유할 수 있습니다. 마치 여러 명의 작업자들이 한 프로젝트를 완성하기 위해 각자의 역할을 수행하는 것과 같다.



멀티 스레딩에서 주의할 점과 해결 방안은 아래와 같다.

​

1. 교착상태 (Deadlock):

- 주의점: 교착상태는 두 개 이상의 스레드가 서로 상대방의 작업이 끝날 때까지 대기하고 있는 상태를 말한다.

- 해결 방법: 교착상태를 방지하기 위해 스레드가 자원을 요청할 때, 다른 스레드가 이미 가지고 있는 자원을 반납하도록 하는 데에 중점을 둔다. 또한, 자원에 대한 순서를 정의하여 교착상태의 가능성을 줄일 수 있다.

​

2. 경쟁 조건 (Race Condition):

- 주의점: 여러 스레드가 공유 자원에 접근할 때, 예상치 못한 결과가 발생하는 상황을 말한다.

- 해결 방법: 동기화 메커니즘을 사용하여 공유 자원에 대한 접근을 조절한다. synchronized 키워드를 사용하거나 Lock 인터페이스를 활용하여 스레드 간의 순차적인 실행을 보장할 수 있다.

​

3. 데드락 (Livelock):

- 주의점: 데드락은 두 개 이상의 스레드가 서로에게 필요한 자원을 가지고 있지만, 진행이 멈춘 상태를 말한다.

- 해결 방법: 자원을 할당할 때, 스레드가 어떤 자원을 기다릴지 미리 정의하고, 모든 스레드가 동일한 순서로 자원을 요청하도록 한다.



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

9.InterruptThread


//class InterruptThread extends Thread{
//	@Override
//	public void run() {
//		for(int i = 100; i >= 0; i--) {
//			System.out.println(i);
//			
//			if(isInterrupted()) {//interrupt 요청이 들어오면 -> true로 변환
//				System.out.println("스레드 취소 요청(Interrupt)으로 스레드 중단");
//				return;//메서드 종료
//			}
//		}
//	}
//}
//
//public class _10_Interrupt {
//
//	public static void main(String[] args) {
//		InterruptThread t1 = new InterruptThread();//인스턴스 생성
//		t1.start(); //스레드가 실행 -> run메서드 호출 -> run 메서드는 스레드에서 실행될 구문을 정의
//		
//		for(int i = 0; i < 500000; i++) {
//			if(i == 100000) {
//				t1.interrupt();//스레드의 작업 취소 요청 -> isInterrupt메서드는 false에서 true로 변환
//			}
//		}
//		
//		//System.out.println("스레드 상태 변환: " + t1.isInterrupted());
//	}
//
//}

package chap33_thread;

import javax.swing.JOptionPane;

class InterruptThread extends Thread{
	@Override
	public void run() {
		for(int i = 100; i >= 0; i--) {
			System.out.println(i);
			
			if(isInterrupted()) {//interrupt 요청이 들어오면 -> true로 변환
				System.out.println("스레드 취소 요청(Interrupt)으로 스레드 중단");
				return;//메서드 종료
			}
		}
	}
}

public class _10_Interrupt {

	public static void main(String[] args) {
		InterruptThread t1 = new InterruptThread();//인스턴스 생성
		
		String isStop = JOptionPane.showInputDialog("스레드를 중지하려면 stop를 입력하세요: ");
		if(isStop.equalsIgnoreCase("stop")) {
			t1.interrupt();//스레드 취소 요청
		}
		
		//다이얼로그박스를 띄어서 문자열을 입력 받는다.
		//입력 받은 문자열이 stop이라면 interrupt를 발생
			
		t1.start(); //스레드가 실행 -> run메서드 호출 -> run 메서드는 스레드에서 실행될 구문을 정의
	}

}

10.YieldThread

class YieldThread extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(getName() + ": " + i);
			
			if(i % 3 == 0)
			yield();//다음 스레드에게 제어권을 넘김
			
		}
	}
}

public class _11_YieldThread {

	public static void main(String[] args) {
		YieldThread t1 = new YieldThread();
		YieldThread t2 = new YieldThread();

		t1.setName("양보하는 스레드 1");
		t2.setName("양보하는 스레드 2");
		
		t1.start();
		t2.start();
	}

}

11. JoinThread


class JoinThread extends Thread{
	private String name;
	
	JoinThread(String name){
		this.name = name;
	}
	
	@Override
		public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(this.name + ": " + i);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class _12_JoinThread {

	public static void main(String[] args) {
		JoinThread t1 = new JoinThread("조인 스레드 1");
		JoinThread t2 = new JoinThread("조인 스레드 2");

		t1.start();
		t2.start();
		
		try {
			t1.join();//t1이 모든 작업을 수행할 때까지 기다린다.
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
//		t2.start();
//		try {
//			t2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("난 main 메서드를 처리하는 스레드야");
	}

}
