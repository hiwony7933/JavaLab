package I_Thread;

//class를 만드는 경우는 대부분 인스턴스를 2개 이상 만드는 경우

class Treadext extends Thread {
	public void run() {
		// 스레드 자신의 이름을 10번 출력(1초마다 쉬면서)
		for (int i = 0; i < 10; i = i + 1) {
			try {
				Thread.sleep(1000);
				System.out.println(getName());
			}
			// InterrupedException 이 발생 했을 때 Return 하도록 만들어주면 스레르다
			// 강제로 종료될수있다.
			catch (InterruptedException e) {
				return ;
			}
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		Treadext th1 = new Treadext();
		Treadext th2 = new Treadext();
		Treadext th3 = new Treadext();

//		th1.setPriority(Thread.MIN_PRIORITY);
//		th2.setPriority(Thread.NORM_PRIORITY);
//		th3.setPriority(Thread.MAX_PRIORITY);

		th1.start();
		th2.start();
		th3.start();
		
		
		// 스레드 강제종료
		try {
			Thread.sleep(3000);
			//th2 스레드에게 인터럽트 발생 (전화가 제일 강한 인터럽트)
			th2.interrupt();
		}catch(Exception e) {
			
		}
	}

}