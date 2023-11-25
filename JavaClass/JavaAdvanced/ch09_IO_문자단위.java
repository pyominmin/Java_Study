*IO 문자단위

1. readLine

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _08_FileReader {

	public static void main(String[] args) {
		//리소스 반환이 필요없다. close를 자동 호출
		try(FileReader fr = new FileReader("proverb.txt");
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

