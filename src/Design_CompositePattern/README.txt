구조와 관련된 패턴
3)Composite Pattern
->재귀적 구조를 쉽게 처리하기 위한 패턴
->Recursive Call(Recursion - 함수가 내부에서 함수 자신을 다시 호출하는 경우)
->파일 시스템에는 파일과 디렉토리가 있는데 디렉토리를 삭제할려고 하는 경우 디렉토리 안의 내용을 확인해서 디렉토리이면 다시 그안에 있는 내용들을 삭제해야 한다.
->하나의 인터페이스를 만들고 인터페이스에 공통된 메소드 이름을 만들어주고 파일과 디렉토리처리를 위한 클래스를 별도로 만들어서 처리하는 메소드를 구현하는 방식
다형성을 구현하는 방식과 유사함니다.

->인터페이스는 Entry - add 와 remove 그리고 rename 
->클래스는 File 과 Directory 로 생성
