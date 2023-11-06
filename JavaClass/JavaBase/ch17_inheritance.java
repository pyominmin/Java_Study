상속
1.연습
//Is - A상속 : 모든 학생(자식)은 사람(부모)이다.
//----------------------------------------------------------------------------------//Human class
class Human{
	public Human(){
		System.out.println("1.부모 클래스 : 생성자");
	}
	public Human(String name, int age){
		mName = name;
		mAge = age;
		System.out.println("2.부모 클래스 : 생성자");
	}
	public Human(Human ref){//복사 생성자는 자신과 같은 타입을 만들어줘야 한다.
		mName = ref.mName;
		mAge = ref.mAge;
		System.out.println("3.부모 클래스 : 복사생성자");
	}
	//getter
	public String getName() {
		return mName;
	}
	public int getAge() {
		return mAge;
	}
	//setter
	public void setName(String name) {
		mName = name;
	}
	public void setAge(int age) {
		mAge =age;
	}
	
	
	//protected : 자신의 클래스 + 같은 패키지 + 상속된 클래스
	protected String mName = null;
	protected int mAge = 0;
}
//----------------------------------------------------------------------------------//Student class

class Student extends Human{//Human 클래스 상속
	public Student() {
		super();//부모 생성자 호출//무조건 호출 구문 넣어야 함//상속 받을 시 자식 클래스의 생성자에는 super();호출
		System.out.println("1.자식 클래스 : 생성자");
	}
	public Student(String name, int age, String no, String major) {
		super(name, age);//부모 생성자를 명시적으로 호출해야 한다. 호출하지 않을 시 1번 생성자만 호출된다.
		mStNo = no;
		mMajor = major;
		
		System.out.println("2.자식 클래스 : 생성자");
	}
	public Student(Student ref) {
		super(ref);//부모 생성자를 명사적으로 호출//참조형 변수 전달 시 무조건 복사 생성자가 받는다.
		mStNo = ref.mStNo;
		mMajor = ref.mMajor;
		System.out.println("3.자식 클래스 : 복사생성자");
	}
	
	//gatter
	public String getStNo() {
		return mStNo;
	}
	public String getMajor() {
		return mMajor;
	}
	
	//setter
	public void setStNo(String stNo) {
		mStNo = stNo;
	}
	public void setMajor(String major) {
		mMajor = major;
	}
	
	public void showStudentInfo() {
		//부모 클래스의 protected멤버는 자유롭게 접근 가능
		System.out.printf("이름 : %s(%d세) \n", mName, mAge);
		System.out.printf("학번 : %s\n", mStNo);
		System.out.printf("전공 : %s\n",mMajor);
	}
	
	private String mStNo = "00-0000-00";
	private String mMajor = null;
}

public class _01_Inheritance {

	public static void main(String[] args) {
		Student s1 = new Student();//인스턴스 생성 -> 생성자 호출
		Student s2 = new Student("홍길동", 17, "01-1234-55", "컴퓨터과학과");
		Student s3 = new Student(s2);
		
		s2.showStudentInfo();
		s3.showStudentInfo();
	}

}

2.연습

class Date{
	public Date() {
		
	}
	public Date(int year, int month, int day) {
		mYear = year;
		mMonth = month;
		mDay = day;
	}
	
	public Date(Date other) {
		//생성자에서 다른 생성자를 호출할 때 this로 호출할 수 있다.
		this(other.mYear, other.mMonth, other.mDay);//this를 이용한 생성자 호출
//		mYear = other.year;
//		mMonth = other.month;
//		mDay = other.day;
	}
	
	//getter
	public int getYear() {
		return mYear;
	}
	
	public int getMonth() {
		return mMonth;
	}
	public int getDay() {
		return mDay;
	}
	
	//setter
	public void setYear(int year) {
		mYear = year;
	}
	
	public void setMonth(int month) {
		mMonth = month;
	}
	
	public void setDay(int day) {
		mDay = day;
	}

	private int mYear = 1900, mMonth = 1, mDay = 1;
	//-----------------------------------------------------------------------//
}
	class Product extends Date{
		public Product() {
			super();
		}
		
		public Product(String name, String where, int price, int year, int month, int day) {
			super(year, month, day);
			this.mName = name;
			this.mWhere = where;
			this.mPrice = price;
		}
	
		public Product(Product ref) {
			super(ref);
			this.mName = ref.mName;
			this.mWhere = ref.mWhere;
			this.mPrice = ref.mPrice;
		}
		
		//getter
		public String getName() {
			return mName;
		}
		public String getWhere() {
			return mWhere;
		}
		public int getPrice() {
			return mPrice;
		}
		
		//setter
		public void setName(String name) {
			mName = name;
		}
		public void setWhere(String where) {
			mWhere = where;
		}
		public void setPrice(int price) {
			mPrice = price;
		}
		
		public void showProductInfo() {
			System.out.println("상품명: " + mName);
			System.out.println("제조사: " + mWhere);
			System.out.println("가격: " + mPrice + "원");
			System.out.println("제조일자: " + getYear() + "년 " + getMonth() + "월" + getDay() + "일");
			System.out.println("");
		}
		
		
		private String mName = null, mWhere = null;
		private int mPrice = 0;
	}
	
	


public class _02_product {

	public static void main(String[] args) {
		Product p1 = new Product("새우깡", "농심", 1200, 2008, 2, 4); //객체생성    
		Product p2 = new Product("먹태깡", "농심", 1800, 2012, 1, 14); //객체생성    
		Product p3 = new Product(p2); //객체생성    

		p1.showProductInfo();	    
		p2.showProductInfo();	    
		p3.showProductInfo();

	}

}
