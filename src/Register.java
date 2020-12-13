import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ccode=request.getParameter("ccode");
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobilenumber=request.getParameter("mobilenumber");
		String r="COMPANY CODE IS INNCORRECT,YOU CANT REGISTER...";
		if(ccode.compareToIgnoreCase("kaap")==0)
		{
		member m=new member(uname,password,email,mobilenumber);
	    Registerdao rdoa=new Registerdao();
	    String result=rdoa.insert(m);
	    response.getWriter().print(result);
	    request.setAttribute("ssmessage",result);
	    request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
		else {
			response.getWriter().print(r);
		    request.setAttribute("ssmessage",r);
		    request.getRequestDispatcher("register.jsp").forward(request, response);
	    }
	}

}
