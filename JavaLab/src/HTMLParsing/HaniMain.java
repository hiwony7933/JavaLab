package HTMLParsing;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class HaniMain {

	public static void main(String[] args) {
		// 한겨례 신문사 웹 페이지에서 코로나로 검색된 기사 내용을 전부 파일에 저장하기

		// 1.코로나로검색된 기사 개수 파악하기
		// 기사 개수를 저장할 변수
		int cnt = 0;
		try {
			// 한글로 된 검색어를 인코딩
			String keyword = URLEncoder.encode("코로나", "utf-8");
			String addr = "http://search.hani.co.kr/Search?command=query&keyword=" + keyword
					+ "&media=news&submedia=&sort=d&period=all&" + "datefrom=2000.01.01&dateto=2020.01.28&pageseq=0";
			URL url = new URL(addr);

			// 연결 옵션과 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(20000);
			con.setUseCaches(false);

			// 문자열을 전부 읽어서 sb에 저장하기
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			String html = sb.toString();
			br.close();
			con.disconnect();
			// 데이터확인 - 확인되면 주석처리
			// System.out.println(html);

			// 뉴스 건수 찾기
			// html을 DOM으로 펼치기
			Document document = Jsoup.parse(html);

			// 1.태그이름으로 찾기 (span이 포함된 모든게 나온다)
			// Elements spans = document.getElementsByTag("span");

			// 2.클래스이름으로 찾기 (total 클래스이름이 포함된 모든게 나온다)
			// Elements spans = document.getElementsByClass("total");

			// 3.select(선택자)를 이용해서 찾기 그 영역만의 값만 찾아서 가져온다 -best)
			Elements spans = document.select("#contents > div.search-result-section.first-child > div > span");

			/*
			 * 출력해보기 for (int i = 0; i < spans.size(); i = i + 1) {
			 * System.out.println(spans.get(i).text()); }
			 */

			String temp = spans.get(0).text();
			// 240건 이라고 temp에 저장 240 만 추출해서 정수로 변환해서 cnt에 저장
			// 공백을 기분으로 분리할수있음
			String[] ar = temp.split(" "); // ar 배열에 빈칸을 기준으로 분리해서 넣는다.
			cnt = Integer.parseInt(ar[0]); // ar[0]번째에 데이터를 정수로 변환해서 cnt에 넣는다.
			// System.out.println(cnt); //확인해보니 240이 출력되더라

		} catch (Exception e) {
			System.out.println("기사 개수 파악 예외" + e.getMessage());
			e.printStackTrace();
		}

		if (cnt <= 0) {
			System.out.println("검색된 기사가 없습니다.");
			return;
		}
		// 검색된 데이터의 링크를 전부 찾아서 list에 삽입
		ArrayList<String> list = new ArrayList<String>();

		try {
			int pagesu = cnt / 10;
			if (pagesu % 10 != 0) {
				pagesu = pagesu + 1;
			}
			// 페이지 단위로 순회
			for (int i = 0; i < pagesu; i = i + 1) {

				// 한글로 된 검색어를 인코딩
				String keyword = URLEncoder.encode("코로나", "utf-8");
				// 한겨례 신문사 뉴스 검색 URL 만들기
				String addr = "http://search.hani.co.kr/Search?command=query&keyword=" + keyword
						+ "&media=news&submedia=&sort=d&period=all&" + "datefrom=2000.01.01&dateto=2020.01.28&pageseq="
						+ i;
				URL url = new URL(addr);

				// 연결 객체 만들기
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setConnectTimeout(10000);
				con.setUseCaches(false);

				// 특정 페이지의 데이터를 읽지 못하더라도 다음 페이지의 데이터를 읽기 위해서 반복문안에 예외처리문장 삽입
				try {
					StringBuilder sb = new StringBuilder();
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					while (true) {
						String line = br.readLine();
						if (line == null) {
							break;
						}
						sb.append(line + "\n");

					}
					String html = sb.toString();
					br.close();
					con.disconnect();

					Document document = Jsoup.parse(html);
					Elements links = document.select(
							"#contents > div.search-result-section.first-child > ul > li.first-child > dl > dt > a");
					for (int j = 0; j < links.size(); j = j + 1) {
						// System.out.println(links.get(j).text()); // a 태그안에 있는 문자열을 가져오
						// System.out.println(links.get(j).attr("href")); // a 태그의 link(href 속성 값) 가져오기

						list.add(links.get(j).attr("href")); // a 태그의 link를 list에 추가

					}
					// System.out.println(list.size());

				} catch (Exception e) {
					System.out.println("링크 수집 실패 : " + e.getMessage());
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("링크 수집 실패 : " + e.getMessage());
			e.printStackTrace();
		}

		try {
			for (String addr : list) {
				try {
					URL url = new URL(addr);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setUseCaches(false);
					con.setConnectTimeout(10000);

					StringBuilder sb = new StringBuilder();
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					while (true) {
						String line = br.readLine();
						if (line == null) {
							break;
						}
						sb.append(line + "\n");
					}
					String html = sb.toString();
					br.close();
					con.disconnect();
					// System.out.println(html);
					// 파일에 기록

					Document document = Jsoup.parse(html);
					Elements articles = document.getElementsByClass("title"); // class가 title인 태그만 찾아오기

					// 찾아온 데이터를 파일에 기록
					for (int i = 0; i < articles.size(); i = i + 1) {
						PrintWriter pw = new PrintWriter(new FileOutputStream("./코로나.txt"));
						pw.println(html);
						pw.flush();
						pw.close();
					}

				} catch (Exception e) {
					System.out.println("기사읽기예외" + e.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println("기사읽기예외" + e.getMessage());
		}

	}
}
