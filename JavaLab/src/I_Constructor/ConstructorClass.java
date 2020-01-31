package I_Constructor;

public class ConstructorClass {

	private String id;
	private String pw;
	// static{ }는 클래스를 처음 사용할 때 1번만 호출
	// 딱 한번만 보여줄때

	// 클래스안에 { } 를 만들고 작성하면 생성자를 호출 할때
	// 생성자보다 먼저 호출되서 내용을 수행
	// 할때마다 보여줄때( ex. 스테이지마다. 등)
	{
		System.out.println("객체를 생성합니다.");
	}

	// CunstructorClass 클래스 생성
	// 생성자는 리턴 타입없이 클래스 이름을 그대로 사용
	// 매개변수가 없는 생성자를 default constructor 라고 함.

	public ConstructorClass() {
		id = "root";
		pw = "1234";

	}

	// 매개변수가 2개인 생성자
	// 2개의 문자열을 받아서 id와 pw에 대입하는 생성자
	public ConstructorClass(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	/////////////////////////////////////////////
	// 인스턴스를 복제해주는 메소드
	public ConstructorClass clone() {
		// 인스턴스를 생성
		ConstructorClass other = new ConstructorClass();
		// 데이터를 복제
		// 원래 참조형 데이터도 clone 해주어야 하지만 String은 예외
		other.id = this.id;
		other.pw = this.pw;

		// 복제된 데이터를 갖는 객체를 리턴
		return other;
	}

}
