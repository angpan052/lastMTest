package com.lastminute.service;


import com.lastminute.model.OrderI;
import com.lastminute.model.OrderOutputI;


public interface LastminuteService {
	
	OrderOutputI processLastMinuteOrder(OrderI orderI);
}
