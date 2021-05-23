package stage1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import stage2.Stage2Constant;

/**
 * 
 * Stage1MyPanel - 스테이지2 패널에 대한 설정
 * <ol>
 * <li> 스테이지2 패널 생성자 설정</li>
 * <li> 공,블럭,바를 그리기 위한 그래픽스 설정</li>
 * 
 *
 */
@SuppressWarnings("serial")
public class Stage1Panel extends JPanel implements Stage1Constant {

	Stage1MainFrame rootComponent;

	/**
	 * 창 크기와 배경 설정
	 */
	public Stage1Panel() {
		this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		this.setBackground(Color.LIGHT_GRAY);
		
		
		
	}
	
	/**
	 * 
	 * 	UI를 그리기 위한 paint 설정
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		drawUI(g2d);
	}
	/**
	 * 
	 * 블럭 첫번째 - 하얀색</br>
	 * 블럭 두번째 - 노란색</br>
	 * 블럭 세번째 - 파란색</br>
	 * 블럭 네번째 - 심홍색</br>
	 * 블럭 다섯번째 - 빨간색</br></br>
	 * 
	 * <li>점수 - 점수색, 글씨 폰트 설정</li>
	 * <li>공 2개 설정</li>
	 * <li>바 설정</li>
	 * 
	 */
	public void drawUI(Graphics2D g2d) {


		for (int i = 0; i < BLOCK_ROWS; i++) {
			for (int j = 0; j < BLOCK_COLUMNS; j++) {

				if (rootComponent.blocks[i][j].isHidden) {
					continue;
				} else if (rootComponent.blocks[i][j].color == 0) {
					g2d.setColor(Color.WHITE);
				} else if (rootComponent.blocks[i][j].color == 1) {
					g2d.setColor(Color.YELLOW);
				} else if (rootComponent.blocks[i][j].color == 2) {
					g2d.setColor(Color.BLUE);
				} else if (rootComponent.blocks[i][j].color == 3) {
					g2d.setColor(Color.MAGENTA);
				} else if (rootComponent.blocks[i][j].color == 4) {
					g2d.setColor(Color.RED);
				}
				g2d.fillRect(rootComponent.blocks[i][j].x, rootComponent.blocks[i][j].y,
						rootComponent.blocks[i][j].width, rootComponent.blocks[i][j].height);

			}

			g2d.setColor(Color.BLUE);
			g2d.setFont(new Font("고딕체", Font.BOLD, 20));
			g2d.drawString("score : " + rootComponent.score, CANVAS_WIDTH / 2 - 50, 20);

			g2d.setColor(Color.BLACK); 
			g2d.fillOval(rootComponent.balls[0].x, rootComponent.balls[0].y, BALL_WIDTH, BALL_HEIGHT); 


			g2d.setColor(Color.WHITE);
			g2d.fillRect(rootComponent.bar.x, rootComponent.bar.y, BAR_WIDTH, BAR_HEIGHT);



		}
	}
}
