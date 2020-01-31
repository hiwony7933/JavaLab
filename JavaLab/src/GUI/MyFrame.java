package GUI;

import java.awt.Dialog;
import java.awt.Frame;

public class MyFrame extends Frame {

	// 생성자
	public MyFrame() {
		setTitle("프레임상속");
		setLocation(20, 20);
		setSize(400, 400);

		// 대화상자를 만들어서 출력-모달로 생성
		// 대화상자가 모달로 출력이되면 출력 이후 문장은 대기상태
		Dialog dialog = new Dialog(this, "대화상자", true);
		dialog.setLocation(10, 10);
		dialog.setSize(100, 100);
		dialog.setVisible(true);

		setVisible(true);

		dialog.setVisible(true);
	}
}
