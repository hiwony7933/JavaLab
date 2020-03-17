package Practice;

import java.util.*;

public class LottoInput {

	public static void main(String[] args) {
		
		TreeSet<Integer> lotto = new TreeSet<Integer>();	// 1~45 까지의 정수를 저장할 자료구조를 생성

		Scanner sc = new Scanner(System.in);
		while (lotto.size() < 6) {
			try {
				System.out.print("1~45 까지의 중복되지 않는 숫자 : ");
				int su = sc.nextInt();

				if (su < 1 || su > 45) {	// 1~ 45 사이의 숫자인지 검사
					System.out.println("1~45 사이의 숫자만 입력하세요 ");
					continue;
				}

				boolean result = lotto.add(su);
				if (result == false) {
					System.out.println("중복된 숫자는 안됩니다. ");
				}
			} catch (Exception e) {
				System.out.println("숫자만입력해라");
				sc.nextLine();
			}
		}

		// lotto 데이터 출력
		for (Integer su : lotto) {
			System.out.print(su + "\t");
		}
		sc.close();
	}

}
