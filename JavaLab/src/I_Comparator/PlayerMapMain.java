package I_Comparator;

import java.util.*;

public class PlayerMapMain {

	public static void main(String[] args) {
		// 번호, 이름, 타율을 저장하는 Vector 클래스의 인스턴스를 만들어서 데이터를 저장
		PlayerClass vector = new PlayerClass(1, "주원", 0.444);

		// 3개를 저장하는 Map을 인스턴스를 생성해서 데이터를 저장
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", 2);
		map.put("name", "해단");
		map.put("hitrate", 0.433);

		// 대부부 IDE에서 일반 인스턴스를 사용할 때 Code Sense가 동작
		// 하나의 속성을 가져올때는 클래스가 유용
		String name = vector.getName();
		name = (String) map.get("name"); // <-- map은 key를 기억해야 됨.. code Sense가 동작안함. 형변환도 직접입력, key도 직접입력

		// Map이 좋을 때는 언제냐 ~? 전체를 출력할때나 속성을 확장할때는 Map이 유리하다!
		// DTO 클래스의 인스턴스는 속성 확장이 안된다.
		// DTO 클래스의 인스턴스는 속성을 확장할려면 클래스 구조를 변경해야 합니다.
		// 맨처음 Table 설계해버리면 아무것도 추가 몬함.
		// map은 제한이 읍다. 추가하고싶으면 하고 ~
		// 하나하나씩 출력할때는 map이 더 쉽고, 유연하다
		map.put("homrun", 31);
		map.put("넹", "홈런 31개 쳤네 ");

		// DTO 클래스의 인스턴스는 각각의 데이터를 하나씩 출력해야 한다면 메소드를 일일이 호출 : 반복문 사용불가
		// map의 인스턴스 keyset()을 이용해서 반복문 출력 가능
		System.out.println(vector.getName());
		System.out.println(vector.getNum());
		System.out.println(vector.getHitrate());
		
		System.out.println("----------------------------------");

		// Map의 인스턴스는 keyset()을 이용해서 반복문으로 출력가능
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + "  " + map.get(key));
		}

	}

}
