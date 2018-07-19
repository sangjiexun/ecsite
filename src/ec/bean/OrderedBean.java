package ec.bean;

import java.io.Serializable;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class OrderedBean implements Serializable, Array {
	private int orderCode;
	private int itemCode;
	private String itemName;
	private int itemPrice;
	private int num;


	public OrderedBean() {
		super();
	}


	public OrderedBean(int orderCode, int itemCode, String itemName, int itemPrice, int num) {
		super();
		this.orderCode = orderCode;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.num = num;
	}


	public int getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}


	public int getItemCode() {
		return itemCode;
	}


	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public String getBaseTypeName() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override
	public int getBaseType() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}


	@Override
	public Object getArray() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override
	public Object getArray(Map<String, Class<?>> map) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override
	public Object getArray(long index, int count) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override
	public Object getArray(long index, int count, Map<String, Class<?>> map) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override
	public ResultSet getResultSet() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override
	public ResultSet getResultSet(Map<String, Class<?>> map) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override
	public ResultSet getResultSet(long index, int count) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override
	public ResultSet getResultSet(long index, int count, Map<String, Class<?>> map) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override
	public void free() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}



}