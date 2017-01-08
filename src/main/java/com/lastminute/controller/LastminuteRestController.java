package com.lastminute.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lastminute.model.OrderOutputI;
import com.lastminute.model.impl.OrderInputImpl;
import com.lastminute.model.impl.Views;
import com.lastminute.service.LastminuteService;


@RestController
public class LastminuteRestController {

	final static Logger log = Logger.getLogger(LastminuteRestController.class);

	@Autowired
	LastminuteService lastminuteService;

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/order")
	public OrderOutputI processLastMinuteOrder(@RequestBody OrderInputImpl obj) {

		log.info("processLastMinuteOrder - " + obj.toString());
		
		return lastminuteService.processLastMinuteOrder(obj);

	}

}
