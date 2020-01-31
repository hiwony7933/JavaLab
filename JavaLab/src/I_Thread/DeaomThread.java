package I_Thread;

public class DeaomThread {

	public static void main(String[] args) {
		Thread th = new Thread() {
			public void run() {
				try {
					for (int i = 0; i < 10; i = i + 1) {
						Thread.sleep(1000);
						System.out.println("데몬스레드");
					}
				} catch (Exception e) {
				}
			}
		};
		// th를 데몬으로 설정 - 다른 작업이 없으면 자동으로 종료
		// 프로그램에서는 데몬 스레드가 더 많이 사용됩니다. 
		// start 하기 전에 데몬으로 설정 
		th.setDaemon(true);
		th.start();

		try {
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("메인종료");
	}

}
