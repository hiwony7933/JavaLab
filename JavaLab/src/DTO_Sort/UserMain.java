package DTO_Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		// User 클래스의 배열 생성
		UserClass user1 = new UserClass();
		user1.setNum(7);
		user1.setName("LEE");
		user1.setScore(100);

		UserClass user2 = new UserClass();
		user2.setNum(3);
		user2.setName("Kim");
		user2.setScore(80);

		UserClass user3 = new UserClass();
		user3.setNum(6);
		user3.setName("jung");
		user3.setScore(90);

		UserClass[] users = { user1, user2, user3 };

		Scanner sc = new Scanner(System.in);
		System.out.print("정렬조건 선택(1.번호, 2.이름, 3.점수):");
		String menu = sc.nextLine();

		// 자바는 지역변수를 만들면 자동 초기화를 하지 않습니다.
		// 만들기만 하고 값을 대입해두지 않으면 없는 것으로 간주합니다.
		Comparator<UserClass> comp = null;
		switch (menu) {
		case "1":
			comp = new Comparator<UserClass>() {
				@Override
				public int compare(UserClass o1, UserClass o2) {
					if (o1.getNum() > o2.getNum()) {
						return 1;
					} else if (o1.getNum() == o2.getNum()) {
						return 0;
					} else {
						return -1;
					}
				}
			};
			break;

		case "2":
			comp = new Comparator<UserClass>() {
				@Override
				public int compare(UserClass o1, UserClass o2) {
					return o1.getName().compareTo(o2.getName());
				}
			};
			break;

		case "3":
			comp = new Comparator<UserClass>() {
				@Override
				public int compare(UserClass o1, UserClass o2) {
					return o1.getScore() - o2.getScore();
				}
			};
			break;

		default:
			System.out.println("잘못된 메뉴를 선택하셨습니다.");
			System.exit(0);	// 프로그램 종료
		}
		sc.close();

		Arrays.sort(users, comp);

		// 데이터 출력
		for (UserClass user : users) {
			System.out.println(user);
		}

	}

}
