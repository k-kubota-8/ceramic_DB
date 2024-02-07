package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.SelectCondition;

public class ProductsDAO {
//	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";
//	private final String DB_DRIVER = "org.h2.Driver";
	
	private final String JDBC_URL = LoadDriver.getURL();
	private final String DB_USER = LoadDriver.getUSER();
	private final String DB_PASS = LoadDriver.getPASS();
	
	//作品情報新規登録用メソッド
	public Integer insertNewProduct(Product product) {
		//戻り値の初期化
		Integer result = null;
		
		//LoadDriver.javaよりJDBCドライバの読み込み
		LoadDriver.execute();
		
		//JDBCドライバを読み込む（上のLoadDriver.javaを使用するためコメント化）
//		try {
//			Class.forName(DB_DRIVER);
//		}catch (ClassNotFoundException e) {
//			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
//		}
		
		//データベースに接続 try-with-resource文で記述->close()の記載不要
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//INSERT文を用意
			String sql =
					"INSERT INTO PRODUCTS (TITLE,SERIES,CATEGORY,GLAZE,PATTERN,COLOR,SIZE,PRICE,STOCK,PRODUCT_YEAR,IS_ONLINE_SHOP) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//INSERT文に値を流し込みSQL文を組み立てる
			pstmt.setString(1, product.getTitle()); //TITLE
			pstmt.setString(2, product.getSeries()); //SERIES
			pstmt.setString(3, product.getCategory()); //CATEGORY
			pstmt.setString(4, product.getGlaze()); //GLAZE
			pstmt.setString(5, product.getPattern()); //PATTERN
			pstmt.setString(6, product.getColor()); //COLOR
			pstmt.setString(7, product.getSize()); //SIZE
			pstmt.setInt(8, product.getPrice()); //PRICE
			pstmt.setInt(9, product.getStock()); //STOCK
			pstmt.setInt(10, product.getProductYear()); //PRODUCT_YEAR
			pstmt.setBoolean(11, product.isOnlineShop()); //IS_ONLINE_SHOP
			
			//組み立てたSQL文をDBMSに送信する。戻り値は更新行数
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	//作品検索用メソッド
	public List<Product> selectProduct(SelectCondition selectCondition){
		//リストの作成
		List<Product> productList = new ArrayList<>();
		//LoadDriver.javaよりJDBCドライバの読み込み
		LoadDriver.execute();
		//データベースに接続 try-with-resource文で記述->close()の記載不要
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//検索系SQL文を用意
			String sql = "SELECT * FROM PRODUCTS";
			//文字列連結のためにStringBuilderに変換
			StringBuilder sqlsb = new StringBuilder(sql);
			//条件によってSQL文に追加
			if(!(selectCondition.getTitle() == null &&
					selectCondition.getSeries() == null &&
					selectCondition.getCategory() == null &&
					selectCondition.getGlaze() == null &&
					selectCondition.getPattern() == null &&
					selectCondition.getColor() == null &&
					selectCondition.getSize() == null &&
					selectCondition.getPriceLowerLimit() ==null &&
					selectCondition.getPriceUpperLimit() == null &&
					selectCondition.getStockLowerLimit() == null &&
					selectCondition.getStockUpperLimit() == null &&
					selectCondition.getProductYearLowerLimit() == null &&
					selectCondition.getProductYearUpperLimit() == null &&
					selectCondition.getOnlineShop() == null )) {
				sqlsb = sqlsb.append(" WHERE");
			}
			if(selectCondition.getTitle() != null) {
				sqlsb = sqlsb.append(" TITLE LIKE '%" + selectCondition.getTitle() + "%' AND");
			}
			if(selectCondition.getSeries() != null) {
				sqlsb = sqlsb.append(" SERIES LIKE '%" + selectCondition.getSeries() + "%' AND");
			}
			if(selectCondition.getCategory() != null) {
				sqlsb = sqlsb.append(" CATEGORY LIKE '%" + selectCondition.getCategory() + "%' AND");
			}
			if(selectCondition.getGlaze() != null) {
				sqlsb = sqlsb.append(" GLAZE LIKE '%" + selectCondition.getGlaze() + "%' AND");
			}
			if(selectCondition.getPattern() != null) {
				sqlsb = sqlsb.append(" PATTERN LIKE '%" + selectCondition.getPattern() + "%' AND");
			}
			if(selectCondition.getColor() != null) {
				sqlsb = sqlsb.append(" COLOR LIKE '%" + selectCondition.getColor() + "%' AND");
			}
			if(selectCondition.getSize() != null) {
				sqlsb = sqlsb.append(" SIZE LIKE '%" + selectCondition.getSize() + "%' AND");
			}
			if(selectCondition.getPriceLowerLimit() != null) {
				sqlsb = sqlsb.append(" PRICE >=" + selectCondition.getPriceLowerLimit() + " AND");
			}
			if(selectCondition.getPriceUpperLimit() != null) {
				sqlsb = sqlsb.append(" PRICE <=" + selectCondition.getPriceUpperLimit() + " AND");
			}
			if(selectCondition.getStockLowerLimit() != null) {
				sqlsb = sqlsb.append(" STOCK >=" + selectCondition.getStockLowerLimit() + " AND");
			}
			if(selectCondition.getStockUpperLimit() != null) {
				sqlsb = sqlsb.append(" STOCK <=" + selectCondition.getStockUpperLimit() + " AND");
			}
			if(selectCondition.getProductYearLowerLimit() != null) {
				sqlsb = sqlsb.append(" PRODUCT_YEAR >=" + selectCondition.getProductYearLowerLimit() + " AND");
			}
			if(selectCondition.getProductYearUpperLimit() != null) {
				sqlsb = sqlsb.append(" PRODUCT_YEAR <=" + selectCondition.getProductYearUpperLimit() + " AND");
			}
			if(selectCondition.getOnlineShop() != null) {
				if(selectCondition.getOnlineShop() == 1) { //この条件は要確認
					sqlsb = sqlsb.append(" IS_ONLINE_SHOP = TRUE");
				}else if(selectCondition.getOnlineShop() == 0) {
					sqlsb = sqlsb.append(" IS_ONLINE_SHOP = FALSE");
				}else if(selectCondition.getOnlineShop() == 2) {
					//TrueもFaleseも表示したいので何もしない
				}
			}
			//SQL文に含まれる最後の不要なANDを削除
			if(sqlsb.lastIndexOf("AND") == (sqlsb.length()-3)) {
				sqlsb.delete(sqlsb.lastIndexOf("AND"), sqlsb.length());
			}
			//ORDER BYを追加
			sqlsb.append(" ORDER BY PRODUCT_ID ASC");
			//Stringに戻す
			sql = sqlsb.toString(); 
			//SQL文の送信ひな形を用意
			PreparedStatement pstm = conn.prepareStatement(sql);
			//SQL文をDBMSに送信する
			ResultSet resultSet = pstm.executeQuery();
			//SELECTの結果をArrayListに登録
			while(resultSet.next()) {
				int productID = resultSet.getInt("PRODUCT_ID");
				String title = resultSet.getString("TITLE").trim();
				String series = resultSet.getString("SERIES").trim();
				String category = resultSet.getString("CATEGORY").trim();
				String glaze = resultSet.getString("GLAZE").trim();
				String pattern = resultSet.getString("PATTERN").trim();
				String color = resultSet.getString("COLOR").trim();
				String size = resultSet.getString("SIZE").trim();
				int price = resultSet.getInt("PRICE");
				int stock = resultSet.getInt("STOCK");
				int productYear = resultSet.getInt("PRODUCT_YEAR");
				boolean isOnlineShop = resultSet.getBoolean("IS_ONLINE_SHOP");
				Product product = new Product(productID, title, series, category, glaze, pattern, color, size, price, stock, productYear, isOnlineShop);
				productList.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		//戻り値：ArrayList
		return productList;
	}
}
