package kr.co.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/Validate")
public class Validate extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String txtID = request.getParameter("txtID");
        PrintWriter out = response.getWriter();
       
        if(txtID.equals("javaking")){
            out.println("false"); //이미 있는 아이디
        }else{
            out.println("true"); // 유효성(validation) 통과
        }      
    }
}

