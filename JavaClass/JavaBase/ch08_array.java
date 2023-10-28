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
int[] a = new int[5];//배열은 0부터 시작한다. a[5] 처음 배열 방은 0, 마지막 배열 방은 4이다.
		
		Scanner in = new Scanner(System.in);
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {//배열의 첨자(index)가 돈다.
			System.out.printf("입력 %d : ", i + 1);
			a[i] = in.nextInt();
			
			sum += a[i];
		}
//		System.out.print("입력 1 : "); //이름이 같은 변수이기 때문에 반복문을 사용할 수 있다.
//		a[0] = in.nextInt();
//		
//		System.out.print("입력 2 : ");
//		a[1] = in.nextInt();
//		
//		System.out.print("입력 3 : ");
//		a[2] = in.nextInt();
//		
//		System.out.print("입력 4 : ");
//		a[3] = in.nextInt();
//		
//		System.out.print("입력 5 : ");
//		a[4] = in.nextInt();
//		
//		sum = a[0] + a[1] + a[2] + a[3] + a[4]; 
		
		System.out.println("정수 5개의 합계는 " + sum + "입니다.");
		
		in.close();
	}

2. 

