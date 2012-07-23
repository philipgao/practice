/**
 * 
 */
package com.ssparrow.afi.ch11programming;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Philip
 *
 */
public class Ch11ProgrammingUtilTest {

	@Test
	public void testReverseAllWordsInSentence() {
		String sentence = "alice likes bob";
		
		assertEquals("bob likes alice", Ch11ProgrammingUtil.reverseAllWordsInSentence(sentence));
	}

}
