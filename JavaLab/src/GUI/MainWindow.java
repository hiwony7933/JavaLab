package GUI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class MainWindow extends Frame {

	public MainWindow() {
		// 여러 개의 컴포넌트들을 올려 놓을 수 있는 패널을 생성
		Panel northPanel = new Panel();
		// 레이블과 텍스트 필드를 만들어서 패널에 배치
		// 패널은 FlowLayout 이라서 순서대로 배치
		Label IblTitle = new Label("Title");
		TextField txtTitle = new TextField(30);
		// 화면에 보여지는 문자 설정
		txtTitle.setEchoChar('*');
		northPanel.add(IblTitle);
		northPanel.add(txtTitle);

		// 프레임은 BorderLayout 이라서 방향과 함께 배치
		// 패널을 북쪽에 배치
		add("North", northPanel);

		Panel centerPanel = new Panel();
		Label IblContent = new Label("Content");
		TextArea taContent = new TextArea(20, 30);
		centerPanel.add(IblContent);
		centerPanel.add(taContent);
		add("Center", centerPanel);

		Panel southPanel = new Panel();
		// 패널의 레이아웃을 변경
		southPanel.setLayout(new GridLayout(2, 2));
		for (int i = 0; i < 4; i = i + 1) {
			Button button = new Button("Button" + i);
			southPanel.add(button);
		}

		setTitle("게시물 입력");
		setLocation(100, 100);
		setSize(300, 800);
		// 크기 변경을 못하게 설정
		setResizable(false);
		setVisible(true);

	}
}
