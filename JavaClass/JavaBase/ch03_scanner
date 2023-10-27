문자열 입출력(Scanner)

1. 문자 출력
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		char ch;
		System.out.print("문자 입력 : ");
		ch = in.nextLine().charAt(0);//문자열로 받아오고 그중에서 0번째 가져오겠다.
		in.close();
		System.out.println("입력 문자 : " + ch);
	}

2. 시간
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int time;
		System.out.print("분 입력 : ");
		time = in.nextInt();
		in.close();
		int hour = time / 60;
		int min = time % 60;
		
		
		System.out.printf("%d분은 %d시간 %d분 입니다.", time, hour, min);
	}

3. 일시적으로 형 변환 (double)
public static void main(String[] args) {

		int a = 10;
		int b = 3;
		double re;
		re = (double)a / b; //일시적인 자료형 변환/ (double)(a / b) 하는 경우에는 결과 값에 형변환이되어 re = 3.0 많이 틀리는 부분
		System.out.println("re = " + re);
	}

3-1. 정수부로 형변환

double d = 3.54;
		System.out.println("정수부 : " + (int)d);


4. 무게
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("짐의 무게 입력(kg) : ");
		int weight = in.nextInt();
		in.close();
		
		if(weight >= 50){//무게가 십의 자리가 1이면 10만원, 2이면 2만원의 규칙을 찾을 수 있다.
			System.out.println("50kg 이상의 짐은 부칠 수 없습니다.");
		}
		else {
			int fee = weight / 10 * 10000;
			System.out.println("무게 : " + weight + ", 수수료 : " + fee );
		}
	}

5. 과락으로 탈락
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int kor, eng, mat;

		System.out.print("국어 영어 수학 점수 입력 : ");
		kor = in.nextInt();
		eng = in.nextInt();
		mat = in.nextInt();

		in.close();

		int all = kor + eng + mat;
		double avg = all / 3.0;

		System.out.printf("총점 : %d\n", all);
		System.out.printf("평균 : %.2f\n", avg);

		if (avg >= 60) {
			if (kor >= 60 && eng >= 60 && mat >= 60) {
				System.out.println("합격입니다.");
			} else {
				if(kor < 60) {
					System.out.print("국어 ");
				}if(eng < 60) {
					System.out.print("영어 ");
				}if(mat < 60) {
					System.out.print("수학 ");
				}
				System.out.print("과락으로 탈락입니다.");
			}
		} else {
			System.out.println("평균 미달 탈락입니다.");
		}

	}

6. 등급
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int score = in.nextInt();
		in.close();

		//조건문을 쓰는 경우 else 구문이 없으면 컴파일러는 조건에 걸리지 않는 경우가 발생할 수 있다.
		//때문에 조건에 걸리지 않는 경우 변수의 초기값을 설정할 수 없기 때문에 오류를 발생 시키게 된다.

		//해결방법 1. 변수에 초기값을 설정 후 if문을 else 구문 없이 쓸 수 있다.
		//해결방법 2. else 구문을 마지막에 반드시 포함 시킨다.

		String grade; //두 글자 이상(문자열)
		if (score >= 90 && score <= 100) {
			if (score >= 97) {
				grade = "A+";
			}else if (score < 97 && score >= 93) {
				grade = "A0";
			}else {
				grade = "A-";
			}
		}else if (score >= 80 && score < 90) {
			if (score >= 87) {
				grade = "B+";
			}else if (score < 87 && score >= 83) {
				grade = "B0";
			}else {
				grade = "B-";
			}

		}else {
			grade = "F";
		}

		System.out.printf("당신의 학점은 %s 입니다.\n", grade);
	}
}

7. 배수
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = in.nextInt();
		in.close();

		if (num % 12 == 0) {
			System.out.println(num + "은 3의 배수이면서 4의 배수입니다.");
		} else if (num % 3 == 0) {
			System.out.println(num + "은 3의 배수입니다.");
		} else if (num % 4 == 0) {
			System.out.println(num + "은 4의 배수입니다.");
		} else {
			System.out.println(num + "은 3의 배수도 4의 배수도 아닙니다.");
		}

	}

