package Method_Class;

public class MethodMain {

	public static void main(String[] args) {
		// MethodClass의 인스턴스를 생성
		MethodClass obj = new MethodClass();
		// 메소드 호출
		obj.disp();
		System.out.println("hello java");
		System.out.println("--------------");

		// Method 호출
		obj.disp();

		// 매개변수가 있는 메소드 호출
		obj.disp(3);
		obj.disp(5);

		int x = 100;
		int[] br = { 100, 300, 400, 200 };
		obj.inc(x);
		// x의 값은 직접 호출해서 변경하지 않는 이상 절대로 변경 안됨
		System.out.println("x : " + x);
		System.out.println("--------------");

		obj.dec(br);
		// 참조형의 경우 메소드의 매개변수로 대입되면 데이터가 변경되어 있을수있음
		System.out.println("br[0] : " + br[0]);
		System.out.println("--------------");

		obj.sum(10, 30);
		obj.sum(20, 30, 10, 20);

		obj.addDisplay(100, 200);

		// return 이 있는 메소드
		// 메소드의 수행 결과를 r에 저장
		// 이전 작업 결과를 가지고 다음 작업을 수행 (작업을 이어갈수있다)

		int r = obj.addReturn(200, 300);
		System.out.println("결과:" + r);

		r = obj.addReturn(r, 700);
		System.out.println("결과:" + r);

		r = obj.addReturn(300, obj.addReturn(300, 700)); // return 값이 메소드는 다른 메소드의 매개변수가 될수 있다.
		System.out.println("결과:" + r);
	}
}
