/**
 * 
 */
package com.ssparrow.algorithm.concurrent;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Gao, Fei
 *
 */
public class MatchCounterTest {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, Exception {
		File directory=new File("main/java");
		MatchCounter counter=new MatchCounter(directory, "class");
		FutureTask<Integer> task=new FutureTask<Integer>(counter);
		new Thread(task).start();
		
		System.out.println(task.get()+" java classes");

	}

}
