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

