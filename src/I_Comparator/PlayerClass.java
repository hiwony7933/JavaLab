package I_Comparator;

//선수 번호, 선수이름, 타율
public class PlayerClass {

	private int num;
	private String name;
	private double hitrate;

	// 매개변수가 없는 생성자
	public PlayerClass() {
		super();
	}

	// 모든 필드를 매개변수로 받아서 인스턴스 필드에 대입해주는 생성자
	public PlayerClass(int num, String name, double hitrate) {
		super();
		this.num = num;
		this.name = name;
		this.hitrate = hitrate;
	}

	// 인스턴스 필드들을 private 으로 만들어서 인스턴스가 접근을 못한다.
	// 인스턴스가 필드들에 접근할수있도록 해주는 메소드 : 접근자 메소드(getters & setters)
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHitrate() {
		return hitrate;
	}

	public void setHitrate(double hitrate) {
		this.hitrate = hitrate;
	}

	// 필드의 값을 빠르게 확인하기 위한 메소드 : 디버깅을 위한 메소드
	@Override
	public String toString() {
		return "Vector [num=" + num + ", name=" + name + ", hitrate=" + hitrate + "]";
	}

}
