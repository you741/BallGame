package frames;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = -78609259601161383L;

	JPanel pane = new JPanel();
	JPanel topPane = new JPanel();
	
	JLabel titleLabel = new JLabel("Choose a difficulty to start");
	
	JButton btn = new JButton("START");
	
	JRadioButton jrb = new JRadioButton("Easy");
	JRadioButton jrb2 = new JRadioButton("Medium");
	JRadioButton jrb3 = new JRadioButton("Hard");
	
	ButtonGroup bg = new ButtonGroup();
	
	int diff = 0;
	
	public GameFrame(){
		
		setLayout(new BorderLayout());
		setSize(new Dimension(600,500));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pane.setLayout(new FlowLayout());
		pane.setSize(new Dimension(500,500));
		pane.setBackground(new Color(220,220,50));
		add(pane, BorderLayout.CENTER);
		
		topPane.setLayout(new FlowLayout());
		topPane.setPreferredSize(new Dimension(500,50));
		topPane.setBackground(new Color(150,200,255));
		add(topPane, BorderLayout.PAGE_START);
		
		titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
		titleLabel.setForeground(new Color(190,165,50));
		topPane.add(titleLabel);
		
		btn.addActionListener(this);
		pane.add(btn);
		
		jrb.addActionListener(this);
		jrb.setSelected(true);
		pane.add(jrb);
		bg.add(jrb);
		
		jrb2.addActionListener(this);
		pane.add(jrb2);
		bg.add(jrb2);
		
		jrb3.addActionListener(this);
		pane.add(jrb3);
		bg.add(jrb3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn){
			Runner run = new Runner(diff);
			dispose();
		}
		if(e.getSource() == jrb){
			diff = 0;
		}
		if(e.getSource() == jrb2){
			diff = 1;
		}
		if(e.getSource() == jrb3){
			diff = 2;
		}
	}
	public static void main(String args[]){
		GameFrame game = new GameFrame();
	}
}
