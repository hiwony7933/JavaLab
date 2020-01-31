package IF_Switch;

import java.util.Scanner;

public class I_Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴입력(1-한식, 2-중식, 3-일식, 기타-없음) : ");
		int menu = sc.nextInt();

		// 읽기 전용 함수 final
		final int KOREA = 1;
		final int CHINA = 2;
		final int JAPAN = 3;
		// 의미 있는 변수를 써서 switch 를 쓰면 좀더 가독성이 좋다 .높게 평가함.

		switch (menu) {
		case KOREA:
			System.out.println("한식");
			break;

		case CHINA:
			System.out.println("중식");
			break;

		case JAPAN:
			System.out.println("일식");
			break;

		default:
			System.out.println("없음");
			break;
		}
		sc.close();
	}

}
