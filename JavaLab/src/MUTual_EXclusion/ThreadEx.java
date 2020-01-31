package MUTual_EXclusion;

import java.util.concurrent.Semaphore;

public class ThreadEx extends Thread {

	// 세마포어 변수
	private Semaphore sem;

	// 외부에서 Semaphore를 주입받습니다.
	public ThreadEx(Semaphore sem) {
		this.sem = sem;
	}

	// acquire() : 공유자원에 Lock을 설정하는 메소드, 이 메소드가 호출되면 공유자원 개수가 1개 줄어듭니다.
	// release() : 공유자원에 Lock을 해제하는 메소드, 이 메소드가 호출되면 공유자원 개수가 1개 늘어납니다.
	// Semaphore 클래스의 인스턴스를 스레드 외부에서 생성
	// Semaphore 인스턴스를 스레드에게 전달해서 공유자원을 사용하는 부분에서 이용

	public void run() {

		try {
			// lock을 취득 - 사용 개수가 1개 줄어듬
			sem.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("몬스터 생성");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		System.out.println("몬스터 소멸");
		// lock을 해제 - 사용 개수가 1개 늘어남
		sem.release();
	}
}
