*FileInputStream

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _01_FileStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("pigs.txt");// IOException//pigs.txt를 입출력 송수신 하고 싶다.

			System.out.println("pigs.txt 파일과 연결했습니다.");
			int ch;
			while(true) {
			
				ch = fis.read();//1byte 읽어오는 메서드
				
				if(ch == -1) {//파일의 끝에 도달
					break;
				}
				System.out.print((char)ch);
			}
				
//				ch = fis.read();//1byte 읽어오는 메서드
//				System.out.println((char)ch);
//				
//				
//				ch = fis.read();//1byte 읽어오는 메서드
//				System.out.println((char)ch);
//				
//				
//				ch = fis.read();//1byte 읽어오는 메서드
//				System.out.println((char)ch);
//				
//				
//				ch = fis.read();//1byte 읽어오는 메서드
//				System.out.println((char)ch);
				System.out.println();
				
				fis.close();//사용했던 길을 끊어줘야 한다(반환)
				System.out.println("리소스를 반환합니다.");

		} //catch (FileNotFoundException e) {
		catch(IOException e) {
		//catch(Exception e) {//범위가 젤 넓다.
			// e.printStackTrace();//보안상의 이유로 메시지를 뿌려주는게 좋다.
			//System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}

}

1. 글자 수 세기

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _02_FileStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("pigs.txt");// IOException//pigs.txt를 입출력 송수신 하고 싶다.

			System.out.println("pigs.txt 파일과 연결했습니다.");
			int ch;
			int count = 0, lowerCount = 0, totalCount = 0, vowelCount = 0;

			// 1byte를 읽어와서 ch에 저장한 후, 그 값이 -1이 아니라면?? 반복!
			while ((ch = fis.read()) != -1) {// 한 글자 읽어와서 저장하는데, -1과 같지 않다면 출력
				System.out.print((char) ch);
				++totalCount;
				//if (ch >= 'A' && ch <= 'Z') {
				if(Character.isUpperCase(ch)) {//클래스명.메서드 => 정적멤버(static으로 선언된 멤버)만 가능하다.
					++count;
				}else if(Character.isLowerCase(ch)){
					++lowerCount;
				}
				//정규표현식
				//toString으로 문자를 얻어와서 "AEIOUaeiou"중에 한개라도 일치하면 true,아니라면 false
				if(Character.toString((char)ch).matches("[AEIOUaeiou]")) {
					++vowelCount;
				}
//				if ("aeiouAEIOU".indexOf(ch) != -1) {
//				    ++vowelCount;
//				}
				
			}

			System.out.println("\n대문자의 개수는" + count + "개 입니다.");
			System.out.println("소문자의 개수는" + lowerCount + "개 입니다.");
			System.out.println("모음의 개수는" + vowelCount + "개 입니다.");
			System.out.println("전체 문자의 개수는" + totalCount + "개 입니다.");
			

			fis.close();// 사용했던 길을 끊어줘야 한다(반환)
			System.out.println("리소스를 반환합니다.");

		} catch (IOException e) {

			System.out.println(e.toString());
		}
	}

}
2. 파일 복사하기

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class _03_FileCopy {

	public static void main(String[] args) {

		try {
			// 파일이 존재하지 않으면 읽어들일 수 없다.
			FileInputStream fis = new FileInputStream("img.jpg");// 인풋스트림

			// 파일이 존재하지 않으면 파일 생성 후 기록을 시작한다.
			FileOutputStream fos = new FileOutputStream("img(1).jpg");

			int data;
			while((data = fis.read()) != -1) { //byte읽어와서 저장
				fos.write(data);//1byte기록
			}
			
			System.out.println("파일 복사가 완료됐습니다.");
			fis.close();
			fos.close();

		} catch (FileNotFoundException e) {
			// System.out.println(e.toString());
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
3. 파일 복사하기 FileCopyBuffer


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class _04_FileCopyBuffer {

	public static void main(String[] args) {

		try {
			// 파일이 존재하지 않으면 읽어들일 수 없다.
			FileInputStream fis = new FileInputStream("img.jpg");// 인풋스트림

			// 파일이 존재하지 않으면 파일 생성 후 기록을 시작한다.
			FileOutputStream fos = new FileOutputStream("img(2).jpg");

			int byteLen;
			byte[] buffer = new byte[1024];
			//버퍼의 크기만큼 읽어와서 저장(읽어온 바이트를 리턴)
			while((byteLen = fis.read(buffer)) != -1) { //1024byte 읽어와서 저장
				//성능향상의 목적
				System.out.println("@");
				//write(byte[] b, int off, int len)
				//b에 저장된 내용 중에서 0번째부터 len개 기록
				fos.write(buffer, 0, byteLen);//1024byte기록
			}
			
			System.out.println("파일 복사가 완료됐습니다.");
			fis.close();
			fos.close();

		} catch (FileNotFoundException e) {
			// System.out.println(e.toString());
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

4.보조 스트림 생성
	
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class _04_FileCopyBuffer {

	public static void main(String[] args) {

		try {

			FileInputStream fis = new FileInputStream("img.jpg");
			FileOutputStream fos = new FileOutputStream("img(2).jpg");

			// 성능 향상을 위한 보조 스트림을 생성
			// 보조 스트림은 자체적으로 ㅇ비출력이 불가능하기 때문에 반드시 기반 클래스를 인수로 취한다.
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			int byteLen;
			byte[] buffer = new byte[8192];
			while ((byteLen = bis.read(buffer)) != -1) { // 1024byte 읽어와서 저장
				System.out.print("@");
				bos.write(buffer, 0, byteLen);// 1024byte기록
			}

			System.out.println("파일 복사가 완료됐습니다.");
			//보조 스트림 생성 시 기반 클래스는 닫을 필요가 없다.
			//보조 스트림에서 내부적으로 호출되기 때문이다.
			// fis.close();
			// fos.close();
			bis.close();
			bos.close();

		} catch (FileNotFoundException e) {
			// System.out.println(e.toString());
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

5. 예외발생


import java.io.FileInputStream;
import java.io.IOException;

public class _06_AutoClose {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		int n = 1;
		try {
			fis = new FileInputStream("pigs.txt");
			System.out.println("파일 스트림 연결 선공");
			
			System.out.println("@@@@@@@@@@");
			System.out.println("##########");
			System.out.println("**********");
			
			if(n == 1)
			throw new IOException("실습을 위해 예외를 강제적으로 발생!!!!");
			
			//fis.close();
			//System.out.println("리소스 반환 성공");
		}catch(IOException e) {
			System.out.println(e.getMessage());
			
		}finally {//예외가 발생하더라도 무조건 실행되는 명령
			try {
				fis.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			System.out.println("리소스 반환 성공");//리소스 반환은 무조건 이루어져야함
		}

	}

}

6. 대문자 변경하기


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class H1 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("pigs.txt");
			FileOutputStream fos = new FileOutputStream("change.txt");

			System.out.println("pigs.txt 파일과 연결했습니다.");
			int change;
			char ch;

			while ((change = fis.read()) != -1) {
				ch = (char)change;
				if (Character.isUpperCase(change)) {
					ch = '_';
				}
				System.out.print(ch);
				fos.write(ch);
			}

			fis.close();
			fos.close();
			System.out.println("리소스를 반환합니다.");

		} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

