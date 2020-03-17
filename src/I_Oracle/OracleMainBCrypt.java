package I_Oracle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.mindrot.jbcrypt.BCrypt;

public class OracleMainBCrypt {
	public static void main(String[] args) {
		// 접속 정보를 저장할 텍스트 파일을 생성
		// 프로젝트 안에 db.txt 파일을 생성하고 작성

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("./src/I_Oracle/db.txt")))) {
			String driverClass = br.readLine();
			// System.out.println(driverClass); // 1.처음에 잘 읽고 있는지 확인 (예외안뜨면됨)
			
			String url = br.readLine();
			String id = br.readLine();
			String pw = br.readLine();

			Class.forName(driverClass);		// 2.드라이버 클래스 로드
			Connection con = DriverManager.getConnection(url, id, pw);		// 3.데이터베이스 연결 객체 생성
			// System.out.println(con); // 4.con 생성 잘되었나 확인 (예외안뜨면됨)

			// 데이터 베이스에 데이터를 저장하거나 수정 할 때 사용할 수 없는 단어를 확인해서 저장하거나 수정하는 것이 좋다. 
			// 7. 특히 SQL 예약어는 확인 해서 데이터로 사용하지 못하도록 하는 것이 좋다. - 불용어 
			String [] stop_words = {"or", "end"};
			
			/// 5.삽입하는 구문
			PreparedStatement pstmt = con
					.prepareStatement("insert into transactions(num, itemcode, itemname, price, cnt, transdate, userid) "
							+ "values(?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, 3);
			
			//// 7. 불용어 구문
			String str = "dadadfadfor";
			for(String temp : stop_words) { // stop_words의 모든 데이터를 순회 
				// indexOf는 temp가 몇번째 있는지 검색, 찾으면 찾은 위치를 리턴하고 못찾으면 -1를 리턴
				// 불용어가 있으면 replace로 "" 치환  
				if(str.indexOf(temp) >= 0) { 
					System.out.println("사용할 수 없는 단어가 포함되어있습니다");
					// return;  // 작업을 수행하지 않음   
					str = str.replace(temp, "");	// 찾으면 ""으로 치환 - 제거 
				}
			}
			////
			
			// 8.id나 검색어등은 모두 대문자 또는 모두 소문자로 변경해서 저장하는것이 일반적 
			pstmt.setString(2, str.toUpperCase()); // id 대문자저장 
			pstmt.setString(3, BCrypt.hashpw("애플", BCrypt.gensalt()));  // 암호화 저장  
			pstmt.setInt(4, 3000);
			pstmt.setInt(5, 1);

			Calendar cal = new GregorianCalendar(1984, 3, 31, 14, 34, 00);
			Date transdate = new Date(cal.getTimeInMillis());	// java.sql.Date
			pstmt.setDate(6, transdate);
			pstmt.setString(7, "RYU");

			int result = pstmt.executeUpdate();
			if(result > 0 ) {
				System.out.println("삽입 성공"); 	// 삽입은 0보다 크면 성공 
			}
			pstmt.close();
			con.close();
			///
			
			// 6. 암호화 된 값 비교 출력 BCrypt 라이브러리는 복호회가 안된다. 
			System.out.println(BCrypt.checkpw("터미네이터", BCrypt.hashpw("터미네이터", BCrypt.gensalt())));
			System.out.println(BCrypt.checkpw("터미네이터1", BCrypt.hashpw("터미네이터", BCrypt.gensalt())));
			
		} catch (Exception e) {
			System.out.println("데이터베이스 예외" + e.getMessage());
			e.printStackTrace();
		}
	}
}
