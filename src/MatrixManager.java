/*
 * Copyright Hector G. T. Torres	191589
 * 11/2019
 * Manejador de matrices 2D
 */
public class MatrixManager {
	
	public static <T> String toString(T[][] arr, int x, int y) {
		StringBuilder build =new StringBuilder();
		
		for(int i=0; i<x;i++) {
			build.append("| ");
			for(int c=0;c<y;c++) {
				build.append(arr[i][c]);
				build.append(", ");
			}
			build.append("|");
			build.append("\n");
		}
		
		return build.toString();
	}
	
	public static <T extends Comparable <T>> T findInMatrix(T[][] arr,T s,int x,int y) {
		int xL=0,yL=-1,i=0;
		
		while(i<x&&yL==-1) {
			yL=ArrayManager.search(arr[x], s, y);
		}
		if(yL!=-1) {
			xL=i;
		}else {
			yL=0;
		}
		
		return arr[xL][yL];
	}
	public static <T extends Comparable <T>> int greatestInColumn(T[][] arr, int y, int lim) {
		T curr=arr[0][y];
		int pos=0;
		
		for(int i=1;i<=lim;i++) {
			if(arr[i][y].compareTo(curr)>0) {
				curr=arr[i][y];
				pos=i;
			}
		}
		
		return pos;
	}
	
	public static <T extends Comparable <T>> int greatestInRow(T[][] arr, int x, int lim) {
		T curr=arr[x][0];
		int pos=0;
		
		for(int i=0;i<=lim;i++) {
			if(arr[x][i].compareTo(curr)>0) {
				curr=arr[x][i];
					pos=i;
			}
		}
		
		return pos;
	}
	
	public static <T extends Comparable <T>> int smallestInColumn(T[][] arr, int y, int lim) {
		T curr=arr[0][y];
		int pos=0;
		
		for(int i=0;i<=lim;i++) {
			if(arr[i][y].compareTo(curr)<0) {
				curr=arr[i][y];
				pos=i;
			}
		}
		
		return pos;
	}
	
	public static <T extends Comparable <T>> int smallestInRow(T[][] arr, int x, int lim) {
		T curr=arr[x][0];
		int pos=0;
		
		for(int i=0;i<=lim;i++) {
			if(arr[x][i].compareTo(curr)<0) {
				curr=arr[x][i];
				pos=i;
			}
		}
		
		return pos;
	}
	
	public static <T extends Comparable <T>> boolean checkSymetry(T[][] a, int x, int xy) {
		boolean ans=true;
		int i=1;
		
		while(i<xy&&a[0][i].equals(a[i][0])) {
			i++;
		}
		if(i<xy&&!a[0][i].equals(a[i][0])) {
			ans=false;
		}
		
		return ans;
	}
	
	public static <T> T[][] transpose(T[][] a, int x, int y){
		T[][] ans = (T[][]) new Object[y][x];
		
		for(int i=0;i<ans.length;i++) {
			for(int c=0;c<ans[0].length;c++) {
				ans[i][c]=a[c][i];
			}
		}
		return ans;
	}
	
	public static <T> void voidTranspose(T[][] a, int x){
		T help;
		
		for(int i=0;i<x;i++) {
			for(int c=0;c<i;c++) {
				help=a[c][i];
				a[c][i]=a[i][c];
				a[i][c]=help;
			}
		}
	}
	
	public static <T> int findInRow(T[][] a,T s, int x, int lim) {
		
		return ArrayManager.search(a[x], s, lim);
	}
	
	public static <T> int findInColumn(T[][] a,T s, int y, int lim) {
		int i=0;
		
		while(i<lim&&!s.equals(a[i][y])) {
			i++;
		}
		if(i==lim) {
			i=-1;
		}
		
		return i;
	}
	
	public static <T extends Comparable<T>> boolean equals(T[][] a, T[][] b, int x, int y) {
		boolean ans=true;
		int i=0, c=0;
		
		while(i<x&&a[i][c].equals(b[i][c])) {
			while(c<y) {
				c++;
			}
			i++;
		}
		if(!a[i][c].equals(b[i][c])) {
			ans=false;
		}
		
		return ans;
	}
}
