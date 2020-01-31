package Data_Structure_Stack_Queue;

import java.util.*;

public class QueueTest {

	public static void main(String[] args) {
		
		// FIFO ( first In First Out) - 먼저 삽입된 데이터를 먼저 제거하는 자료구조
		// 자바에서는 인터페이스로 제공되고 여러 list 클래스에 구현되어 있음 
		// PriorityQueue 라는 우선순위 큐에도 구현되어 있습니다. (오름차순정렬, 정렬할필요가읍다)
		// 우선선위 큐는 우선순위에 따라 데이터를 정렬하고 있는 큐 이다. 
		// 데이터를 삽입하는 메소드는 add이고 데이터를 꺼내는 메소드는 peek와 poll
		// 용도는 스케쥴링에 주로 사용 
		// 입력받은 내용을 순서대로 실행하고자 할 때 Queue를 이용한다.(프린터기)

		// 우선 순위 큐 : 데이터를 크기 순서대로 접근 할 수 있도록 만든 큐
		// 내부적으로 데이터가 정렬된 것이 아니고 정렬된 순서대로 접근 할수있는이진 트리 생성
		PriorityQueue<String> pg = new PriorityQueue<>();
		pg.add("서울");
		pg.add("파주");
		pg.add("전주");
		pg.add("탄현");

		// 트리의 순회를 이용하지 않기 때문에 데이터가 정렬된 순서가 아닐수있음
		for (String temp : pg) {
			System.out.print(temp + "\t");
		}
		System.out.print("\n");
	
		// 데이터를 poll을 이용해서 1개씩 가져와서 출력
		// 트리의 순회를 이용하기 때문에 데이터가 정렬된 순서대로 출력
		for (int i = 0; i < 4; i = i + 1) {
			System.out.print(pg.poll() + "\t");
		}

		// 아래 구문은 쓰면 안된다.
		// 지우면서 가져올 때는 데이터의 개수나 인덱스가 변할수있으므로 주의
		// pg의 size가 변해버린다. for문 안에서 pg.poll() 이 진행되기 때문에
		// 정 쓰고 싶으면 for문 밖에서 변수를 지정해서
		// int len = pg.size()
		for (int i = 0; i < pg.size(); i = i + 1) {
			System.out.print(pg.poll() + "\t");
		}
	}

}
