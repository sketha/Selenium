package corejavaprograms;

public class ZeroOnRightSide {

	public static void main(String[] args) {
		int[] a={0, 0, 3, 5, 1, 4, 5, 23, 23, 45, 7, 0, 9};
		int k=a.length;
		int m=0;
		int[] b = new int[a.length];
		for(int i=0;i<a.length;i++){
			if(a[i]==0){
				//b[k-1]=a[i];
			}
			else{
				b[m]=a[i];
				m++;
			}
		}
		for(int i=0;i<a.length;i++){
			System.out.print(" "+b[i]);
		}

	}

}
