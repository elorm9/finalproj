package game.StartMenu;

import game.Board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartMenu extends JFrame implements ActionListener{

	private JButton start;
	private JButton instructions;
	
	private boolean isRunning;
	
	private int score;
	
	public StartMenu(){
		
		isRunning = true;
		
		this.getContentPane().setBackground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 150));
		
		start = new JButton("Start");
		start.setAlignmentY(CENTER_ALIGNMENT);
		start.setPreferredSize(new Dimension(100,100));
		start.setBackground(Color.GRAY);
		start.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		start.setActionCommand("start");
		
		instructions = new JButton("How to Play");
		instructions.setPreferredSize(new Dimension(200,100));
		instructions.setAlignmentY(CENTER_ALIGNMENT);
		instructions.setBackground(Color.GRAY);
		instructions.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		instructions.setActionCommand("instructions");
		
		start.addActionListener(this);
		instructions.addActionListener(this);
		
		setSize(800, 450);
		setResizable(false);
		
		add(start);
		add(instructions);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public boolean isRunning(){
		return isRunning;
	}
	
	public JButton getStart(){
		return start;
	}
	
	public JButton getInstruct(){
		return instructions;
	}
	
	public void showInstructions(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(isRunning == false)
			System.exit(0);
			
		if("start".equals(e.getActionCommand())){
			isRunning = false;
			
		}
		
		if("instructions".equals(e.getActionCommand())){
			showInstructions();
		}
		
		
	}
	


}
