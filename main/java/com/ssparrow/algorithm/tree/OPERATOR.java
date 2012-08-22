package com.ssparrow.algorithm.tree;

enum OPERATOR {
	
	ADD("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");
	
	private String expression;
	
	private OPERATOR(String expression){
		this.expression=expression;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return expression;
	}
	
	
}