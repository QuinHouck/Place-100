import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Square
 *
 * Each square is an extension of a JButton.
 * Each square holds a number for the grid.
 * Numbers can be placed or removed.
 *
 * @author Quinten Houck
 * @version 8/1/2021
 *
 */

public class Square extends JButton {
	Data data;
	int x;
	int y;
	int value;
	ImageIcon iconA;
	int state;
	
	public Square(Data data, int x, int y) {
		super();
		this.data = data;
		value = 0;
		iconA = new ImageIcon(Images.getImage("sprites/SquareBackground.PNG"));
		this.setIcon(iconA);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
		this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (data.getGrid()[x][y] == 0) {
            		if (checkSquare(data,x,y) == 1) {          			
            			state=1;
            			placeNumber(data, x, y);
            		}	
            	} else if (data.getCount() == value) {
            		state=0;
            		removeNumber(data, x, y);
            	}
            }
        });
	}
	
	//The next number is placed in the grid square//
	//The data object is updated for the new square//
	public void placeNumber(Data data, int x, int y) {
		data.setLastX(x);
		data.setLastY(y);
		this.setText(String.valueOf(data.getCount()+1));
		data.getGrid()[x][y] = data.getCount()+1;
		data.addCount();
		value = data.getCount();
	}
	
	//The last number placed is removed//
	//The data object is updated//
	public void removeNumber(Data data, int x, int y) {
		this.setText("");
		data.getGrid()[x][y] = 0;
		data.subCount();
		value = 0;
		
		//Finds last number placed before just removed//
		//Sets last coordinates of that square in data object//
		int[][] grid = data.getGrid();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (grid[i][j] == data.getCount()) {
					data.setLastX(i);
					data.setLastY(j);
				}
				if (data.getCount() == 0) {
					data.setLastX(-1);
					data.setLastY(-1);
				}
			}
		}
	}
	
	//Resets the text and value of each square//
	public void reset() {
		value = 0;
		this.setText("");
	}
	
	//Checks the eligibility of a square for the next number to be placed//
	//New numbers can be placed 3 away up, down, left, and right//
	//New numbers can be placed 2 away diagonally//
	public int checkSquare(Data data, int x, int y) {
		int LX = data.getLastX();
		int LY = data.getLastY();
		if (LX == -1 && LY == -1) {
			return 1;
		}
		
		try {
			if (LX-3 == x && LY == y) {
				return 1;
			} else if (LX-3 == x && LY == y) {
				return 1;
			} else if (LX-2 == x && LY+2 == y) {
				return 1;
			} else if (LX == x && LY+3 == y) {
				return 1;
			} else if (LX+2 == x && LY+2 == y) {
				return 1;
			} else if (LX+3 == x && LY == y) {
				return 1;
			} else if (LX+2 == x && LY-2 == y) {
				return 1;
			} else if (LX == x && LY-3 == y) {
				return 1;
			} else if (LX-2 == x && LY-2 == y) {
				return 1;
			} else {
				return 0;
			}
		} catch (IndexOutOfBoundsException e) {
			return 0;
		}
	}
}
