import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Main executable
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException,
    JavaLayerException{
		/*Encyclopedia enc=new Encyclopedia();
		String search="josuke";
		
		//System.out.println(enc.getStand(5, 0).toString());
		JFrame frame = new JFrame();
		ImageIcon icon=new ImageIcon(enc.findMaster(search).get(0).getImage());
		JLabel label = new JLabel(icon);
		  frame.add(label);
		  frame.setDefaultCloseOperation
		         (JFrame.EXIT_ON_CLOSE);
		  frame.pack();
		  frame.setVisible(true);
		
		//enc.findMaster("geil").get(0).setImage("JGeil.png");
		System.out.println(enc.findMaster(search).get(0).toString());
		Player ply=new Player(new FileInputStream(enc.getStand(5, 1).getBattleCry()));
		
		ply.play();*/
		
		PrimaryController c=new PrimaryController("Jojo's Bizarre Encyclopedia");
	}

}
