package I_Thread;

// 하나의 파일에 클래스를 2개 만든다면
// public class는 1개이어야 하고 파일이름은 public class의 이름이여야 한다. 
// Runnable 인터페이스를 implements 한 클래스
class RunnableImpl implements Runnable {
	// 스레드로 수행할 내용을 가지는 메소드
	public void run() {
	}
}

public class OnefileThread {

	public static void main(String[] args) {
		RunnableImpl r1 = new RunnableImpl();

		// r1 과 r2는 같은 기능임.
		Runnable r2 = new Runnable() {
			public void run() {
				// Hello Runnable 을 1초마다 5번 출력
				try {
					for (int i = 0; i < 5; i = i + 1) {
						Thread.sleep(1000);
						System.out.println("Hello Runnable");
					}
				} catch (Exception e) {
					System.out.println("스레드예외" + e.getMessage());
				}
			}
		};

		// Thread 클래스의 인스턴스를 생성
		Thread th = new Thread(r2);
		// r2의 run 메소드를 스레드로 수행
		th.start();

		
		
		Thread th1 = new Thread() {
			public void run() {
				// Hello Thread 을 1초마다 5번 출력
				try {
					for (int i = 0; i < 5; i = i + 1) {
						Thread.sleep(1000);
						System.out.println("Hello Thread");
					}
				} catch (Exception e) {
					System.out.println("스레드예외" + e.getMessage());
				}

			}
		};
		// 스레드로부터 상속을 받은 경우에는 start로 바로 호출 가능
		th1.start();

	}

}
