package test;

import java.util.ArrayList;
import java.util.List;

import dao.ProductsDAO;
import model.Product;
import model.SelectCondition;

public class TestProductsDAO {
	public static void main(String[] args) {
//		testInsertNewProductOK(); //データベースに正しく登録できる場合のテスト
//		testInsertNewProductNG(); //登録できない場合のテスト
		
		//データベースから作品情報を取得
		testSelectProductOK();
	}
	
	public static void testInsertNewProductOK() {
		Product testOK = new Product();
		ProductsDAO dao = new ProductsDAO();
		
		//テストデータ作成
		testOK.setTitle("テスト3");
		testOK.setSeries("シリーズ3");
		testOK.setCategory("シリーズ3");
		testOK.setGlaze("釉薬3");
		testOK.setPattern("パターン3");
		testOK.setColor("赤");
		testOK.setSize("20x30x40");
		testOK.setPrice(3000);
		testOK.setStock(30);
		testOK.setProductYear(2022);
		testOK.setOnlineShop(false);
		
		//DAOのメソッド実行
		Integer result = dao.insertNewProduct(testOK);
		if(result == 1) {
			System.out.println("testInsertNewProductOK:success!");
		}else if(result == null) {
			System.out.println("testInsertNewProductOK:failed...");
		}else {
			System.out.println("testInsertNewProductOK:??");
		}
	}
	
	
	public static void testInsertNewProductNG() {
		Product testNG = new Product();
		ProductsDAO dao = new ProductsDAO();
		
		//DAOのメソッド実行
		Integer result = dao.insertNewProduct(testNG);
		if(result == 0) {
			System.out.println("testInsertNewProductNG:success!");
		}else {
			System.out.println("testInsertNewProductNG:failed...");
		}
	}
	
	public static void testSelectProductOK() {
		SelectCondition sc = new SelectCondition();
		
		//条件指定
//		sc.setTitle("テスト");
//		sc.setSeries(null);
//		sc.setCategory(null);
//		sc.setGlaze(null);
//		sc.setPattern(null);
//		sc.setColor(null);
//		sc.setSize(null);
//		sc.setPriceLowerLimit(null);
//		sc.setPriceUpperLimit(null);
//		sc.setStockLowerLimit(null);
//		sc.setStockUpperLimit(null);
//		sc.setProductYearLowerLimit(null);
//		sc.setProductYearUpperLimit(null);
//		sc.setOnlineShop(1);
		
		
		ProductsDAO dao = new ProductsDAO();
		List<Product> productList = new ArrayList<>();
		productList = dao.selectProduct(sc);
		for(Product product : productList) {
			System.out.print("作品ID:" + product.getProductID() + "|");
			System.out.print("タイトル:" + product.getTitle() + "|");
			System.out.print("シリーズ:" + product.getSeries() + "|");
			System.out.print("釉薬" + product.getGlaze() + "|");
			System.out.print("柄:" + product.getPattern() + "|");
			System.out.print("色:" + product.getColor() + "|");
			System.out.print("サイズ:" + product.getSize() + "|");
			System.out.print("価格:" + product.getPrice() + "|");
			System.out.print("在庫:" + product.getStock() + "|");
			System.out.print("制作年:" + product.getProductYear() + "|");
			System.out.print("ネットショップ取り扱い:" + product.isOnlineShop() + "\n");
			System.out.println("--------");
		}
	}
}
