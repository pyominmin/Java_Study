for문
for(초기값; 조건; 증가/감소값){
  명령문;
}

ex. 1부터 100까지 출력하시오

public class GitHub_for {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 100; i++) {
		System.out.printf("%4d", i);
		}
	}  

for문을 이용한 예시
1.
public class GitHub_for {

	public static void main(String[] args) {
		
		for(int i = 10; i >=0; i--) {
		System.out.printf("%-5d", i);//5자리 공간 확보 후 왼쪽(-)부터 기록
		}
    System.out.println("\n\ni = " + i);
	}  

2.
public class GitHub_for {

	public static void main(String[] args) {
		
		for(int i = 10; i >= 0; i--) {
		System.out.print(i + " ");
		}

3.
public class GitHub_for {

	public static void main(String[] args) {
		
		for(int i = 100; i>=0; i -= 10) {
			System.out.print(i + " ");
		}
    System.out.println("\n\ni = " + i);
	}  

4.
public class GitHub_for {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 91; i += 10) {
			System.out.printf("%d ~ %d\n", i, i + 9);
		}
    
	}  

5.
public class GitHub_for {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 9; i++) {
			System.out.printf("2 * %d = %d\n", i, 2 * i );
		}
    
	}  

6.
public class GitHub_for {

	public static void main(String[] args) {
		
		int sum = 0;//쓰레기 값에 i를 더할 수 없어 초기값 설정
		for(int i = 100; i<= 500; i++) {
			sum += i;
		} System.out.println(sum);
    
	}  

7.
public class GitHub_for {

	public static void main(String[] args) {
		
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
			System.out.print(sum);
    
	}  

8.
public class GitHub_for {

	public static void main(String[] args) {
		
		int count = 0;
		for(int i = 100; i <= 200; i+= 4) {
			++count;//개수는 1씩 증가
		}
		System.out.print(count);
    
	}  
}





