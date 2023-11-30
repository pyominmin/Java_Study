
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

12. synchronized


//경쟁조건(Race condition) : 두 개의 스레드가 동시에 자원을 접근하면서 발생하는 문제
//이 경우 원치 않은 결과를 얻을 수 있다.

class ShareResource{
	private int count = 0;
	
	//synchronized //메서드에 대한 임계영역(critical section) - lock 획득
	public synchronized void increment() {
		count++;
		//Load count toR1
		//R1 = R1 + 1
		//Store R1 to count
	}//lock반납
	
	public int getCount() {
		return count;
	}
}
//--------------------------------------------------------//Thread클래스
class IncrementThread extends Thread{
	
	private ShareResource shRsc;//참조형 변수 선언 
	
	public IncrementThread(ShareResource sRsc){
		shRsc = sRsc;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			shRsc.increment();
		}
	}
}

public class _13_RaceCondition {

	public static void main(String[] args) {
		ShareResource sr = new ShareResource();//인스턴스 생성
		IncrementThread t1 = new IncrementThread(sr);//인스턴스 생성
		IncrementThread t2 = new IncrementThread(sr);//인스턴스 생성
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("증가된 횟수: " + sr.getCount());
	}

}


13. synchronized


class BankAccount {
	private int balance;// 잔액

	public BankAccount(int amount) {
		balance += amount;
	}

	public synchronized void withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println(amount + "원 출금, 남은 잔액 : " + balance + "원");	
		} else {
			System.out.println("잔액이 부족하여 출금할 수 없습니다.");
		}

	}
	
	public synchronized void sendDeposit(int deposit) {
		int totalMoney;
		totalMoney = balance += deposit;
		System.out.println(deposit + "원 입금, 남은 잔액 : " + totalMoney + "원");
	}

}
//-------------------------------------------------------------------//
class WithdrawThread extends Thread{
	private BankAccount ac;//계좌 참조형 변수
	private int amount;//출금 금액
	
	public WithdrawThread(BankAccount acc, int money) {
		ac = acc;
		amount = money;
	}
	@Override
	public void run() {
		ac.withdraw(amount);
	}
}

class sendDeposit extends Thread{
	private BankAccount account;
	private int deposit;
	
	public sendDeposit(BankAccount account, int deposit) {
		this.account = account;
		this.deposit = deposit;
	}
	
	@Override
	public void run() {
		account.sendDeposit(deposit);
	}
}

public class _14_SynchronizedBank {

	public static void main(String[] args) {
		BankAccount bank = new BankAccount(1000);//인스턴스 생성
		WithdrawThread th1 = new WithdrawThread(bank, 500);//인스턴스 생성
		WithdrawThread th2 = new WithdrawThread(bank, 800);//인스턴스 생성
		
		th1.start();
		th2.start();

		sendDeposit sd1 = new sendDeposit(bank, 1000);
		sendDeposit sd2 = new sendDeposit(bank, 1000);
		
		sd1.start();
		sd2.start();
	}

}
