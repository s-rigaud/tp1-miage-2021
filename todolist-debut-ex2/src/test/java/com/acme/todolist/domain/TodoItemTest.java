package com.acme.todolist.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodoItemTest {
	
	private static TodoItem item;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void justCreatedIsNotLate() {
		item = new TodoItem("1", Instant.now(), "content");
		assertFalse(item.isLate());
	}

	@Test
	void ThirtyMinutesOldIsNotLate() {
		item = new TodoItem("1", Instant.now().minus(30, ChronoUnit.MINUTES), "content");
		assertFalse(item.isLate());
	}

	@Test
	void TwoDaysOldIsLate() {
		item = new TodoItem("1", Instant.now().minus(2, ChronoUnit.DAYS), "content");
		assertTrue(item.isLate());
	}

}
