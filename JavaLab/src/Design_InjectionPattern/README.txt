3)행동에 관련된 패턴
1)Command Pattern
->처리 내용이 비슷한 명령을 모아서 실행하는 처리가 필요할 때 명령을 인스턴스로 취급해서 처리하는 패턴 
->데이터를 삽입하는 처리와 수정하는 처리가 필요한 경우 

interface Action{
	public void execute(DTO dto);
}
class InsertAction implement Action{
	public void execute(DTO dto) {
		삽입하는 코드
	}
}
class InsertAction implement Action{
	public void execute(DTO dto) {
		수정하는 코드
	}
}

//action에 대입되는 인스턴스 자체가 명령어와 유사한 역할을 수행 

Action action = null;
if(command == 삽입){
	action = new InsertAction();
}else if(command == 삭제){
 	action = new UpdateAtion();
}
action.execute(dto);

->이러한 패턴은 웹 서버의 Controller 클래스를 만들어서 요청에 따라 처리를 할 때 많이 사용 
웹 서버 프로그래밍을 하다보면 URL에 따른 Routing 구조를 만들 때도 이 구조를 이용합니다.

2)Observer Pattern
->어떤 인스턴스의 내부 상태가 자주 변경되는 경우 내부 상태가 변경되는지를 감시하고 있다가 변경이 되면 알려줘서 다른 처리를 할 수 있도록 해주는 패턴 
->알려준다고 해서 Notification 이라는 표현을 많이 사용합니다.
->이 패턴을 사용하는 대표적인 예가 스마트 폰 의 뷰에서 키보드가 화면에서 보여지고 사라지는 것을 감시해서 뷰의 컴포넌트들을 재배치 하는 형태

3)Strategy Pattern
->어떤 클래스가 공통된 부분이 있고 서로 다른 부분이 있는 경우 공통된 부분은 클래스 안에서 만들어 사용하고 서로 다른 부분은 외부에서 주입(Injection)받아 사용하는 패턴

->Design Pattern은 하나의 클래스에 여러가지를 적용하기도 합니다.
->Design Pattern의 개념은 절대적인 개념이 아니라서 개발자마다 약간씩 다르게 설명하기도 합니다.
Singleton, Template Method, Command Pattern 은 모두 동일하게 설명합니다.
->이외에도 인스턴스 생성을 대신해주는 Factory Method Pattern 이나 개발자가 만든 클래스에 코드를 더해서 실제로는 개발자가 마든 클래스와 다른 형태의 인스턴스를 만들어내는 Proxy Pattern 등도 있습니다. 
->객체지향 프로그래밍에서는 디자인 패턴이 중요합니다.
