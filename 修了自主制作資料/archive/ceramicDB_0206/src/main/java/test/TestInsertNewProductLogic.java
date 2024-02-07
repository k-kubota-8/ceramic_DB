package test;

import model.InsertNewProductLogic;
import model.Product;

public class TestInsertNewProductLogic {
	public static void main(String[] args) {
		testExecuteInsertOK();
	}
	
	public static void testExecuteInsertOK() {
		Product testOK = new Product();
		InsertNewProductLogic insertLogic = new InsertNewProductLogic();
		
		//テストデータ作成
		testOK.setTitle("テスト4");
		testOK.setSeries("シリーズ4");
		testOK.setCategory("カテゴリー4");
		testOK.setGlaze("釉薬4");
		testOK.setPattern("パターン4");
		testOK.setColor("青");
		testOK.setSize("40x30x40");
		testOK.setPrice(4000);
		testOK.setStock(40);
		testOK.setProductYear(2021);
		testOK.setOnlineShop(true);
		
		boolean result = insertLogic.executeInsert(testOK);
		if(result) {
			System.out.println("testExecuteInsertOK : success!!");
		}else {
			System.out.println("testExecuteInsertOK : failed...");
		}
	}
}
