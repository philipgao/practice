package com.ssparrow.bitwise;

public class BitUtil {
	public static int insertNumberToAnother(int m, int n, int i, int j){
		int mShift=m<<i;
		//System.out.println(Integer.toBinaryString(mShift));
		
		int mask=0;
		for(int shift=j;shift>=i;shift--){
			mask=mask|(1<<shift);
		}
		//System.out.println(Integer.toBinaryString(mask));
		mask=~mask;
		//System.out.println(Integer.toBinaryString(mask));
		
		int nMasked=n&mask;
		//System.out.println(Integer.toBinaryString(nMasked));

		//System.out.println(Integer.toBinaryString(nMasked|mShift));
		return nMasked|mShift;
	}
}
