package JFrame;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class KeyWindow extends Frame {

	private Label Ibl;

	public KeyWindow() {

		setLayout(null); // 컴포넌트들의 위치변경이나 크기 변경이 가능하도록 레이아웃을 null로 설정

		// 레이블을 생성하고 배치
		Ibl = new Label("@");
		Ibl.setLocation(20, 30);
		Ibl.setSize(15, 15);
		add(Ibl);

		// 레이블을 1초마다 아래로 5만큼씩 이동하는 스레드
		Thread th = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						int x = Ibl.getLocation().x;
						int y = Ibl.getLocation().y;
						y = y + 5;
						Ibl.setLocation(x, y);
					} catch (Exception e) {
					}
				}
			}
		};
		th.start();

		// 키보드 이벤트 처리르 ㄹ위한 인스턴스를 ㅎ생성
		KeyListener listener = new KeyListener() {
			// 키보드를 누렀을 때 호출되는 메소드
			@Override
			public void keyPressed(KeyEvent e) {
				// 조합키 확인 : shift-1, control-2, alt-8
				int modifiers = e.getModifiers();
				// control + X 이면 종료
				// control 키가 눌러졌는지 확인 - 대소문자를 구분해서 하고자 하는 경우는 getKeyChar()
				if ((modifiers & 2) != 0) {
					int key = e.getKeyCode();
					if (key == KeyEvent.VK_X) {
						System.exit(0);
					}
				}

				// System.out.println(modifiers); // 키 번호 확인

				// System.out.println("아무키나 누르면 호출됩니다.");

				// keyChar 는 대소문자 구분 : a -> a A-> A
				// System.out.println(e.getKeyChar());

				// keycode는 대소문자 구부만 안함 : a ->65, A->65
				// System.out.println(e.getKeyCode());

				// 현재 레이블의 위치 가져오기
				int x = Ibl.getLocation().x;
				int y = Ibl.getLocation().y;

				// 누른 키보드 값 가져오기
				int code = e.getKeyCode();

				switch (code) {
				case KeyEvent.VK_UP:
					y = y - 5;
					break;
				case KeyEvent.VK_DOWN:
					y = y + 5;
					break;
				case KeyEvent.VK_LEFT:
					x = x - 5;
					break;
				case KeyEvent.VK_RIGHT:
					x = x + 5;
					break;
				}
				Ibl.setLocation(x, y);

			}

			// 키보드에서 손을 뗄 때 호출되는 메소드
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("키보드에서 손을 떼면 무조건 호출");
			}

			// 문자키를 눌렀을 때 호출되는 메소드
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("문자 키를 눌렀을 때 호출");

			}

		};
		// 윈도우에 키보드 이벤트 리스너를 연결
		this.addKeyListener(listener);

		setTitle("key Title");
		setLocation(100, 100);
		setSize(300, 500);
		setVisible(true);

		// Listener는 인터페이스라서 모든 메소드를 구현해야 하지만..
		// Adapter는 추상 클래스라서 추상메소드와 필요한 메소드만 구현하면 됩니다.
		WindowAdapter windowListener = new WindowAdapter() {

			// 종료 버튼을 누를 때 호출되는 메소드
			@Override
			public void windowClosing(WindowEvent arg0) {
				// 프로그램 종료
				System.exit(0);
			}

		};
		// 윈도우 이벤트 연결
		this.addWindowListener(windowListener);

	}
}
