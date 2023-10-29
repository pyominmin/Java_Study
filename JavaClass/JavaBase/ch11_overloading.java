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

  

  
