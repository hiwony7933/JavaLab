package Method_Class;

public class SampleMain {

	public static void main(String[] args) {
		// SampleClass 의 인스턴스 만들기
		// new SampleClass()가 인스턴스를 만드는데
		// 위의 구문은 수행을 하고 인스턴스의 참조를 리턴합니다.
		// 이 인스턴스를 재사용할려면 인스턴스의 참조를 동일한 자료형의 변수에 대입을 해야함니다.
		SampleClass obj = new SampleClass();

		// final 변수는 생성과 동시에 값을 할당
		// 값을 변경할 수 없기 때문입니다.
		// final 변수의 이름은 모두 대문자로 만드는 것이 관례
		final int TEN = 10;
		// TEN = 11; // 이문장은 에러

		// smapleClass의 인스턴스를 2개 생성
		SampleClass ob1 = new SampleClass();
		SampleClass ob2 = new SampleClass();

		// 인스턴스 변수에 값 대입
		ob1.name = "첫번째 인스턴스";
		ob2.name = "두번째 인스턴스";
		// static이 붙지 않은 멤버는 클래스는 호출 할 수 없습니다.
		// SampleClass.name은 안됨

		// 인스턴스 변수의 값 출력 - 인스턴스 변수는 각각 소유하기 때문에 서로 다른 값 출력
		System.out.println(ob1.name);
		System.out.println(ob2.name);

		// static 변수에 값 대입
		// 클래스와 인스턴스 모두 접근 가능
		ob1.share = 100;
		SampleClass.share = 200;
		// static 변수는 하나만 만들어서 공유
		// 출력 을 해보면 동일한 값을 출력
		System.out.println(ob1.share);
		System.out.println(ob1.share);
		System.out.println(SampleClass.share);
	}
}
