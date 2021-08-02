import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * Main Panel
 *
 * An extension of JPanel, this creates the main panel that the
 * rest of the buttons, panels, and text areas are held in.
 *
 * @author Quinten Houck
 * @version 8/1/2021
 *
 */

public class MainPanel extends JPanel{
	Image background;
	Data data;
	private int myTimerDelay;
	private final Timer myTimer;
	GamePanel gp;
	JTextArea score;
	JButton resetButton;
	JButton tutButton;
	JButton nextButton;
	JButton backButton;
	
	public MainPanel(Data data) {
		super();
		this.data = data;
		
		this.setPreferredSize(new Dimension(700, 700));
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		
		//Starts the repaint timer and sets for 200 milliseconds//
		myTimerDelay = 200;
        myTimer = new Timer(myTimerDelay, gameTimer);
        myTimer.start();
        
        //Instantiates the game panel//
        gp = new GamePanel(data);
		gp.setBounds(50, 75, 600, 600);
		this.add(gp);
		
		//Button that resets the game and brings the score back to 0//
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset(data, gp);
            }
        });
		resetButton.setVisible(true);
		resetButton.setBounds(300, 20, 100, 40);
		this.add(resetButton);
		
		//Text Area that displays the current score//
		score = new JTextArea();
		score.setOpaque(false);
		score.setEditable(false);
		Font font = new Font("Arial", Font.BOLD, 30);
		score.setFont(font);
		score.setText("Score: " + data.getCount());
		score.setVisible(true);
		score = data.getScore();
		score.setBounds(110, 20, 150, 40);
		this.add(score);
		
		//Button that brings the user to the tutorial screen//
		tutButton = new JButton();
		tutButton.setFont(font);
		tutButton.setText("?");
		tutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.setTutorial(true);
                data.settPage(true);
            }
        });
		tutButton.setVisible(true);
		tutButton.setBounds(410, 20, 60, 40);
		this.add(tutButton);
		
		//Sends the user to the next frame of the tutorial screen//
		nextButton = new JButton();
		font = new Font("Arial", Font.PLAIN , 20);
		nextButton.setFont(font);
		nextButton.setText("Next");
		nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.settPage(false);
            }
        });
		nextButton.setVisible(false);
		nextButton.setBounds(475, 640, 100, 40);
		this.add(nextButton);
		
		//Returns the user from the next screen//
		backButton = new JButton();
		font = new Font("Arial", Font.PLAIN , 20);
		backButton.setFont(font);
		backButton.setText("Back");
		backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(data.gettPage()) {
                	data.setTutorial(false);
                } else {
                	data.settPage(true);
                }
            }
        });
		backButton.setVisible(false);
		backButton.setBounds(30, 640, 80, 40);
		this.add(backButton);
        
		
	}
	
	//Where the timer calls//
	ActionListener gameTimer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent theEvent) {
        	redraw();
        }
    };
    
    //Reset function that clears all squares and sets score to 0//
    public static void reset(Data data, GamePanel gp) {
		data.setCount(0);
		data.setLastX(-1);
		data.setLastY(-1);
		data.reset();
		gp.reset();
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, 700, 700, this);
	}

    //Determines what should be painted or visible//
    public void redraw() {
    	if (data.getTutorial()) {
    		gp.setVisible(false);
    		score.setVisible(false);
    		resetButton.setVisible(false);
    		tutButton.setVisible(false);
    		backButton.setVisible(true);
    		if (data.gettPage()) {
    			background = Images.getImage("sprites/GridGameWords.PNG");
    			nextButton.setVisible(true);
    		} else {
    			background = Images.getImage("sprites/GridGameBackground.PNG");
    			nextButton.setVisible(false);
    		}
    	} else {
    		background = null;
    		gp.setVisible(true);
    		resetButton.setVisible(true);
    		score.setVisible(true);
    		nextButton.setVisible(false);
    		tutButton.setVisible(true);
    		backButton.setVisible(false);
    		score.setText("Score: " + data.getCount());
    	}
    	this.repaint();
    }

}
