package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Category;
import model.Glaze;
import model.InsertNewProductLogic;
import model.Product;
import model.ProductTagLogic;
import model.Series;

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
		//シリーズタグ、カテゴリータグ、釉薬タグをDBからそれぞれ入手
		List<Series> seriesTag = new ArrayList<>();
		List<Category> categoryTag = new ArrayList<>();
		List<Glaze> glazeTag = new ArrayList<>();
		ProductTagLogic pTagLogic = new ProductTagLogic();
		seriesTag = pTagLogic.getSeriesTable();
		categoryTag = pTagLogic.getCategoryTable();
		glazeTag = pTagLogic.getGlazeTable();
		//シリーズ、カテゴリー、釉薬リストをリクエストスコープに保存
//		request.setAttribute("seriesTag", seriesTag);
//		request.setAttribute("categoryTag", categoryTag);
//		request.setAttribute("glazeTag", glazeTag);
		//リクエストスコープではなく、セッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("seriesTag", seriesTag);
		session.setAttribute("categoryTag", categoryTag);
		session.setAttribute("glazeTag", glazeTag);
		
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
//		String series = request.getParameter("series");
		int seriesID = Integer.parseInt(request.getParameter("seriesTag"));
//		String category = request.getParameter("category");
		int categoryID = Integer.parseInt(request.getParameter("categoryTag"));
//		String glaze = request.getParameter("glaze");
		int glazeID = Integer.parseInt(request.getParameter("glazeTag"));
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
		Product product = new Product(title, seriesID, categoryID, glazeID, pattern, color, size, price, stock,productYear, isOnlineShop);
		//シリーズ、カテゴリー、釉薬のIDと名前を結合させてproductインスタンスの情報に追加
		//sessionスコープからインスタンスを取得
		List<Series> seriesTag = new ArrayList<>();
		List<Category> categoryTag = new ArrayList<>();
		List<Glaze> glazeTag = new ArrayList<>();
		HttpSession session = request.getSession();
		seriesTag = (ArrayList<Series>) session.getAttribute("seriesTag");
		categoryTag = (ArrayList<Category>) session.getAttribute("categoryTag");
		glazeTag = (ArrayList<Glaze>) session.getAttribute("glazeTag");
		//IDと名前を一致させて、インスタンスに情報追加
		for(Series series: seriesTag) {
			if(seriesID == series.getSeriesID()) {
				product.setSeries(series.getSeriesName());
				break;
			}
		}
		for(Category category: categoryTag) {
			if(categoryID == category.getCategoryID()) {
				product.setCategory(category.getCategoryName());
				break;
			}
		}
		for(Glaze glaze: glazeTag) {
			if(glazeID == glaze.getGlazeID()) {
				product.setGlaze(glaze.getGlazeName());
				break;
			}
		}
		//データベースにインスタンスの情報を格納
		InsertNewProductLogic insertLogic = new InsertNewProductLogic();
		boolean result = insertLogic.executeInsert(product);
		//セッションスコープの破棄(オブジェクトの削除のみ）
		session.removeAttribute("seriesTag");
		session.removeAttribute("categoryTag");
		session.removeAttribute("glazeTag");
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
