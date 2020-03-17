package Design_ProducerConsumerPattern;

public class Main {

	public static void main(String[] args) {
		// 공유 자원 생성
		Product product = new Product();

		// Thread 클래스를 상속받은 클래스와 인스턴스를 만들고 스레드로 동작
		Customer customer = new Customer(product);
		Producer producer = new Producer(product);

		customer.start();
		producer.start();

	}

}
