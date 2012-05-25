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
		char[] result = findLongestCommonSubsequence(map, array, array.length, reverse, reverse.length);
		return new String(result);
	}
	
	public static char[] findLongestCommonSubsequence(char[][][] map,char[] array1, int length1,char array2[], int length2){
		System.out.println(length1+":"+length2);
		if(length1==0||length2==0){
			return new char[0];
		}
		
		if(map[length1][length2]!=null){
			return map[length1][length2];
		}
		
		if(array1[length1-1]==array2[length2-1]){
			char[] subLCS = findLongestCommonSubsequence(map, array1, length1-1, array2, length2-1);
			char[] result=new char[subLCS.length+1];
			System.arraycopy(subLCS, 0, result, 0, subLCS.length);
			result[subLCS.length]=array1[length1-1];
			map[length1][length2]=result;
			return result;
		}else{
			char[] subLCS1=findLongestCommonSubsequence(map, array1, length1-1, array2, length2);
			char[] subLCS2=findLongestCommonSubsequence(map, array1, length1, array2, length2-1);
			
			char[] result;
			if(subLCS1.length>=subLCS2.length){
				result=subLCS1;
				
			}else{
				result=subLCS2;
			}
			map[length1][length2]=result;
			return result;
		}
	}
}
