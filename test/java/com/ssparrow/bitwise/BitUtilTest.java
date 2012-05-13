package com.ssparrow.bitwise;

import static org.junit.Assert.*;
import org.junit.Test;

public class BitUtilTest {

	@Test
	public void TestInsertNumberToAbother(){
		int m=Integer.parseInt("10011", 2);
		int n=Integer.parseInt("10000000000",2);
		
		String result="10001001100";
		assertEquals(result, Integer.toBinaryString(BitUtil.insertNumberToAnother(m, n, 2, 6)));
	}
}
