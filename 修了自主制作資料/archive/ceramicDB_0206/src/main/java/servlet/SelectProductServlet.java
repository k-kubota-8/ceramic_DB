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

import model.Product;
import model.SelectCondition;
import model.SelectProductLogic;

/**
 * Servlet implementation class SelectProductServlet
 */
@WebServlet("/SelectProductServlet")
public class SelectProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//selectProduct.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/selectProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		//引数で必要となるSelectConditionをインスタンス化
		SelectCondition selectCondition = new SelectCondition();
		//リクエストパラメータを取得し、selectConditionのプロパティにセット *nullの判定をしてからすべきか？->しないと例外エラー
		if(request.getParameter("title") != null) {
			selectCondition.setTitle(request.getParameter("title").trim());
		}else {selectCondition.setTitle(null);}
		if(request.getParameter("series") != null) {
			selectCondition.setSeries(request.getParameter("series").trim());
		}else {selectCondition.setSeries(null);}
		if(request.getParameter("category") != null) {
			selectCondition.setCategory(request.getParameter("category").trim());
		}else {selectCondition.setCategory(null);}
		if(request.getParameter("glaze") != null) {
			selectCondition.setGlaze(request.getParameter("glaze").trim());
		}else {selectCondition.setGlaze(null);}
		if(request.getParameter("pattern") != null) {
			selectCondition.setPattern(request.getParameter("pattern").trim());
		}else {selectCondition.setPattern(null);}
		if(request.getParameter("color") != null) {
			selectCondition.setColor(request.getParameter("color").trim());
		}else {selectCondition.setColor(null);}
		if(request.getParameter("size") != null) {
			selectCondition.setSize(request.getParameter("size").trim());
		}else {selectCondition.setSize(null);}
		if(request.getParameter("priceLowerLimit") != "") {
			selectCondition.setPriceLowerLimit(Integer.valueOf(request.getParameter("priceLowerLimit").trim()));
		}else {selectCondition.setPriceLowerLimit(null);}
		if(request.getParameter("priceUpperLimit") != "") {
			selectCondition.setPriceUpperLimit(Integer.valueOf(request.getParameter("priceUpperLimit").trim()));
		}else {selectCondition.setPriceUpperLimit(null);}
		if(request.getParameter("stockLowerLimit") != "") {
			selectCondition.setStockLowerLimit(Integer.valueOf(request.getParameter("stockLowerLimit").trim()));
		}else {selectCondition.setStockLowerLimit(null);}
		if(request.getParameter("stockUpperLimit") != "") {
			selectCondition.setStockUpperLimit(Integer.valueOf(request.getParameter("stockUpperLimit").trim()));
		}else {selectCondition.setStockUpperLimit(null);}
		if(request.getParameter("productYearLowerLimit") != "") {
			selectCondition.setProductYearLowerLimit(Integer.valueOf(request.getParameter("productYearLowerLimit").trim()));
		}else {selectCondition.setProductYearLowerLimit(null);}
		if(request.getParameter("productYearUpperLimit") != "") {
			selectCondition.setProductYearUpperLimit(Integer.valueOf(request.getParameter("productYearUpperLimit").trim()));
		}else {selectCondition.setProductYearUpperLimit(null);}
		if(request.getParameter("isOnlineShop") != null) {
			selectCondition.setOnlineShop(Integer.valueOf(request.getParameter("isOnlineShop").trim()));
		}else {selectCondition.setOnlineShop(null);}
		//SelectProductLogic.executeSelect()の戻り値となるリストを用意
		List<Product> resultSelect = new ArrayList<>();
		//SelectProductLogicをインスタンス化
		SelectProductLogic selectLogic = new SelectProductLogic();
		//SelectProductLogic.executeSelect()実行
		resultSelect = selectLogic.executeSelect(selectCondition);
		//リストをリクエストスコープに保存
		request.setAttribute("resultSelectProduct", resultSelect);
		
		//resultSelectProduct.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/resultSelectProduct.jsp");
		dispatcher.forward(request, response);
	}

}
