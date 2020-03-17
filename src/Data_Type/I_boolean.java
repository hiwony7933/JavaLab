package Data_Type;

public class I_boolean {

	public static void main(String[] args) {

		int x = 10;
		boolean result = x % 4 == 0;	//x 가 4의 배수인지 판별
		System.out.println("result : " + result);		

		int a1 = 10;
		boolean result1 = a1 > 5 && (a1++ > 10);
		System.out.println("결과 : " + result1);
		System.out.println("a : " + a1);
		
		// 윤년인지 판별 -> 윤년은 4의 배수이고 100의 배수가 아닌 경우 또는 400의 배수인경우
		int year = 2020 ;
		result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		System.out.println("result : " + result);
	}
}
