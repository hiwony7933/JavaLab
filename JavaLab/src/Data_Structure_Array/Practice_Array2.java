package Data_Structure_Array;

public class Practice_Array2 {

	public static void main(String[] args) {
		String[] strAr = { "발렌수엘라", "클레멘테", "루게릭" };

		System.out.println(strAr[0]);	// 데이터 1개 출력 - 0번째 데이터 출력
		System.out.println("====================");

		// 데이터 전체 출력
		// 배열이름.length 는 배열의 데이터 개수를 정수로 리턴
		for (int i = 0; i < strAr.length; i = i + 1) {
			System.out.println(strAr[i]);
		}
		System.out.println("====================");

		String[] homerunHitters = new String[3];
		// 공간만 할당받은 배열에 데이터 채우기
		homerunHitters[0] = "김봉연";
		homerunHitters[1] = "이만수";
		homerunHitters[2] = "장성한";

		for (int i = 0; i < homerunHitters.length; i = i + 1) {
			System.out.println(homerunHitters[i]);
		}
		System.out.println("====================");
		
		// 참조형 내부 데이터를 기본형으로 저장하고 반복문 안에서 기본형의 데이터를 접근
		// 두번째 접근 부터 메모리 접근 회수가 줄어듬
		int len = homerunHitters.length;
		for (int i = 0; i < len; i = i + 1) {
			System.out.println(homerunHitters[i]);
		}
		System.out.println("====================");

		// 빠른 열거를 이용한 접근
		// 데이터의 시작과 끝을 직접 작성하지 않기 때문에 Index 오류를 일으키지 않게 된다.
		for (String temp : homerunHitters) {
			System.out.println(temp);
		}
	}
}
