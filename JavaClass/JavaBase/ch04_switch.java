
switch(num) { //(조건X, 비교 대상이 되는 변수)
		case 1:  //case 변수의 값 :
			System.out.println(num + "은 가위 입니다.");
			break;//break를 사용하지 않으면 탈출하지 않고 끝까지 수행함
		case 2:
			System.out.println(num +"는 바위 입니다.");
			break;
		case 3:
			System.out.println(num +"은 보 입니다.");
			break;
		default:
			System.out.println("오류");
			break;
		}

1. 메뉴
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		char menu = in.nextLine().charAt(0);
		in.close();
		
		switch(menu) {
		case 'f': //if(menu == 'f' || menu == 'F')
		case 'F':
			System.out.println("File Menu");
			break;//break를 사용하지 않으면 탈출하지 않고 끝까지 수행함
		case 'h':
		case 'H':
			System.out.println("Help Menu");
			break;
		case 'e':
		case 'E':
			System.out.println("Edit Menu");
			break;
		default:
			System.out.println("Error");
		}
	} 

2. 자음, 모음 판별
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("영문자 입력 : ");
		char alphabet = in.nextLine().charAt(0);
		in.close();
		
		switch(alphabet) {
		case 'A': case 'E': case 'I': case 'O': case 'U':
		case 'a': case 'e': case 'i': case 'o': case 'u':
			System.out.println("모음 입니다.");
			break;
		default:
			System.out.println("자음 입니다.");
			
		}
	} 

3. 영문자가 아닙니다.
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("영문자 입력 : ");
		char alphabet = in.nextLine().charAt(0);
		in.close();
		
		if(alphabet >= 'a' && alphabet <= 'z') {
			alphabet -=32;
		}
		
		switch(alphabet) {
		case 'A': case 'E': case 'I': case 'O': case 'U':
		//case 'a': case 'e': case 'i': case 'o': case 'u':
			System.out.println("모음 입니다.");
			break;
		default:
			if(alphabet >= 'A' && alphabet <= 'Z') {
			System.out.println("자음 입니다.");
			}else {
				System.out.println("영문자 아닙니다.");
			}
		}

4. 남자 여자 구분
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("주민등록번호 입력(형식 : 020321-1234567) : ");
		char number = in.nextLine().charAt(7); //한번만 문자를 찾아낼 수 있다.
		in.close();
		
		switch(number) {
		case '2': case '4':
			System.out.println("여자입니다.");
			break;
		case '1': case '3':
			System.out.println("남자입니다.");
			break;
		default:
			System.out.println("유효한 주민번호가 아닙니다.");
		}
		
	} 

5. 여러개의 글자를 찾고 싶은 경우
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("주민등록번호 입력(형식 : 020321-1234567) : ");

		String number; //
		number = in.nextLine(); // 문자열을 입력 받아 number에 저장을 하고
		in.close();
		
		if (number.length() == 14) {
			char gender = number.charAt(7);// 7번째 문자를 추출
			char sign = number.charAt(7);// 6번쨰 문자를 추출

			if (sign == '-') {//length : 문자열의 길이를 구해주는 메서드
				switch (gender) {
				case '2':
				case '4':
					System.out.println("여자입니다.");
					break;
				case '1':
				case '3':
					System.out.println("남자입니다.");
					break;
				default:
					System.out.println("유효한 주민번호가 아닙니다.");
				}
			} else {
				System.out.println("주민등록 번호는 '-'를 포함해서 입력해주세요.");
			}
		}else {
			System.out.println("입력 오류입니다.");
		}
	}

