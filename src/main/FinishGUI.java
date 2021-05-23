package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import stage1.Stage1MainFrame;
import stage2.Stage2Bar;
import stage2.Stage2MainFrame;
import stage2.Stage2MyPanel;

/**
 * 
 * 게임이 끝났을 때 뜨는 GUI
 *
 */
@SuppressWarnings("serial")
public class FinishGUI extends JFrame {

	private static final String EXIT = "게임 종료"; // 게임 종료 문자열
	private static final String BACK = "스테이지 선택하기"; // 스테이지 선택하기 문자열

	private static final String[] RESTART_BACK_BUTTON = { EXIT, BACK }; // 두 문자열 배열에 담기

	private JPanel panel; // 패널
	private JButton[] buttons; // 버튼

	/**
	 * @param listener
	 *                 <li>EXIT 버튼 동작</li>
	 *                 <li>BACK 버튼 동작</li>
	 *
	 */
	public ActionListener listener = new ActionListener() { // 버튼을 눌렀을 때 동작

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			switch (button.getText()) {
			case EXIT: {					// 게임 종료

				setVisible(false);

				System.exit(0);

				break;
			}
			case BACK: {				// 뒤로 가기

				setVisible(false);
				new MainGUI(getName());

				break;
			}

			}
		}

	};

	/**
	 * 
	 * 게임 제목, EXIT,BACK 버튼이 부착되어 있는 GUI
	 * 
	 * 
	 * @param title - 게임 제목 "벽돌 깨기"
	 */
	public FinishGUI(String title) {

		super("벽돌 깨기");

		panel = new JPanel(); // 패널 생성
		panel.setLayout(null); // 패널 배치 방식 자유롭게

		
		
		//버튼
		buttons = new JButton[RESTART_BACK_BUTTON.length]; // 버튼 배열 공간 만들기
		for (int i = 0; i < RESTART_BACK_BUTTON.length; ++i) {
			buttons[i] = new JButton(RESTART_BACK_BUTTON[i]); // 버튼 생성
			buttons[i].setFont(new Font("고딕체", Font.CENTER_BASELINE, 20)); // 버튼 폰트 설정

			buttons[i].setForeground(new Color(33, 33, 33)); // 버튼 글자색
			buttons[i].setBackground(new Color(216, 216, 216)); // 버튼 배경색

			buttons[i].addActionListener(listener); // 버튼 동작 추가

			buttons[i].setLayout(null); // 버튼 배치 방식 자유롭게
			buttons[i].setBounds(100, 80 * 2 * (i + 1), 250, 100); // 버튼 위치 설정
			panel.add(buttons[i]); // 버튼 패널에 추가

		}

		// 제목
		JLabel j = new JLabel("벽돌 깨기", SwingConstants.CENTER); // 라벨 생성(제목 생성)
		j.setFont(new Font("고딕체", Font.BOLD, 50)); // 제목 폰트 설정
		j.setForeground(new Color(250, 98, 3)); // 제목 글자색
		j.setBounds(100, 30, 250, 100); // 제목 위치
		this.add(j); // 제목 패널에 추가
		
	
		
		
		
		setSize(440, 600);	// 창 크기
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 종료 기본 설정
		setLocationRelativeTo(null);// 창 중앙에 배치
		add(panel);						// 창에 패널을 부착
		setVisible(true);			// 창이 보이게 설정
	}
}
