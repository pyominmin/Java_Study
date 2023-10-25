*Random
double num = Math.random();//0.0 ~ 1.0 랜덤 수 추출(1.0 미포함)
int num = (int)Math.random();//0 또는 1 추출
int num = (int)(Math.random() * 100);// 0 ~ 99 사이의 정수
int num = (int)(Math.random() * 31) + 50;//50(0) ~ 80(30) 사이
  begin ~ end 사이의 난수 발생 : (int)(Math.random() * (end - begin + 1)) + begin
int num = (int)(Math.random() * 101) + 100;// 100 ~ 200 사이의 정수 

1. 문제를 랜덤하게 출력한다.

public class GitHub_for {

	public static void main(String[] args) {
		
		
		
			for(int i = 1; i <= 10; i++) {
				int num1 = (int)(Math.random() * 10);
				int num2 = (int)(Math.random() * 10);
			System.out.printf("%2d. %d + %d = \n", i, num1, num2);

			}
	}  



2. 정답을 입력 했을 때 정답 개수는 몇개인가?

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int count = 0;
		for (int i = 1; i <= 10; i++) {
			int num1 = (int) (Math.random() * 10);
			int num2 = (int) (Math.random() * 10);
			System.out.printf("%2d. %d + %d = \n", i, num1, num2);
			int answer = in.nextInt();

			if (num1 + num2 == answer) {
				++count;
			}

		}

		in.close();
		System.out.print("정답은 " + count + "개");

	}
