import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * The StandView controller
 */
public class StandController extends StandView{
	private Stand t;
	private AbilityView a;
	private String ability,name,path;
	private Player ply;
	
	public StandController(String title, Stand stando) {
		super(title, stando);
		
		t=stando;
		name=title;
		ability=t.getAbility();
		path=t.getBattleCry();
		System.out.println(path);
		this.checkAbility.addActionListener(new buttonListener());
		this.checkMaster.addActionListener(new buttonListener());
		
		if(this.playBattlecry!=null) {
			this.playBattlecry.addActionListener(new buttonListener());
		}
	}
	
	private class buttonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			String command=e.getActionCommand(),master=t.getMasterName();
			
			if(command.equals("Read ability")) {
				a=new AbilityView(name,ability);
			}
			if(command.equals("Play battlecry")) {
				try {
					ply=new Player(new FileInputStream(path));
					ply.play();
				} catch (FileNotFoundException fnfe) {
					System.err.println("Oi Josuke! I used THE HAND to touch that file and now I cant't find it! Ain't that just wacky? "+fnfe);
				} catch (JavaLayerException jle) {
					System.err.println("King Crimson has predicted that layer and leapted past it! "+jle);
				}
			}
			if(command.equals(master)) {
				
			}
		}
		
	}
}
