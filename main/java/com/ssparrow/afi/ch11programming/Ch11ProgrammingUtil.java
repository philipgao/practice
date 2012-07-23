/**
 * 
 */
package com.ssparrow.afi.ch11programming;

/**
 * @author Philip
 *
 */
public class Ch11ProgrammingUtil {
	/**
	 * reverse word in sentence, for example "alice likes bob" --> "bob likes alice"
	 * @param sentence
	 * @return
	 */
	public static String reverseAllWordsInSentence(String sentence){
		StringBuffer result = new StringBuffer();
		
		int firstSpace=sentence.indexOf(' ');
		
		if(firstSpace == -1){
			return sentence;
		}else {
			String word =  sentence.substring(0, firstSpace);
			
			if(firstSpace<sentence.length()-1){
				String remmainedSentence=sentence.substring(firstSpace+1);
				
				result.append(reverseAllWordsInSentence(remmainedSentence)).append(' ');
			}
			
			result.append(word);
		}
		
		return result.toString();
	}
}
