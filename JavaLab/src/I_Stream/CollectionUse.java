package I_Stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class CollectionUse {

	public static void main(String[] args) {
		// List의 데이터를 사용
		// 배열을 이용해서 lIST만들기
		List<String> list = Arrays.asList("C", "Python", "Java");

		// 인덱스를 이용해서 하나씩 접근 - 배열이나 List의 데이터 개수를 알아야 합니다.
		System.out.println();
		System.out.println("데이터를 인덱스를 이용해서 하나씩 접근");
		int length = list.size();
		int i = 0;
		// for보다 while이 좋다.
		// for은 집단으로 접근하는게 좋다.
		while (i < length) {
			String temp = list.get(i);
			System.out.println(temp);
			i++;
		}

		System.out.println();
		System.out.println("반복자(Iterator - Enumeration : __iter__:python)을 이용해서 하나씩 접근");
		// 반복자는 데이터 개수를 알 필요가 없습니다.
		Iterator<String> iterator = list.iterator();
		// 다음 데이터 존재 여부를 확인하고 다음 데이터에 접근 - 데이터베이스에서는 Cursor라고 합니다.
		// 데이터베이스나 c++에서는 이런 방법으로 접근을 하지만 Java나 Python같은 언어는 다른 방법을 제공
		// 간경해졌고 길이를 알 필요없다.
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println();
		System.out.println("빠른 열거 (for-each)를 이용하는 방법");
		// 반복자가 구현된 객체의 경우는 빠른 열거를 사용하는 것이 가능
		// 예약어만 다른것이지 접근 방법은 똑 같다.
		for (String temp : list) {
			System.out.println(temp);
		}

		System.out.println();
		System.out.println("스트림을 이용하는 방법");
		// 스트림 생성
		Stream<String> stream = list.stream();
		// 람다식을 이용해서 메소드의 내용을 매개변수로 대입 - 함수형 프로그래밍
		// 스트림을 만들때 사용한 Collection의 데이터를 name에 순서대로 대입해서 {}안의 내용을 수행
		// 반복문을 사용하지 않아도 forEach가 알아서 순서대로 실행
		// python에서의 numpy의 ndarray나 pandas의 Series, DataFrame등의 동작방식에 이와 동일
		stream.forEach((name) -> {
			System.out.println(name);
		});
	}

}
