
/**
 * Data
 *
 * This is the back end that holds all of the data for the game.
 * Most classes have a object of this data class that can access the data through.
 *
 * @author Quinten Houck
 * @version 8/1/2021
 *
 */

public class Data {
	private int count; //Current score or count//
	private int lastX; //The X coordinate of the previous square//
	private int lastY; //The Y coordinate of the previous square//
	private int[][] grid; //A 10x10 integer grid//
	Score score; //An object of the Score TextArea class//
	boolean tutorial; //Whether the tutorial screen is active or not//
	boolean tPage; //Whether the 2nd tutorial screen is active or not//
	
	public Data() {
		lastX = -1;
		lastY = -1;
		count = 0;
		grid = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = 0; 
			}
		}
		
		score = new Score(this);
		tutorial = false;
		tPage = true;
	}
	
	//resets each grid square to 0//
	public void reset() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = 0; 
			}
		}
		lastX = -1;
		lastY = -1;
	}
	
	//Getters and Setters//
	public Score getScore() {
		return score;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void addCount() {
		count++;
	}
	
	public void subCount() {
		count--;
	}

	public int getLastX() {
		return lastX;
	}

	public void setLastX(int lastX) {
		this.lastX = lastX;
	}

	public int getLastY() {
		return lastY;
	}

	public void setLastY(int lastY) {
		this.lastY = lastY;
	}
	
	public int[][] getGrid(){
		return grid;
	}
	
	public void setGrid(int[][] grid) {
		this.grid = grid;
	}
	
	public void setTutorial(boolean set) {
		tutorial = set;
	}
	
	public boolean getTutorial() {
		return tutorial;
	}

	public boolean gettPage() {
		return tPage;
	}

	public void settPage(boolean tPage) {
		this.tPage = tPage;
	}
	

}
