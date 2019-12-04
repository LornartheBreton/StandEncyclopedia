import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Main Encyclopedia class
 */
public class Encyclopedia {
	private Stand[][] stands;
	private Master[][] masters;
	private int[] standsCounter= {0,0,0};
	private int[] mastersCounter= {0,0,0};
	private final int PARTS=3;
	private final int MAX_STANDS=36;
	
	public Encyclopedia() {
		stands=new Stand[PARTS][MAX_STANDS];
		masters=new Master[PARTS][MAX_STANDS];
	}
	
	public boolean addMaster(String name, String namesake, double height, char sex, int yearOfBirth, String image,
			int debut) {
		boolean ans=false;
		Master add;
		
		if(mastersCounter[debut-3]<MAX_STANDS) {
			ans=true;
			if(height==0.0) {
				add= new Master(name,namesake,sex,debut);
			}else {
				add=new Master(name,namesake,height,sex,yearOfBirth,image,debut);
			}
			debut-=3;
			masters[debut][mastersCounter[debut]]=add;
			mastersCounter[debut]++;
		}
		return ans;
	}
	
	public void readMasterFile() {
		File master=new File("Data/standMasters.csv");
		String name,nameSake,image,h;
		double height=0.0;
		char sex;
		int yearOfBirth=0,debut;
		
		try (Scanner scn=new Scanner(master)){
			scn.nextLine();
			scn.useDelimiter(",|\\n");
			while(scn.hasNext()) {
				//System.out.println(scn.hasNext());
				name=scn.next();
				//System.out.println(name);
				//System.out.println(scn.hasNext());
				nameSake=scn.next();
				//System.out.println(nameSake);
				//System.out.println(scn.hasNext());
				height=scn.nextDouble();
				//System.out.println(height);
				//System.out.println(scn.hasNext());
				sex=scn.next().charAt(0);
				//System.out.println(sex);
				//System.out.println(scn.hasNext());
				yearOfBirth=scn.nextInt();
				//System.out.println(yearOfBirth);
				//System.out.println(scn.hasNext());
				image=scn.next();
				//System.out.println(image);
				//System.out.println(scn.hasNext());
				debut=Integer.parseInt(String.valueOf(scn.next().charAt(0)));
				//System.out.println(debut);
				addMaster(name,nameSake,height,sex,yearOfBirth,image,debut);
				//System.out.println(yearOfBirth);
				//h=scn.nextLine();
				//System.out.println(h);
			}
			
			scn.close();
		}catch(FileNotFoundException fnfe) {
			System.err.println("Could not find standMaster file"+fnfe);
			System.exit(-1);
		}
	}
	
	public boolean addStand(String name, int debut, String master, char d,char s,char r, char p, char pr,char de, String type, String ability, String namesake,
			String image,String battleCry) {
		boolean ans=false;
		Stand add;
		int y,deb=debut-3;
		char[] stats= {d,s,r,p,pr,de};
		Master search=new Master(master);
		
		if(standsCounter[deb]<MAX_STANDS) {
			y=ArrayManager.search(masters[deb],search,mastersCounter[deb]);
			if(!battleCry.isEmpty()) {
				add=new Stand(name,debut,master,stats,type,ability,namesake,
				image,y,battleCry);
			}else {
				add=new Stand(name,debut,master,stats,type,ability,namesake,
						image,y);
			}
			stands[deb][standsCounter[deb]]=add;
			standsCounter[deb]++;
			ans=true;
		}
		
		return ans;
	}
	
	public void readStandFile() {
		File stands=new File("Data/stands.csv");
		String name,master,type,ability,namesake,image,battleCry;
		char d,s,r,p,pr,de;
		int debut;
		
		try (Scanner scn=new Scanner(stands)){
			scn.nextLine();
			scn.useDelimiter(",|\\n");
			while(scn.hasNext()) {
				name=scn.next();
				System.out.println(name);
				master=scn.next();
				//System.out.println(master);
				debut=scn.nextInt();
				//System.out.println(debut);
				d=scn.next().charAt(0);
				//System.out.println(height);
				s=scn.next().charAt(0);
				//System.out.println(sex);
				r=scn.next().charAt(0);
				//System.out.println(yearOfBirth);
				p=scn.next().charAt(0);
				//System.out.println(image);
				pr=scn.next().charAt(0);
				de=scn.next().charAt(0);
				type=scn.next();
				ability=scn.next();
				image=scn.next();
				battleCry=scn.next();
				namesake=scn.next();
				//System.out.println(battleCry);
				addStand(name, debut, master, d,s,r,p,pr,de,type,ability,namesake,
						image,battleCry);
				//System.out.println(yearOfBirth);
			}
			
			scn.close();
		}catch(FileNotFoundException fnfe) {
			System.err.println("Could not find stands file"+fnfe);
			System.exit(-1);
		}
	}
	
	public Master getMaster(int x, int y) {
		x-=3;
		
		return masters[x][y];
	}
	
	public Stand getStand(int x, int y) {
		x-=3;
		
		return stands[x][y];
	}
	
	public ArrayList<Master> findMaster(String name) {
		ArrayList<Master> result=new ArrayList<Master>();
		
		for(int i=0;i<PARTS;i++) {
			for(int c=0;c<mastersCounter[i];c++) {
				if(masters[i][c].getName().contains(name)) {
					result.add(masters[i][c]);
				}
			}
		}
		
		return result;
	}
	
	public ArrayList<Stand> findStand(String name) {
		ArrayList<Stand> result=new ArrayList<Stand>();
		
		for(int i=0;i<PARTS;i++) {
			for(int c=0;c<standsCounter[i];c++) {
				if(stands[i][c].getName().contains(name)) {
					result.add(stands[i][c]);
				}
			}
		}
		
		return result;
	}
	
	public String toString() {
		StringBuilder build=new StringBuilder();
		
		build.append("\nStand Masters");
		build.append("\n	Part 3 - Stardust Crusaders");
		for(int i=0;i<mastersCounter[0];i++) {
			build.append("\n			"+masters[0][i].toString());
		}
		build.append("\n	Part 4 - Diamond is Unbreakable");
		for(int i=0;i<mastersCounter[1];i++) {
			build.append("\n			"+masters[1][i].toString());
		}
		build.append("\n	Part 5 - Vento Aureo");
		for(int i=0;i<mastersCounter[2];i++) {
			build.append("\n			"+masters[2][i].toString());
		}
		build.append("\nStands");
		build.append("\n	Part 3 - Stardust Crusaders");
		for(int i=0;i<standsCounter[0];i++) {
			build.append("\n			"+stands[0][i].toString());
		}
		build.append("\n	Part 4 - Diamond is Unbreakable");
		for(int i=0;i<standsCounter[1];i++) {
			build.append("\n			"+stands[1][i].toString());
		}
		build.append("\n	Part 5 - Vento Aureo");
		for(int i=0;i<standsCounter[2];i++) {
			build.append("\n			"+stands[2][i].toString());
		}
		return build.toString();
	}
}
