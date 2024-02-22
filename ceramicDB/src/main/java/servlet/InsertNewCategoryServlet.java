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

import model.Category;
import model.ProductTagLogic;

/**
 * Servlet implementation class InsertNewCategoryServlet
 */
@WebServlet("/InsertNewCategoryServlet")
public class InsertNewCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNewCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insertNewCategory.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/insertNewCategory.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String categoryName = request.getParameter("categoryName");
		Category category = new Category();
		category.setCategoryName(categoryName);
		//同名のシリーズ名が登録済かどうか判定
		List<Category> categoryTag = new ArrayList<>();
		ProductTagLogic pTagLogic = new ProductTagLogic();
		categoryTag = pTagLogic.getCategoryTable();
		int count =0;
		for(Category registered: categoryTag) {
			if(categoryName.equals(registered.getCategoryName())) {
				count++;
				//すでに登録済の場合、登録済画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registered.jsp");
				dispatcher.forward(request, response);
			}
		}
		if(count == 0) {
			//DBに登録
			boolean result = pTagLogic.executeInsertNewCategory(category);
			if(result) {
			//doneInsert.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/doneInsert.jsp");
			dispatcher.forward(request, response);
			}else {
				//格納が失敗したら登録失敗画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/failed.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
