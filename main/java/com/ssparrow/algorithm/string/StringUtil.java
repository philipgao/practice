package com.ssparrow.algorithm.string;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class StringUtil {
	public static final int ASC_CHAR_NUM=256;

	/**
	 * @param str
	 * @return
	 */
	public static int convertStringtoInt(String str){
		if(str==null){
			return -1;
		}
		
		int result=0;
		for(int index=0;index<str.length();index++){
			result=result*10+Character.getNumericValue(str.charAt(index));
		}
		return result;
	}
	
	/**
	 * @param sentence
	 * @return
	 */
	public static String reverseCharsInWords(String sentence){
		if(sentence==null){
			return null;
		}
		
		char [] array=sentence.toCharArray();
		int wordStart=0;
		
		for(int index=0;index<array.length;index++){
			char c = array[index];
			if(c==' '||index==array.length-1){
				int wordEnd=c==' '?index-1:index;
				
				while(wordEnd-wordStart>=1){
					char tmp=array[wordStart];
					array[wordStart]=array[wordEnd];
					array[wordEnd]=tmp;
					
					wordEnd--;
					wordStart++;
				}
				
				wordStart=index+1;
			}
		}
		return new String(array);
	}
	
	
	/**
	 * revere words in a sentence
	 * for example "this is it" will be converted to "it is this"
	 * 
	 * @param sb
	 * @param sentence
	 */
	public static void reverseWordsInSentence(StringBuffer sb, String sentence){
		int wordstart=0;
		int wordend=0;
		
		for(int index=0;index<sentence.length();index++){
			if(sentence.charAt(index)==' ' || index==sentence.length()-1){
				wordend=(index==sentence.length()-1)? index+1:index;
				
				if(wordend>wordstart){
					String word=sentence.substring(wordstart, wordend);
					
					if(index==sentence.length()-1){
						sb.append(word);
					}else{
						reverseWordsInSentence(sb, sentence.substring(wordend+1));
						
						sb.append(" ").append(word);
					}
				}
				
				break;
			}
		}
	}
	/**
	 * @param str
	 * @return
	 */
	public static boolean checkCharUnique(String str){
		if(str.length()>ASC_CHAR_NUM){
			return false;
		}
		
		BitSet bitSet=new BitSet(ASC_CHAR_NUM);
		
		for(int index=0;index<str.length();index++){
			char c = str.charAt(index);
			if(bitSet.get(c)){
				return false;
			}
			bitSet.set(c);
		}
		
		return true;
	}
	
	/**
	 * @param array
	 * @param length
	 */
	public static int replaceSpaceInStr(char[] array, int length){
		if(array==null||length==0){
			return 0;
		}
		
		int spaceCount=0;
		for(int index=0;index<length;index++){
			if(array[index]==' '){
				spaceCount++;
			}
		}
		
		if(spaceCount==0){
			return length;
		}
		
		int count=spaceCount;
		
		for(int index=length-1;index>=0;index--){
			if(array[index]==' '){
				array[index+2*(count-1)+2]='0';
				array[index+2*(count-1)+1]='2';
				array[index+2*(count-1)]='%';
				
				count=count-1;
			}else{
				array[index+2*count]=array[index];
			}
		}
		
		return length+2*spaceCount;
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static String countCompress(String str){
		if(str==null||str.length()==0){
			return str;
		}
		
		int compressedSize=0;
		char last=str.charAt(0);
		int count=1;
		for(int index=1;index<str.length();index++){
			char c = str.charAt(index);
			if(c==last){
				count++;
			}else{
				compressedSize+=1+String.valueOf(count).length();
				
				count=1;
				last=c;
			}
		}
		compressedSize+=1+String.valueOf(count).length();
		
		if(compressedSize>=str.length()){
			return str;
		}
		
		char[] result=new char[compressedSize];
		int resultIndex=0;
		
		last=str.charAt(0);
		count=1;
		for(int index=1;index<str.length();index++){
			char c = str.charAt(index);
			if(c==last){
				count++;
			}else{
				result[resultIndex++]=last;
				char[] countCharArray = String.valueOf(count).toCharArray();
				System.arraycopy(countCharArray, 0, result, resultIndex,countCharArray.length);
				resultIndex+=countCharArray.length;
				
				count=0;
				last=c;
			}
			
		}
		result[resultIndex++]=last;
		char[] countCharArray = String.valueOf(count).toCharArray();
		System.arraycopy(countCharArray, 0, result, resultIndex,countCharArray.length);
		
		return new String(result);
	}
	
	/**
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String findMajorityWord(String fileName) throws Exception{
		BufferedReader reader=new BufferedReader(new FileReader(fileName));
		
		String word;
		String candidate=null;
		int count=0;
		
		while((word=reader.readLine())!=null){
			if(count==0){
				candidate=word;
				count++;
			}else{
				if(word.equals(candidate)){
					count++;
				}else{
					count--;
				}
			}
		}
		
		return candidate;
		
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static boolean checkPalindrome(String str){
		if(str==null){
			return false;
		}else if(str.length()==0 ||str.length()==1){
			return true;
		}
		
		int backIndex=0;
		
		int length = str.length();
		for(int fastIndex=0,forwardIndex=0;forwardIndex<length;forwardIndex++, fastIndex+=2){
			if(fastIndex==length-1){
				backIndex=forwardIndex-1;
			}else if(fastIndex==length){
				backIndex=forwardIndex-1;
				forwardIndex--;
			}else if(fastIndex>length){
				if(str.charAt(forwardIndex)!=str.charAt(backIndex)){
					return false;
				}
				backIndex--;
			}
		}
		
		return true;
	}
	
	/**
	 * @param words
	 * @return
	 */
	public static String findLongestComboWords(List<String> words){
		Comparator<String> lengthSorter = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		};
		
		Collections.sort(words, lengthSorter);
		
		
		for(int index=words.size()-1; index>0; index--){
			String word = words.get(index);
			
			if(isComboWords(word, 0, words)){
				return word;
			}
		}
		
		return null;
	}
	
	private static boolean isComboWords(String str, int start, List<String> words){
		for(int index=start+1; index<str.length();index++){
			String firstSection=str.substring(start, index);
			
			if(words.contains(firstSection)){
				String remained=str.substring(index);
				
				if(words.contains(remained)){
					return true;
				}else{
					return isComboWords(remained, 0, words);
				}
			}
		}
		
		return false;
	}
}
