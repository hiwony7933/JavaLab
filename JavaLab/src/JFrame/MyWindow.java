package JFrame;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends Frame {
	private Button btn;
	private TextField tf;

	// 인스턴스 변수로 버튼 2개를 추가
	private Button btn1, btn2; // 수동 두개
	private Button[] buttons = new Button[2]; // 배열생성

	public MyWindow() {
		// 여러 개의 컴포넌트를 묶어줄 Container 생성
		Panel p = new Panel();

		// 컴포넌트를 생성
		btn = new Button("Click");
		tf = new TextField(30);

		// 버튼의 이벤트 처리를 위한 ActionListener 인터페이스의 anonymous class 생성
		ActionListener listener = new ActionListener() {

			// 버튼을 누르거나 텍스트 필드에서 Return 누르거나 메뉴를 누르면 호출되는 메소드
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 입력한 내용 가져오기
				String msg = tf.getText();
				// 출력
				System.out.println(msg);
			}
		};

		// btn 에서 Action 이벤트가 발생하면 listener가 대신 처리하도록 위임 (Delegation)
		// btn.addActionListener(listener); (클릭 이벤트처리)

		// 이벤트 처리를 위한 인스턴스를 생성
		EventHandler handler = new EventHandler(tf);
		btn.addActionListener(handler);

		// 컴포넌트들을 컨테이너에 배치
		p.add(tf);
		p.add(btn);

		//버튼을 생성해서 패널에 추가 
		btn1 = new Button("Button1");
		p.add(btn1);

		btn2 = new Button("Button2");
		p.add(btn2);
		
		
		/* 각각의 버튼마다 이벤트 처리를 해야해서 버튼이 많을 경우 비추 
		//버튼의 이벤트 처리 - 라우팅을 이용하지 않는 경우
		ActionListener event1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Button1 use Click ");
			}
			
		};
		btn1.addActionListener(event1);
		
		ActionListener event2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Button2 use Click");
			}
			
		};
		btn2.addActionListener(event2);
		*/
		
		//이벤트 라우팅을 이용하는 방법
		ActionListener eventRouting = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(arg0.getActionCommand() + " 예약");
			}
			
		};
		btn1.addActionListener(eventRouting);
		btn2.addActionListener(eventRouting);
		
		
		// 컨테이너를 윈도우에 배치
		add(p);

		// Frame 기본설정
		setTitle("이벤트처리");
		setLocation(100, 100);
		setSize(300, 500);
		setVisible(true);

	}
}
