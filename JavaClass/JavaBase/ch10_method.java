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

2. 나눗셈
public static void divide(int num1, int num2) {
		System.out.println("나눗셈한 결과는" + (num1 / num2) + "입니다.");//그냥 출력만 해주기 때문에 void
	}
	public static void main(String[] args) {
		int n1, n2; //지역변수 : 블록{} 내에서만 사용 가능한 변수
		Scanner in = new Scanner(System.in);
		
		System.out.print("두 수 입력(공백 구분) : ");
		n1 = in.nextInt();
		n2 = in.nextInt();
		in.close();
		
		sum(n1, n2); //메서드로 호출// int num1, int num2로 호출
		divide(n1, n2);
	}

3. 별찍기
public static void printStar(int count) {
		for(int i = 1; i <= count ; i++) {
			System.out.print("*");	
		}
		System.out.println("");
	}
	
	public static void printChar(int count, char ch) {
		for(int i = 1; i <= count ; i++) {
			System.out.print(ch + " ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int count;
		System.out.print("반복 횟수 입력 : ");
		count = in.nextInt();
		in.nextLine();
		
		char ch;
		System.out.print("반복 문자 입력: ");
		ch = in.nextLine().charAt(0);
		in.close();
		
		printStar(count);//반복횟수만큼 '*'문자를 출력하는 메서드
		printChar(count, ch);
	}

4. 리턴(return)
public static int sum(int num1, int num2) {//출력되는 자료형이 int이다.
		int re = num1 + num2;
		return re;//연산을 해서 호출한 곳으로 계산 결과를 돌려준다 즉, return은 함수의 종료이다.
		//return 다음에 코드를 입력 시 오류가 난다. return에서 호출한 곳으로 돌아가기 때문에 그 아래의 코드는 사용되지 않는다.
	}

	public static double divide(int num1, int num2) {
		double re = (double)num1 / num2;//정수 연산이되지 않게 형변환
		return re;
	}

	public static void main(String[] args) {
		int n1, n2;
		
		Scanner in = new Scanner(System.in);

		System.out.print("두 수 입력(공백 구분) : ");
		n1 = in.nextInt();
		n2 = in.nextInt();
		in.close();

		double result = sum(n1, n2) * 1234 / 3.4;//n1, n2를 sum메서드로 보낸다.
		System.out.println("연산 결과는 " + result + "입니다.");
		System.out.println("연산 결과는 " + sum(n1, n2) + "입니다.");
		
		System.out.println("나눗셈 결과는 " + divide(n1, n2) + "입니다.");
	}

4-1 두 수 비교
	public static int largeNumber(int num1, int num2) {
		if(num1 < num2) {
			return num2;
		}else {
			return num1;
		}
	}
	
	public static int smallNumber(int num1, int num2) {
			return num1 < num2 ? num1 : num2;
	}
	
	public static void main(String[] args) {
		int n1, n2; 
		Scanner in = new Scanner(System.in);
		
		System.out.print("두 수 입력(공백 구분) : ");
		n1 = in.nextInt();
		n2 = in.nextInt();
		in.close();

		int large = largeNumber(n1, n2);//두 수 중 큰 수를 구해 리턴하는 메서드 호출
		
		System.out.println("큰 수는 " + large + "이다.");
		System.out.println("작은 수는 " + smallNumber(n1, n2) + "이다.");
	}

4-2 boolean 두 수 비교
public static int largeNumber(int num1, int num2) {
		if(num1 < num2) {
			return num2;
		}else {
			return num1;
		}
	}
	
	public static int smallNumber(int num1, int num2) {
			return num1 < num2 ? num1 : num2;
	}
	
	public static boolean sameNumber(int n1, int n2) {
//		if(n1 == n2) {
//			return true;
//		}else {
//			return false;
//		}
		
		return n1 == n2;
	}
	
	public static void main(String[] args) {
		int n1, n2; 
		Scanner in = new Scanner(System.in);
		
		System.out.print("두 수 입력(공백 구분) : ");
		n1 = in.nextInt();
		n2 = in.nextInt();
		in.close();

		int large = largeNumber(n1, n2);//두 수 중 큰 수를 구해 리턴하는 메서드 호출
		
		System.out.println("큰 수는 " + large + "이다.");
		System.out.println("작은 수는 " + smallNumber(n1, n2) + "이다.");
		
		if(sameNumber(n1, n2)){//두 수가 같다면 true, 다르다면 false => boolean
			System.out.println("두 수는 같습니다.");
		}else {
			
		}
	}

4-3 등급
public static char getGrade(int score) {
			if(score <= 90 && score >= 100) {
				return 'A';
			}else if(score >= 80) {
				return 'B';
			}else if(score >= 70) {
				return 'C';
			}else if(score >= 60) {
				return 'D';
			}else {
				return 'F';
			}
		}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int score;
		System.out.print("점수 입력 (0 ~ 100) : ");
		score = in.nextInt();
		in.close();
		
		System.out.println("점수 : " + score + ", 등급 : " + getGrade(score));
	}

4-4 범위의 합계
	public static double getRangeSum(int begin, int end) {
		double total = 0;
		for(double i = begin; i <= end; i++) {
			total += i;
		}
		return total;//합계 리턴
	}
	
	public static void main(String[] args) {
		int n1, n2;
		Scanner in = new Scanner(System.in);
		
		System.out.print("두 수 입력(공백 구분) : ");
		n1 = in.nextInt();
		n2 = in.nextInt();
		in.close();

		double result = getRangeSum(n1, n2);
		System.out.println("두 수의 범위 합은" + result + "입니다.");
	}

4-5 factorial
public static double factorial(int n) {
		if( n <= 1) {//조건에 따라 수행되는 명령문이 단일문ㅇ니 경우 중괄호{}는 생략 가능하다.
			return 1;
		}
		double mul = 1;
		for(int i = 2; i <= n; i++) {
			mul *= i;
		}
		return mul;
	}
	
	public static void main(String[] args) {
		int n;
		Scanner in = new Scanner(System.in);
		System.out.print("자연수 입력 : ");
		n = in.nextInt();
		in.close();
		
		System.out.println(n + "! = " + factorial(n));
	}

5. 배열의 최댓값
public static int getMax(int[] arr) {
		int max = arr[0];
		
		for(int i = max; i < arr.length; i++ ) {
			if(max < arr[i]) {//최댓값 < 비교값
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 45, 2, 87, 34, 7, 9, 5, 345, -3};
		
		int max = getMax(arr);//배열에서 최댓값을 구해 리턴하는 메서드

		System.out.println("배열의 최댓값은 " + max + "입니다.");
	}
