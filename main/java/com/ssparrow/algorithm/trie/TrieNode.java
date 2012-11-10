/**
 * 
 */
package com.ssparrow.algorithm.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gao, Fei
 *
 */
public class TrieNode {
	private List<TrieNode> children=new ArrayList<TrieNode>();
	private Map<Character, TrieNode> childrenMap=new HashMap<Character, TrieNode>();
	
	private TrieNode parent;
	private char value;
	/**
	 * @param parent
	 */
	public TrieNode(TrieNode parent) {
		this.parent = parent;
	}
	/**
	 * @return the value
	 */
	public char getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(char value) {
		this.value = value;
	}
	/**
	 * @return the parent
	 */
	public TrieNode getParent() {
		return parent;
	}
	
	/**
	 * @param value
	 * @return
	 */
	public TrieNode getChild(char value){
		return childrenMap.get(value);
	}
	
	/**
	 * @param value
	 * @return
	 */
	public boolean hasChild(char value){
		return childrenMap.containsKey(value);
	}
	
	/**
	 * @param str
	 * @param index
	 */
	public void addChild(String str, int index){
		if(index>=str.length()){
			return;
		}
		
		char childValue = str.charAt(index);
		if(!this.hasChild(childValue)){
			TrieNode newChild=new TrieNode(this);
			newChild.setValue(childValue);
			
			children.add(newChild);
			childrenMap.put(childValue, newChild);
		}
		
		this.getChild(childValue).addChild(str, index+1);
	}
}
