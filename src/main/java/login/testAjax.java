package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testAjax
 */
@WebServlet("/testAjax")
public class testAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws ServletException,IOException{
		res.setContentType("text/html; charset = UTF=8");

		String userName = req.getParameter("ID");
		PrintWriter out = res.getWriter(); 

		try {
			UsersDao usersDao = new UsersDao();
			ArrayList<UsersBean> usersList = usersDao.findAll();

//			boolean exist = usersList.stream().anyMatch(user -> user.getName().equals(userName));
			boolean exist = false;
			UsersBean users = usersList.get(0);
			if(users.getName().equals(userName)) {
				exist = true;
			}
			
			//for(int i = 0; i < usersList.size(); i++) {
			//UsersBean usersBean = usersList.get(i);
			//if(userName.equals(usersBean.getName())) {
			out.print(exist);
			/*req.setAttribute("data",  "存在するユーザーです");
					RequestDispatcher dispacher = req.getRequestDispatcher("./login.js");
					dispacher.forward(req,res);*/
			//			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public testAjax() {
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
