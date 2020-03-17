package I_Lambda;

public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i = i + 1) {
				Thread.sleep(1000);
				System.out.println("클래스를 만들어서 사용");
			}
		} catch (Exception e) {
			System.out.println("예외" + e.getMessage());
			e.printStackTrace();
		}
	}

}
