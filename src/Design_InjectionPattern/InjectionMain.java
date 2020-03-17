package Design_InjectionPattern;

public class InjectionMain {

	public static void main(String[] args) {
		Injection injection = new Injection("JavaScript");
		injection.setDiff2("Spring");

		injection.disp();

		// setDiff2를 호출하지 않았기 때문에 diff2가 null인 상태에서 toUpperCase를 호출해서 예외
		injection = new Injection("FrontEnd");
		injection.disp();

	}

}
