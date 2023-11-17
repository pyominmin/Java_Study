*HashSet
  
import java.util.HashSet;

public class _01_HashSet {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		
		//요소 추가 시 중복 허용x
		hs.add(3);
		hs.add(4);
		hs.add(5);
		hs.add(6);
		hs.add(3);
		hs.add(4);
		hs.add(5);
		hs.add(6);
		
		hs.remove(5);//인덱스 삭제는 불가능하고, 값(벨류) 삭제는 가능하다.
		
		System.out.println("HashSet : " + hs);
		
		if (hs.contains(5)) {
			System.out.println("5는 HashSet에 포함된 값입니다.");
		}else {
			System.out.println("5는 HashSet에 포함된 값이 아닙니다.");
		}
		

	}

}

1. 연습문제 로또 번호
import java.util.HashSet;
import java.util.Random;

public class _02_GenerateLottoNumber {

	public static void generatorLottoNum(HashSet<Integer> hs) {
		
		Random rad = new Random();//난수 인스턴스 생성
		while(hs.size() < 6) {
			int num = rad.nextInt(45) + 1;//1 ~ 45사이의 랜덤 값 저장
			//음수가 아닌 45보다 작은 값을 리턴
			hs.add(num);//중복된 값인 경우 HashSet에 추가되지 않는다.
		}
	}
	
	public static void main(String[] args) {
		//중복되지 않으려면 HashSet 자료구조 이용
		
		//로또 번호의 개수 만큼 HashSet의 크기 설정
		HashSet<Integer> hs = new HashSet<>(6);
		
		generatorLottoNum(hs);//로또번호 추출기
		
		System.out.println("이번 주 로또 번호 : " + hs);
	}

}

2. 빙고판

import java.util.HashSet;
import java.util.Random;

public class _03_GeneratorBingo {

	private static void displayBingoBoard(int[][] bingo) {
		System.out.println("\n\t*빙고판 출력*");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(bingo[i][j] + "\t");
				
			}
			System.out.println();
		}
	}

	private static void generatorBingoBoard(int[][] bingo) {
		HashSet<Integer> hs = new HashSet<>();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				boolean isAdd;
				int rad;
				do {
				rad = random.nextInt(50) + 1 ;//1 ~ 50
				isAdd = hs.add(rad);//추가//add 메서드는 boolean형이다.
				}while(!isAdd);//(isAdd == false);
				
				bingo[i][j] = rad;//중복되지 않은 값인 경우? 2차원 배열에 추가
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] bingo = new int [5][5];
			
		generatorBingoBoard(bingo);
		displayBingoBoard(bingo);

	}

}
