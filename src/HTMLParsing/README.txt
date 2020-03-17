**HTML
1.tag : 브라우저가 해석해서 랜더링하기 위한 명령어
->하나의 페이지에서 중복될수 있다. 
2.class : 동일한 디자인을 적용하기 위해서 태그에적용하는 속성
3.id : 자바스크립트에서 하나의 태그를 구분하기 위해서 적용하는 속성
->하나의 페이지에서는 절대로 중복될수 없다.
4.name : 서버에서 처리하기 위해 붙이는 이름
->중복될수 있다 .
5.attribute. : 태그 내에서 설정하는 옵션 - key-value 형태로 설정
<태그 옵션이름='값'> (값은 문자열) : 스크래핑을 할 때는 a태그의 href 속성  
6.selector : 별도로 설정하는 것이 아니고 css에서 태그들을 선택하기 위해 만든 문법 
태그
.클래스이름
#id 
7.xpath: 별도로 설정하는것이 아니고 브라우저가 태그의 경로를 나타내기 위해서 사용하는 문법 
태그의 경로를 구분해서 나타내기 때문에 중복될수없습니다. 

**java가 실행을 할 때 클래스를 찾는 방법
1. 자신의 애플리케이션에 찾습니다.
1. 2번에서 없으면 Jvm이 제공하는 라이브러리에서 찾습니다.
3. 자바실행을 할 때 자신의 build path에 추가된 라이브러리를 jvm에 로드를 합니다
2번에서도 없으면 build path에 추가된 라이브러리에서 찾습니다. 
->build path에 추가될 때는 링크가 설정됩니다. (복사 아님)
->외부 라이브러리르 사용 할 때는 프로젝트에서 포함해서 배포를 하던가 다운로드 링크를 같이 제공해야 한다. 

**HTML Parsing
->JAVA에서는 python의 BeautifulSoup와 유사한 JSoup라는 라이브러리를 이용
1.http://www.naver.com에서 원하는 항목의 값 가져오기
1)프로젝트의 butil path에 jsoup 라이브러리를 추가
->www.mvnrepository.com에서 jsoup를 검색해서 다운로드
->다운로드 받은 파일을 프로젝트에 복사
->복사한 파일을 선택해서 마우스 우클릭 [Build Path]-[Add To Build Path]를 실행
 

2)코드 작성
NaverMain.java

2.한겨례 신문사에서 검색을 해서 실제 기사를 전부 읽어서 파일에 저장하기 
->검색을 이용해서 데이터를 읽어 올때는 주소 패턴을 정확하게 이해
http://search.hani.co.kr/Search?command=query&keyword=%EC%9A%B0%ED%95%9C&media=news&submedia=&sort=d&period=all&datefrom=2000.01.01&dateto=2020.01.28&pageseq=1

keyword = 검색어
datefrom = 시작날짜 dateto= 종료 날짜
pageseq = 페이지번호 0부터 시작 
->기사 개수를 읽어오는 것이 먼저
 
->기사 검색이나 게시판, sns 검색의 경우 검색의 결과로 나오는것은 대부분 제목과 본문의 링크입니다.
검색의 결과에서 링크를 전부 찾아서 실제 기사나 본문의 내용을 읽어와야 합니다. 


반복문 
1.html
2.html (문제가 생기면) 나가버림  
3.html

반복문안에서 try catch를 만들면 2번페이지 문제가 생겨도 3번페이지로 간다. 
- 스크래핑할때 생각해보자 - 기사가 내려가는경우도 있다. 

#반복문안에 try catch는 권장하지는 않지만 해야할 경우가 있다. 

**일반적인 방법으로 web의 데이터를 못 읽는 경우
1.ajax를 이용해서 동적으로 데이터를 가져와서 출력하는 경우
->ajax : 현재 페이지를 다시 호출하지 않고 동적으로 데이터를 가져오는 기술
java의 HttpURLConnextion 이나 python의 requests 모듈은 접속했을 때 존재하는 데이터만 읽어 올수 있다.

2.로그인을 해야만 사용이 가능한 데이터 

**selenium
->웹페이지를 테스트하기 위한 라이브러리로 출발 
->브라우저를 실행시켜서 직접 제어가능한 라이브러리 
->브라우저로 URL에 접속한 후 일정 시간 대기 한 후  페이지의 데이터를 읽어내면 ajax 형태로 읽어오는 데이터도 사용 가능
->자바 스크립트를 이용해서 로그인과 같은 폼에 데이터 입력이 가능하기 때문에 로그인 한 후 접근 가능한 데이터도 사용이 가능
->자바 이외 파이썬에서도 사용이 가능

1.준비
1)seleninum 라이브러리를 다운로드 받아서 프로젝트에 포함
www.seleniumhq.org 에서 다운로드, 혹은 www.mvnrepository.com 에서 selenium 검색 후 다운로드 
-다운로드 받은 파일을 프로젝트에 복사하고 파일을 선택한 후 [Build Path]-[Add To Build Path]

2)동작시키고자 하는 브라우저의 드라이버 파일을 다운로드
->브라우저 없이 하고자 하면 pantom.js를 다운로드 받으면 되는데 deprecated 
->chroe의 경우는 버전에 맞는 드라이버를 다운로드

https://chromedriver.chromium.org/downloads 에서 다운로드 한 후 압축해제 

2.크롬을 실행시켜 사이트에 접속
1)크롬 드라이버 이름과 드라이버 위치를 시스템 프로퍼티에 추가
System.setProperty("webdriver.chrome.driver", String 드라이버 파일의 경로);

2)크롬 실행
WebDriver driver = new ChromeDriver();

3)사이트 접속
driver.get("사이트 URL");

4)사이트의 html
driver.getPageSource();

5)크롬을 실행시켜 naver에 접속하고 html 가져오기 
chrome.java

3.Element 선택
driver.findElement(By.id, "id")
driver.findElement(By.xpath, "xpath")

driver.findElement(By.tagName, "tag")
driver.findElement(By.class, "class")

선택한 요소가 폼의 입력도구 인 경우 .send_keys(String value)를 호출하면 value폼의 입력도구가 채워짐
선택한 요소가 폼의 버튼이나 링크 인 경우 .click() 을 호출하면 버튼이나 링크를 클릭한 효과
폼의 submit 이면 .submit()을 호출하면 폼의 데이터 전송

4.페이지 접속과 해제
get(String url) : url에 접속

Close() : 종료


5.프레임(페이지를 나누어서 다른 html을 불러온다던가 다른 DOM 객체를 가져와서 출력)전환
switchTo().frame(프레임 Element) 

6.크롬을 실행시키지 않고 작업 가능 함
ChromeOptions options = new ChromeOptions();
options.addArguments("headless");
WedDriver driver = new ChromeDriver(options);
