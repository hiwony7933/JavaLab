package MUTual_EXclusion;

public class MutexMain {

	public static void main(String[] args) {
		// Runnable 인터페이스를 implements 한 클래스의 인스턴스 생성
		ThreadImpl threadImpl = new ThreadImpl();

		// Thread 클래스의 생성자에 대입해서 Thread 인스턴스 생성
		Thread th1 = new Thread(threadImpl);
		Thread th2 = new Thread(threadImpl); // 스레드가 두개이상일때 문제 발생 예제1

		// 스레드 시작 - 스레드는 기본적으로 비동기임
		th1.start();
		th2.start(); // 스레드가 두개이상일때 문제 발생 예제 (1000번씩 더하는걸 두번할때 출력값이다르다)1

		// 위 구문대로 순서대로 시작하면 동기
		// 순서대로 시작않하고 쉬는시간이 조금이라도 나오면 다음구문시작 (AJAX 에이작스라고 한다)

		try { 	// 스레드의 수행이 끝나면 결과를 출력
			Thread.sleep(35000); // 최소 10초정도는 쉬라고 해야됨
			System.out.println(threadImpl.getResult());
		} catch (Exception e) {
		}

	}

}
