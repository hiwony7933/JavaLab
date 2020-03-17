package Design_AdapterPattern;

public class AdapterMain {

	public static void main(String[] args) {
		NewSystem newSystem = new NewSystem();
		newSystem.process(); 	// 새로 만들어진 메소드
		newSystem.legacyProcess();	// 이전에 만들어진 메소드
	}

}
