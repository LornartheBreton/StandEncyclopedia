import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Class to display popup messages
 */
public class PopUp {
	
	public PopUp(String mess) {
		JFrame parent = new JFrame();
	    JOptionPane.showMessageDialog(parent, mess);
	}
	
}
