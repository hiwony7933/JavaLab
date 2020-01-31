package I_Generic;

//Generic을 적용한 클래스 타입파라미터는 일반적으로 대문자 알파벳 한 글자로 표현한다
public class GenericClass<L> {

	// L 라는 미지정 자료형 배열
	private L[] data;

	// 주의사
	// 실제 자료형을 기재할 때 기본형은 안됩니다.
	// int는 안되기 때문에 대신에 integer를 사용해야 합니다.

	// 생성자
	public GenericClass(L[] data) {
		this.data = data;

	}

	// 메소드
	public void disp() {
		for (L temp : data) {
			System.out.print(temp + "\t");
		}
		System.out.println();
	}

}
