package model;

import java.util.ArrayList;
import java.util.List;

import dao.ProductsDAO;

public class SelectProductLogic {
	public List<Product> executeSelect(SelectCondition sc){
		//戻り値を受け取るためのリスト生成
		List<Product> resultProductList = new ArrayList<>() ;
		//DAOをインスタンス化
		ProductsDAO dao = new ProductsDAO();
		//DAOの作品検索用メソッドを実行
		resultProductList = dao.selectProduct(sc);
		return resultProductList;
	}
}
