package corejavaprograms;

public class MaxProduct3 {

	public static void main(String[] args) {
		runSolution();
	}
	public static void runSolution() {
		int[] a = {-1, 2, 3, -4, -5, -2, -8, -4};
		
		System.out.println(findMaxProduct(a));
	}
	
	public static int findMaxProduct(int[] a) {
		if (a == null || a.length < 3) {
			return -1; // error
		}
				
		int nPos = 0; // count of positive nums.
		int nNeg = 0; // count of negative nums.
		int mPos1 = 0, mPos2 = 0, mPos3 = 0; // max. Found highest 3 positive
		int mNeg1 = 0, mNeg2 = 0, mNeg3 = 0; // max. Found lowest 3 negative 
		int mN1 = Integer.MIN_VALUE, mN2 = Integer.MIN_VALUE, mN3 = Integer.MIN_VALUE; // max. Found highest 3 negative 
		int zCount = 0; // count of zeros;
		
		for (int i = 0; i < a.length; i++) {			
			if (a[i] > 0) {
				nPos++;				
				if (a[i] > mPos1) {
					mPos3 = mPos2; mPos2 = mPos1; mPos1 = a[i];
				} else if (a[i] > mPos2) {
					mPos3 = mPos2; mPos2 = a[i];
				} else if (a[i] > mPos3) {
					mPos3 = a[i];
				}
			} else if (a[i] < 0) {  
				nNeg++;
				if (a[i] < mNeg1) {
					mNeg3 = mNeg2; mNeg2 = mNeg1; mNeg1 = a[i];
				} else if (a[i] < mNeg2) {
					mNeg3 = mNeg2; mNeg2 = a[i];
				} else if (a[i] < mNeg3) {
					mNeg3 = a[i];
				}				

				// store min negative if any
				if (a[i] > mN1) {
					mN3 = mN2; mN2 = mN1; mN1 = a[i];
				} else if (a[i] > mN2) {
					mN3 = mN2; mN2 = a[i];
				} else if (a[i] > mN3) {
					mN3 = a[i];
				}				
				
			} else {
				zCount++;
			}			
		}

		// fetch highest 3 * positive numbers
		int maxPos = 0;
		if (nPos >= 3) {
			maxPos = mPos1 * mPos2 * mPos3;
		}
		
		// fetch highest 1 positive * 2 negative		
		int maxPos2Neg = 0;
		if (nPos >= 1 && nNeg >= 2) {
			maxPos2Neg = mNeg1 * mNeg2 * mPos1;
		}

		// compare both if any and return highest
		if (maxPos > 0 && maxPos2Neg > 0) {
			return Math.max(maxPos, maxPos2Neg);
		} else if (maxPos > 0 && maxPos2Neg == 0) {
			return maxPos;
		} else if (maxPos == 0 && maxPos2Neg > 0) {
			return maxPos2Neg;
		}
				
		// return 0 if any found
		if (zCount > 1) {
			return 0;
		}
		
		// if all negative return 3 Min. negative
		if (nNeg >= 3) {
			return mN1*mN2*mN3;
		}
		
		return -1; // error should return any of the cases above.
	}


}
