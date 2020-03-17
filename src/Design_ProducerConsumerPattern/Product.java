package Design_ProducerConsumerPattern;

import java.util.ArrayList;
import java.util.List;

//공유 자원을 소유할 클래스
public class Product {
	// 공유자원 변수
	private List<Character> list;

	// 생성자 - list를 초기화
	public Product() {
		list = new ArrayList<Character>();

	}

	// 데이터 1개를 받아서 저장하는 메소드
	// synchronized 가 붙지 않으면 jvm이 모니터링을 하지 않기 때문에 신호를 보낼 수 없습니다.
	public synchronized void put(Character ch) {
		if (list.size() > 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(ch);
		// 다른쪽에 Wait가 있으면 다른쪽에는 notify가 꼭 있어야됨.
		// notify로 순서를 잡아줘야됨.
		// 데이터 추가후 신호를 보내미
		notify();

		System.out.println(ch + "가 입고되었습니다.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.println("입고 후 현재수량 : " + list.size());
	}

	// 데이터 1개를 꺼내서 출력하는 메소드
	public synchronized void get() {
		if (list.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 첫번째 데이터를 삭제하고 리턴
		Character ch = list.remove(0);
		notify();
		System.out.println(ch + "가 출고되었습니다.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.println("출고 후 현재수량 : " + list.size());
	}
}
