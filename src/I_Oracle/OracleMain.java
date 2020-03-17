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

public class OracleMain {
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

			// 2.드라이버 클래스 로드
			Class.forName(driverClass);
			// 3.데이터베이스 연결 객체 생성
			Connection con = DriverManager.getConnection(url, id, pw);
			// System.out.println(con); // 4.con 생성 잘되었나 확인 (예외안뜨면됨)

			// 5.삽입하는 구문
			/*
			PreparedStatement pstmt = con
					.prepareStatement("insert into transactions(num, itemcode, itemname, price, cnt, transdate, userid) "
							+ "values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, 2);
			pstmt.setString(2, "t10000");
			pstmt.setString(3, "터미네이터");
			pstmt.setInt(4, 300000);
			pstmt.setInt(5, 1);

			Calendar cal = new GregorianCalendar(1984, 3, 31, 14, 34, 00);
			// java.sql.Date
			Date transdate = new Date(cal.getTimeInMillis());
			pstmt.setDate(6, transdate);
			pstmt.setString(7, "RYU");

			int result = pstmt.executeUpdate();
			if(result > 0 ) {
				System.out.println("삽입 성공"); 	// 삽입은 0보다 크면 성공 
			}
			pstmt.close();
			*/
			
			// 6.수정하는 구문
			/*
			PreparedStatement pstmt = con
					.prepareStatement("update transactions set itemcode=?, itemname=?, price=?, cnt=?, transdate=?, userid=?"
							+ " where num = ?");
			
			pstmt.setString(1, "t10000");
			pstmt.setString(2, "터미네이터");
			pstmt.setInt(3, 20000);
			pstmt.setInt(4, 2);

			Calendar cal = new GregorianCalendar(1984, 3, 31, 14, 34, 00);
			Date transdate = new Date(cal.getTimeInMillis());
			pstmt.setDate(5, transdate);
			
			pstmt.setString(6, "아놀드슈왈츠");
			pstmt.setInt(7, 3);

			int result = pstmt.executeUpdate();
			if(result > 0 ) {
				System.out.println("수정 성공"); 	 
			}else if(result == 0) {
				System.out.println("조건에 맞는 데이터가 없습니다.");
			}
			pstmt.close();
			*/
			
			// 7.데이터 삭제 - 기본키를 가지고 데이터를 삭제하는 것이 일반
			PreparedStatement pstmt = con
					.prepareStatement("delete from transactions where num = ?");
			pstmt.setInt(1, 2);
			
			int result = pstmt.executeUpdate();
			if(result > 0 ) {
				System.out.println("삭제 성공"); 	 
			}else if(result == 0) {
				System.out.println("조건에 맞는 데이터가 없습니다.");
			}
			pstmt.close();
			
			con.close();
			
			
		} catch (Exception e) {
			System.out.println("데이터베이스 예외" + e.getMessage());
			e.printStackTrace();
		}
	}
}
