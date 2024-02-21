package test;

import java.util.ArrayList;
import java.util.List;

import dao.ProductTagsDAO;
import model.Category;
import model.Glaze;
import model.Series;

public class TestProductTagsDAO {
	public static void main(String[] args) {
		//データベースからSeriesテーブルの情報を取得
		testSeriesTableOK();
		System.out.println("");
		//データベースからCategoryテーブルの情報を取得
		testCategoryTableOK();
		System.out.println("");
		//データベースからCategoryテーブルの情報を取得
		testGlazeTableOK();
	}
	
	public static void testSeriesTableOK() {
		ProductTagsDAO dao = new ProductTagsDAO();
		List<Series> seriesList = new ArrayList<>();
		seriesList = dao.getSeriesTable();
		System.out.println("シリーズ一覧");
		for(Series series: seriesList) {
			System.out.println("シリーズ:" + series.getSeriesID() + "|" + series.getSeriesName());
		}
	}
	
	public static void testCategoryTableOK() {
		ProductTagsDAO dao = new ProductTagsDAO();
		List<Category> categoryList = new ArrayList<>();
		categoryList = dao.getCategoryTable();
		System.out.println("カテゴリー一覧");
		for(Category category: categoryList) {
			System.out.println("カテゴリー:" + category.getCategoryID() + "|" + category.getCategoryName());
		}
	}
	
	public static void testGlazeTableOK() {
		ProductTagsDAO dao = new ProductTagsDAO();
		List<Glaze> glazeList = new ArrayList<>();
		glazeList = dao.getGlazeTable();
		System.out.println("釉薬一覧");
		for(Glaze glaze: glazeList) {
			System.out.println("釉薬:" + glaze.getGlazeID() + "|" + glaze.getGlazeName());
		}
	}
}
