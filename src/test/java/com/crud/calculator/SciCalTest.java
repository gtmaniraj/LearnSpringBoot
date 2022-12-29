package com.crud.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SciCalTest {
	
	@Test
	public void addTest()
	{
		SciCal t = new SciCal();
		assertEquals(14, t.add(7,7));
		
	}
}
