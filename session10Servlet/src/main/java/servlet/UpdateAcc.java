package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccDAOimp;
import entities.Acc;

/**
 * Servlet implementation class UpdateComp
 */
@WebServlet("/UpdateAcc")
public class UpdateAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = sf.parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		Acc c = new Acc();
		c.setId(id);
		c.setFullName(fullName);
		c.setPassword(password);
		c.setGender(gender);
		c.setBirthday(birthday);
		c.setAddress(address);
		c.setEmail(email);
		c.setPhone(phone);
		
		Boolean ins = new AccDAOimp().update(c);
		if(ins) {
			request.setAttribute("success", "Update Successful");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Update failed");
			id = Integer.parseInt(request.getParameter("id"));
			Acc comp = new AccDAOimp().getById(id);
			request.setAttribute("comp", comp);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
