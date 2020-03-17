package GUI;

import java.awt.Color;
import java.awt.Frame;

public class FrameMain1 {

	public static void main(String[] args) {
		// 윈도우 생성
		Frame f = new Frame();
		// 좌표설정
		f.setLocation(100, 100);
		// 윈도우 크기 설정 - 기본크기가 0,0이므로 크기 설정하지 않으면 출력안됨
		f.setSize(300, 500);

		f.setTitle("처음만드는 윈도우");
		f.setBackground(new Color(128, 3, 222));
		// 윈도우를 화면에 출력 - 기본적으로 보이지 않도록 설정되어 있어서 이 메소드를 호출해야 보여짐
		f.setVisible(true);
	}

}
