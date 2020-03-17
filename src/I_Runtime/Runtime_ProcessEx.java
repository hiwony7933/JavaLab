package I_Runtime;

import java.io.IOException;

public class Runtime_ProcessEx {

	public static void main(String[] args) {
		
		// 프로세스 실행과 관련된 클래스
		// 생성자가 없는 클래스인데 메소드들은 static과 static이 아닌 메소드가 같이 존재(섞여 있다)
		// 이런클래스는 디자인 패턴을 적용해서 인스턴스를 만드는 방법을 별도로 제공

		// TEST - Runtime 클래스의 인스턴스 2개 생성
		Runtime r1 = Runtime.getRuntime();
		Runtime r2 = Runtime.getRuntime();

		// 해시코드가 동일하게 출력 - Runtime은 인스턴스를 1개만 만들 수 있는 클래스
		// 생성하는 메소드를 여러 번 호출해도 하나만 가지고 작업 - Singleton 패턴 (한개의 출입문)

		System.out.println("r1:" + System.identityHashCode(r1));
		System.out.println("r2:" + System.identityHashCode(r2));
		// TEST 종료

		// 메모장 실행
		try {
			r1.exec("notepad.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
