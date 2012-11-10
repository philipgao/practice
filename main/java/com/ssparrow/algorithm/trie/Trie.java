/**
 * 
 */
package com.ssparrow.algorithm.trie;

/**
 * @author Gao, Fei
 *
 */
public class Trie {
	private TrieNode root=new TrieNode(null);
	
	public void addWord(String word){
		root.addChild(word, 0);
	}
	
	public boolean isValidPrefix(String word){
		int index=0;
		
		TrieNode node=root;
		while(index<word.length()){
			char value=word.charAt(index);
			
			if(node.hasChild(value)){
				node=node.getChild(value);
				index++;
			}else{
				return false;
			}
		}
		
		return true;
	}
}
