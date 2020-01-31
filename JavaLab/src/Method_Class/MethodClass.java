package Method_Class;

public class MethodClass {
	// 매개 변수가 없고 리턴 타입이 void 메소드
	public void disp() {
		// 메소드의 내용
		for (int i = 0; i < 3; i = i + 1) {
			System.out.println("Hello");
		}
		System.out.println("--------------");
	}

	// 매개 변수가 정수1개이고 리턴 타입이 void 메소드
	// 이 메소드는 호출할려면 반드시 정구 1개를 넘겨주어야 한다.
	// 동일한 이름의 Method가 하나의 Class에 존재하는 경우 Method Overloading
	public void disp(int n) {
		// 메소드의 내용
		for (int i = 0; i < n; i = i + 1) {
			System.out.println("Hi");
		}
		System.out.println("--------------");
	}

	//////////////////////////////////////////////////////////

	// 정수 1개를 매개변수로 받아서 1증가 시키고 출력하는 메소드 : call by value
	public void inc(int n) {
		n = n + 1;
		System.out.println("n : " + n);
		System.out.println("--------------");
	}

	// 배열 1개를 매개변수로 받아서 첫 번째 데이터를 1감소시키고 출력하는 메소드 : call by reference
	public void dec(int[] ar) {
		ar[0] = ar[0] - 1;
		System.out.println("ar[0] : " + ar[0]);
		System.out.println("--------------");
	}

	////////////////////////////////////////////////////////////

	// 정수 데이터가 몇개가 오던지 합계를 구해서 출력해주는 메소드
	public void sum(int... ar) {
		// ... 이름을 이용하면 내부에서는 배열로 취급
		int sum = 0;
		// 배열의 모든 데이터를 순서대로 접근해서 sum에 추가
		for (int data : ar) {
			sum = sum + data;
		}
		System.out.println("합계 : " + sum);
		System.out.println("--------------");
	}

	////////////////////////////////////////////////////////////
	// 2개의 정수를 매개변수로 받아서 더한 후 결과를 출력하는 메소드
	public void addDisplay(int a, int b) {
		System.out.println("a+b : " + (a + b));
		System.out.println("--------------");
	}

	//////////////////////////////////////////////////////////////
	// 2개의 정수를 매개변수로 받아서 더한 후 결과를 리턴하는 메소드
	// 메소드 이름 앞의 자료형과 return 하는 데이터의 자료형은 일치해야 합니다.
	public int addReturn(int a, int b) {
		return (a + b);
		
	}

}
