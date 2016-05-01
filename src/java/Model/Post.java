

package Model;
import Controller.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.objects.Global.getDate;
public class Post {
    protected static String post_id ="post_id";
    protected static String post_title ="post_title";
    protected static String post_desc ="description";
    protected static String post_pic ="picture";
    protected static String post_thumb ="thumb";
    protected static String post_cat ="category";
    protected static String post_created ="created";
    protected static String post_updated ="updated";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public List<PostBean> post(){
        List<PostBean> posts = new ArrayList<PostBean>();
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8888/graviet", "root", "root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from post");
            while(rs.next()){
                posts.add(new PostBean(rs.getInt(post_id),rs.getString(post_title),rs.getString(post_desc),rs.getString(post_pic),rs.getString(post_thumb),rs.getString(post_cat),rs.getDate(post_created),rs.getDate(post_updated)));
            }                        
            
            rs.close();
            rs = null;
            stmt = null;
            conn = null;
        } catch (SQLException e) {
            System.out.println("No" + e.getMessage());
        }

        return posts;
    }
    public List<PostBean> getpost(Integer order){
        List<PostBean> posts = new ArrayList<PostBean>();
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8888/graviet", "root", "root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from post limit "+(order*12)+",12");
            while(rs.next()){
                posts.add(new PostBean(rs.getInt(post_id),rs.getString(post_title),rs.getString(post_desc),rs.getString(post_pic),rs.getString(post_thumb),rs.getString(post_cat),rs.getDate(post_created),rs.getDate(post_updated)));
            }                        
            
            rs.close();
            rs = null;
            stmt = null;
            conn = null;
        } catch (SQLException e) {
            System.out.println("No" + e.getMessage());
        }

        return posts;
    }    
}
