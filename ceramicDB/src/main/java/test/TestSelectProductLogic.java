package test;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.SelectCondition;
import model.SelectProductLogic;

public class TestSelectProductLogic {
	public static void main(String[] args) {
		testSelectProductOK();
	}
	
	public static void testSelectProductOK() {
		//検索条件作成
		SelectCondition sc = new SelectCondition();
		sc.setTitle("テスト");
		sc.setSeries("シリーズ_");
		sc.setCategory(null);
		sc.setGlaze(null);
		sc.setPattern(null);
		sc.setColor(null);
		sc.setSize(null);
		sc.setPriceLowerLimit(3000);
		sc.setPriceUpperLimit(6000);
		sc.setStockLowerLimit(null);
		sc.setStockUpperLimit(null);
		sc.setProductYearLowerLimit(null);
		sc.setProductYearUpperLimit(null);
		sc.setOnlineShop(2);
		//SelectProductLogicをインスタンス化
		SelectProductLogic logic = new SelectProductLogic();
		//戻り値を受け取るためのリスト生成
		List<Product> result = new ArrayList<>();
		//SelectProductLogic.executeSelectを実行
		result = logic.executeSelect(sc);
		//リストの中身を表示
		for(Product product : result) {
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
