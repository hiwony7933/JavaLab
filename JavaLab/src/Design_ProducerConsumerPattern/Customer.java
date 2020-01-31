package Design_ProducerConsumerPattern;

public class Customer extends Thread {
	// 공유 자원 변수 
	private Product product;
	
	// 외부에서 주입받는 생성자
	public Customer(Product product) {
		this.product = product;
	}
	
	public void run() {
		for(int i =0; i <26; i=i+1) {
			product.get();
		}
	}

}
