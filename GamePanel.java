import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * Game Panel
 *
 * An extension of JPanel, this is the panel where the game is played.
 * It creates and stores each grid square.
 *
 * @author Quinten Houck
 * @version 8/1/2021
 *
 */

public class GamePanel extends JPanel {
	Image background;
	Data data;
	Square[][] grid;
	
	public GamePanel(Data data) {
		super();
		this.data = data;
		this.setLayout(new GridLayout(10,10));
		this.setBackground(Color.RED);
		this.setVisible(true);
		
		//Makes the grid//
		grid = new Square[10][10];
		
		//Creates each square//
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Square square = new Square(data,i,j);
				grid[i][j] = square;
				this.add(square);
			}
		}
		
	}
	
	//Calls the reset feature for each grid square//
	public void reset() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j].reset(); 
			}
		}	
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);	
	}
	
	public void changeBackground() {
		background = Images.getImage("sprites/GridGameWords.PNG");
		repaint();
	}
	
}