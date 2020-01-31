package I_Generic;

public class GenericMain {

	public static void main(String[] args) {
		
		Integer[] ar = { 100, 200, 300 };	// 미지정 자료형 1개를 갖는 클래스의 인스턴스 만들기
		
		GenericClass<Integer> obj1 = new GenericClass<Integer>(ar);	// 클래스를 만들 때 사용한 L 이 Integer로 치환되서 동작
		
		obj1.disp();	// 메소드 호출

		String[] br = { "류해단", "정세희" ,"김지환" };	// 클래스를 만들 때 사용한 L가 String으로 치환되서 동작
		
		GenericClass<String> obj2 = new GenericClass<String>(br);
		obj2.disp();

	}

}
