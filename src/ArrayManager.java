/*
 * Copyright Hector G. T. Torres	191589
 * 10/2019
 * Clase que hace varias operaciones con
 * arreglos.
 */
public class ArrayManager {
	
	//Indicates which is the biggest element in the array from index 0 to y
	public static <T extends Comparable<T>> int max (T [] arr, int y) {
		int max = 0;
		T current=arr[0];
		
		if(y<arr.length&&y>=0)
			for(int i=0; i<y; i++) {
				if (current.compareTo(arr[i])>0) {
					current=arr[i];
					max=i;
				}
			}
		
		return max;
	}
	//Indicates which is the smallest element in the array from index 0 to y
	public static <T extends Comparable<T>> T min (T [] arr, int y) {
		T current=arr[0];
		
		if(y<arr.length&&y>=0)
			for(int i=0; i<y; i++) {
				if (current.compareTo(arr[i])<0) {
					current=arr[i];
				}
		}
		
		return current;
	}
	//Indicates how many elements (from arr[0] to arr[y]) are greater than x
	public static <T extends Comparable<T>>int greaterThan(T[] arr, T x, int y) {
		int elements=0;
		
		if(y<arr.length&&y>=0)
			for(int i=0; i<y; i++) {
				if(x.compareTo(arr[i])<0) {
					elements++;
				}
		}
		
		return elements;
	}
	//Indicates how many elements (from arr[0] to arr[y]) are less than x
	public static <T extends Comparable<T>> int lessThan(T[] arr, T x, int y) {
		int elements=0;
		
		if(y<arr.length)
			for(int i=0; i<y; i++) {
				if(x.compareTo(arr[i])>0) {
					elements++;
				}
		}
		
		return elements;
	}
	//Shift elements, starting from x, y amount of places to the right
	public static <T> void shiftRight(T[]arr, int x, int y) {
		int lim=x+y;
		
		if(y> 0&&x<arr.length&&x>=0) {
			for(int i=arr.length-1;i-y>=x;i--) {
				arr[i]=arr[i-y];
			}
			
			for(int i=x;i<lim;i++) {
				arr[i]=null;
			}
		}

	}
	//Shift elements, starting from x, y amount of places to the left
	public static <T> void shiftLeft(T[] arr, int x, int y) {
		int lim=x-y;
		
		if(y> 0&&x<arr.length&&x>=0) {
			for(int i=0;i+y<=x;i++) {
				arr[i]=arr[i+y];
			}
			
			for(int i=x;i>lim;i--) {
				arr[i]=null;
			}
		}
	}
	
	/*public static <T> void invert(T[] arr, int lim) {
		T[] back = new T [lim+1];
		T[] inverse = new T [back.length];
		
		if(lim<arr.length&&lim>=0) {
			for(int i=0; i<back.length; i++) {
				back[i]=arr[i];
			}
			
			for(int i=lim;i>=0;i--) {
				inverse[i]=back[lim-i];
			}
			
			for(int i=0; i<inverse.length;i++) {
				arr[i]=inverse[i];
			}
		}
	}*/
	//Swaps the values in arr[x] and arr[y]
	public static <T> void swap(T[] arr, int x, int y) {
		T back;
		
		if(x>=0&&y>=0
				&&x<arr.length&&y<arr.length&&x!=y) {
			back=arr[x];
			arr[x]=arr[y];
			arr[y]=back;
		}
	}
	
	public static <T> int search(T[] arr, T search, int lim) {
		int ans=-1;
		
		if(lim<arr.length&&lim>=0) {
			for(int i=0; i<lim; i++) {
				if(arr[i].equals(search)) {
					ans=i;
					i=lim+1;
				}
			}
		}
		
		return ans;
	}
	
	public static <T extends Comparable<T>> int orderSearch(T[] arr, T search, int lim) {
		int ans=-1;
		int min;
		for(int i=0; i<arr.length-1; i++) {
			min=i;
			
			for(int o=i+1;o<arr.length;o++) {
				if(arr[o].compareTo(arr[min])<0) {
					min=o;
				}
			}
			swap(arr,min,i);
		}
		
		if(lim<arr.length&&lim>=0) {
			for(int i=0; i<=lim; i++) {
				if(arr[i]==search) {
					ans=i;
					i=lim+1;
				}
			}
		}
		
		return ans;
	}
	
	public static <T extends Comparable<T>> boolean directSelection(T[] arr, int lim) {
		int min;
		boolean res=false;
		
		if(lim>=0&&lim<arr.length) {
			res=true;
			for(int i=0; i<=lim; i++) {
				min=i;
				
				for(int o=i+1;o<arr.length;o++) {
					if(arr[o].compareTo(arr[min])<0) {
						min=o;
					}
				}
				swap(arr,min,i);
			}
		}
		return res;
		
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] arr, int lim, T term) {
		int index=-1;
		int min=0, max=lim,mid=(min+max)/2;
		
		if(lim>=0&&lim<arr.length) {
			while(term!=arr[mid]&&mid<max&&mid>min) {
				if(term.compareTo(arr[mid])>0) {
					min=mid;
				}else {
					max=mid;
				}
				mid=(min+max)/2;
			}
			
			if(term.equals(arr[mid])) {
				index=mid;
			}
		}
		return index;
	}
	
	public static <T extends Comparable<T>> int minPos (T[] arr, int lim) {
		int min = 0;
		T current=arr[0];
		
		if(lim<arr.length&&lim>=0)
			for(int i=0; i<lim; i++) {
				if (current.compareTo(arr[i])>0) {
					current=arr[i];
					min=i;
				}
		}
		return min;
	}
	
	public static <T> boolean insertAtEnd(T[] arr, T x) {
		boolean ans=false;
		
		if(arr[arr.length-1]==(null)) {
			arr[arr.length-1]=x;
		}
		return ans;
	}
	
	public static <T> boolean insertAtTail(T[] arr, T x) {
		boolean ans=false;
		int i=0;
		
		while(i<arr.length&&arr[i]!=null) {
			i++;
		}
		if(i<arr.length&&arr[i]==null) {
			arr[i]=x;
			ans=true;
		}
		return ans;
	}
	
	public static <T extends Comparable<T>> int disorderedDeletion(T[] arr, T value) {
		int ans=-1;
		int pos,o=0;
		
		pos=search(arr,value,arr.length-1);
		if(pos>=0&&pos<arr.length) {
			ans=0;
			for(int i=pos;i<arr.length-1;i++) {
				arr[i]=arr[i+1];
			}
			arr[arr.length-1]=null;
		}
		if(ans==0) {
			while(!arr[o].equals(null)) {
				ans++;
				o++;
			}
		}
		
		return ans;
	}
	
	public static <T extends Comparable<T>> int orderedDeletion(T[] arr,T value) {
		int ans=-1;
		int pos,o=0;
		
		pos=binarySearch(arr,arr.length-1,value);
		if(pos>=0&&pos<arr.length) {
			ans=0;
			for(int i=pos;i<arr.length-1;i++) {
				arr[i]=arr[i+1];
			}
			arr[arr.length-1]=null;
		}
		if(ans==0) {
			while(!arr[o].equals(null)) {
				ans++;
				o++;
			}
		}
		return ans;
	}
	
	public static <T extends Comparable<T>> int disorderedInsertion(T[] arr, int pos,T value) {
		int ans=-1;
		int o=0;
		
		if(pos>=0&&pos<arr.length) {
			ans=0;
			for(int i=arr.length-1;i>pos;i--) {
				arr[i]=arr[i-1];
			}
			arr[pos]=value;
		}
		
		if(ans==0) {
			while(o<arr.length&&!arr[o].equals(null)) {
				ans++;
				o++;
			}
		}
		
		return ans;
	}
	
	public static <T extends Comparable<T>> int orderedInsertion(T[] arr,T value) {
		int ans=-1,o=0;
		int pos=lessThan(arr,value,arr.length-1)-1;
		
		for(int i=arr.length-1;i>pos+1;i--) {
			arr[i]=arr[i-1];
		}
		arr[pos]=value;
		while(o<arr.length&&!arr[o].equals(null)) {
			ans++;
			o++;
		}
		
		return ans;
	}
	
	//Tarea EXTRA
		/*public static int union(double[] x, double[] y,double[] z) {
			int c1=0,c2=0,c3=0,ans=0,c=0;
			
			while(c1<x.length&&c2<y.length&&c3<z.length) {
				if(x[c1]<=y[c2]) {
					z[c3]=x[c1];
					if(x[c1]==y[c2]) {
						c2++;
					}
					c1++;
				}else {
					z[c3]=y[c2];
					c2++;
				}
				c3++;
			}
			
			if(c1<x.length) {
				for(int i=c1;i<=x.length&&c3<z.length;i++) {
					z[c3]=x[i];
					System.out.println(i+" "+z.length);
					c3++;
				}
			}
			if(c2<y.length){
				for(int i=c2;i<=x.length&&c3<z.length;i++) {
					z[c3]=y[i];
					System.out.println(i+" "+z.length);
					c3++;
				}
			}
			
			while(c<z.length&&z[c]!=0) {
				ans++;
				c++;
			}
			
			return ans;
		}
		
		public static void removeDuplicates(double[] arr, int n) {
			directSelection(arr, arr.length-1);
			int c=1;
			
			if(n>=0&&n<arr.length) {
				for(int i=0;i<=n;i++) {
					while(i+c<arr.length&&arr[i]!=0.0
							&&arr[i]==arr[i+c]) {
						arr[i+c]=0.0;
					}
					c=1;
				}
				directSelection(arr,arr.length-1);
			}
		}*/
}
