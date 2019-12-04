import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
		Encyclopedia enc=new Encyclopedia();
		
		enc.readMasterFile();
		enc.readStandFile();
		//System.out.println(enc.getStand(5, 0).toString());
		JFrame frame = new JFrame();
		ImageIcon icon=new ImageIcon(enc.findStand("Highway").get(0).getImage());
		JLabel label = new JLabel(icon);
		  frame.add(label);
		  frame.setDefaultCloseOperation
		         (JFrame.EXIT_ON_CLOSE);
		  frame.pack();
		  frame.setVisible(true);
		
		System.out.println(enc.findMaster("Riss").get(0).getImage());
		Player ply=new Player(new FileInputStream(enc.getStand(5, 1).getBattleCry()));
		
		ply.play();
		
		
	}

}
