1. synchronized


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


2. synchronized


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

3. synchronized//동기화

//--------------------------------------------------------//Chat클래스
class Chat{
	private String message = null;
	private boolean isMessage = false;//메시지 수신 여부//기본값으로 false가 잡혀있다.
	
	//동기화 : 한 스레드가 사용중이면 다른 스레드는 사용할 수 없도록 만드는 작업.
	public synchronized void sendMessage(String msg) {
		//받은게 있으면 대기//멈추는 조건 멈추지 않으면 실행되는 조건
		if(isMessage) {//isMessage가 true라면?? 메시지를 수신한 상태 //send부터 실행되기 위해 조건을 달아놨다.//isMessage가 true라면 실행
			try {
				wait();//스레드를 대기 상태로 바꾼다. 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		message = msg;
		isMessage = true;
		System.out.println("-> " + message + "메시지 송신");
		notify();//대기 상태인 스레드를 깨운다
	}
	
	public synchronized String receiveMessage() {
		//받은게 없으면 대기
		if(!isMessage) {//isMessage가 false라면?// false라면 무조건 대기
			try {
				wait();//스레드를 대기 상태로 바꾼다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("<-" + message + "메시지 수신");
		isMessage = false;
		notify();//대기 상태인 스레드를 깨운다
		return message;
	}
}
//--------------------------------------------------------//SenderThread클래스//송신으로 가는
class SenderThread extends Thread {
	Chat chat = null; // Chat의 참조형 변수 선언

	SenderThread(Chat ct) {// 참조형 변수를 ct 메개변수로 초기화 해준다.
		chat = ct;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			chat.sendMessage("메시지#" + i);// msg로 메시지 전송
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
//--------------------------------------------------------//ReceverThread클래스//수신으로 가는
class ReceiverThread extends Thread {
	private Chat chat;// 참조형 변수 선언

	public ReceiverThread(Chat ct) {
		chat = ct;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			chat.receiveMessage();
			try {
				sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}

public class _15_Chat {

	public static void main(String[] args) {
		Chat cha = new Chat();//인스턴스 생성
		SenderThread sendTh = new SenderThread(cha);//인스턴스 생성
		ReceiverThread revTh = new ReceiverThread(cha);//인스턴스 생성
		
		sendTh.start();
		revTh.start();
		
	}

}
