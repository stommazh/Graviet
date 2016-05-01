

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="RequestController", urlPatterns={"/RequestController"})
public class RequestController extends HttpServlet {



    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if(action.equals("login")){
            if(session.getAttribute("user")==null){
            session.setAttribute("page", "login");         
//            response.sendRedirect("index.jsp"); 
            }
            else session.setAttribute("page",null);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);  
        }
        else if(action.equals("homepage")){
            session.setAttribute("page", null);
//            session.setAttribute("pagenumber", 0);
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                rd.forward(request, response); 
            response.sendRedirect("index.jsp");       
        }
        else if(action.equals("navigation_next")){
            Integer i = 0;
            if ((Integer) session.getAttribute("pagenumber")!=null){
                i = (Integer) session.getAttribute("pagenumber");
                session.setAttribute("pagenumber", i+1);
//                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                rd.forward(request, response);
                response.sendRedirect("index.jsp");
        }
            else{
                session.setAttribute("pagenumber", 1);
//                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                rd.forward(request, response);
                response.sendRedirect("index.jsp");
            }
        }
        else if(action.equals("navigation_pre")){
            Integer i = 0;
            if ((Integer) session.getAttribute("pagenumber")!=null){
                i = (Integer) session.getAttribute("pagenumber");
                if(i>0){
                session.setAttribute("pagenumber", i-1);
                }
//                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                rd.forward(request, response);
                response.sendRedirect("index.jsp");
        }
            else{
                session.setAttribute("pagenumber", 0);
//                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                rd.forward(request, response);
                response.sendRedirect("index.jsp");
            }
        }
        else if(action.equals("navigation_first")){
                session.setAttribute("pagenumber", 0);
//                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                rd.forward(request, response);
                response.sendRedirect("index.jsp");
        }        
        else{
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response); 
        }
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        


    }

}
