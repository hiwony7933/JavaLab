package GUI;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ButtonWindow extends Frame {

	private Button btn; // 버튼 만들때 여기서 만들어야 어디서든 쓸수있다 .
	private Checkbox man, woman; // 성별을 체크하는 라디오 버튼

	public ButtonWindow() {
		setTitle("버튼 윈도우");
		setLocation(100, 100);
		setSize(300, 300);

		Panel p = new Panel();

		btn = new Button("Button");
		// btn.setLabel("버튼1"); //버튼 텍스트 바꾸기
		// 버튼을 패널에 추가
		p.add(btn);

		CheckboxGroup group = new CheckboxGroup();
		man = new Checkbox("Man", group, true);
		woman = new Checkbox("Woman", group, false);
		p.add(man);
		p.add(woman);

		Label label = new Label("Hello World");
		p.add(label);

		for (int i = 0; i < 5; i = i + 1) {
			Button button = new Button("Button" + i);
			p.add(button);
		}

		ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		sp.add(p);

		add(p);

		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("file");
		MenuItem item = new MenuItem("open");

		menu.add(item);
		menuBar.add(menu);
		setMenuBar(menuBar);

		FileDialog open = new FileDialog(this, "open", FileDialog.LOAD);
		// 기본 디렉토리 설정
		open.setDirectory("C://");
		open.setVisible(true);
		// 선택한 파일 경로 출력하기
		System.out.println(open.getDirectory() + open.getFile());
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(open.getDirectory() + open.getFile())));
			String line = br.readLine();
			System.out.println(line);
		} catch (Exception e) {
		}
		setVisible(true);

		Color[] colors = { Color.RED, Color.BLUE, Color.GREEN };
		String[] Ibls = { "ello World H", "llo World He", "lo World Hel", "o World Hell", " World Hello",
				"World Hello ", "orld Hello W", "rld Hello Wo", "ld Heelo Wor" };
		int j = 0;
		while (true) {
			try {
				Thread.sleep(1000);
				j = j + 1;
				label.setText(Ibls[j % Ibls.length]);
				label.setForeground(colors[j % colors.length]);
			} catch (Exception e) {
			}
		}
	}
}
// 버튼 레이블 변경

/*
 * Color [] colors = { Color.RED, Color.BLUE, Color.GREEN }; int i = 0; while
 * (true) { try { Thread.sleep(1000); btn.setBackground(colors[i %
 * colors.length]); i = i + 1; } catch (Exception e) { } }
 */
