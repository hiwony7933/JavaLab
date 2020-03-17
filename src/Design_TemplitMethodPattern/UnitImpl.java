package Design_TemplitMethodPattern;

public class UnitImpl implements Unit {

	@Override
	public void attack() {
		System.out.println("공격");
	}

	@Override
	public void move() {
		System.out.println("이동");
	}

}
