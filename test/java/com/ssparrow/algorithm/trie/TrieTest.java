/**
 * 
 */
package com.ssparrow.algorithm.trie;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Gao, Fei
 *
 */
public class TrieTest {

	@Test
	public void test() {
		Trie trie=new Trie();
		
		assertFalse(trie.isValidPrefix("a"));
		assertFalse(trie.isValidPrefix("z"));
		
		trie.addWord("abroad");
		
		assertTrue(trie.isValidPrefix("a"));
		assertTrue(trie.isValidPrefix("ab"));
		assertTrue(trie.isValidPrefix("abr"));
		assertFalse(trie.isValidPrefix("ac"));
		assertFalse(trie.isValidPrefix("z"));
		
		trie.addWord("accede");
		
		assertTrue(trie.isValidPrefix("a"));
		assertTrue(trie.isValidPrefix("ab"));
		assertTrue(trie.isValidPrefix("abr"));
		assertTrue(trie.isValidPrefix("ac"));
		assertFalse(trie.isValidPrefix("z"));
		
		trie.addWord("zoo");
		
		assertTrue(trie.isValidPrefix("a"));
		assertTrue(trie.isValidPrefix("ab"));
		assertTrue(trie.isValidPrefix("abr"));
		assertTrue(trie.isValidPrefix("ac"));
		assertTrue(trie.isValidPrefix("z"));
	}

}
