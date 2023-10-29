1.x의 y승을 구해 리턴하는 메서드를 정의해 보시오.
  public class _09_OverloadingH1 {

	public static int square(int a, int b) {
		int answer = 1;
		for(int i = 0; i < b; i++) {
			answer *= a;
		}
		return answer;
	}
		
	
	public static void main(String[] args) {
//		x의 y승을 구해 리턴하는 메서드를 정의해 보시오.
//		=> power(x, y) 메소드 : x의 y승을 구해 리턴하는 메소드
		int a, b;
		Scanner in = new Scanner(System.in);
		System.out.print("밑수 입력 : ");
		a = in.nextInt();
		
		System.out.print("지수 입력 : ");
		b = in.nextInt();
		in.close();
		
		System.out.printf("%d ^ %d = %d", a, b, square(a, b));
	}

}

2.3개의 정수를 연속으로 입력
  public class _10_OverloadingH2 {

	public static void getLargeNum(int n1, int n2, int n3) {
		int large = n1;
		if(n1 < n2) {
			large = n2;
		}if(n1 < n3) {
			large = n3;
		}
		
		System.out.println("세 수 중 가장 큰 수는" + large + "입니다.");
	}
	
	public static void main(String[] args) {
//		3개의 정수를 연속으로 입력 받아 세 수 중 가장 큰 수를 리턴하는 메서드를 정의해 보시오.
//		=> getLargeNum(x, y, z) 메서드 : x, y, z중 큰 수를 구해 리턴하는 메서드
		int n1, n2, n3;
		Scanner in = new Scanner(System.in);
		System.out.print("3개의 정수 입력(공백 구분) :  ");
		n1 = in.nextInt();
		n2 = in.nextInt();
		n3 = in.nextInt();
		in.close();
		
		getLargeNum(n1, n2, n3);
		
	}

}

3.섭씨(C)를 화씨(F)로 변환하는 코드를 작성해보자.
  public class _11_OverloadingH3 {

	public static double CelToFah(double celsius) {
		double Fahrenheit;
		Fahrenheit = (celsius * 1.8) + 32;
		return Fahrenheit;
	}
	
	
	public static void main(String[] args) {
//		섭씨(C)를 화씨(F)로 변환하는 코드를 작성해보자.
//		화씨 온도(F) = (섭씨 온도(C) × 1.8) ＋ 32
//		=> CelToFah(celsius) 메서드 : 섭씨를 화씨로 변환한 후 리턴하는 메서드
		
		double celsius;
		Scanner in = new Scanner(System.in);
		System.out.print("섭씨 입력 :  ");
		celsius = in.nextDouble();
		in.close();
		
		System.out.println("섭씨 " + celsius + "도 -> " + CelToFah(celsius));
		
	}

}

4.입력받은 문자열이 회문인지 검사하는 메서드를 구현해보자.
  public class _12_OverloadingH4 {

	public static boolean isPalindrome(String str) {
		int length = str.length();

		for (int i = 0; i < length / 2; i++) {
			if(str.charAt(i) != str.charAt(length - 1 - i)) {
				return false;
			}
	}
		return true;
		
	}
	
	public static void main(String[] args) {
//		입력받은 문자열이 회문인지 검사하는 메서드를 구현해보자.
//		회문이란 앞/뒤 어느쪽에서 읽어도 같은 문장이 되는 문자열을 말한다. 
//		예를 들어 noon은 회문이다.
//		=> isPalindrome(str) 메서드 : str의 회문 여부를 판별한 후, true나 false를 리턴하는 메서드
		String str;
		Scanner in = new Scanner(System.in);
		System.out.print("문자열 입력 :  ");
		str = in.next();
		in.close();
		
		if (isPalindrome(str) == true) {
			System.out.println(str + "은 회문입니다.");
		}else {
			System.out.println(str + "은 평문입니다.");
		}
	}

}

5.배열에서 범위의 난수를 출력
  public class _13_OverloadingH5 {

	public static void randRange(int[] num, int begin, int end){
		for(int i = 0; i < num.length; i++) {
		num[i] = (int)(Math.random() * (begin - end + 1)) + begin;
		if(num[i] < 0) {
			num[i] *= -1;
		}
		}
	}
	
	public static void display(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
//		배열에서 범위의 난수를 출력하는 메서드를 구현해보자.
//		배열은 아래와 같이 선언한다.
//		int[] num = new int[10];
//		=> randRange(num, begin, end)  메서드 : begin ~ end 사이의 정수를 랜덤하게 뽑아 num배열에 저장하는 메서드
//		=> display(num) : num배열의 값을 출력하는 메서드
		
		int[] num = new int[10];
		int begin, end;
		Scanner in = new Scanner(System.in);

		System.out.print("랜덤 시작 수 입력 :  ");
		begin = in.nextInt();
		System.out.print("랜덤 끝 수 입력 :  ");
		end = in.nextInt();
		in.close();
		
		randRange(num, begin, end);
		System.out.printf("\n*** %d ~ %d 범위의 랜덤 값 출력 ***\n\n",begin, end);
		display(num);

	}

}
