package com.qa.Dao;

import com.qa.dao.TruckDAO;
import com.qa.vehicles.Truck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestTruckDao {

	TruckDAO truckDao = new TruckDAO();
	Truck testTruck = new Truck("Scania", "blue", "L");
	Truck testTruck1 = new Truck("Scania", "blue", "L");
	Truck testTruck2 = new Truck("Scania", "blue", "L");

	private List<Truck> convertedList = new ArrayList<Truck>();

	@Before
	public void testSetup() {
		truckDao.create(testTruck);
		truckDao.create(testTruck1);
		truckDao.create(testTruck2);

		convertedList.add(testTruck);
		convertedList.add(testTruck1);
		convertedList.add(testTruck2);
	}

	@Test
	public void testRead() {
		assertEquals(testTruck, truckDao.read(1));
		assertEquals(testTruck1, truckDao.read(2));
		assertEquals(testTruck2, truckDao.read(3));
	}

	@Test
	public void testReadAll() {
		assertEquals(convertedList, truckDao.readAll());
	}

	@Test
	public void testDelete() {
		assertTrue(truckDao.delete(1));
	}
	

}


