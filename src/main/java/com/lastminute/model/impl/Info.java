package com.lastminute.model.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class Info {

	@JsonView(Views.Public.class)
	String key;

	@JsonView(Views.Public.class)
	String value;

	public Info() {
	}

	public Info(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Info [key=" + key + ", value=" + value + "]";
	}

}
