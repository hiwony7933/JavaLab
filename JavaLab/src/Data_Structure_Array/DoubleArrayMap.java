package Data_Structure_Array;

import java.util.*;

public class DoubleArrayMap {

	public static void main(String[] args) {

		ArrayList<String> kia = new ArrayList<String>();
		kia.add("최최최");
		kia.add("주주주");
		kia.add("류류류");

		ArrayList<String> dusan = new ArrayList<String>();
		dusan.add("가가가");
		dusan.add("카카카");
		dusan.add("카카");

		ArrayList<String> hanhwa = new ArrayList<String>();
		hanhwa.add("가가");
		hanhwa.add("카카");
		hanhwa.add("카");

		// 팀별 명당은 다시 List로 만들기
		ArrayList<ArrayList<String>> players = new ArrayList<ArrayList<String>>();

		// 팀이 추가되는 경우 팀 이름을 출력하기 위해서 출력하는 로직을 수정
		players.add(kia);
		players.add(dusan);
		players.add(hanhwa);

		// 데이터 출력하기
		for (int i = 0; i < players.size(); i = i + 1) {
			if (i == 0) {
				System.out.print("기아 : ");
			} else {
				System.out.print("두산 : ");
			}

			ArrayList<String> imsi = players.get(i); // imsi 의 데이터를 하나씩 temp 에 대입
			for (String temp : imsi) {
				System.out.print(temp + "\t"); // 선수는 추가해도 괜차늠.
			}
			System.out.println(" ");
		}
		System.out.println("---------------------------------------");

		// 앞에서의 문제는 list의 list를 만들때 각 list의 특징을 같이 저장하지 못한다는데 있습니다.
		// 팀이름은 문자열이고 팀의선수명단은 배열이라서 같이 list에 저장을 못한다. (동일한데이터만저장가능함)
		// 이 부분을 map이나 Class로 해결해야 한다.

		// List 와 팀이름을 갖는 Map을 생성
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("Team", "기아");
		map1.put("player", kia);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("Team", "두산");
		map2.put("player", dusan);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("Team", "한화");
		map3.put("player", hanhwa);

		// Map의 List를 생성
		ArrayList<Map<String, Object>> kbo = new ArrayList<Map<String, Object>>();
		kbo.add(map1);
		kbo.add(map2);
		kbo.add(map3);

		// 출력하는 부분
		for (Map<String, Object> map : kbo) {
			System.out.print(map.get("Team") + " : ");
			
			ArrayList<String> p = (ArrayList<String>) map.get("player");
			
			for (String temp : p) {
				System.out.print(temp + "\t");
			}
			System.out.println("");
		}

	}

}
