//package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrameTest extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JFrame mf = new JFrame("Make The Button Disappear!");
	
	JButton button = new JButton("Good Job you won!");
	JPanel pane = new JPanel(new FlowLayout());
	
	int count = 0;
	boolean shouldDraw = false;
	
	public FrameTest(){
		mf.setLayout(new BorderLayout());		
		mf.setTitle("Make The Button Disappear!");
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
		mf.add(this, BorderLayout.CENTER);
		
		button.addActionListener(this);
		mf.add(button, BorderLayout.PAGE_START);
		
		mf.setSize(new Dimension(500,500));
		mf.setBackground(new Color(50,100,255));
		mf.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(new Color(255,255,100));
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.BLACK);
		if(shouldDraw)
			g.drawString("YOU WIN!", 400, 400);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		count++;
		button.setText("OW DON'T PUNCH ME!");
		if(count > 101){
			button.setVisible(false);
			shouldDraw = true;
			repaint();
		}
		else if(count > 100){
			button.setText("Punch me one more time I go.");
		}
		else if(count > 50){
			button.setText("SRSLY STOP OR I WILL EXPLODE!");
			button.setBackground(new Color(count * 2 + 55,50,50));
		}
		else if (count > 10){
			button.setText("Ok now I am mad!");
		}
	}
}
