/**
 * 
 */
package com.ssparrow.algorithm.string;

/**
 * @author Philip
 *
 */
public class PremutateString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PremutateString mutate=new PremutateString();
		mutate.permute("abcd");

	}
	
	void permute(String str) {
		int length = str.length();
		boolean[] used = new boolean[length];
		StringBuffer out = new StringBuffer();
		char[] in = str.toCharArray();
		doPermute(in, out, used, length, 0);
	}

	void doPermute(char[] in, StringBuffer out, boolean[] used, int length,
			int level) {
		if (level == length) {
			System.out.println(out.toString());
			return;
		}
		for (int i = 0; i < length; ++i) {
			if (used[i])
				continue;
			out.append(in[i]);
			used[i] = true;
			doPermute(in, out, used, length, level + 1);
			used[i] = false;
			out.setLength(out.length() - 1);
		}
	}

}
