/**
 * 
 */
package com.ssparrow.algorithm.concurrent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Gao, Fei
 *
 */
public class MatchCounter implements Callable<Integer>{
	private File directory;
	private String keyword;
	
	

	/**
	 * @param directory
	 * @param keyword
	 */
	public MatchCounter(File directory, String keyword) {
		this.directory = directory;
		this.keyword = keyword;
	}



	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception {
		int count=0;
		List<Future<Integer>> tasks=new ArrayList<Future<Integer>>();
		
		File[] children = directory.listFiles();
		for (int i = 0; i < children.length; i++) {
			File child = children[i];
			
			if(child.isDirectory()){
				MatchCounter subCounter = new MatchCounter(child, keyword);
				FutureTask<Integer> subTask =new FutureTask<Integer>( subCounter);
				tasks.add(subTask);
				
				new Thread(subTask).start();
			}else{
				count++;
			}
		}
		
		for(Future<Integer> task:tasks){
			count+=task.get();
		}
		
		return count;
	}
	
	
	private boolean searchFile(File file) throws IOException{
		Scanner scanner=new Scanner(file);
		
		String line;
		
		while((line=scanner.nextLine())!=null){
			if(line.contains(keyword)){
				return true;
			}
		}
		
		return false;
		
	}
	

}
