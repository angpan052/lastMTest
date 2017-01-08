package com.lastminute.model;

import java.util.List;

public interface OrderI {

	public <T> List<T> getItems();

	public <T> void setItems (List<T> items);

}