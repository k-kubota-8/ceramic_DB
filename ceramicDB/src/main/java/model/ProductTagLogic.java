package model;

import java.util.ArrayList;
import java.util.List;

import dao.ProductTagsDAO;

public class ProductTagLogic {
	//シリーズテーブルの情報を取得するメソッド
	public List<Series> getSeriesTable(){
		//戻り値を受け取るリストを用意
		List<Series> seriesList = new ArrayList<>();
		//DAOをインスタンス化
		ProductTagsDAO dao = new ProductTagsDAO();
		//DAOのシリーズテーブル取得メソッドを使用
		seriesList = dao.getSeriesTable();
		return seriesList;
	}
	
	//カテゴリーテーブルの情報を取得するメソッド
	public List<Category> getCategoryTable(){
		//戻り値を受け取るリストを用意
		List<Category> categoryList = new ArrayList<>();
		//DAOをインスタンス化
		ProductTagsDAO dao = new ProductTagsDAO();
		//DAOのカテゴリーテーブル取得メソッドを使用
		categoryList = dao.getCategoryTable();
		return categoryList;
	}
	
	//釉薬テーブルの情報を取得するメソッド
	public List<Glaze> getGlazeTable(){
		//戻り値を受け取るリストを用意
		List<Glaze> glazeList = new ArrayList<>();
		//DAOをインスタンス化
		ProductTagsDAO dao = new ProductTagsDAO();
		//DAOの釉薬テーブル取得メソッドを使用
		glazeList = dao.getGlazeTable();
		return glazeList;
	}
}
