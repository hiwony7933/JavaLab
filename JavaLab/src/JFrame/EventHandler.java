package JFrame;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {

	private TextField tf;

	// 생성자 : TextField 1개를 주입받는 생성자
	public EventHandler(TextField tf) {
		this.tf = tf;
	}

	@Override
	// 이벤트 처리하는 메소드의 매개변수는 이벤트가 밸생한 객체에 대한 정보와
	// 이벤트 처리에 필요한 정보를 소유하고 있습니다.

	public void actionPerformed(ActionEvent e) {
		// 누르는 키값의 저장 위치를 확인하는 구문
		System.out.println(e.getModifiers());

		// 아래구문은 다른 키를 같이 눌렀을때도 적용됨.
		if (e.getModifiers() == ActionEvent.ALT_MASK) {
			System.out.println("Alt key together push");
		} else {
			System.out.println("Alt Key not push");
		}

		// alt 키만 눌렀을때의 감지 512가 알트키 저장위치 임
		if ((e.getModifiers() & 512) == 512) {
			System.out.println("Alt key together push");
		} else {
			System.out.println("Alt Key not push");
		}

		String msg = tf.getText();
		System.out.println(msg);

	}

}
