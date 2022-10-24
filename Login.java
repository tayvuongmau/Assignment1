package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// lấy về dữ liệu
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String savepass = request.getParameter("savepass");
		
		//gán dữ liệu cho username và password được thiết lập trong file web.xml
		String id = getServletConfig().getInitParameter("username");
		String pass = getServletConfig().getInitParameter("password");
		
		
		System.out.println(id);
		System.out.println(pass);
		
		
		//kiểm tra tài khoản đăng nhập
		if(username != null && username.equals(id) && password != null && password.equalsIgnoreCase(pass)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			
			//xử lí savepass - tạo cookie để lưu user và pass khi tách vào nhớ mật khẩu
			if(savepass != null && savepass.equals("savepass")) {
				Cookie cUser = new Cookie("username", username);
				Cookie cPass = new Cookie("password", password);
				Cookie cSave = new Cookie("savepass", "true");
				
				// đặt thời gian lưu tài khoản
				cUser.setMaxAge(24*60*60);   //24h*60p*60s
				cPass.setMaxAge(24*60*60);   //24h*60p*60s
				cSave.setMaxAge(24*60*60);   //24h*60p*60s
				
				response.addCookie(cUser);
				response.addCookie(cPass);
				response.addCookie(cSave);
				//chuyển trang bằng resp 
				response.sendRedirect("home.jsp");
			}else {
				// khong tich vao save
				Cookie cUser = new Cookie("username", "");
				Cookie cPass = new Cookie("password", "");
				Cookie cSave = new Cookie("savepass", "");
				
				response.addCookie(cUser);
				response.addCookie(cPass);
				response.addCookie(cSave);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
			
		}else {
			request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
