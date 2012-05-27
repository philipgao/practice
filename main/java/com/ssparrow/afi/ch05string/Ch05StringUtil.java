package com.ssparrow.afi.ch05string;

public class Ch05StringUtil {
	/**
	 * @param str
	 * @return
	 */
	public static String p506FindLongestPalindrome(String str){
		char []  array=str.toCharArray();
		char [] reverse=new char[array.length];
		for (int i = 0; i < reverse.length; i++) {
			reverse[i]=array[array.length-i-1];
		}
		
		char[][][] map = new char[array.length+1][reverse.length+1][];
		char[] result = findLongestCommonSubString(map, array, array.length, reverse, reverse.length);
		return new String(result);
	}
	
	
	private static char[] findLongestCommonSubString(char[][][]map, char[] array1, int length1,char[] array2, int length2){
		if(length1==0 || length2==0){
			char[] result=new char[0];
			map[length1][length2]=result;
			return result;
		}
		
		if(map[length1][length2]!=null){
			return map[length1][length2];
		}
		
		if(array1[length1-1]==array2[length2-1]){
			int i=length1-2;
			int j=length2-2;
			
			while(i>=0 && j>=0 && array1[i]==array2[j]){
				i--;
				j--;
			}
			
			int length=length1-i-1;
			char[] result = new char[length];
			System.arraycopy(array1, i+1, result, 0, length);
			map[length1][length2]=result;
			return result;
		} else {
			char[] subLCS1 = findLongestCommonSubString(map, array1,length1 - 1, array2, length2);
			char[] subLCS2 = findLongestCommonSubString(map, array1, length1,array2, length2 - 1);

			char[] result;
			if (subLCS1.length >= subLCS2.length) {
				result = subLCS1;
			} else {
				result = subLCS2;
			}
			map[length1][length2] = result;
			return result;
		}
	}
}
