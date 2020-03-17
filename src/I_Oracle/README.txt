**관계형 데이터베이스 인 오라클 사용
1. 프로그래밍 언어에서 관계형 데이터 베이스를 사용하는 방법
1)언어가 제공하는 기능만을 이용해서 구현 - java의 경우는 JDBC 그리고 윈도우는 ODBC 등
2)프레임워크를 이용해서 구현 - 언어가 제공하는 기능을 편리하게 사용할 수 있도록 만들어진 프레임워크 이용 
- SQL Mapper : java 코드와 SQL을 분리해서 작성하는 구조, MyBatis(iBatis가 예전이름) 가 대표적
->성능은 떨어지지만 쉬워서 SI(시스템 통합 - 기업의 전산화, 외주를 많이 줌)에서 많이 사용

- Object Relation Mapper  
->최근에 많이 사용하는 프레임워크로 하나의 행을 하나의 인스턴스와 매핑하는 프레임워크
하나의 테이블을 하나의 클래스와 매핑
데이터베이스에 대한 구조를 파악하고 있어야만 사용이 가능
어렵지만 선능이 우수해서 솔루션 제작에 많이 이용
Java의 JPA(구현체로는 Hibernate)가 대표적인 프레임워크 - 다른 언어에도 대부분 있음 
SQL없이 데이터베이스 작업이 가능 - DBMS를 변경해서 적용하더라도 설정파일만 수정하면 된다. 

autoincrement : sqlite 의 일련번호
sequence : 오라클 

IBatis, MyBatis
MariaDB, MySQL
Fedora, Cent OS, Red Hat Enterprise <-> Ubuntu 

2.java에서 관계형 데이터베이스 연동 방법
1)사용하고자 하는 데이터베이스와의 인터페이스를 제공하는 드라이버를 사용할수있도록 설정 
->자바는 드라이버를 build path에 추가하고 클래스를 로드 

2)데이터베이스 접속 정보를 가지고 데이터베이스 연결 객체(java.sql.Connection)를 생성
->접속정보는 데이터베이스 URL, 포트번호, 데이터베이스이름(오라클의 경우는 sid 또는 serviceName)이 필요하고 접속계정과 비밀번호도 필요
->데이터베이스 종류에 따라서 접속 계정과 비밀번호가 필요없는 경우가 있음
->데이터베이스 중에는 자신의 기본 포트를 사용하는 경우 포트번호 생략이 가능(MySQL은 3306포트인 경우 생략가능)
->java의 경우는 연결 객체를 이용해서 트랜잭션 사용 방법을 설정합니다. 

3)Connection을 이용해서 SQL을 주고받을 객체를 생성하고 실행 - Java는 Statement(완성된 SQL), PreparedStatement(나중에 데이터를 매핑할수있는 SQL- 대부분의 언어가 사용), CallableStatement(Procedure 실행)  
4)결과를 사용
-select를 제외한 구문 : 영향받은 행의 개수를 정수로 리턴 
-select 구문 : select의 결과를 사용할 수 있는 Cursor를 리턴 

5)트랜잭션 처리를 하고 사용한 객체를 close를 합니다. 

6)java에서는 이 과정 전체가 예외처리를 강제합니다.
다른 언어에서 예외처리를 강제하지 않더라도 예외처리를 해주는 것이 좋습니다. 
문제가 발생하면 어떤 조치를 취할 수 있도록 해 주어야 합니다. 
데이터베이스는 외부에 존재하는 경우가 많기 때문에 어떤 문제가 발생할지 우리가 예측할수 없음.

3. 애플리케니션 프로그램이 잘 수행하지 않는 SQL
->Grant(권한부여), Revoke(권한회수)
->Create(개체 생성), Alter(개체 구조 변경), Drop(개체 삭제), Truncate(테이블의 데이터만 삭제), Rename(테이블의 이름변경)
->주로 관리자가 사용하는 SQL 명령어들이고 이 명령들은 Rollback이 안됩니다. 
관리자만 로컬에서 사용하는 애플리케니션을 만들어서 수행하도록 하는 경우는 종종 있습니다.

4.데이터베이스 계정

5.샘플 테이블을 생성
=>Oracle 의 자료형
숫자 - number(정수자릿수), number(전체자릿수, 소수자릿수)

문자열 - char(글자수), varchar2(글자수), clob
한글은 곱하기 3해야 합니다.
char를 사용하면 글자수보다 작은 양의 글자를 입력하면 뒤에 공백이 있습니다.
clob는 아주 많은 글자인 경우 사용

날짜 - date

=>거래정보 테이블
거래번호 - 정수 10자리이고 기본키, 일련번호 형식
품목코드 - 거래한 품목의 코드, 문자열 20자리
품목명 - 거래한 품목 이름, 문자열 100자리
단가 - 정수 7자리
수량 - 정수 3자리
거래일 - 날짜
거래ID - 거래한 유저의 ID, 문자열 50자리

create table transactions(
	num number(10) primary key,
	itemcode varchar2(20),
	itemname varchar2(100),
	price number(7),
	cnt number(3),
	transdate date,
	userid varchar2(50)
);

6.프로젝트를 생성하고 오라클을 사용할 준비
->데이터베이스 드라이버를 프로젝트의 build path에 추가
오라클은 ojdbc?jar
ojdbc6.jar : 숫자의 의미는 자바 버전이고 이외의 숫자가 추가로 있으면 오라클 버전입니다.
상위버전은 하위버전을 지원함

7.애플리케이션이 시작될 때 처음 드라이버 클래스를 로드
->Class.forName("드라이버 클래스 이름")
->실제 애플리케이션을 만들 때는 드라이버 클래스 이름을 별도의 파일에 작성하고 읽어드리는 구조로 만듬.
->오라클의 경우는 드라이버 클래스 이름 : oracle.jdbc.drive.OracleDriver
->드라이버 클래스이름이 틀리거나 jar 파일을 build path에 추가하지 않았다면 예외가 발생함니다.


8.데이터베이스 연결 및 해제 
->데이터베이스 연결 할 때는 3가지 정보가 필요
데이터베이스 URL : 데이터베이스 종류마다 설정 방법이 다름
계정
비번
->계정과 비번은 없어도 되는 경우가 있다.
->오라클의 URL - jdbc:oracle:thin:@IP 또는 Domoan:port:sid
sid가 아니고 serviceName 인 경우는 : 대신에 /serviceName

->데이터베이스 접속
Connection ? = DriverManager.getConnection(url, id, pw) ;

->데이터베이스 접속 해제
?.close();

->url이 잘못된 경우는 기본적인 접속시간동안 접속을 해보고 네트워크 문제라고 예외를 발생시킵니다.
->id.pw 

9.데이터베이스 드라이버이름이나 접속 정보는 별도로 작성한 후 읽어 들이는 구조로 만드는것을 권장
ㄴ 개발환경과 운영환경이 다를 가능성이 있기 때문


**오라클 연동
1. 프로젝트에 ojdbc.jar 파일을 복사하고 build path에 추가

2. 접속 정보를 저장할 텍스트 파일을 생성
->프로젝트 안에 db.txt 파일을 생성하고 작성

4.SQL 실행
1)select를 제외한 구문
PreparedStatement pstmt = con.prepareStatement("SQL 작성");
->입력받는 값들은 ?로 설정 
pstmt.set자료형(?번호, 실제 데이터); <- 매핑
? 개수만큼 정확하게 매핑 

int result = pstmt.executeUpdate();
//리턴되는 값은 영향받은 행의 개수입니다.
//0이 리턴되면 조건에 맞는 데이터가 없는 것이고 1 이상의 숫자면 테이블에 변화가 생김 
//sql이 잘못되면 예외가 발생 
pstmt.close();

2. 복호화가 불가능한 암호화
->비밀번호와 같은 데이터를 저장할 때는 관리자도 알아볼 수 없도록 복호화가 불가능한 형태로 저장해야됨.
->java에서 JBCrypt 라이브러리를 이용해서 구현
암호화할 때는 BCrypt.hashpw(String 평문, BCrypt.getSalt());
비교할 때는 BCrypt.checkpw(String 평문, String 암호화된 문장) ; 두 개가 일치하면 true 그렇지 않으면 false
암호화를 할 때는 최소 64자리 이상 저장할 수 있어야 합니다. 

1)www.mvnrepository.com에서 jbcrypt를 검색해서 다운로드 받아서 프로젝트에 복사하고 build path에 추가 

3. Transaction 
->한번에 이루어 져야 하는 작업의 논리적인 단위 
->SQL은 명령어 단위로 실행되는데 실제 업무에서는 여러 개의 SQL이 모여서 하나의 작업을 구성하는 경우가 많다. 이런 경우에는 트랜잭션을 만들어서 전부 수행되거나 전부 수행되지 않도록 해줘야 한다. (All Or Nothing)

1)Commit 과 rollback 
->commit은 현재까지 수행한 내용을 원본에 반영 
->rollback은 현재까지 수행한 내용을 원본에 반영하지 않음.
->savepoint는 rollback할 지점을 생성
2)트랜잭션 처리 방법
auto commit : SQL 문장이 성공적으로 수행될 때 마다 바로 commit
manual commit : 명시적으로 commit이나 rollback을 호출해야 하는 방법

3)트랜잭션 생성
->commit이나 rollback을 한 후 첫번째 DML(insert, update, delete)을 만났을 때 생성

4)commit을 하지 않아도 commit을 수행하고 트랜잭션을 종료하는 경우
->접속 프로그램을 정상적으로 종료할 때 
->DDL(create, alter, drop, truncate, rename)이나 DCL(grant, revoke)을 성공적으로 수행한 경우

5)자동으로 rollback 되는 경우
->데이터베이스나 접속 프로그램이 비정상적으로 종료되는 경우

6)java에서의 트랜잭션 처리 
->java는 기본적으로 auto commit 
->manual commit을 하고자 하는 경우에는 Connection 객체가 setAutoCommit(false)를 호출하고 Connection 객체 가지고 commit() 이나 rollback()을 호출하면 됩니다.

4.select 구문 실행
->SELECT 구문은 PreparedStatement 객체를 가지고 ececuteQuery()를 호출하면 됩니다.
ResultSet을 리턴합니다.
->ResultSet은 조회된 데이터에 접근할 수 있는 Cursor의 역할을 합니다.
next() 메소드를 이용해서 다음 데이터가 있는지 확인하고 있으면 다음 데이터를 가리킵니다. 
->각 컬럼의 데이터를 읽고자 하는 경우에는 ResultSet.get자료형(컬럼의 인덱스 또는 컬럼이름)으로 가져옵니다.
->데이터를 읽어서 다른 곳에서 사용을 하고자 할 때는 검색된 데이터를 하나의 변수에 저장을 해야 합니다.
여러 개의 데이터의 경우는 컬럼의 데이터를 저장할 수 있는 DTO 클래스를 생성하거나 Map을 이용해서 저장하고 이러한 DTO 클래스나 Map 클래스의 인스턴스들은 List에 저장합니다.
이런 구조를 R이나 Python의 pandas에서는 DataFrame 이라고 합니다.
Map의 List 구조입니다. 
->DTO패턴 : Map 대신에 여러 개의 데이터를 저장할 수 있는 별도의 클래스를 만들어서 사용하는 패턴
이러한 클래스를 DTO(Data Transfer Object) 또는 VO(variable Object) 또는 Domain 클래스라고 한다. 

5. Map과 DTO 비교
->DTO는 메소드를 호출해서 대입하고 가져오기 때문에 오류를 발생시킬 가능성이 줄어든다는 장점이 있지만
데이터 구조가 변경되는 경우에 수정할 부분이 많아 진다. 
관계형 데이터베이스의(RDBMS - 테이블 기반의 데이터베이스) 의 특징

->Map을 사용하면 put 이라는 메소드를 이용할 때 문자열로 키를 지정하고 get으로 읽어올 때 문자열로 키를 대입해야 하는데 이때 오류가 많이 발생됨.
데이터 구조가 변경되더라도 저장과 읽기 할 때 키만 변경하면 됨. 
NoSQL 데이터베이스의 특징 


