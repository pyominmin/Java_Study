이차원배열

1-1 배열
public static void main(String[] args) {
		int[][] a = new int[3][5];// 앞(행), 뒤(열)

		// 배열에 값을 저장
		int num = 1;
		for (int i = 0; i < 3; i++) {// i는 0, 1, 2로 돈다.(행)
			for (int j = 0; j < 5; j++) {// j는 0, 1, 2, 3, 4로 돈다.(열)
				a[i][j] = num++;

			}
		}
		// 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

1-2 배열
  public static void main(String[] args) {
		int[][] a = new int[3][5];// 앞(행), 뒤(열)

		// 배열에 값을 저장
		int num = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				a[j][i] = num++;

			}
		}
		// 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

1-3 배열
  public static void main(String[] args) {
		int[][] a = new int[5][5];// 앞(행), 뒤(열)

		// 배열에 값을 저장
		int num = 1;
		for (int i = 0; i < 5; i++) {
			if (i == 0 || i == 2 || i == 4) {// 0행 2행 4행
				for (int j = 0; j < 5; j++) {// 열 // 0 1 2 3 4
					a[i][j] = num++;
				}
			} else {// 1행 3행
				for (int j = 4; j >= 0; j--) {// 열 // 4 3 2 1 0
					a[i][j] = num++;
				}
			}
		}
		// 출력
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

1-4 배열
  public static void main(String[] args) {
		int[][] table = new int[8][9];
		
		for(int i = 0; i < 8; i++) {//행
			for(int j = 0; j < 9; j++) {//열
				
				//저장 순서와 출력 순서가 같은 경우는 같은 반복문 내에서 쓸 수 있다.
				table[i][j] = (i + 2) * (j + 1);//저장
				System.out.printf("%4d", table[i][j]);//출력
			}
			System.out.println("");
		}

	}

1-5 배열
 public static void main(String[] args) {
		int[][] a = new int[6][6];

		// 저장
		for (int i = 0; i < 5; i++) {// 행
			for (int j = 0; j < 5; j++) {// 열
			a[i][j]	= (int)(Math.random() * 10);
			
			a[i][5] += a[i][j];//가로 저장
			a[5][j] += a[i][j];//세로저장
			
			}
		}
		
		// 출력
		for (int i = 0; i < 6; i++) {// 행
			for (int j = 0; j < 6; j++) {// 열
				System.out.printf("%2d", a[i][j]);
			}
			System.out.println("");
		}
	}
