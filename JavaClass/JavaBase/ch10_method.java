method(함수와 같다)
-함수는 in put과 out put이 있어야 한다.(ex,믹서기에 딸기를 넣으면 딸기 주스)
public static void//이게 아웃풋 main(String[] args)//인풋


public static void => void는 출력할게 없을 때 사용
public static void printStar() => 입력도 없을 경우 괄호()안도 생략

//메서드 정의 : 메서드를 만드는 작업
//메서드를 정의한다고 해서 실행되지 않는다. 호출을 따로 해야 한다.
public static void printStar() {
		System.out.println("**********");
	}
	
	public static void printLine() {//1.점프
		System.out.println("----------");
	}

	public static void main(String[] args) {
		printLine();//2. 리턴// 메서드 호출
	}

1. 두 수의 합계
public static void sum(int num1, int num2) {//public static void main의 n1과 n2를 받게된다.//매개변수(parameter)
		System.out.println("덧셈 결과는" + (num1 + num2) + "입니다.");
	}
	public static void main(String[] args) {
		int n1, n2; //지역변수 : 블록{} 내에서만 사용 가능한 변수
		Scanner in = new Scanner(System.in);
		
		System.out.print("두 수 입력(공백 구분) : ");
		n1 = in.nextInt();
		n2 = in.nextInt();
		in.close();
		
		sum(n1, n2); //메서드로 호출// int num1, int num2로 호출
	}

2. 
