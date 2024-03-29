*buffer
public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int num;
		System.out.print("정수 입력 : ");
		num = in.nextInt();
		in.nextLine();//저장 목적이 아니라 buffer에서 enter까지 가지고 오겠다.
		
		char ch;
		System.out.print("문자 입력 : ");
		ch = in.nextLine().charAt(0);//nextLine이 enter까지 가져오기 때문에 문자 입력 후 정수 입력 시에는 문제가 없다.
		
		in.close();
		
		System.out.println("입력 문자 : " + ch + ", 입력 정수 : " + num);
	}


*루프(true)
1. 제곱근 구하기
//Math. = 수학적 공식 사용(음수는 구할 수 없음)
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner in =new Scanner(System.in);
		double num, result;
		while(true) {
			System.out.print("제곱근을 입력하세요 : ");
			num = in.nextDouble();
			in.nextLine();//버퍼에 남아있는 엔터 가져오기
			
			if(num < 0) {
				System.out.println("0보다 작은 수는 입력하실 수 없습니다.");
				continue;//반복문의 선두로 이동
			}
			
			result = Math.sqrt(num);//제곱근 구하기
			System.out.println(num + "제곱근은 " + result + "입니다.");
			System.out.print("계속(아무키) / 종료(Q/q) : ");
			char isExit;
			isExit = in.nextLine().charAt(0);
			
			if(isExit == 'Q' || isExit == 'q') {
				break;
			}
		}
	}

2. 시간 구하기
public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int inMin, hour, minute;

		while (true) {
			System.out.print("분 입력 : ");
			inMin = in.nextInt();
			
			if (inMin < 0) {
				System.out.println("0보다 작을 수는 하실 수 없습니다.");
				continue;
			}else if(inMin == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
				}
			
			hour = inMin / 60;
			minute = inMin % 60;
			System.out.println(inMin + "분은 " + hour + "시간 " + minute + "분 입니다.");
			}

		}

3. 사칙연산

public static void main(String[] args) {
		double n1, n2;
		char ch, go;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("첫 번째 수 : ");
			n1 = in.nextDouble();
			in.nextLine();

			System.out.print("두 번째 수 : ");
			n2 = in.nextDouble();
			in.nextLine();
			System.out.print("연산자 : ");
			ch = in.nextLine().charAt(0);

			double result;
			switch (ch) {
			case '+':
				result = n1 + n2;
				System.out.println('+');
				break;
			case '-':
				result = n1 - n2;
				System.out.println('-');
				break;
			case '/':
				result = n1 / n2;
				System.out.println('/');
				break;
			case '*':
				result = n1 * n2;
				System.out.println('*');
				break;
			default:
				result = 0;
			}
			System.out.printf("\n%.2f %c %.2f = %.3f", n1, ch, n2, result);
			
			System.out.print("\n계속(아무키) / 종료(Q/q) : ");
			go = in.nextLine().charAt(0);
			if(go == 'Q' || go == 'q') {
				break;
			}
			
		}
	}
