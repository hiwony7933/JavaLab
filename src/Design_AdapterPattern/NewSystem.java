package Design_AdapterPattern;

public class NewSystem extends OldSystem implements Target { // implements Target 추가 해서
	@Override
	public void process() {
		// 구현된 메소드의 오버라이딩 : 상위 클래스의 메소드를 호출하고 기능을 추가
		/*
		  super.process(); System.out.print("Sequence add");
		 */
		System.out.println("New Sequence");
	}
	@Override
	public void legacyProcess() {
		super.process();
	}
}
