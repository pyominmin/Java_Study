*이중for문

public static void main(String[] args) {
		        1        2      4
		for(int i = 1; i <= 5; i++) {// j의 반복문이 다 돌지 않으면 i는 실행하지 않는다.
	3		for(int j = 0; j <= 3; j++) {//3번씩 반복하는걸 5번 수행한다.
				System.out.print("*");
			}
			System.out.println("");
		}

	}

1-1 별찍기
  public static void main(String[] args) {
		
		for(int i = 1; i <= 5; i++) {// 행(i) 별(j) == i
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

1-2 별찍기
  public static void main(String[] args) {
		
		for(int i = 1; i <= 5; i++) {// 행(i) 별(j) == 6 - 1
			for(int j = 1; j <= 6 - i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

1-3 별찍기
  public static void main(String[] args) {
		
		for(int i = 5; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}
1-4 별찍기
  public static void main(String[] args) {
		
		/* 행(i)  숫자(j) = j는 변수가되어야 한다. 시작하는 수가 고정되어있지 않기 때문이다. j <= i
		 * 1	 12345    끝수 == i + 4
		 * 2	 23456
		 * 3	 34567
		 * 4	 45678
		 * 5	 56789
		 */
		for(int i = 1; i <= 5; i++) { //반복횟수
			for(int j = i; j <= i + 4; j++) { //숫자
				System.out.print(j);
			}
			System.out.println("");
		}

	}

1-5 숫자 
  public static void main(String[] args) {
		
		/* 행(i)  숫자(j)   시작수(j == i)
		 * 1	 56789    끝수 == i + 4
		 * 2	 45678
		 * 3	 34567
		 * 4	 23456
		 * 5	 12345
		 */
		for(int i = 5; i >= 1; i--) {
			for(int j = i; j <= i + 4; j++) {
				System.out.print(j);
			}
			System.out.println("");
		}

	}

1-6 숫자
  public static void main(String[] args) {
		
		/* 
		 * 1 0 0 0 0 0 0
		 * 0 2 0 0 0 0 0
		 * 0 0 3 0 0 0 0
		 * 0 0 0 4 0 0 0
		 * 0 0 0 0 5 0 0
		 * 0 0 0 0 0 6 0
		 * 0 0 0 0 0 0 7
		 */
		for (int i = 1; i <= 7; i++) {// 행
			for (int j = 1; j <= 7; j++) { // 열
				if (i == j) {// 행 == 열
					System.out.print(j);
				} else {
					System.out.print(0 + " ");

				}
			}
			System.out.println("");
		}

	}

1-7 숫자
  public static void main(String[] args) {

		/*1 
		  0 0 
		  1 1 1 
		  0 0 0 0 
		  1 1 1 1 1 
		  0 0 0 0 0 0 
		  1 1 1 1 1 1 1 
		  0 0 0 0 0 0 0 0 
		  1 1 1 1 1 1 1 1 1 
		*/
		for (int i = 1; i <= 9; i++) {// 행
			for (int j = 1; j <= i; j++) { // 열
				if (i % 2 == 1 ) {
					System.out.print("1" + " " );
				} else {
					System.out.print("0" + " ");
				}
				
			}
			System.out.println("");
		}	

	}

1-8  별찍기
  public static void main(String[] args) {
	//		$*****
	//		$$****
	//		$$$***
	//		$$$$**
	//		$$$$$*
	
		for (int i = 1; i <= 5; i++) {// 행
			for (int j = 1; j <= i; j++) { // $찍는 반복문
				System.out.print("$");
			}
			for(int k = 1; k <= 6 - i; k++) {//행과 별의 합이 6이므로 6 - i
			System.out.print("*"); // *찍는 반복문
			}
			System.out.println("");
		}	

	}

1-9 별찍기
public static void main(String[] args) {
		//		$$$$*
		//		$$$**
		//		$$***
		//		$****
		//		*****
	
		for (int i = 1; i <= 5; i++) {// 행
			for (int j = 1; j <= 5 - i; j++) { 
				System.out.print("$");
			}
			for(int k = 1; k <= i; k++) {
			System.out.print("*"); 
			}
			System.out.println("");
		}	

	}
1-10 별찍기
public static void main(String[] args) {
//	     *
//	    **
//	   ***
//	  ****
//	 *****
	
		for (int i = 1; i <= 5; i++) {// 행
			for (int j = 1; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
			System.out.print("*"); 
			}
			System.out.println("");
		}	

	}

1-11 별찍기
public static void main(String[] args) {
//	     *
//	    ***
//	   *****
//	  *******
//	 *********
	
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5 - i; j++) { 
				System.out.print(" ");
			}
			for(int k = 1; k <= (2 * i) - 1; k++) {
			System.out.print("*"); 
			}
			System.out.println("");
		}	

	}

2. 가로 구구단
public static void main(String[] args) {

		for (int i = 2; i <= 9; i++) {
			System.out.printf("%d단\t", i);
			for (int j = 1; j <= 9; j++) { 
				System.out.printf("%d * %d = %2d\t", i, j, i * j );
			}
			System.out.println("");
		}	

	}
3. 세로 구구단
public static void main(String[] args) {
		System.out.println("*** 세로 구구단 ***");

		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%d * %d = %2d\t", j, i, i * j);
			}
			System.out.println("");
		}
	}
