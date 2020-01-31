package I_Thread;

public class ThreadMain {

	public static void main(String[] args) {

		// ThreadEx 익스턴스 2개를 생성
		ThreadEx th1 = new ThreadEx();
		ThreadEx th2 = new ThreadEx();

		// 일반적인 메소드 호출 : 하나의 메소드 수행이 종료되고 다른 메소드를 수행
		// th1.run();
		// th2.run();

		// 스레드로 실행 : 하나의 스레드가 쉬는 시간이 생기면 다른 스레드의 작업을 처리
		// 처리하는 시간이 짧아져서 동시에 처리하는것처럼 보임
		th1.start();
		th2.start();
		
		
	}

}
