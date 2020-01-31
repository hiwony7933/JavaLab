package RandomClass;

import java.util.UUID;

public class UUIDUse {

	public static void main(String[] args) {
		// 랜덤한 문자열 만들기 - 이미지 파일등을 업로드 햇을 때 파일이름 그리고 유저를 구분하기 위한 이름등을 만들 때 이용한다. 
		String name = UUID.randomUUID().toString();
		System.out.println(name);
	}
}
