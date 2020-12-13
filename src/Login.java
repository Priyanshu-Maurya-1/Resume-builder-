import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		Registerdao rdoa=new Registerdao();
		member m=rdoa.getmember(uname,password);
		if(m!=null)
		{
			 request.setAttribute("message",m.getUname());
			 request.getRequestDispatcher("Welcome.jsp").forward(request,response);
		}
		else
		{
			request.setAttribute("smessage","This user doesn't exist,Register User to login");
			 request.getRequestDispatcher("login.jsp").forward(request,response);
			 
		}
	}

}
