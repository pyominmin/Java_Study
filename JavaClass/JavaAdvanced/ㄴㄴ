
import java.util.ArrayList;
import java.util.Scanner;

public class _03_RemoveString {

	public static ArrayList<String> removeDuplicates(ArrayList<String>list) {
		ArrayList<String> unique = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			if(unique.contains(list.get(i)) == false){//contains : ArrayList에 객체가 존재하는 경우 true
				unique.add(list.get(i));//unique에 추가
			}
		}
		return unique;
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String>arr = new ArrayList<>();//ArrayList 생성
		
		System.out.println("문자열을 입력하세요. 종료하려면 빈 문자열을 입력하세요.");
		while(true) {
			System.out.print("문자열 입력 : ");
			String str = in.nextLine();
			arr.add(str);
			
			if(str.isEmpty()){//문자열이 비어있다면?? true
				break;
			}
		}
		
		in.close();

		System.out.println("ArrayList : " + arr);
		ArrayList<String> unique = removeDuplicates(arr);//중복된 문자열이 있는 경우 중복된 문자열을 제거 후 새로운 리스트 생성
		System.out.println("ArrayList(중복제거)" + unique);
	}

}
