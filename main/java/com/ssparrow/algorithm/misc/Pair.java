package com.ssparrow.algorithm.misc;



public class Pair{
	private int a;
	private int b;
	
	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + a + ", " + b + "]";
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pair){
			Pair target=(Pair)obj;
			return a==target.getA()&&b==target.getB();
		}
		return false;
	}
	
	
}
