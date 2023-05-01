package com.anmol.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("Before Each");
	}

	@Test
	void test1() {
		System.out.println("Test 1");
	}

	@Test
	void test2() {
		System.out.println("Test 2");
	}

	@Test
	void test3() {
		System.out.println("Test 3");
	}

	@AfterEach
	void afterEach() {
		System.out.println("After Each");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("After All");
	}

}
