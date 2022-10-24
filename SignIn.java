package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SignIn() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//thiet lap font chu
		request.setCharacterEncoding("UTF-8");
		
		//bat dau validate input nhap vao tu nguoi dung
		boolean valid = true;
		
		String newname = request.getParameter("newname");
			if(newname == null || newname.length() == 0 ) {
				valid = false;
				request.setAttribute("newnameErr", "Tên đăng nhập không hợp lệ");
			}else {
				request.setAttribute("newname", newname);
			}
		String newpassword = request.getParameter("newpassword");
			if(newpassword == null || newpassword.length() == 0 ) {
				valid = false;
				request.setAttribute("newpasswordErr", "Mật khẩu đăng nhập không hợp lệ");
			}else {
				request.setAttribute("newpassword", newpassword);
			}
		String newmail = request.getParameter("newmail");
			if(newmail == null || newmail.length() == 0 ) {
				valid = false;
				request.setAttribute("newmailErr", "Email không hợp lệ");
			}else {
				request.setAttribute("newmail", newmail);
			}
		
		String newbirthday = request.getParameter("newbirthday");
			if(newbirthday == null || newbirthday.length() == 0 ) {
				valid = false;
				request.setAttribute("newbirthdayErr", "Ngày sinh không hợp lệ");
			}else {
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = null;
				try {
					birthday = sd.parse(newbirthday);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				request.setAttribute("newbirthday", birthday);
			}
		
		String newtel = request.getParameter("newtel");
			if(newtel == null || newtel.length() == 0 ) {
				valid = false;
				request.setAttribute("newtelErr", "Số điện thoại không hợp lệ");
			}else {
				request.setAttribute("newtel", newtel);
			}
			
		if(valid) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("signin.jsp").forward(request, response);
		}
	}

}
