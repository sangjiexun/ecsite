package ec.bean;

import java.io.Serializable;

public class ItemBean implements Serializable {
	private int code;
	private String name;
	private int price;
	private int quantity;
	private int category;

	public ItemBean(int code, String name, int price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public ItemBean(int code, String name, int price, int quantity) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}



	public ItemBean(String name, int price, int category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public ItemBean() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}




}
