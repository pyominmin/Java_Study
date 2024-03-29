overloading
  -같은 이름의 메서드 사용이 가능하다.
  메서드명이 같아도 매개변수의 타입이나 개수가 다르면 메서드 오버로딩이라고 한다.
  메서드 오버로딩은 다형성(polymorphism)이 구현된다.

  1. 매개변수의 타입이 다르므로 메서드 오버로딩
  public static int sum(int a, int b) {
		return a + b;
	}

	public static double sum(double a, double b) {
		return a + b;
	}

	public static void main(String[] args) {
		System.out.println("정수 합계 : " + sum(3, 5));
		System.out.println("실수 합계 : " + sum(3.5, 4.8));
	}


2. 매개변수의 개수가 다르므로 오버로딩
public static void fun(int a) {
		System.out.println("인수 1개 호출");
	}

	public static void fun(int a, int b) {
		System.out.println("인수 2개 호출");
	}

	public static void main(String[] args) {
		fun(5);
		fun(2, 3);
	}

3. 오버로딩
public static int add(int a, int b) {
		System.out.println("1. add");
		return a + b;
	}	
	
	public static double add(double a, double b) {
		System.out.println("2. add");
		return a + b;
	}
	
	public static int add(int[] arr) {
		System.out.println("3. add");
		int sum = 0;
		for(int i = 0; i < arr.length; i++ ) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static String add(String s1, String s2) {
		System.out.println("4. add");
		return s1 + s2;
	}
	
	public static void main(String[] args) {
		System.out.println("두 수의 합은? : " + add(3, 5234));
		System.out.println("두 수의 합은? : " + add(3.8, 52.34));
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("배열의 합은? " + add(arr));
		
		System.out.println("연결 문자열은?" + add("Happy", "Birthday"));
	}

4. 오버로딩
public static int getTotal() {
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static int getTotal(int begin) {
		int sum = 0;
		for(int i = begin; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static int getTotal(int begin, int end) {
		int sum = 0;
		for(int i = begin; i <= end; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("1 ~ 100의 합 = " + getTotal());
		System.out.println("50 ~ 100의 합 = " + getTotal(50));
		System.out.println("70 ~ 90의 합 = " + getTotal(70, 90));
	}

5. 오버로딩
  public static void printChar() {
		for(int i = 1; i <= 10; i++) {
			System.out.print("*");
		}
		System.out.println("");
	}
	
	public static void printChar(char ch, int count) {
		for(int i = 1; i <= count; i++) {
			System.out.print(ch);
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
		printChar();
		
		char ch;
		int n;
		System.out.print("출력 문자 / 개수 입력(공백 구분) : ");
		Scanner in = new Scanner(System.in);
		
		//next : 공백 이전의 문자열을 가져오는 메서드
		//nextLine : 엔터까지의 문자열을 가져오는 메서드
		ch = in.next().charAt(0);
		n = in.nextInt();
		in.close();

		printChar(ch, n);
	}

6. 오버로딩 //하나의 메서드에는 하나의 함수
public static void randomize(int[] num) {// 랜덤한 값을 저장해주는 메서드
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 100) + 1;// 한개의 함수가 저장도 하면서 출력도 하면 나쁜 함수다.
			// 한개의 메서드에서는 하나의 기능만 가져야 좋은 메서드이다.//출력 함수는 따로 만들자
		}
	}

	public static void display(int[] num) {// 출력 해주는 메서드
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println(" ");
	}

	public static int getMax(int[] num) {// 최댓값을 구하는 메서드
		int max = num[0];

		for (int i = 1; i < num.length; i++) {
			if (max < num[i]) {
				max = num[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {//명령하는 일을 함
		int[] num;
		num = new int[5];

		randomize(num);// 랜덤하게 저장하는 함수를 호출

		System.out.print("1 ~ 100 사이의 난수 5개 출력 : ");
		display(num); // 출력함수 호출
		System.out.println("\n최댓값은 " + getMax(num) + "입니다.");

	}

7. 오버로딩
public static void upperRandomize(char[] upper) {
		for (int i = 0; i < upper.length; i++) {
			int temp = (int) (Math.random() * 26) + 65;
			upper[i] = (char) temp;
		}

	}

	public static void display(char[] alpha) {
		for (int i = 0; i < alpha.length; i++) {
			System.out.print(alpha[i] + " ");
			if (i % 10 == 9) {
				System.out.println("");
			}
		}
	}

	public static int getSearchCharCount(char[] alpha, char searchCh) {
		int count = 0;
		for (int i = 0; i < alpha.length; i++) {
			if (searchCh == alpha[i]) {
				++count;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		char[] upper = new char[100];
		upperRandomize(upper);//대문자를 랜덤하게 저장하는 메서드 호출
		System.out.println("***대문자 " + upper.length + "개 출력***");
		display(upper);//출력 메서드 호출

		char searchCh;
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.print("\n\n검색 문자 입력 : ");
			searchCh = in.nextLine().charAt(0);
		} while (searchCh < 'A' || searchCh > 'Z');
		
		in.close();

		System.out.println("검색한 문자의 개수는 " + getSearchCharCount(upper, searchCh) + "개 입니다.");

	}
  
8. 오버로딩
public static void initScore(int[] score, int[] rank) {
		Scanner in = new Scanner(System.in);

		for (int i = 0; i < score.length; i++) {
			System.out.print((i + 1) + "번 점수 입력 : ");
			score[i] = in.nextInt();
			rank[i] = 1;
		}
		in.close();
	}

	public static void getRank(int[] score, int[] rank) {

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++) {

				if (score[i] < score[j]) {
					rank[i]++;
				}
			}
		}
	}

	public static void displayRank(int[] score, int[] rank) {

		System.out.println("\n\n***등수 출력***");
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%d번. %3d점. %2d등\n", i + 1, score[i], rank[i]);
		}
	}

	public static void main(String[] args) {
		int[] score = new int[5];
		int[] rank = new int[5];

		initScore(score, rank); // 점수와 등수를 초기화 하는 메서드 호출
		getRank(score, rank); // 순위 구하기
		displayRank(score, rank);

	}

9. 오버로딩
public static void randomizeFloat(double[] num) {
		for (int i = 0; i < num.length; i++) {
			num[i] = Math.random() * 1000;
		}
	}

	public static void display(double[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.printf("%.2f  ", num[i]);
		}
		System.out.println();
	}

	public static double getSum(double[] num) {
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		double[] num = new double[10];
		randomizeFloat(num);// 랜덤하게 실수 값 저장
		System.out.println("랜덤 실수 값 " + num.length + "개 출력");
		display(num);// 출력

		System.out.println("배열의 합은 " + getSum(num) + "입니다.");
	}

10.오버로딩 
public static void randomizeFloat(double[] num) {
		for (int i = 0; i < num.length; i++) {
			num[i] = Math.random() * 1000;
		}
	}

	public static void display(double[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.printf("%.2f  ", num[i]);
		}
		System.out.println();
	}

	public static double getSum(double[] num) {
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		return sum;
	}

	public static void displayLessNumber(double[] num, double limit) {
		for(int i = 0; i < num.length; i++) {
			if(num[i] < limit) {
				System.out.printf("%.2f  ", num[i]);
			}	
		}
		System.out.println();
	}
	
	public static void displayRangeNumber(double[] num, double begin, double end) {
		for(int i = 0; i < num.length; i++) {
			if(num[i] >= begin && num[i] <= end) {
				System.out.printf("%.2f  ", num[i]);
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		double[] num = new double[10];
		randomizeFloat(num);// 랜덤하게 실수 값 저장
		System.out.println("랜덤 실수 값 " + num.length + "개 출력");
		display(num);// 출력

		System.out.println("배열의 합은 " + getSum(num) + "입니다.");
		
		System.out.print("\n몇 까지 출력 하시겠습니까? ");
		Scanner in = new Scanner(System.in);
		double limit = in.nextDouble();
		displayLessNumber(num, limit);//limit 보다 작은 수만 출력
		
		System.out.print("\n 출력 범위를 입력하세요\n");
		System.out.println("출력 시작 수와 끝 수를 공백으로 구분해서 입력하세요");
		double begin = in.nextDouble();
		double end = in.nextDouble();
		
		displayRangeNumber(num, begin, end);//begin ~ end 범위의 수를 출력
		in.close();
	}

11. 역순으로 배열 만들기


	public static void randomize(int[] num) {
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 100) + 1;
		}
	}

	public static void display(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

	public static void reverse(int[] arr) {

		int length = arr.length; // 배열의 크기

		for (int i = 0; i < length / 2; i++) {// 교환횟수
			// 값 교환
			int temp = arr[i];
			arr[i] = arr[length - 1 - i];
			arr[length - 1 - i] = temp;
		}
		// 값 교환
//		int temp = arr[0];
//		arr[0] = arr[9];
//		arr[9] = temp;

	}

	public static void main(String[] args) {
		int[] arr = new int[100];

		randomize(arr); // 저장
		System.out.println("\n\n***저장 된 데이터 출력***\n\n");
		display(arr);// 출력

		reverse(arr);// 리버스를 호출할떄마다 뒤집어진다.

		System.out.println("\n\n***역순으로 저장 된 데이터 출력***\n\n");
		display(arr);// 배열에 저장된 데이터를 역순 저장
	}
