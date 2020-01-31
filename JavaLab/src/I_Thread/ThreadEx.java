package I_Thread;

public class ThreadEx extends Thread {
	
	public void run() {
		// 1 초마다 Hello Thread 문자열을 10번 출력
		for(int i = 0; i <10; i=i+1) {
			System.out.println("Hello Thread");
			try {
				// 현재 스레드 1초대기 
				Thread.sleep(1000);		// 항상 try, catch가 같이 다녀야됨. 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
