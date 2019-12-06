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
		readMasterFile();
		readStandFile();
	}
	
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
	
	public void readMasterFile() {
		File master=new File("Data/standMasters.csv");
		String name,nameSake,image,h;
		double height=0.0;
		char sex;
		int yearOfBirth=0,debut;
		
		masters=new Master[PARTS][MAX_STANDS];
		try (Scanner scn=new Scanner(master,"UTF-8")){
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
		int y=-1,deb=debut-PARTS,i=0;
		char[] stats= {d,s,r,p,pr,de};
		Master search=new Master(master);
		
		while(i<PARTS&&y==-1) {
			y=ArrayManager.search(masters[i],search,mastersCounter[i]);
			i++;
		}
		if(standsCounter[deb]<MAX_STANDS&&y!=-1) {
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
	
	public void readStandFile() {
		File standos=new File("Data/stands.csv");
		String name,master,type,ability,namesake,image,battleCry;
		char d,s,r,p,pr,de;
		int debut;
		
		stands=new Stand[PARTS][MAX_STANDS];
		try (Scanner scn=new Scanner(standos,"UTF-8")){
			scn.nextLine();
			scn.useDelimiter(",|\\n");
			while(scn.hasNext()) {
				System.out.println(scn.hasNext());
				name=scn.next();
				System.out.println(name);
				master=scn.next();
				//System.out.println(master);
				debut=scn.nextInt();
				//System.out.println(debut);
				d=scn.next().charAt(0);
				//System.out.println(d);
				s=scn.next().charAt(0);
				//System.out.println(s);
				r=scn.next().charAt(0);
				//System.out.println(r);
				p=scn.next().charAt(0);
				//System.out.println(p);
				pr=scn.next().charAt(0);
				//System.out.println(pr);
				de=scn.next().charAt(0);
				//System.out.println(de);
				type=scn.next();
				//System.out.println(type);
				ability=scn.next();
				//System.out.println(ability);
				image=scn.next();
				//System.out.println(image);
				battleCry=scn.next();
				//System.out.println(battleCry);
				namesake=scn.next();
				//System.out.println(namesake);

				System.out.println(addStand(name, debut, master, d,s,r,p,pr,de,type,ability,namesake,
						image,battleCry));
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
	
	public ArrayList<Stand> findStand(String name) {
		ArrayList<Stand> result=new ArrayList<Stand>();
		name=name.toUpperCase();
		
		for(int i=0;i<PARTS;i++) {
			for(int c=0;c<standsCounter[i];c++) {
				if(stands[i][c].getName().toUpperCase().contains(name)) {
					result.add(stands[i][c]);
				}
			}
		}
		
		return result;
	}
	
	public Stand exactStandSearch(String name) {
		Stand result=new Stand();
		Stand s=new Stand(name);
		int[] coord= {0,-1};
		int i=0;
		
		while(i<PARTS&&coord[1]==-1) {
			coord[1]=MatrixManager.findInRow(stands, s, i, standsCounter[i]);
			i++;
			System.out.println(coord[1]);
		}
		if(coord[1]!=-1) {
			i--;
			coord[0]=i;
			System.out.println(coord[0]);
			result=stands[coord[0]][coord[1]];
		}
		
		return result;
	}
	
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
	//For startup
		public ArrayList<Stand> returnAsList(){
			ArrayList<Stand> ans=new ArrayList<Stand>();
			
			for(int i=0; i<PARTS;i++) {
				for(int c=0;c<standsCounter[i];c++) {
					ans.add(stands[i][c]);
					System.out.println(stands[i][c].toString());
				}
			}
			
			return ans;
		}
		//To search
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
