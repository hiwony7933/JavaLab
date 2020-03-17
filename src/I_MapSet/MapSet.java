package I_MapSet;

import java.util.*;

public class MapSet {

	public static void main(String[] args) {

		// key 와 value를 쌍으로 저장하는 자료구조
		// key는 중복될 수 없지만 Value는 중복되거나 null 일수 있다.
		// 미지정 자료형이 2개라서 인스턴스를 생성 할때 key와 value 자료형 2개를 설정해야 한다.
		// key는 특별한 경우가 아니라면 String -> 여러 종류의 데이터를 하나로 묶기 위한 용도로 주로 이용
		// Map은 Key를 무한정 추가시킬 수 있습니다.
		// 주의 : DTO 클래스는 클래스를 만들 때 사용한 필드를 제외하고는 확장이 안됩니다.

		// Map 구현 클래스
		// 1)HashMap(Hashtable) : key를 해싱에 의해서 저장하기 때문에 Key의 순서를 알수 없다.
		// 2)LinkedHashMap : key가 데이터를 저장한 순서대로 배치
		// 3)TreeMap : Key가 compareTo 메소드를 이용해서 비교한 후 크기 순서대로 배치

		// 3. 데이터 관련 메소드
		// void put(key, value):key값에 value를 저장, 동일한 key 이름을 입력하면 수정
		// Object get(key) : key에 해당하는 값 리턴, key가 없으면 null 리턴
		// 					리턴되는 데이터가 Object라서 출력하는 것이 아니고 사용할 거라면 저장할 때의 자료형으로 강제 형 변환해서 사용
		// Object remove(key) : key에 해당하는 데이터 삭제

		// Map 인스턴스 생성
		HashMap<String, Object> map = new HashMap<String, Object>();

		// 데이터 저장
		map.put("baseball", "야구");
		map.put("soccer", "축구");
		map.put("volleyball", "배구");

		// 데이터가져오기 - 출력만 할 때는 강제 형 변환이 필요없지만 다른 용도로 사용할 때는 강제 형변환을 해서 가져옵니다.
		String obj = (String) map.get("soccer");
		System.out.println("데이터가져오기 : " + obj.toUpperCase());

		// 없는 key값 가져오기 - 언어마다 다름
		Object value = map.get("basketball");
		System.out.println("없는 key값 가져오기 : " + value);

		// 동일한 key에 데이터를 삽입하면 업데이트 됨 
		map.put("soccer", "발로하는축구");
		obj = (String) map.get("soccer");
		System.out.println("데이터가져오기 : " + obj.toUpperCase());
		System.out.println();

		// Map의 모든 데이터를 출력 - key의 이름을 사용하지 않음
		// 모든 key의 값을 가져오기
		Set<String> keys = map.keySet();
		
		// Set을 순회 - 중요
		for (String key : keys) {
			System.out.println(key + " - " + map.get(key));
		}
		System.out.println();
		
		
		// set
		// Set 인스턴스 생성 - HashShet, LinkedHashSet, TreeSet 으로 변경하면서 확인
		Set<Integer> set = new TreeSet<Integer>();
		// Set에 데이터 추가 
		set.add(400);
		set.add(200);
		set.add(300);
		set.add(100);
		
		// 데이터 전부 출력
		for(Integer temp : set) {
			System.out.println(temp);
		}
		
	}

}
