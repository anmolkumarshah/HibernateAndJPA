package com.anmol.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	
	List<String> todos = Arrays.asList("AWS","Java","Python");

	@Test
	void test() {
//		assertEquals(true, todos.contains("Java"));
//		assertEquals(false, todos.contains("js"));
//		assertTrue(todos.contains("dart"));
		assertArrayEquals(new int[] {1,2}, new int[] {2,1});
	}
	
	@Test
	void test1() {
		assertEquals(3, todos.size());
	}

}
