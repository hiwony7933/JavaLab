package Design_ProducerConsumerPattern;

public class Producer extends Thread {

	private Product product;

	// 외부에서 인스턴스 주입받아서 객체를 생성하는 생성자
	public Producer(Product product) {
		this.product = product;
	}

	// 스레드로 동작하는 메소드는 한개는 있어야된다.
	public void run() {
		for (char i = 'A'; i <= 'Z'; i++) {
			product.put(i);
		}

	}

}
