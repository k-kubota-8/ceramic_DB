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

import model.Glaze;
import model.ProductTagLogic;

/**
 * Servlet implementation class InsertNewGlazeServlet
 */
@WebServlet("/InsertNewGlazeServlet")
public class InsertNewGlazeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNewGlazeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insertNewGlaze.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/insertNewGlaze.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String glazeName = request.getParameter("glazeName");
		Glaze glaze = new Glaze();
		glaze.setGlazeName(glazeName);
		//同名のシリーズ名が登録済かどうか判定
		List<Glaze> glazeTag = new ArrayList<>();
		ProductTagLogic pTagLogic = new ProductTagLogic();
		glazeTag = pTagLogic.getGlazeTable();
		int count =0;
		for(Glaze registered: glazeTag) {
			if(glazeName.equals(registered.getGlazeName())) {
				count++;
				//すでに登録済の場合、登録済画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registered.jsp");
				dispatcher.forward(request, response);
			}
		}
		if(count == 0) {
			//DBに登録
			boolean result = pTagLogic.executeInsertNewGlaze(glaze);
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
