package ComparatorAnonymous;

import java.util.ArrayList;
import java.util.Comparator;

public class ListSortMain {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("SKT");
		list.add("LGU+");
		list.add("KT");
		list.add("채용공고");

		// Comparator 인터페이스를 implements 한 클래스의 인스턴스를 만들어서 정렬
		StringComp comp = new StringComp();

		// 데이터 정렬 - Comparator를 매개변수로 요구
		// Comparator가 인터페이스 므로 new Comparator를 할수 없다.
		// Comparator를 implement 한 class 생성
		list.sort(comp);

		// Comparator의 Anonymous Class 만들기
		// 클래스 없이 Comparator 인터페이스를 구현하는 클래스의 인스턴스를 바로 만들기
		// 이 문법의 확장인 람다가 자바의 함수형 프로그래밍을 지원
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o2);
			}
		};
		list.sort(c);

		// 데이터 출력
		for (String temp : list) {
			System.out.print(temp + '\t');
		}

	}

}
