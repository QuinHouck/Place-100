import java.awt.Font;

import javax.swing.JTextArea;

/**
 * Score
 *
 * An extension of JTextArea.
 * A helper class designed to make it easier to change the score displayed
 *
 * @author Quinten Houck
 * @version 8/1/2021
 *
 */

public class Score extends JTextArea {
	Data data;
	
	public Score(Data data) {
		super();
		this.data = data;
		this.setOpaque(false);
		this.setEditable(false);
		Font font = new Font("Arial", Font.BOLD, 30);
		this.setFont(font);
		this.setText("Score: " + data.getCount());
		this.setVisible(true);
		
	}
	
	public void changeScore() {
		this.setText("Score: " + data.getCount());
	}

}
