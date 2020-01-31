package MUTual_EXclusion;
//Runnable : 스레드로 동작 할 수 있도록 해주는 인터페이스 

public class ThreadImpl implements Runnable {
	// 인덱스 변수와 합계를 저장할 변수
	private int idx;
	private int result;

	// result를 리턴하는 메소드
	public int getResult() {
		return result;
	}

	// idx 값을 1 씩 증가시키면서 result에 추가하는 메소드
	// 1000번 수행하는 메소드
	// 메소드 앞에 synchronized가 붙으면 멀티스레드 환경이더라도 메소드 수행이 종료될때까지는
	// 다른 작업은 수행할 수 없다. 
	private void sum() {	//스레드 두개이상일때 문제 해결은 synchronized 구문 추가 1
		for (int i = 0; i < 10000; i = i + 1) {
			synchronized(this) {	// 이블럭안에서  this(자기자신)의 요소를 사용하는 부분을 동기화
				idx = idx + 1;
				try {
					Thread.sleep(1);
				} catch (Exception e) {
				}
				result = result + idx;
			}
		}
	}

	// 스레드로 동작할 내용을 작성하는 메소드
	@Override
	public void run() {
		sum();

	}

}
