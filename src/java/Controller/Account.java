

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.Database;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
@WebServlet(name="Account", urlPatterns={"/Account"})
public class Account extends HttpServlet {
    protected static boolean executed=false;
    protected static boolean validatePasswordLength(String password){
        boolean valid = false;
        if((password.length()>5 && password.length()<65))valid = true;
        return valid;
    }


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if(action!=null){
        if(action.equals("back")){
        session.setAttribute("email", null);
        session.setAttribute("notregister",null);
        session.setAttribute("page","login");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response); 
        }
        else 
        if(action.equals("logout")){
            session.setAttribute("user", null);
            session.setAttribute("page", null);
            response.sendRedirect("index.jsp");
        }
        else {
        response.sendRedirect("index.jsp");
        }
        }else
        response.sendRedirect("index.jsp");
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();   
        HttpSession session = request.getSession();
        if(session.isNew()){
            request.setAttribute("message","<center><p>Session time out</p></center>");
            session.setAttribute("page","login");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } 
        else{
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        String newemail = (String) session.getAttribute("notregister");
        String user = (String) session.getAttribute("user");
        if(user==null){
            //get email 
            if((request.getParameter("email")!=null) && (request.getParameter("password")==null) &&(request.getParameter("new_email")==null)){
                if(Database.checkEmail(request.getParameter("email"))){
                    session.setAttribute("email", request.getParameter("email"));
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                } else{
                    session.setAttribute("email", null);
                    session.setAttribute("notregister",request.getParameter("email"));
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            } else
                //login
            
            
            if((request.getParameter("password")!=null) &&(request.getParameter("email")==null) && (request.getParameter("new_password")==null)){    
                if(!Database.checkEmail(email)){ //email does not existed in database
                    session.setAttribute("email",null);
                    session.setAttribute("notregister",null);
                    request.setAttribute("message","<center><p>Account is dropped when processing!</p></center>");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response); 
                }
                else if(Database.checkUser(email,request.getParameter("password"))){
                    session.setAttribute("email",null);
                    session.setAttribute("user",email);
                    session.setAttribute("page",null);
                    response.sendRedirect("index.jsp");
                    
                } else{
                    request.setAttribute("message","<center><p>Incorrect password</p></center>");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
                 
            } else
            //create account
            if((request.getParameter("new_password")!=null) &&(request.getParameter("email")==null) 
                    &&(request.getParameter("password")==null)){
                if(Database.checkEmail(newemail)){//First check before proceed database, Email is already existed in database
                    session.setAttribute("email",null);
                    session.setAttribute("notregister",null);
                    request.setAttribute("message","<center><p>This email is already registered, please choose another one</p></center>");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
                else{
                    if(validatePasswordLength(request.getParameter("new_password"))){ //Re check password length
                    Database.addUser(newemail,request.getParameter("new_password"));                    
                        session.setAttribute("email",null);
                        session.setAttribute("user",session.getAttribute("notregister"));
                        session.setAttribute("notregister",null);
                        session.setAttribute("page",null);
                        response.sendRedirect("index.jsp");            
                }
                    else{
                        session.setAttribute("email",null);
                    session.setAttribute("notregister",null);
                    request.setAttribute("message","<center><p>This email is already registered, please choose another one</p></center>");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                    }

            }
        }else{
            session.setAttribute("page","login");
            session.setAttribute("email",null);
            session.setAttribute("notregister",null);
            session.setAttribute("message","Some thing went wrong. Please try again.");
            response.sendRedirect("index.jsp");
                    
        }
        
        
    }

    }
    }//End of session
}
