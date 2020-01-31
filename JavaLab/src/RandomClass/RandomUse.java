package RandomClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUse {

	public static void main(String[] args) {

		Random r1 = new Random(); // seed 설정없이 랜덤 인스턴스 생성 - seed가 현재 시간을 설정
		Random r2 = new Random(1); // seed를 1번으로 설정

		int result1 = r1.nextInt(); // 실행할때마다 다르게 나옴
		int result2 = r2.nextInt(); // 실행할때마다 동일하게 나옴

		System.out.println("ssed 설정없음 : " + result1);
		System.out.println("seed 1번설정 : " + result2);

		// 빨강, 파랑, 녹색을 랜덤하게 출력 하고 싶다.
		// 배열이나 리스트 생성 , 좀더 확률이 높게 하고싶으면 배열에 하나더 추가 { "빨강", "파랑", "녹색","빨강" }
		String[] colors = { "빨강", "파랑", "녹색" };
		
		// 숫자가 정수범위내는 너무크게 나오니까
		// 배열안의 인덱스가 랜덤하게 나오도록 r1.nextInt(colors.length) 범위내에서만 나오게 하자
		String color = colors[r1.nextInt(colors.length)];
		System.out.println("color: " + color);
		// 위에까진 복원 추출 (주사위게임 등)
		System.out.println();

		
		// 비복원 추출 ( Lotto, 배열을 쓰면안되고 List로 )
		// 훈련데이터 와 테스트데이터 샘플링, 로또, 고스톱, 포커
		List<String> list = new ArrayList<String>(); // list 생성
		for (int i = 1; i < 45; i = i + 1) { // 1~ 45까지 저장
			list.add(i + "");
		}
		for (int i = 0; i < 6; i = i + 1) {
			String x = list.get(r1.nextInt(list.size())); // list.size() 설정하면 1~45까지 나온걸 x로 추출
			list.remove(x); // 추출된 x를(데이터)list에서 제거
			System.out.print(x + '\t');
			// list에서 랜덤으로 1개 뽑고, 뽑은걸 list에서 지우고, 출력하고 반복
		}

	}

}
