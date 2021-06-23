package com.model;

import java.io.Serializable;

public class Category implements Serializable {
	private int category_id;
	private String category_name;

	public int getId() {
		return category_id;
	}

	public void setId(int id) {
		this.category_id = id;
	}

	public String getName() {
		return category_name;
	}

	public void setName(String name) {
		this.category_name = name;
	}

}
