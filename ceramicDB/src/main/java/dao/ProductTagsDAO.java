package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Glaze;
import model.Series;

public class ProductTagsDAO {
	private final String JDBC_URL = LoadDriver.getURL();
	private final String DB_USER = LoadDriver.getUSER();
	private final String DB_PASS = LoadDriver.getPASS();
	
	//SeriesテーブルからIDとNameを取得するメソッド　引数不要
	public List<Series> getSeriesTable(){
		//リストの作成
		List<Series> seriesList = new ArrayList<>();
		//LoadDriver.javaよりJDBCドライバの読み込み
		LoadDriver.execute();
		//データベースに接続 try-with-resource文で記述->close()の記載不要
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//検索系SQL文の用意
			String sql = "SELECT * FROM SERIES";
			//SQL文の送信ひな形を用意
			PreparedStatement pstm = conn.prepareStatement(sql);
			//SQL文をDBMSに送信する
			ResultSet resultSet = pstm.executeQuery();
			//SELECTの結果をArrayListに登録
			while(resultSet.next()) {
				int seriesID = resultSet.getInt("SERIES_ID");
				String seriesName = resultSet.getString("SERIES_NAME").trim();
				Series series = new Series(seriesID, seriesName);
				seriesList.add(series);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		//戻り値：ArrayList
		return seriesList;
	}
	
	//CategoryテーブルからIDとNameを取得するメソッド　引数不要
	public List<Category> getCategoryTable(){
		//リストの作成
		List<Category> categoryList = new ArrayList<>();
		//LoadDriver.javaよりJDBCドライバの読み込み
		LoadDriver.execute();
		//データベースに接続 try-with-resource文で記述->close()の記載不要
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//検索系SQL文の用意
			String sql = "SELECT * FROM CATEGORY";
			//SQL文の送信ひな形を用意
			PreparedStatement pstm = conn.prepareStatement(sql);
			//SQL文をDBMSに送信する
			ResultSet resultSet = pstm.executeQuery();
			//SELECTの結果をArrayListに登録
			while(resultSet.next()) {
				int categoryID = resultSet.getInt("CATEGORY_ID");
				String categoryName = resultSet.getString("CATEGORY_NAME").trim();
				Category category = new Category(categoryID, categoryName);
				categoryList.add(category);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		//戻り値：ArrayList
		return categoryList;
	}
		
	//GlazeテーブルからIDとNameを取得するメソッド　引数不要
	public List<Glaze> getGlazeTable(){
		//リストの作成
		List<Glaze> glazeList = new ArrayList<>();
		//LoadDriver.javaよりJDBCドライバの読み込み
		LoadDriver.execute();
		//データベースに接続 try-with-resource文で記述->close()の記載不要
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//検索系SQL文の用意
			String sql = "SELECT * FROM GLAZE";
			//SQL文の送信ひな形を用意
			PreparedStatement pstm = conn.prepareStatement(sql);
			//SQL文をDBMSに送信する
			ResultSet resultSet = pstm.executeQuery();
			//SELECTの結果をArrayListに登録
			while(resultSet.next()) {
				int glazeID = resultSet.getInt("GLAZE_ID");
				String glazeName = resultSet.getString("GLAZE_NAME").trim();
				Glaze glaze = new Glaze(glazeID, glazeName);
				glazeList.add(glaze);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		//戻り値：ArrayList
		return glazeList;
	}
		
	//シリーズ名をDBに追加するメソッド
	public Integer insertNewSeries(Series series) {
		//戻り値の初期化
		Integer result = null;
		//LoadDriver.javaよりJDBCドライバの読み込み
		LoadDriver.execute();
		//データベースに接続 try-with-resource文で記述->close()の記載不要
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//INSERT文を用意
			String sql =
					"INSERT INTO SERIES (SERIES_NAME) VALUES(?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//INSERT文に値を流し込みSQL文を組み立てる
			pstmt.setString(1, series.getSeriesName());
			//組み立てたSQL文をDBMSに送信する。戻り値は更新行数
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
	
	//シリーズ名をDBに追加するメソッド
	public Integer insertNewCategory(Category category) {
		//戻り値の初期化
		Integer result = null;
		//LoadDriver.javaよりJDBCドライバの読み込み
		LoadDriver.execute();
		//データベースに接続 try-with-resource文で記述->close()の記載不要
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//INSERT文を用意
			String sql =
					"INSERT INTO CATEGORY (CATEGORY_NAME) VALUES(?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//INSERT文に値を流し込みSQL文を組み立てる
			pstmt.setString(1, category.getCategoryName());
			//組み立てたSQL文をDBMSに送信する。戻り値は更新行数
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
	
	//釉薬をDBに追加するメソッド
	public Integer insertNewGlaze(Glaze glaze) {
		//戻り値の初期化
		Integer result = null;
		//LoadDriver.javaよりJDBCドライバの読み込み
		LoadDriver.execute();
		//データベースに接続 try-with-resource文で記述->close()の記載不要
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//INSERT文を用意
			String sql =
					"INSERT INTO GLAZE (GLAZE_NAME) VALUES(?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//INSERT文に値を流し込みSQL文を組み立てる
			pstmt.setString(1, glaze.getGlazeName());
			//組み立てたSQL文をDBMSに送信する。戻り値は更新行数
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
