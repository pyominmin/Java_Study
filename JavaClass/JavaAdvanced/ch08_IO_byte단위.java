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

