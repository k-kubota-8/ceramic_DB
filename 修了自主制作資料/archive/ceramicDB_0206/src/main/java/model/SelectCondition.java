package model;

public class SelectCondition {
	private String title;
	private String series;
	private String category;
	private String glaze;
	private String pattern;
	private String color;
	private String size;
	private Integer priceLowerLimit;
	private Integer priceUpperLimit;
	private Integer stockLowerLimit;
	private Integer stockUpperLimit;
	private Integer productYearLowerLimit;
	private Integer productYearUpperLimit;
	private Integer onlineShop; //0:無 1:有　2:両方
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGlaze() {
		return glaze;
	}
	public void setGlaze(String glaze) {
		this.glaze = glaze;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Integer getPriceLowerLimit() {
		return priceLowerLimit;
	}
	public void setPriceLowerLimit(Integer priceLowerLimit) {
		this.priceLowerLimit = priceLowerLimit;
	}
	public Integer getPriceUpperLimit() {
		return priceUpperLimit;
	}
	public void setPriceUpperLimit(Integer priceUpperLimit) {
		this.priceUpperLimit = priceUpperLimit;
	}
	public Integer getStockLowerLimit() {
		return stockLowerLimit;
	}
	public void setStockLowerLimit(Integer stockLowerLimit) {
		this.stockLowerLimit = stockLowerLimit;
	}
	public Integer getStockUpperLimit() {
		return stockUpperLimit;
	}
	public void setStockUpperLimit(Integer stockUpperLimit) {
		this.stockUpperLimit = stockUpperLimit;
	}
	public Integer getProductYearLowerLimit() {
		return productYearLowerLimit;
	}
	public void setProductYearLowerLimit(Integer productYearLowerLimit) {
		this.productYearLowerLimit = productYearLowerLimit;
	}
	public Integer getProductYearUpperLimit() {
		return productYearUpperLimit;
	}
	public void setProductYearUpperLimit(Integer productYearUpperLimit) {
		this.productYearUpperLimit = productYearUpperLimit;
	}
	public Integer getOnlineShop() {
		return onlineShop;
	}
	public void setOnlineShop(Integer onlineShop) {
		this.onlineShop = onlineShop;
	}
	
	
	
}
