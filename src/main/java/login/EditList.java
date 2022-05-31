package login;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditList
 */
@WebServlet("/EditList")
public class EditList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws ServletException,IOException{
		res.setContentType("text/html; charset = UTF=8");
		

		//問題一覧画面から、問題Noを取得
		int editNo = Integer.parseInt(req.getParameter("edit"));
		QuestionsBean questionsBean = null;
		ArrayList<AnswersBean> answersList = null;
		
		try {
			QuestionsDao questionsDao = new QuestionsDao();
			AnswersDao answersDao = new AnswersDao();
			questionsBean = questionsDao.find(editNo);
			answersList = answersDao.findAll();
			
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		if( req.getParameter("editFlag") == null) {
			req.setAttribute("editNo", editNo);
			req.setAttribute("editQ", questionsBean.getQuestion());
			req.setAttribute("editA", answersList);
			RequestDispatcher disList = req.getRequestDispatcher("./editList.jsp");
			disList.forward(req,res);
			return;
		}

		
		//更新処理
		
		//画面から入力された問題を取得する
		String questionData = req.getParameter("qData");
		//画面から入力された答えを取得する
		String answerData[] = req.getParameterValues("data[]");
		
		try {
			QuestionsDao questionsDao = new QuestionsDao();
			questionsDao.update(editNo, questionData, answerData);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("Questions");
		dispatcher.forward(req,res);
		
		
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
