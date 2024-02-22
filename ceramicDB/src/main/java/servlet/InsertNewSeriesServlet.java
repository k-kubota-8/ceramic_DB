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

import model.ProductTagLogic;
import model.Series;

/**
 * Servlet implementation class InsertNewSeriesServlet
 */
@WebServlet("/InsertNewSeriesServlet")
public class InsertNewSeriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNewSeriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insertNewSeries.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/insertNewSeries.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String seriesName = request.getParameter("seriesName");
		Series series = new Series();
		series.setSeriesName(seriesName);
		//同名のシリーズ名が登録済かどうか判定
		List<Series> seriesTag = new ArrayList<>();
		ProductTagLogic pTagLogic = new ProductTagLogic();
		seriesTag = pTagLogic.getSeriesTable();
		int count =0;
		for(Series registered: seriesTag) {
			if(seriesName.equals(registered.getSeriesName())) {
				count++;
				//すでに登録済の場合、登録済画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registered.jsp");
				dispatcher.forward(request, response);
			}
		}
		if(count == 0) {
			//DBに登録
//			ProductTagLogic pTagLogic = new ProductTagLogic(); //
			boolean result = pTagLogic.executeInsertNewSeries(series);
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
