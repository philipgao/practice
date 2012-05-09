package com.ssparrow.algorithm.string;

public class BayerMooreSearch {
	public static final int ALPHABET_SIZE=256;
	
	public static int search(String pStr, String tStr){
		char[] pattern = pStr.toCharArray();
		char[] text = tStr.toCharArray();
		
		int[] charTable=makeCharTable(pattern);
		System.out.println("charTable="+charTable);
		
		int[] offsetTable=makeOffsetTable(pattern);
		System.out.println("offsetTable="+offsetTable);
		
		int move=0;
		
		for(int i=pattern.length-1,j;i<text.length;){
			System.out.println("loop i="+i);
			
			for(j=pattern.length-1;pattern[j]==text[i];i--,j--){
				System.out.println("j="+j);
				
				if(j==0){
				    System.out.println("move"+move);
					return i;
				}
			}
			
			i+=Math.max(charTable[text[i]],offsetTable[pattern.length-j-1]);
			System.out.println("i="+i);
			move++;
		}

	    System.out.println("move"+move);
		return -1;
	}
	
	public static int[] makeCharTable(char[] pattern){
		int[] charTable=new int[ALPHABET_SIZE];
		
		for (int i = 0; i < charTable.length; i++) {
			charTable[i]=pattern.length;
		}
		
		for(int i=0;i<pattern.length-1;i++){
			charTable[pattern[i]]=pattern.length-i-1;
		}
		
		return charTable;
	}
	
	public static int[] makeOffsetTable(char[] pattern){
		int[] offsetTable=new int[pattern.length];
		int lastPrefixPosition=pattern.length;
		
		for(int i=pattern.length-1;i>=0;--i){
			if(isPrefix(pattern, i+1)){
				lastPrefixPosition=i+1;
			}
			offsetTable[pattern.length-i-1]=lastPrefixPosition-i+pattern.length-1;
		}
		
		for (int i = 0; i < pattern.length-1; i++) {
			 int suffixLen=suffixLength(pattern,i);
			 offsetTable[suffixLen]=pattern.length-i-1+suffixLen;
		}		
		return offsetTable;
	}
	
	public static boolean isPrefix(char[] pattern, int p){
		for(int i=p,j=0;i<pattern.length;i++,j++){
			if(pattern[i]!=pattern[j]){
				return false;
			}
		}
		return true;
	}
	
	public static int suffixLength(char[]pattern, int p){
		int len=0;
		for(int i=p, j=pattern.length-1;i>=0&&pattern[i]==pattern[j];--i,--j){
			len+=1;
		}
		return len;
	}
	
	public static void main(String[] args) {
		System.out.println(search("qcwq", "fcwqfcdrfgtvghjksrbv dfhs"));
	}
}
