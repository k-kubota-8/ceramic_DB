package test;

import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Glaze;
import model.ProductTagLogic;
import model.Series;

public class TestProductTagLogic {
	public static void main(String[] args) {
		seriesLogicOK();
		System.out.println("");
		categoryLogicOK();
		System.out.println("");
		glazeLogicOK();
	}
	
	public static void seriesLogicOK() {
		List<Series> seriesList = new ArrayList<>();
		ProductTagLogic logic = new ProductTagLogic();
		seriesList = logic.getSeriesTable();
		System.out.println("シリーズ一覧");
		for(Series series: seriesList) {
			System.out.println(series.getSeriesID() + "|" + series.getSeriesName());
		}
	}
	
	public static void categoryLogicOK() {
		List<Category> categoryList = new ArrayList<>();
		ProductTagLogic logic = new ProductTagLogic();
		categoryList = logic.getCategoryTable();
		System.out.println("カテゴリー一覧");
		for(Category category: categoryList) {
			System.out.println(category.getCategoryID() + "|" + category.getCategoryName());
		}
	}
	
	public static void glazeLogicOK() {
		List<Glaze> glazeList = new ArrayList<>();
		ProductTagLogic logic = new ProductTagLogic();
		glazeList = logic.getGlazeTable();
		System.out.println("釉薬一覧");
		for(Glaze glaze: glazeList) {
			System.out.println(glaze.getGlazeID() + "|" + glaze.getGlazeName());
		}
	}
}
