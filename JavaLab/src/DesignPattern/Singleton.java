package DesignPattern;

public class Singleton {
	//싱글톤 패턴 적용
	
	//생성자를 private 으로 생성 
	private Singleton() {};
	
	//자신의 자료형과 동일한 자료형의 static 변수를 생성
	private static Singleton obj;
	
	public static Singleton sharedInstance() {
		if(obj == null) {
			obj = new Singleton();
		}
		return obj;
	}
	
	
}
