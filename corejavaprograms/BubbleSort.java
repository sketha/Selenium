package corejavaprograms;

public class BubbleSort {
	public static void main(String[] args){
		int[] a ={5,8,2,7,1,9};
		int temp=0;
		for (int i =a.length; i>=0; i--) {
			for (int j = 0; j <a.length-1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
//					System.out.println(a);
				}
			} 
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}

}
