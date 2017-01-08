package com.lastminute.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.lastminute.model.ItemI;
import com.lastminute.model.OrderI;
import com.lastminute.model.OrderOutputI;
import com.lastminute.model.impl.ItemInputImpl;
import com.lastminute.model.impl.OrderInputImpl;
import com.lastminute.service.impl.LastminuteServiceImpl;

public class LastMinuteTest {

	@Test
	public void test1() {
		
		LastminuteServiceImpl serviceImpl = new LastminuteServiceImpl();
		OrderI orderI = new OrderInputImpl();
		
		List<ItemI> listItemI = new ArrayList<>();

		ItemInputImpl p1 = new ItemInputImpl(1, "", "book", (float)12.49, false, null);
		ItemInputImpl p2 = new ItemInputImpl(1, "", "CD", (float)14.99, false, null);
		ItemInputImpl p3 = new ItemInputImpl(1, "", "food", (float)0.85, false, null);
		
		listItemI.add(p1);
		listItemI.add(p2);
		listItemI.add(p3);
		
		orderI.setItems(listItemI);
		
		OrderOutputI oI = serviceImpl.processLastMinuteOrder(orderI);
		
		Assert.assertEquals(29.83, oI.getTotal(), 0.0002);
		
		
	}

	@Test
	public void test2() {
		
		LastminuteServiceImpl serviceImpl = new LastminuteServiceImpl();
		OrderI orderI = new OrderInputImpl();
		
		List<ItemI> listItemI = new ArrayList<>();

		ItemInputImpl p1 = new ItemInputImpl(1, "", "food", (float)10, true, null);
		ItemInputImpl p2 = new ItemInputImpl(1, "", "perfume", (float)47.50, true, null);
		
		listItemI.add(p1);
		listItemI.add(p2);
		
		orderI.setItems(listItemI);
		
		OrderOutputI oI = serviceImpl.processLastMinuteOrder(orderI);
		
		Assert.assertEquals(65.15, oI.getTotal(), 0.0002);
		
		
	}

	@Test
	public void test3() {
		
		LastminuteServiceImpl serviceImpl = new LastminuteServiceImpl();
		OrderI orderI = new OrderInputImpl();
		
		List<ItemI> listItemI = new ArrayList<>();

		ItemInputImpl p1 = new ItemInputImpl(1, "", "perfume", (float)27.99, true, null);
		ItemInputImpl p2 = new ItemInputImpl(1, "", "perfume", (float)18.99, false, null);
		ItemInputImpl p3 = new ItemInputImpl(1, "", "medicine", (float)9.75, false, null);
		ItemInputImpl p4 = new ItemInputImpl(1, "", "food", (float)11.25, true, null);
		
		listItemI.add(p1);
		listItemI.add(p2);
		listItemI.add(p3);
		listItemI.add(p4);
		
		orderI.setItems(listItemI);
		
		OrderOutputI oI = serviceImpl.processLastMinuteOrder(orderI);
		
		Assert.assertEquals(74.68, oI.getTotal(), 0.0002);
		
	}
}
