package MUTual_EXclusion;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {

	public static void main(String[] args) {
			
		// 공유자원을 동시에 사용할 수 있는 스레드의 개수를 설정할수있는 클래스
		// 이 클래스를 이용하면 동시에 수행되는 스레드의 개수를 지정 가능

		// 동시에 3개까지 실행되는 세마포어 생성
		Semaphore sem = new Semaphore(3);
		for (int i = 0; i < 20; i = i + 1) {
			ThreadEx th = new ThreadEx(sem);
			th.start();
		}
	}
}
