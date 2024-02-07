package model;

import dao.ProductsDAO;

public class InsertNewProductLogic {
	public boolean executeInsert(Product product) {
		ProductsDAO dao = new ProductsDAO();
		Integer result = dao.insertNewProduct(product);
		boolean r;
		
		if(result == 1) {
			r = true;
		}else {
			r = false;
		}
		
		return r;
	}
}
