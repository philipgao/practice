package com.ssparrow.afi.ch02sorting;

public class StockQuote implements Comparable<StockQuote> {
	private int fileIndex;
	private int key;
	private String quote;
	
	public StockQuote(int fileIndex, String quote) {
		this.fileIndex=fileIndex;
		this.quote = quote;
		
		int firstSpace=quote.indexOf(' ');
		if(firstSpace>0){
			try{
				key=Integer.parseInt(quote.substring(0,firstSpace));
			}catch(NumberFormatException exception){
				exception.printStackTrace();
			}
		}
	}
	
	public int getKey() {
		return key;
	}

	public int getFileIndex() {
		return fileIndex;
	}

	public String getQuote() {
		return quote;
	}

	@Override
	public int compareTo(StockQuote o) {
		return key-o.getKey();
	}

}
