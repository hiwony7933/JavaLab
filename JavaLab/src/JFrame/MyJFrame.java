package JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyJFrame extends JFrame {
	JLabel Ibl;
	ImageIcon icon; 
	JButton btn;
	
	// 애니메이션을 수행할 스레드 변수 
	Thread th;
	public MyJFrame() {
		/*
		//단순한 메시지 출력 - 리턴값이 없습니다.
		JOptionPane.showMessageDialog(this,  "메시지", "제목", JOptionPane.ERROR_MESSAGE);
		*/
		
		//2개 이상의 버튼을 배치해서 confirm을 받은 메소드
		/*
		int result = JOptionPane.showConfirmDialog(this, "정말로삭제", "삭제", JOptionPane.YES_NO_CANCEL_OPTION);
		if(result ==JOptionPane.YES_OPTION) {
			
		}else if (result == JOptionPane.NO_OPTION) {
			
		}else if (result == JOptionPane.CANCEL_OPTION) {
			
		}
		*/
		
		// 한줄의 텍스트를 입력받는 대화상자를 출력
		// 입력한 내용이 없는 상태에서 확인을 누르면 "" <--- 
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요", "");
		System.out.println(name);
		
		JPanel p = new JPanel();
		// JLabel Ibl = new JLabel("문자열");
		// 이미지를 가지고 아이콘을 생성
		// 이미지 파일 크기 그대로 생성됨.

		// icon = new ImageIcon("C:\\Users\\norel\\Downloads\\1.png");
		Ibl = new JLabel(icon);
		p.add(Ibl);
		
		// 버튼을 만들어서 패널에 추가
		btn = new JButton("시작");
		p.add(btn);
		
		//버튼을 누를 때 이벤트 처리를 위한 인스턴스를 생성
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				switch(arg0.getActionCommand()) {
				case "시작" : 
					btn.setText("중지");
					//스레드를 생성해서 시작
					th = new Thread() { 
						// String [] images = {"파일이름", "파일이름", "파일이름"};
						public void run() {
							try {
								int i = 0 ;
								while(true) {
									//0.1초마다 대기
									Thread.sleep(100);
									// 아이콘 생성  
									// 규칙이 없으면 배열을 만들고 배열에서 가져오게 한다.
									// (i&10) -> images[i % images.length]
									icon = new ImageIcon("C:\\Users\\norel\\Downloads\\" + (i%10) + ".png");
									Ibl.setIcon(icon);
									i = i + 1;
									
								}
							}catch(InterruptedException e) {
								return;
							}
						}
					};
					th.start();
					break;
				case "중지" :
					btn.setText("시작");
					//스레드를 중지 
					th.interrupt();
					break;
				}
			}
			
		};
		btn.addActionListener(listener); 	// 버튼 btn의 이벤트 리스너의 연결 
		
		//테이블에 출력할 컬럼이름 배열
		String [] columnNames = {"이름", "전화번호" , "주소"};
		String [] [] data = {{"이주원" , "01075777933", "파주시 해솔로 20"}, {"류해단", "010101010","구로구"}, {"정세희", "03020202020", "광명시"}};
		
		//데이터를 가지고 테이블 모델을 생성
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		//테이블 모델을 가지고 테이블 생성
		JTable table = new JTable(model);
		
		//테이블은 데이터가 무한정 늘어날 수 있어서 상위 컨데이너의 크기를 넘어 설수 있다. 
		//바로 패널이나 프레임에 배치하지 말고 JScrollPane에 배치한후 배치하는것을 권장합니다.
		JScrollPane sp = new JScrollPane(table);
		
		p.add(sp);
		
		add(p); // 뭔가 보여지는거는 이 라인 전에 만들어야됨.
		
		//메뉴바 -> 메뉴 -> 메뉴아이템
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("메뉴(T)"); 
		//ALT + t를 별도의 단축키로 설정을 하면 단축키는 동작하지 않는다 
		menu.setMnemonic('t'); 		//단축키 설정

		//메뉴 항목 만들기
		JMenuItem item = new JMenuItem("파일 열기");
		//메뉴 아이템의 이벤트 처리는 버튼과 같다. ActionListener 이용
		//Anonymous Class 안에서 this는 자기 자신이다. 
		
		ActionListener itemListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//내부 클래스에서 외부 클래스의 인스턴스를 호출 할 때는
				//외부 클래스이름.this로 한다. 
				//안드로이드에서는 이벤트 처리를 많이 하고 메모리 절약을 위해서 anonymous를 많이 
				//사용하기 때문에 외부 클래스의 인스턴스를 호출해야 하는 상황이 많아서
				//이 문법을 기억해야 한다. 
				//JOptionPane.showMessageDialog(this, "메뉴를 누름");		//this 못씀..
				JOptionPane.showMessageDialog(MyJFrame.this, "메뉴를 누름");		// this 못써서 외부클래스이름을 쓴다
			}
			
		};
		item.addActionListener(itemListener); 	// 연결 
		item.setToolTipText("파일을 열수 없습니다(아직은...)");
		
		menu.add(item);
		bar.add(menu);
		this.setJMenuBar(bar); 		// 메소드를 모르면 this. 사용해라~

		
		setTitle("이미지 레이블");
		setLocation(100, 100);
		setSize(500, 1000);
		setVisible(true);

		// 종료기능부여 - JFrame 이것이바뀐거임.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* int i = 0;
		while (true) {

			try {
				Thread.sleep(1000);

				icon = new ImageIcon(" 파일경로" + (i%10) + ".png");
				Ibl.setIcon(icon);
				i = i + 1;
			} catch (Exception e) {
			}
			
			// 이미지 교체 애니메이션
			
			 String[] images = { "파일이름 ", "파일이름", "파일이름" };
			 
			 while (true) { int i = 0; try { Thread.sleep(50); i = i + 1; icon = new
			 ImageIcon("파일경로" + images[i % images.length]); Ibl.setIcon(icon);
			  
			 } catch (Exception e) { }
			 
		}*/
	}

}
