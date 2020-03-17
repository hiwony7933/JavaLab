package DTO_Board;

//게시판 작업을 위한 메소드
public class BoardService {
	// NoticeClass 100개를 저장할수있는 공간을 100개 생성해서 이름을 list라고 붙임.
	BoardClass[] list = new BoardClass[100];

	// 전체 목록이나 일부 목록을 리턴하는 메소드
	// 리턴 타입은 배열이나 List
	// 일부 목록을 가져올때는 매개변수로 페이지 번호를 갖는 경우가 많습니다.
	public BoardClass[] getList() {
		return list;
	}

	// 페이지 번호에 해당하는 데이터를 가져오는 메소드
	public BoardClass[] getList(int pageNo) {
		BoardClass[] page = new BoardClass[10];

		// 한페이지에 10개씩 있다고 가정 0~9, 10~19, 20~29
		// pageNo가 1일때는 0과 9, pageNo가 2일때는 10과 19

		int start = (pageNo - 1) * 10;
		int end = pageNo * 10 - 1;

		for (int i = 0; i < 10; i = i + 1) {
			page[i] = list[start + i];
		}

		return page;
	}

	// 글번호에 해당하는 데이터를 1개 가져오는 메소드
	// 기본키를 매개변수로 받아서 처리
	// 상세보기를 처리하는 메소드
	public BoardClass getBoardClass(int num) {
		// list에서 num이라는 글 번호를 가진 데이터를 찾아서 리턴
		BoardClass board = null;

		// list 를 순회하면서 num과 같은 글번호를 가진 데이터를 board에 대입
		for (BoardClass temp : list) {
			if (temp != null) {
				// 동일한 글번호를 찾으면 더 이상 반복문을 수행할필요가 없어서 break, 찾으면끝
				if (temp.getNum() == num) {
					board = temp;
					break;
				}
			}
		}
		// 동일한 글번호가 없으면 null을 리턴 중요
		return board;
	}

	// 글쓰기를 처리하는 메소드
	// 데이터삽입을 처리하는 메소드 (boolean을 리턴하는 경우가 많다)
	// 수행 결과를 알려주고자 할때는 boolean 이나 int로 리턴
	// 수행 결과를 알려주지 않고자 할 때는 void(실패는 없다라는 가정)
	// 매개 변수는 데이터 1개

	// 현재 작성된 글의 개수를 저장하기 위한 변수 -list를 사용하게 되면 필요없음.
	private int cnt;

	public boolean insertBoard(BoardClass board) {
		// 맨 마지막 위치에 데이터를 대입
		list[cnt] = board;
		cnt = cnt + 1;
		return true;
	}

	// 글수정을 처리하는 메소드
	// 리턴 타입은 삽입과 동일
	// 매개변수도 삽입과 동일
	// 수정을 할 때는 기본키(클번호)의 값이 자동으로 설정되는 것이 다름.
	public boolean updateBoard(BoardClass board) {
		// 글번호에 해당하는 데이터를 찾으면 board로 대체
		for (int i = 0; i < cnt; i = i + 1) {
			BoardClass imsi = list[i];
			// 글번호 비교
			if (imsi != null) {
				if (imsi.getNum() == board.getNum()) {
					list[i] = board;
					break;
				}
			}
		}

		return true;
	}

	// 삭제를 처리하는 메소드
	// 삭제를 할 때는 데이터 전체가 필요하지 않고 일반적으로 기본키만 필요합니다.
	public boolean deleteBoard(int num) {
		// list에 모든 데이터를 순회해서 글번호가 num인 데이터를 찾아서 그 위치에 null을 대입
		for (int i = 0; i < cnt; i = i + 1) {
			BoardClass imsi = list[i];
			// 글번호 비교
			if (imsi != null) {
				if (imsi.getNum() == num) {
					list[i] = null;
					break;
				}
			}
		}

		return true;
	}

}
