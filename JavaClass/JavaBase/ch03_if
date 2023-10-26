제어 명령문 => 조건문(if, switch), 반복문(for, while, do ~ while)

  *if문

  1. 음의 정수를 양의 정수로 변환
  public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int num;
		System.out.print("정수 입력 : ");
		num = in.nextInt();
		in.close();
		
		if(num < 0) {
			num *= -1;
		}
		
		System.out.println("결과는 " + num + "입니다.\n");
	}

2. 소문자를 대문자로 변환
  char(2byte) - int(4byte) - double(8byte)
  public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		char ch;
		System.out.print(" 문자 입력 : ");
		ch = in.nextLine().charAt(0);
		in.close();
			
		if(ch >= 'a' && ch <= 'z') {//범위값을 표현할때는 무조건 &&(and)
			//ch = (char)(ch - 32);// 정수 연산에서는 무조건 제일 큰타입으로 계산되어서 정수 값으로 계산해야 하지만 결과 값은 문자이므로 정수를 문자로 바꿔서 넣는다.
      ch -= 32; //복합되어 있는 연산자는 묵시적으로 좌측에 있는 타입으로 변경됨
			System.out.println("소문자를 대문자로 변환합니다.");
		}
		
		System.out.println("결과는 " + ch + "입니다.\n");
	}

}
3. 60점 이상 합격
  
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

//		if (kor >= 60 && eng >= 60 && mat >= 60) {
//			System.out.println("합격입니다.");
//		} else { //else 뒤에는 조건이 올 수 없다.(if문이 아닌 경우 수행하는 명령)
//			System.out.println("불합격 입니다.");
//		}
		if (kor < 60 || eng < 60 || mat < 60) {// 한 과목 이라도 60점 이하면 불합격이기 때문에 || 사용
			System.out.println("불합격입니다.");
		} else { //else 뒤에는 조건이 올 수 없다.(if문이 아닌 경우 수행하는 명령)
			System.out.println("합격 입니다.");
		}
		
	}

4. 입장 가능
public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int age, skill;
		System.out.print("나이 : ");
		age = in.nextInt();
		
		System.out.print("내공 : ");
		skill = in.nextInt();
		in.close();

		if (age >= 18 && skill >= 1400 && skill <= 1600) {
			System.out.println("입장 가능");
		} else {
			System.out.println("입장 불가능");
		}

	}




