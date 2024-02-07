package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InsertNewProductLogic;
import model.Product;

/**
 * Servlet implementation class InsertNewProductServlet
 */
@WebServlet("/InsertNewProductServlet")
public class InsertNewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNewProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//【作品情報新規登録画面】へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/insertNewProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String series = request.getParameter("series");
		String category = request.getParameter("category");
		String glaze = request.getParameter("glaze");
		String pattern = request.getParameter("pattern");
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int productYear = Integer.parseInt(request.getParameter("productYear"));
		String onlineShop = request.getParameter("isOnlineShop");
		
		//リクエストパラメータを使用してProductインスタンスを生成
		boolean isOnlineShop = false;
		if(onlineShop.equals("1")) {
			isOnlineShop = true;
		}else if(onlineShop.equals("0")) {
			isOnlineShop = false;
		}
		Product product = new Product(title, series, category, glaze, pattern, color, size, price, stock,productYear, isOnlineShop);
		
		//データベースにインスタンスの情報を格納
		InsertNewProductLogic insertLogic = new InsertNewProductLogic();
		boolean result = insertLogic.executeInsert(product);
		
		//格納が成功したらリクエストスコープにインスタンスを保存してフォワード
		if(result) {
			request.setAttribute("newProduct", product);
			
			//【登録完了画面】へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/doneInsertNewProduct.jsp");
			dispatcher.forward(request, response);
		}else {  //格納が失敗したら登録失敗画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/failed.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
