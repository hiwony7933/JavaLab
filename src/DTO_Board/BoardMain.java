package DTO_Board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		// Android, IOS 는 한글로 변수 지정해도 괜찬다 UTF-8
		final int 전체보기 = 1;
		final int 상세보기 = 2;
		final int 삽입하기 = 3;
		final int 수정하기 = 4;
		final int 삭제하기 = 5;
		final int 종료하기 = 6;

		// 게시판 작업을 수행할 인스턴스를 생성
		BoardService boardService = new BoardService();

		// 키보드로 부터 입력받기 위한 객체 생성
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.전체보기 2.상세보기 3.삽입하기 4.수정하기 5.삭제하기 6.종료하기");
			System.out.println("메뉴입력 : ");
			int menu = sc.nextInt();

			// menu에 따른 분기
			switch (menu) {
			case 전체보기:
				// BoardService 클래스의 getList 메소드가 처리할수있습니다.
				// static이 아닌 메소드를 사용하기 위해서 인스턴스를 생성
				// BoardService는 클래스 이름
				// new 다음에 나오는 BoardService는 생성자 이름

				BoardClass[] boards = boardService.getList();

				// 배열의 데이터 출력
				for (BoardClass board : boards) {
					if (board != null) {
						System.out.println(board);
					}
				}

				break;
			case 상세보기:
				// 글번호를 입력받아서 상세보기 메소드를 호출
				// 상세보기는 그번호에 해당하는 데이터가 있으면 데이터가 리턴되고 없으면 null

				// 글번호 입력
				System.out.print("상세보기할 글번호 : ");
				int num1 = sc.nextInt();

				BoardClass board1 = boardService.getBoardClass(num1);
				if (board1 == null) {
					System.out.println("글번호에 해당하는 데이터가 없습니다.");
				} else {
					System.out.println(board1);
				}

				break;
			case 삽입하기:
				// 삽입하기는 BoardService 클래스의 insertBoard가 처리
				// 인스턴스 메소드이고 매개변수는 BoardClass 이고 리턴 타입은 boolean임니다.

				BoardClass board = new BoardClass();

				System.out.print("제목입력:");
				sc.nextLine();
				String temp = sc.nextLine();
				board.setTitle(temp);

				System.out.print("내용입력:");
				temp = sc.nextLine();
				board.setContent(temp);

				boolean r = boardService.insertBoard(board);

				break;
			case 수정하기:
				// 수정할 글 번호를 입력받기
				System.out.print("수정할 글번호 : ");
				int n = sc.nextInt();
				// 글번호가 n인 데이터 찾기
				BoardClass b = boardService.getBoardClass(n);
				if (b == null) {
					System.out.println("글 번호에 해당하는 데이터가 없습니다.");
					continue;
				} else {
					System.out.print("수정할 제목:");
					sc.nextLine();
					b.setTitle(sc.nextLine());

					System.out.print("수정할 내용:");
					b.setContent(sc.nextLine());

					boardService.updateBoard(b);
				}

				break;
			case 삭제하기:
				// 삭제할 글 번호 입력받기
				// 해당하는 데이터가 있는지 확인하고
				// 정말로 삭제할것인지 문고 삭제

				System.out.print("삭제할 글번호: ");
				int n1 = sc.nextInt();

				BoardClass c = boardService.getBoardClass(n1);
				if (c == null) {
					System.out.println("글번호에 해당하는 글이 없습니다.");
					continue;

				} else {
					System.out.print("정말로 삭제(삭제는: 1, 그외는 삭제안됨)");
					int del = sc.nextInt();
					if (del == 1) {
						boardService.deleteBoard(n1);
					}

				}

				break;
			case 종료하기:
				sc.close();
				System.out.println("프로그램 종료");
				System.exit(0); // 프로그램 종료 (0) 정상종료, 그 외 에러코드임 운영체제가 에러코드를 해결하는 작업을함..
				break;
			default:
				System.out.println("메뉴 확인좀 !!!!");
				break;

			}

		}

	}

}
