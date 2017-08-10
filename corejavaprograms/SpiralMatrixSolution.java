package corejavaprograms;

import java.util.Scanner;

public class SpiralMatrixSolution {

	public static void main(String[] args) {
		System.out.println("Enter the order of the Matrix");
		System.out.println("Enter the row size");
		Scanner in = new Scanner(System.in);
		int rowsize = in.nextInt();
		System.out.println("Enter the col size");
		int colsize = in.nextInt();
		int[][] a = new int[rowsize][colsize];
		int[][] b = new int[rowsize][colsize];
		System.out.println("Enter the numbers into the Matrix");
		for (int i = 0; i < rowsize; i++) {
			for (int j = 0; j < colsize; j++) {
				a[i][j] = in.nextInt();
			} 
		}
		int Cmax=colsize-1;
		int Cmin=0;
		int Rmax=rowsize-1;
		int Rmin=0;
		int j=rowsize*colsize;
		while(j!=0){
			for(int i=Cmin;i<=Rmax;i++){
				b[Rmin][i]=a[Rmin][i];
			}
			for(int i=Rmin+1;i<=Rmax;i++){
				b[i][Rmax]=a[i][Rmax];
			}
			for(int i=Cmax-1;i>=Cmin;i--){
				b[Rmax][i]=a[Rmax][i];
			}
			for(int i=Rmax-1;i>=Cmin;i--){
				b[i][Cmin]=a[i][Cmin];
			}
			Cmax--;
			Cmin++;
			Rmax--;
			Rmin++;
			j--;
		}
		for (int i = 0; i < rowsize; i++) {
			for (int d = 0; d < colsize; d++) {
				System.out.print(b[i][d]+" ");
			} 
			System.out.println();
		}

	}

}
