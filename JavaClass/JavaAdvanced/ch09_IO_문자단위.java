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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _10_FileWriter {

	public static void main(String[] args) {
		
		try (FileWriter fw = new FileWriter("contens.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				Scanner in = new Scanner(System.in)){
			
			System.out.println("빈 문자열을 입력할 때까지 문자열을 입력하세요(엔터 두 번 입력 시 종료됩니다.)");
			String content;
			
			while(true) {
				content = in.nextLine();
				
				if(content.isEmpty()){
					break;
				}
				
				bw.write(content);
				bw.newLine();//bw.write("\n");
			}
			
			System.out.println("입력이 완료 됐습니다.\ncontens.txt 파일에 내용이 저장됩니다.");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}

3. split

public class _12_Split {

	public static void main(String[] args) {
		String num = "010-888-9999";
		
		String[] part = num.split("-");
		System.out.println("전화번호 앞자리" + part[0]);
		System.out.println("전화번호 가운데 자리" + part[1]);
		System.out.println("전화번호 뒷자리" + part[2]);
		
		String time = "09:12:34";
		String[] timePart = time.split(":");
		System.out.println(timePart[0] + "시 입니다.");
		System.out.println(timePart[2] + "초 입니다.");
	}

}


3-1.단어 개수세기

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _11_LineWordCount {

	private static int countwordLine(String line) {
		//문자열이 생성되지 않았거나 빈 문자열인 경우 개수는 0개
		if(line == null || line.isEmpty()) {
			return 0;
		}
		
		//String[] words = line.split(" ");//특정 기준으로 문자열을 구분
		//정규식을 이용한 구분
		String[] words = line.split("\\s+");// \s : 공백 문자열// 여러 칸 공백도 하나로 친다.
		return words.length;//배열의 크기를 리턴
	}

	public static void main(String[] args) {
		try (FileReader fr = new FileReader("proverb.txt");
				BufferedReader br = new BufferedReader(fr)){
			
			String line;
			
			//행 단위로 읽어 들여서 line에 저장
			while((line = br.readLine()) != null){ //파일의 끝이 아니라면?
				int wordCount = countwordLine(line); //한 문장에서 사용된 단어의 개수를 구하기
				System.out.println(line + "(단어 수 : " + wordCount + "개)");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
3-2 단어 찾기
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class _13_WordSearch {

	public static void main(String[] args) {
		try (FileReader fr = new FileReader("meaning.txt");
				BufferedReader br = new BufferedReader(fr);
				Scanner in = new Scanner(System.in)) {

			System.out.print("검색 할 영단어를 입력하세요 : ");
			String userInput = in.nextLine();

			boolean isSearch = false;
			String line;
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				// 공백 기준으로 나눌 때 최대 2개로
				String[] parts = line.split("\\s+", 2);

				// if(userInput == parts[0])//주소비교
				if (userInput.equals(parts[0])) {
					System.out.print("단어 : " + parts[0] + "=> 의미 : " + parts[1]);
					isSearch = true;
					break;
				}

			}

			if (!isSearch) {
				System.out.println("[" + userInput + "]에 대한 뜻은 찾을 수 없습니다.");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
