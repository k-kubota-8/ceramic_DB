package model;

import java.io.Serializable; //JavaBeansに必要な直列化

public class Product implements Serializable {
	private int productID;
	private String title;
	private String series;
	private String category;
	private String glaze;
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

	public String getCategory() { return category;}
	public void setCategory(String category) { this.category = category;}

	public String getGlaze() { return glaze;}
	public void setGlaze(String glaze) { this.glaze = glaze;}

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
