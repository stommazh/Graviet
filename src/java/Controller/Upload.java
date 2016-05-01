

package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import Controller.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
@WebServlet(name="Upload", urlPatterns={"/Upload"})
@MultipartConfig
public class Upload extends HttpServlet {



    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String title = request.getParameter("title"); // Retrieves <input type="text" name="description">
        String desc = request.getParameter("desc");
        String picture = request.getParameter("picture");
        String thumb = request.getParameter("thumb");
        String cat = request.getParameter("cat");
        
        try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:8888/graviet","root","root");
         PreparedStatement ps =con.prepareStatement
                             ("insert into post (post_title,description, picture, thumb, category, created, updated) values (?,?,?,?,?,?,?)");
         ps.setString(1, title);
         ps.setString(2, desc);
         ps.setString(3, picture);
         ps.setString(4, thumb);
         ps.setString(5, cat);
         ps.setString(6,null);
         ps.setString(7, null);
         ps.execute();
         ResultSet rs =ps.executeQuery();
         con.close();
      }catch(Exception e)
      {
          e.printStackTrace();
      }
    } 
    
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
         String title = request.getParameter("title"); // Retrieves <input type="text" name="description">
        String desc = request.getParameter("desc");
        String picture = request.getParameter("picture");
        String thumb = request.getParameter("thumb");
        String cat = request.getParameter("cat");
        
        try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:8888/graviet","root","root");
         PreparedStatement ps =con.prepareStatement
                             ("insert into post (post_title,description, picture, thumb, category, created, updated) values (?,?,?,?,?,?,?)");
         ps.setString(1, title);
         ps.setString(2, desc);
         ps.setString(3, picture);
         ps.setString(4, thumb);
         ps.setString(5, cat);
         ps.setString(6,null);
         ps.setString(7, null);
         ps.execute();
         ResultSet rs =ps.executeQuery();
         con.close();
      }catch(Exception e)
      {
          e.printStackTrace();
      }
//        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
//        String fileName = filePart.getSubmittedFileName();
//        InputStream fileContent = filePart.getInputStream();
//                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
////                rs.sendRedirect(request, response);
    response.sendRedirect("add.jsp");
    }

  
}
