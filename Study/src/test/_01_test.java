package test;

public class _01_test {

	public static void main(String[] args) {
		int radius = 5; //반지름
		final double PI = 3.141592;
		double area, round;
		
		area = PI *radius *radius; //pi * r ^ 2
		round = 2 * PI * radius; //2 * pi * r
		
		System.out.printf("반지름 %d의 원의 넓이는 %.3f입니다.\n", radius, area);

	}

}
