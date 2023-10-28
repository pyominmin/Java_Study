*do while
//조건이 거짓이라도 최소 1번은 무조건 수행된다.
//명령을 수행 후 조건을 물어본다.
//조건이 마지막이기 때문에 (;)로 끝난다.
int k = 1;
		do {
			System.out.print(k + " ");
			k++;
		}while(k <= 100);//do~while문의 끝은 반드시 세미콜론(;)으로 마무리

*while(조건){
//반복한다
}
int i = 1; //증가되는 값을 저장하는 변수
		while(i <= 100) {//조건이 참(true)인 경우 반복한다.
			System.out.print(i + " ");
			i++; //증가 시켜주지 않으면 무한루프
		}
		for(int j = 1; j <= 100; j++) {// while문과 구성이 같다(초기값, 조건, 증가값)
			System.out.print(i + " ");
		}

1. while문 무한루프(true)
int i = 1;
		while(true) {//무한루프
			System.out.print(i++ + " ");
			
			if(i > 100) {
				break; //반복문 탈출(속해있는 반복문 단 한개만 탈출)
			}
		}//end while
	}

1-2 for문의 무한루프
for(;;) {//무한루프 조건이 없으면 무한루프이다.
			
		}

2. continue(반복문의 끝으로 이동한다.)
//for문에서 continue를 이용하면 증가값으로 이동한다.
//do ~ while문에서 사용하면 조건으로 이동하게된다.
public static void main(String[] args) {
		
		int i = 1;
		while(true) {//무한루프
			System.out.print(i++ + " ");
			
			if(i > 100) {
				break; //반복문 탈출(속해있는 반복문 단 한개만 탈출)
			}
			
			if(i > 50) {
				continue; //반복문의 끝으로 이동한다.(continue 아래 있는 명령은 수행되지 않음)
			}
			System.out.println("###########");
			System.out.println("&&&&&&&&&&");
		}//end while
	}

3. 다시 입력받게 돌리기
while문 이용
public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int num;
		while (true) {// 무한루프
			System.out.print("정수 입력(1 ~ 5) : ");
			// int num = in.nextInt();//블록 안에서 선언한 변수는 지역변수라 한다. 그러므로 블록 밖에서 변수 선언을 한다.
			num = in.nextInt();

			if (num >= 1 && num <= 5) {
				break;
			}
		}

		in.close();
		System.out.println("입력 결과 : " + num);
	}

do~while문 이용
public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int num;
		do {// 무한루프
			System.out.print("정수 입력(1 ~ 5) : ");
			num = in.nextInt();

		} while (num < 1 || num > 5);// 무한루프 //반복조건

		in.close();
		System.out.println("입력 결과 : " + num);

	}

4. 점수 입력하기
while문 이용
public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int score;
		
		while(true){
			System.out.print("점수 입력(0 ~ 100) : ");
			score = in.nextInt();
			
			if(score >= 0 && score <= 100) {//이 조건을 만났을때 탈출
			break;
			}
		}
		System.out.println("입력 받은 점수는 " + score + "점 입니다.");
		in.close();
	}

do~while문 이용
public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int score;
		
		do{System.out.print("점수 입력(0 ~ 100) : ");
		score = in.nextInt();
		}while(score < 0 || score > 100);// 이 조건에서 무한루프
		
		System.out.println("입력 받은 점수는 " + score + "점 입니다.");
		in.close();
	}

5. 범위의 합계
while문 이용
public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int num;
		int score = 0;
		while(true){
			System.out.print("점수 입력(0종료) : ");
			num = in.nextInt();
			 score += num;
			if(num == 0) {
			break;
			}

		}
		System.out.println("입력 받은 점수의 합은 " + score + "입니다.");
		in.close();
	}

do~while문 이용
public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int num;
		int score = 0;
		do {
			System.out.print("점수 입력(0종료) : ");
			num = in.nextInt();
			score += num;
		} while (num != 0);

		System.out.println("입력 받은 점수의 합은 " + score + "입니다.");
		in.close();
	}

