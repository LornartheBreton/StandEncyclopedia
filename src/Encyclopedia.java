import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Copyright Hector G. T. Torres	191589
 * 12/2019
 * Main Encyclopedia class that binds everything together
 */
public class Encyclopedia {
	private Stand[][] stands;
	private Master[][] masters;
	private int[] standsCounter= {0,0,0};
	private int[] mastersCounter= {0,0,0};
	private final int PARTS=3;//Only 3 of the animated Jojo parts have Stands
	private final int MAX_STANDS=40;//Exceeded the number of Stands in Part 3 to test adding Stands
	//One Encyclopedia config, one constructor
	public Encyclopedia() {
		stands=new Stand[PARTS][MAX_STANDS];
		masters=new Master[PARTS][MAX_STANDS];
		//Reading files here because it is ESSENTIAL
		readMasterFile();
		readStandFile();
		
	}
	//Adds a master, no class
	public boolean addMaster(String name, String namesake, double height, char sex, int yearOfBirth, String image,
			int debut) {
		boolean ans=false;
		Master add;
		
		if(mastersCounter[debut-PARTS]<MAX_STANDS) {
			ans=true;
			if(height==0.0) {
				add= new Master(name,namesake,sex,debut,image);
			}else {
				add=new Master(name,namesake,height,sex,yearOfBirth,image,debut);
			}
			debut-=3;
			masters[debut][mastersCounter[debut]]=add;
			mastersCounter[debut]++;
		}
		return ans;
	}
	//Finds and removes a Stand
	public void removeStand(String name) {
		int i=0,c=0;

		boolean found=false;
		
		while(i<PARTS&&!found) {
			while(c<standsCounter[i]) {
				found=name.equals(stands[i][c].getName());
				c++;
			}
			i++;
		}
		if(found) {
			for(int o=c;o<standsCounter[i];o++) {
				stands[o]=stands[o+1];
			}
			standsCounter[i]--;
		}
	}
	//Reads the master file
	public void readMasterFile() {
		File master=new File("Data/standMasters.csv");
		String name,nameSake,image,h;
		double height=0.0;
		char sex;
		int yearOfBirth=0,debut;
		
		mastersCounter=new int[3];
		masters=new Master[PARTS][MAX_STANDS];
		try (Scanner scn=new Scanner(master,"UTF-8")){
			scn.nextLine();
			scn.useDelimiter(",|\\n");
			while(scn.hasNext()) {
				name=scn.next();
				nameSake=scn.next();
				height=scn.nextDouble();
				sex=scn.next().charAt(0);
				yearOfBirth=scn.nextInt();
				image=scn.next();
				debut=Integer.parseInt(String.valueOf(scn.next().charAt(0)));

				addMaster(name,nameSake,height,sex,yearOfBirth,image,debut);
			}
			
			scn.close();
		}catch(FileNotFoundException fnfe) {
			PopUp pop=new PopUp("Could not find standMasters file"+fnfe);
			System.exit(-1);
		}
	}
	//Adds a Stand, no class
	public boolean addStand(String name, int debut, String master, char d,char s,char r, char p, char pr,char de, String type, String ability, String namesake,
			String image,String battleCry) {
		boolean ans=false;
		Stand add;
		int y=-1,deb=debut-PARTS,i=0;
		char[] stats= {d,s,r,p,pr,de};
		Master search=new Master(master);
		
		while(i<PARTS&&y==-1) {
			y=ArrayManager.search(masters[i],search,mastersCounter[i]);
			i++;
		}
		if(standsCounter[deb]<MAX_STANDS&&y!=-1) {
			////System.out.println(standsCounter[deb]);
			if(!battleCry.isEmpty()) {
				add=new Stand(name,debut,master,stats,type,ability,namesake,
				image,y,battleCry);
			}else {
				add=new Stand(name,debut,master,stats,type,ability,namesake,
						image,y);
			}
			////System.out.println(add.toString());
			stands[deb][standsCounter[deb]]=add;
			standsCounter[deb]++;
			//System.out.println(standsCounter[deb]);
			ans=true;
		}
		
		return ans;
	}
	//Adds a Stand, class
	public boolean addStandClass(Stand add) {
		boolean ans=false;
		int deb=add.getDebut()-PARTS;
		Master search=new Master(add.getMasterName());
		int i=0,y=-1;
		
		while(i<PARTS&&y==-1) {
			y=ArrayManager.search(masters[i],search,mastersCounter[i]);
			i++;
		}
		if(standsCounter[deb]<MAX_STANDS&&y!=-1) {
			stands[deb][standsCounter[deb]]=add;
			standsCounter[deb]++;
			ans=true;
		}
		
		return ans;
	}
	//Reads the Stand File
	public void readStandFile() {
		File standos=new File("Data/stands.csv");
		String name,master,type,ability,namesake,image,battleCry;
		char d,s,r,p,pr,de;
		int debut;
		
		standsCounter=new int[3];
		stands=new Stand[PARTS][MAX_STANDS];
		try (Scanner scn=new Scanner(standos,"UTF-8")){
			scn.nextLine();
			scn.useDelimiter(",|\\n");
			while(scn.hasNext()) {
				name=scn.next();
				master=scn.next();
				debut=scn.nextInt();
				d=scn.next().charAt(0);
				s=scn.next().charAt(0);
				r=scn.next().charAt(0);
				p=scn.next().charAt(0);
				pr=scn.next().charAt(0);
				de=scn.next().charAt(0);
				type=scn.next();
				ability=scn.next();
				image=scn.next();
				battleCry=scn.next();
				namesake=scn.next();

				addStand(name, debut, master, d,s,r,p,pr,de,type,ability,namesake,
						image,battleCry);
			}
			
			scn.close();
		}catch(FileNotFoundException fnfe) {
			PopUp pop=new PopUp("Could not find stands file"+fnfe);
			System.exit(-1);
		}
	}
	//Getters
	public Master getMaster(int x, int y) {
		x-=PARTS;
		
		return masters[x][y];
	}
	
	public Stand getStand(int x, int y) {
		x-=PARTS;
		
		return stands[x][y];
	}
	//Master lookup, returns an array, not case sensitive
	public ArrayList<Master> findMaster(String name) {
		ArrayList<Master> result=new ArrayList<Master>();
		name=name.toUpperCase();
		
		for(int i=0;i<PARTS;i++) {
			for(int c=0;c<mastersCounter[i];c++) {
				if(masters[i][c].getName().toUpperCase().contains(name)) {
					result.add(masters[i][c]);
				}
			}
		}
		
		return result;
	}
	
	//Searches for and returns exactly 1 Stand
	public Stand exactStandSearch(String name) {
		Stand result=new Stand();
		Stand s=new Stand(name);
		int[] coord= {0,-1};
		int i=0;
		
		while(i<PARTS&&coord[1]==-1) {
			coord[1]=MatrixManager.findInRow(stands, s, i, standsCounter[i]);
			i++;
			//////System.out.println(coord[1]);
		}
		if(coord[1]!=-1) {
			i--;
			coord[0]=i;
			//////System.out.println(coord[0]);
			result=stands[coord[0]][coord[1]];
		}
		
		return result;
	}
	//Searches for and returns exactly 1 stand master (done due to similar master names)
	public Master exactMasterSearch(String name) {
		Master result=new Master();
		Master s=new Master(name);
		int[] coord= {0,-1};
		int i=0;
		
		while(i<PARTS&&coord[1]==-1) {
			coord[1]=MatrixManager.findInRow(masters, s, i,mastersCounter[i]);
			i++;
		}
		if(coord[1]!=-1) {
			i--;
			coord[0]=i;
			result=masters[coord[0]][coord[1]];
		}
		
		return result;
	}
	//For startup when creating the GUI
	public ArrayList<Stand> returnAsList(){
		ArrayList<Stand> ans=new ArrayList<Stand>();
			
		for(int i=0; i<PARTS;i++) {
			System.out.println(standsCounter[i]);
			for(int c=0;c<standsCounter[i];c++) {
					
				ans.add(stands[i][c]);
			}
		}
		return ans;
	}
	//To search, filters the Stands, not case sensitive
	public ArrayList<Stand> returnAsList(String search){
		ArrayList<Stand> ans=new ArrayList<Stand>();
			
		search=search.toUpperCase();
		for(int i=0; i<PARTS;i++) {
			for(int c=0;c<standsCounter[i];c++) {
				if(stands[i][c].getName().toUpperCase().contains(search)) {
					ans.add(stands[i][c]);
				}
			}
		}
			
		return ans;
	}
	
	public String toString() {
		StringBuilder build=new StringBuilder();
		String standos, users;
		
		build.append("\nStands");
		standos=MatrixManager.toString(stands, PARTS, MAX_STANDS);
		users=MatrixManager.toString(masters, PARTS, MAX_STANDS);
		build.append(standos);
		build.append("\nStands Masters");
		build.append(users);

		return build.toString();
	}
	
}
