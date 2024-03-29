array(배열)
public static void main(String[] args) {
		//int a, b, c, d, e; 같은 변수 를 여러개 사용하게될 때 배열[](index) 사용한다.
		int[] a = new int[5];//int 타입의 변수 5개 선언하겠다. 배열의 이름은 a이다. a는 배열을 참조하고 있다.
		
		int[]aa;//aa는 int형 배열을 참조(배열의 주소)하겠다.
		aa = new int[5];//int형 메모리를 5개 선언 후 aa가 참조
		
		double[] c = new double[2];
		
		char[] ch = new char [100];
	}

1. 배열의 합
public static void main(String[] args) {
		char[] upper = new char[100];// char형의 배열을 100개 할당 후 upper가 참조

		System.out.println("\n\n*** 대문자 " + upper.length + "개 출력***");// 오류를 줄이기 위해 사용
		for (int i = 0; i < upper.length; i++) {
			int temp = (int) (Math.random() * 26) + 65;// 65 ~ 90// 0부터이기 때문에 26
			upper[i] = (char) temp; // 문자값으로 변환해서 배열에 저장
			System.out.print(upper[i] + " ");

			// i(i % 5 == 4) // 4 9 14 19 24 29 ...
			if (i % 10 == 9) {// 10으로 나눈 나머지가 9// 0부터 시작하기 때문에
				System.out.println("");// 줄바꿈
			}
		}

		char ch;
		int count = 0; // 개수를 구하는 변수
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("문자 입력 : ");
			ch = in.nextLine().charAt(0);
		} while (ch < 'A' || ch > 'Z');//다른 문자 입력 시 무한루프
		in.close();

		for (int j = 0; j < upper.length; j++) {
			if (ch == upper[j]) {// 검색문자 == 저장문자
				count++;
			}
		}
		System.out.printf("%d개", count);
	}


2. 등수 증가

public static void main(String[] args) {
		int[] score = new int[5];
		int[] rank = new int[5];

		Scanner in = new Scanner(System.in);
		// 점수 입력, 등수 1로 저장
		for (int i = 0; i < score.length; i++) {
			System.out.print((i + 1) + "번 점수 입력 : ");// 괄호를 씌워야 연산된다.
			score[i] = in.nextInt();
			
			rank[i] = 1;
		}
		for (int i = 0; i < score.length; i++) {// 순위를 구하려는 기준
			for (int j = 0; j < score.length; j++) {// 비교하려는 점수의 첨자
				if (score[i] < score[j]) {// 순위를 구하려는 점수 , 비교 점수
					rank[i]++;
				}
			}
		}
		in.close();
		System.out.println("***등수 출력***");
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%d번. %d점. %2d등\n", i + 1, score[i], rank[i]);
		}
	}

3. 배열 초기화
	public static void main(String[] args) {
		// 배열 초기화
		//int[] a = new int[] {1, 2, 3, 4, 5};//배열이 0으로 채워져 있어서 초기화 시켜준다./int[](배열)의 크기를 생락한다
		int[] a = {1, 2, 3, 4, 5};// 초기화의 개수로 배열의 크기가 결정// 초기화를 주는 경우 new int를 생략할 수 있다.
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

3-1
	public static void main(String[] args) {

		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 각 달의 일수를 저장

		for (int i = 0; i < month.length; i++) {
			System.out.printf("%2d월의 일수는 %2d일 입니다.\n", i + 1, month[i]);
		}
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int searchMon;
		while (true) {
			System.out.print("검색 월 입력 : ");
			searchMon = in.nextInt();
			if (searchMon < 0 || searchMon > 13) {

				continue;
			} else {
				System.out.printf("검색한 월의 일수는 %d일 입니다.", month[searchMon - 1]);
				break;
			}
		}
	}

4. 랜덤 개수
public static void main(String[] args) {
		// 0 ~ 99 사이의 무작위 숫자 100 출력 후 카운트 하는 프로그램

		int[] num = new int[100];//랜덤 수를 저장하는 배열
		int[] count = new int[10];//구간의 개수를 카운트하는 배열

		for (int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random() * 100);
			count[num[i] / 10]++;// 100개의 숫자를 10개의 그룹으로 나눈다.//10의 자리는 1에 20의 자리는 2에 저장할 것이다.//10의 자리를 배열의 첨자로 이용한다.
			System.out.printf("%5d ", num[i]);
			if (i % 10 == 9) {
				System.out.println(" ");
			}
		}
		int st = 0;
		int end = 9;
		System.out.println("------------------------------");

		for (int i = 0; i < count.length; i++) {
			System.out.printf("%2d ~ %2d까지의 정수는 %2d개 입니다.\n", st, end, count[i]);
			st += 0;
			end += 10;
		}

	}

5. 배열 출력
public static void main(String[] args) {
		int[] arr = {40, 50, 60, 70, 80};
		int index;
		
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("시작 인덱스 입력 : ");
			index = in.nextInt();
		}while(index < 0 || index > arr.length - 1);
		in.close();
		
		for(int i = index; i < arr.length; i++) {//입력 인덱스부터 끝까지
			System.out.print(arr[i] + " ");
		}
		for(int i = 0; i < index; i++) {//0부터 입력 인덱스 전까지
			System.out.print(arr[i] + " ");
		}

	}
5-1 많이 응용되는 방법
public static void main(String[] args) {
		int[] arr = {40, 50, 60, 70, 80};
		int index;
		
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("시작 인덱스 입력 : ");
			index = in.nextInt();
		}while(index < 0 || index > arr.length - 1);
		in.close();

		for(int i = index; i <= index + 4; i++){//자신을 포함해서 5번 반복
			System.out.print(arr[i % 5] + " ");//5로 나누면 나머지가 0, 1, 2, 3, 4를 반복한다.
		}//arr[2 % 5], arr[3 % 5], arr[4 % 5], arr[5 % 5], arr[6 % 5]
		 //	2	    3          	4	     0	         1
	
		
	}
