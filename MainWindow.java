import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Main Window
 *
 * An extension of JFrame, this creates the main window that the
 * game is run in.
 *
 * @author Quinten Houck
 * @version 8/1/2021
 *
 */

public class MainWindow extends JFrame {
	Image background;
	Data data;
	JTextArea score;
	GamePanel gp;
	
	//Creates the main frame and window for the application//
	public MainWindow() {
		super("Place 100!");
		data = new Data();
		MainPanel frame = new MainPanel(data);
		
		this.add(frame);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
