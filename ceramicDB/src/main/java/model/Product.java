package model;

import java.io.Serializable; //JavaBeansに必要な直列化

public class Product implements Serializable {
	private int productID;
	private String title;
	private String series;
	private int seriesID;
	private String category;
	private int categoryID;
	private String glaze;
	private int glazeID;
	private String pattern;
	private String color;
	private String size;
	private int price;
	private int stock;
	private int productYear;
	private boolean isOnlineShop;
	
	public Product() {} //JavaBeansに必要な引数のないコンストラクタ
	
	public Product(String title, String series, String category, String glaze, String pattern, String color, String size, int price, int stock, int productYear, boolean isOnlineShop) {
		this.title = title;
		this.series = series;
		this.category = category;
		this.glaze = glaze;
		this.pattern = pattern;
		this.color = color;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.productYear = productYear;
		this.isOnlineShop = isOnlineShop;
	}
	
	//シリーズ、カテゴリー、釉薬をIDでインスタンス化する場合
	public Product(String title, int seriesID, int categoryID, int glazeID, String pattern, String color, String size, int price, int stock, int productYear, boolean isOnlineShop) {
		this.title = title;
		this.seriesID = seriesID;
		this.categoryID = categoryID;
		this.glazeID = glazeID;
		this.pattern = pattern;
		this.color = color;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.productYear = productYear;
		this.isOnlineShop = isOnlineShop;
	}
	
	//productID付きでインスタンス化する場合
	public Product(int productID, String title, String series, String category, String glaze, String pattern, String color, String size, int price, int stock, int productYear, boolean isOnlineShop) {
		this.productID = productID;
		this.title = title;
		this.series = series;
		this.category = category;
		this.glaze = glaze;
		this.pattern = pattern;
		this.color = color;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.productYear = productYear;
		this.isOnlineShop = isOnlineShop;
	}

	public int getProductID() { return productID;}
	public void setProductID(int productID) { this.productID = productID;}
	
	public String getTitle() { return title;}
	public void setTitle(String title) { this.title = title;}

	public String getSeries() {	return series;}
	public void setSeries(String series) { this.series = series;}
	
	public int getSeriesID() { return seriesID;}
	public void setSeriesID(int seriesID) { this.seriesID = seriesID;}

	public String getCategory() { return category;}
	public void setCategory(String category) { this.category = category;}
	
	public int getCategoryID() {return categoryID;}
	public void setCategoryID(int categoryID) {this.categoryID = categoryID;}

	public String getGlaze() { return glaze;}
	public void setGlaze(String glaze) { this.glaze = glaze;}
	
	public int getGlazeID() {return glazeID;}
	public void setGlazeID(int glazeID) {this.glazeID = glazeID;}

	public String getPattern() { return pattern;}
	public void setPattern(String pattern) { this.pattern = pattern;}

	public String getColor() { return color;}
	public void setColor(String color) { this.color = color;}

	public String getSize() { return size;}
	public void setSize(String size) { this.size = size;}

	public int getPrice() { return price;}
	public void setPrice(int price) { this.price = price;}

	public int getStock() { return stock;}
	public void setStock(int stock) { this.stock = stock;}

	public int getProductYear() { return productYear;}
	public void setProductYear(int productYear) { this.productYear = productYear;}

	public boolean isOnlineShop() { return isOnlineShop;}
	public void setOnlineShop(boolean isOnlineShop) { this.isOnlineShop = isOnlineShop;}
	
}
