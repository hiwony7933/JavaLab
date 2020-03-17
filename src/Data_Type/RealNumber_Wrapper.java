package Data_Type;

import java.math.BigDecimal;

public class RealNumber_Wrapper {

	public static void main(String[] args) {
		// 기본형 정수 데이터를 참조형 Integer로 생성
		Integer i = new Integer(100);
		i = 300; // AutoBoxing (기본형 데이터를 참조형으로 자동 변환해주는 문법)

		// 기본형을 참조형으로 표현할 수 있기 때문에 Object 클래스 변수에는 모든 데이터를 대입가능
		Object obj = 300;
		// Obj 는 Integer를 저장하기는 했지만 변수의 자료형이 Object 라서
		// object 것만 사용가능함.
		// 원래 자료형에 있던 intValue() 를 사용 못함.
		// 원래 자료형에 있던 것들을 사용할려면 강제로 원래 자료형으로 변환시켜야 함.
		System.out.println(((Integer) obj).intValue());
		System.out.println();
		
		// 실수 연산에 문제점 발생
		double d1 = 1.600000000000000000000000000000000000000;
		double d2 = 0.100000000000000000000000000000000000000;
		System.out.println(d1 + d2); 	// 실수는 +- 로 연산하면 누락이 발생한다.
		System.out.println();
		
		// 실수 연산 문제 해결하기
		BigDecimal b1 = new BigDecimal("1.6000000000000000000000000000000");
		BigDecimal b2 = new BigDecimal("0.1000000000000000000000000000000");
		
		System.out.println(b1.add(b2));		// add를 통해서 연산한다.
		System.out.println();
		
		// 더하기 - add
		// 빼기 - subtract
		// 곱하기 - multiply
		// 나누기 - divide

		// 프로그래밍 언어와 데이터베이스를 연동하는 경우
		// 대부분의 경우 데이터베이스가 더 정밀한 숫자를 저장하는 경우가 많다.
		// 데이터베이스에 실수를 저장했을 때는 float이나 Double로 받는 것보다는
		// BigDeimal 같은 클래스를 이용해서 자정하고 연산한 후 결과를 float이나 double로 표현하는 것이 좋다.

		// 운영체제 버전과 자바버전을 확인
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.version"));

	}

}
