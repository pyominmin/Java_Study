*IO 문자단위

1. FileReader(readLine)

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _08_FileReader {

	public static void main(String[] args) {
		//리소스 반환이 필요없다. close를 자동 호출
		try(FileReader fr = new FileReader("proverb.txt");//인스턴스를 여러개 생성 시 세미콜론으로 구분
				BufferedReader br = new BufferedReader(fr)){//창고에서 마트로 라면 카트로 이동//성능 향상
			//int ch;
			//while((ch = fr.read()) != -1) {//한 글자씩 반복해서 출력해주겠다.//먼저 읽어들이고 -1에 닿으면 나오겠다.
				
			String line;
			while((line = br.readLine()) != null){//행 단위로 읽기(엔터는 포함X)
				System.out.print("@");
				//System.out.print((char)ch);//글자 단위
				System.out.println(line);//행단위
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

2. FileWriter

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class _09_FileWriter {

	public static void main(String[] args) {
		//파일 기록 시 파일이 존재하지 않는 경우 파일을 생성해서 기록을 시작
		try (FileWriter fw = new FileWriter("output.txt");
				BufferedWriter bw = new BufferedWriter(fw)){
			
			String str = "FileWriter and BufferedWriter";
			bw.write(str);
			
			System.out.println("output.txt파일에 기록을 완료했습니다.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
2-1 FileWriter
