**람다 (Lamdba) 
->자바에서의 람다는 함수형 프로그래밍을 지원하기 위해서 1.7에서부터 지원하기 시작한 이름없는 함수
->메소드가 하나 뿐인 인터페이스를 구현해서 사용할 때 람다를 이용해서 대입하는 것이 가능 
->Intelli J 나 Android Studio의 경우 메소드가 하나 뿐인 인터페이스를 anonymous를 이용해서 작성하면 람다로 자동 수정됩니다.
->이전버전의 자바는 완전한 객체 지향언어라서 메소드의 매개변수로 함수를 대입할 수 없었습니다. 
누군가에게 작업만을 수행해달라고 요청을 해야 하는 경우 자바는 객체를 만들어서 메소드 형태로 대입한 후 요청을 했습니다. 이런 이유로 자바가 작업을 요청하는 경우 시스템이 무거워졌습니다. 
이러한 문제를 해결하기 위해서 등장했던 언어들이 jvm을 사용하는 Scala, Closure, Kotlin 같은 언어들입니다.
위의 언어들은 마지막에는 java로 번역되서 jvm위에서 실행됩니다. 

->자바에서도 이러한 함수형 프로그래밍을 지원하기 위해서 등장시킨 개념이 람다와 스트림입니다.
1.8이상에서만 사용이 가능

1.메소드가 하나 뿐인 인터페이스의 구현
->public void run 이라는 메소드를 소유한 Runnable 이라는 인터페이스가 있습니다.
이 인터페이스는 스레드를 만들어주는 인터페이스 
1)인터페이스를 구현한 클래스를 생성하고 인스턴스를 만들어서 사용
RunnableImpl.java (class, interface) 
ThreadMain.java

2.자바에서 람다
1)직접 호출해서 메소드를 실행할 때는
인터페이스 변수 = 람다식 ;
변수.메소드();

2)1.8이상의 API를 사용하는 경우에는 람다식만 대입해서 메소드를 사용 

3.람다식 작성 요령
(타입 매개변수, 타입 매개변수...) -> {메소드 내용 작성; return 데이터}
->매개변수의 자료형은 생략 가능 : 호출할 때 대입되는 데이터를 가지고 자료형을 유추
->매개벼수가 없을때는 () 을 해야 하지만 매개변수가 1개인경우에는 () 을 생략가능 
->메소드 내용이 한줄 이면 {} 해도 됨. 
->리턴 타입은 작성할 필요없고 return을 해야 하면 return 데이터; 만 해주면 됩니다. 


4.람다식을 사용할 수 있는 인터페이스는 메소드가 반드시 1개만 존재해야 합니다. 
이러한 인터페이스는 @FuntionalInterface 라는 어노테이션을 이용해서 생성
람다로 쓸수있는 클래스는 @FuntionalInterface 이것이 붙어있다. 

5. 매개변수가 없고 리턴타입이 업는 메소드를 소유한 인터페이스의 경우 
( ) -> {메소드 내용}
->매개변수도 없고 리턴 타입도 없는 경우는 굉장히 드문 경우 (이런 경우는 거의 없다고 보면됨.)
->이런 메소드는 출력하는 메소드 정도에서만 가능하다.

6.람다식을 사용할 수 있는 인터페이스 
->1.8버전 이상에서는 java.util.function 패키지에서 기본적인 람다식을 사용할 수 있는 인터페이스를 제공 
Consumer : 매개변수는 있고 리턴 값은 없는 메소드들 소유한 인터페이스 
Supplier : 매개변수는 없고 리턴 값만 있는 메소드를 소유한 인터페이스 
Function : 매개변수가 있고 리턴 값도 있는 메소드를 소유한 인터페이스 - 변환(바꿈)
Operator : 매개변수가 있고 리턴 값도 있는 메소드를 소유한 인터페이스 - 연산(합계, 평균, 최대값...)
 	  매개변수를 누적해서 연산해서 리턴하는 메소드를 소유한 인터페이스 
Predicate : 매개변수가 있는 리턴 값도 있는 메소드를 소유한 인터페이스 
	  리턴 값이 boolean
	  조건에 맞는 데이터만 골라내는 메소드를 소유한 인터페이스 
->기본적으로 제너릭을 적용 - 매개변수의 자료형은 Generic 으로 설정 

Consumer를 요청하는 경우 
