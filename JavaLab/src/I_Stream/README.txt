**스트림 api
=>java.io패키지에 있는 스트림은 입출력을 위한 스트림
=>java.util.stream패키지의 스트림은 Collection 에 대한 작업을 위한 스트림 -1.8버전에 추가
=>기존에는 동일한 자료형의 데이터 여러 개를 다룰 때 Collection이나 배열을 이용
Collection이나 배열을 이용하게 되면 코드가 길어지고 재사용성이 떨어집니다.
Collection과 배열에 있는 동일한 작업을 수행하는 메소드가 이름은 같은데 사용방법이 조금씩 다릅니다.
예를 들면 LIst의 정렬을 위한 sort메소드는 instance메소드인데 배열의 정렬을 위한 메소드는 Arrays클래스의 SORT라는 STATIC메소드입니다.
배열의 데이터를 하나씩 가져올 때는 [인덱스]를 이용하고 list의 데이터는 get(인덱스)을 이용합니다.
=>메소드의 매개변수로 인터페이스를 이용하는 경우에 별도의 클래스를 만들거나 anonymous class를 이용해야 해서 코드가 길어지고 메모리 낭비가 발생했는데 스트림api에서는 매개변수에 람다식을 사용해서 코드를 간결하게 만들 수 있습니다.
=>병렬처리도 쉽게 할 수 있음

1.배열의 데이터 접근
CollectionUse.java
		
2. 스트림의 특징
1)스트림은 데이터 소스를 변경하지 않습니다.
원본 데이터에 변경을 가하지 않습니다.
중간 연산한 결과를 별도로 저장할 수 있습니다.

2)스트림은 일회용
=>한 번 읽고 나면 재사용이 안되므로 다시 만들어서 사용

3)스트림은 작업을 내부적으로 반복해서 처리
=>반복문이 내부에 숨어있는 것 입니다.
=>단순하게 스트림을 사용한다고 해서 실행 속도가 빨라지는 것은 아닙니다.

4)다양한 기본 연산 제공
=>중간 처리 (매핑 - 변환, 필터링, 정렬) 연산과 최종 처리(반복 ,카운팅, 평균,합계)연산을 제공

5)스트림의 연산은 지연된 연산
=>중간 연산이 중간에 수행되는 것이 아니고 최종 연산을 수행하기 전에 수행

6)Fork & join을 이용해서 병렬처리를 구현하는 것보다 휠씬 쉽게 병렬 처리를 구현


3.Stream생성
1)Collection(List, Set)을 가지고 생성


2)배열을 가지고 생성
Arrays.stream(배열)

3)디렉토리 경로를 가지고 생성
Stream<Path> Files.list(Path path): path에 있는 모든 디렉토리 및 파일에 접근할 수 있는 스트림

4) 텍스트 파일의 내용을 줄 단위로 접근
Stream<String> BufferedReader.lines()

5)랜덤한 스트림
Random.doubles(), ints(), longs()를 이용

6)배열을 이용해서 스트림을 생성하고 모든 데이터 출력

똑같은 것을 여러개 할 수있다. 요즘에는 메모리를 많이 사용하지만 속도가 빠르다.
CollectionUse.java
//현재 디렉토리에 있는 pl.csv파일의 내용을 읽어서 문자열 배열 만들기
		try {
			//파일을 읽을 수 있는 스트림을 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\project\\JAVA_PROJECT\\java\\src\\java0129\\pl.csv")));
			//데이터 한 줄 읽기
			String line = br.readLine();
			//, 단위로 분할해서 문자열 배열로 만들기
			String [] ar  = line.split(",");
			Stream<String> stream1 = Arrays.stream(ar);
			//출력
			stream1.forEach(System.out::println);//System.out::println메소드 이름 을 할 수 있는 것
			br.close();
		} catch (Exception e) {
			System.out.println("파일 내용 읽기 실패: "+e.getMessage());
		}

텍스트 파일 데이터 읽어올때 발생하는 문제

123건
처음에 1을 읽는다.
su : 0 su * 10 +('1' - '0')  => 1
su  su * 10 + ('2'-'0') =>12
계산기를 이렇게 바꾼다. 그래서 숫자를 문자로 해서 한다. 숫자 입력이 안되면 계산이 안된다.
0-> 48이다.
//현재 디렉토리에 있는 pl.csv파일의 내용을 읽어서 문자열 배열 만들기
		try {
			//파일을 읽을 수 있는 스트림을 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\project\\JAVA_PROJECT\\java\\src\\java0129\\pl.csv")));
			//데이터 한 줄 읽기
			String line = br.readLine();
			//, 단위로 분할해서 문자열 배열로 만들기
			String [] ar  = line.split(",");
			Stream<String> stream1 = Arrays.stream(ar);
			//출력
			stream1.forEach(System.out::println);//System.out::println메소드 이름 을 할 수 있는 것
			br.close();
			
			//ar[3]에는 12345건이라는 문자열에 존재 - 12345라는 정수로 변환
			int su  =0;
			for(i = 0; i < ar[3].length(); i++) {
				//한글 자씩 가져오기
				char ch = ar[3].charAt(i);
				// 숫자인지 확인
				if(ch >= '0' && ch <= '9') {
					su = su * 10 +(ch - '0');
				}else {
					break;//, 콤마 있을 때 빼기
				}
			}
			System.out.println(su);
		} catch (Exception e) {
			System.out.println("파일 내용 읽기 실패: "+e.getMessage());
		}

4.스트림의 중간 연산(Reduction)
map reduce비슷한 것이다.
=>데이터를  변환, 필터링, 정렬, 그룹화 하는 것 등이 있습니다.
1)distinct():중복 제거 - 요소의 equals 메소드를 가지고 비교해서 equals 가  true를 리턴할 경우를 중복으로 간주
2)Filter(): 조건에 맞는 데이터만 필터링
=>하나의 매개변수를 받아서 boolean을 리턴하는 메소드를 대입
=>스트림의 모든 데이터를 매개변수에 대입해서 true리턴한 데이터만 골라서 Stream으로 리턴

3)map(); 데이터를 변환
=>하나의 매개변수를 받아서 리턴을 해주는 메소드를 대입
하나받아서 바꿔야 하나깐 리턴해야 한다.

4)sorted():데이터를 정렬
=>매개변수가 없으면 Comparable 인터페이스의 compareTo메소드를 이용해서 비교한 후 오름차순 정렬행
=>매개변수로 Comparator인터페이스를 구현한 객체나 2개의 매개변수를 받아서 정수를 리턴하는 람다식을 대입하면 대입된 객체나 람다식에 의해서 오름차순 정렬
앞의 데이터가 크다라고 할때는 양수를 리턴하면 되고 같으면 0 뒤의 데이터가 클 때는 음수를 리턴

5)peek(): 모든 데이터를 순회하면서 작업을 수행
=>매개변수로 1개의 데이터를 설정하고 return 이 없는 메소드를 대입

5.중간 연산 실습
1) 변호, 이름 , 성별 ,나이 ,점수를 소유한 dto(Data Transfer Object -VO)크래스르 생성
Student.java

2)main메소드를 소유한 main메소드 생성
stream사용하고있을경우오류가난다 .
 
ReductionMain.java
c++은 예약어가 거의 없다.
		
3)중간 연산 메소드는 여러 연속해서 사용 가능

6. 최종 연산 메소드
=>마지막에 한번만 사용가능한 메소드
(여러번 사용할 수 가 없다.한번만 사용하는 것이다.)

1)매칭관 관련된 메소드
=>모두 boolean을 리턴
allMatch()
anyMatch()
noneMatch()
=>3가지 메소드 모두 filter와 동일한 메소드를 매개변수로 받아서 전부 true또는 하나 이상 true또는 모두 false로 리턴하는지 알려지는 메소드

2)데이터 개수
long count()

3)데이터 합계
int, long ,double sum()

4)평균
OptionalDouble average()
=>Optional은 nulll을 저장할 수 있는 자료형을 최근에는 optional이라고 합니다.
평균은 null이 있을수 있다.그래서 데이터 확인하고 해야 한다.

5)최대값 및 최소값
OptionalXXX max()
OptionalXXX min()

6)누적 연산
OptionalXXX reduce()
현재 파이썬에서 동작하면 오류 난다. 버전 확인해야 한다.

7)모든 요소에게 메소드 수행
forEach()

8) 결과를 저장
R collect()

자바도 ,딥러닝 가능하는데 만들어진 것이 적어서 python등으로 한다.

7.Optional
=>어떤 클래스의 객체를 감싸는 클래스
=>null이 리턴될 가능성이 있을 때 이 데이터를 바로 사용하면 예외가 발생할 가능성이 존재하기 때문에 null여부를 확인하고 사용해야 합니다.
자바는 Optional이라는 자료형을 이용해서 null인 경우 다른 데이터로 치환할 수 있는 메소드를 제공합니다.

T get(): 값을 가져오고 null이면 예외 발생
T orElse(T 기본값 ): 결과가 null이면 기본값을 리턴
boolean isPresent(): null이면 false그렇지 않으면 true리턴


=>변형으로는 OptionInt, OptionalLong, OptionalDouble

9.collect
->collect를 이용해서 중간 결과를 List나 Set으로 리턴받고자 하면 이 때는 collect에 매개변수로 Collector.toList 또는 toSet을 대입하면 됩니다. 
->결과를 Map으로 저장하고자 하면 Collector.toMap(키로 사용할 데이터를 리턴해주는 메소드, 매개변수 1개를 가지고 리턴하는 메소드)를 대입하면 됩니다.
앞의 메소드 결과로 key를 만들고 뒤의 메소드 결과를 value를 만듬니다. 

->toList() 대신에 counting()을 설정하면 long 타입의 데이터 개수를 리턴
->summingInt 나 summingDouble 메소드에 mapToInt 나 mapToDouble을 대입하면 합계를 리턴 
->averagingInt 나 averagingDouble 메소드에 mapToInt 나 mapToDouble을 대입하면 평균을 리턴
->maxBy나 minBy 메소드에 비교하는 메소드에 대입하면 최대값이나 최소값을 리턴
최대나 최소는 실제 값이 아니고 최대값이나 최소값을 가진 데이터를 리턴 

11.grouping 이 가능
->collect 메소드에 collectors.groupingBy()를 이용해서 그룹화가 가능 
어떤 메소드의 결과로 그룹화 할 것인지를 설정하면 됩니다. 
->두번째 매개변수로 구하고자 하는 집계함수를 설정하면 그룹화 한 후 집계도 가능
counting(), averagingDouble(), maxBy(), minBy(), summingInt, summingLong, summingDouble()등으로 합계도 구할수있음.
->결과는 그룹화 하는 함수의 결과를 key로 해서 map으로 리턴 합니다.
->데이터의 규격화가 잘되어있다면 데이터베잇의 sql을 사용하는 것처럼 사용가능

12.병렬 스트림
-> java 1.8 이전 까지는 데이터의 모임에 병렬처리를 할려면 fork&join API를 사용(API 사용이 어려움)
->stream API에서는 병렬 스트림을 만들기만 하면 자동으로 병렬 처리를 수행
스트림을 만들 때 stream() 메소드 대신에 parallelStream() 메소드를 호출하면 병렬 스트림이 된다.
stream API는 데이터 병렬성으로 구현
데이터들을 작은 데이터로 분할해서 작업하는 형태

->작업의 병렬성
여러 작업의 요청이 올 때 작업들을 개별 스레드로 만들어서 병렬처리하는 방식으로 웹 서버가 대표적인 작업의 병렬성을 구현한 예 
