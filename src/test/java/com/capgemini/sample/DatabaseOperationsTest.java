package com.capgemini.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DatabaseOperationsTest {
	static DatabaseOperations databaseOperations;
	@BeforeAll
	public static void init() {
		databaseOperations = new DatabaseOperations();
	}
	
	/*@Test
	void testInsertData() {
		assertEquals(1, databaseOperations.insertData(6, "Divyam", "cse", 21, 67988, "hyd", 20000));
	}
	
	@Test
	void testUpdateData() {
		assertEquals(1, databaseOperations.updateData(5, 21500));
	}
	
	@Test
	void testdeleteData() {
		assertEquals(1, databaseOperations.deleteData(10));
	}*/
	
	@Test
	void testSelectData() {
		assertEquals(6, databaseOperations.selectData());
	}
	
	@Test
	void testSelectDataName() {
		assertEquals("ghi", databaseOperations.selectDataName(1));
	}

}
