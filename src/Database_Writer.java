import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.sql.*;

public class Database_Writer {

    public static void open_Database(String word, String description) {
        String user = "root";
        String pw = "password";
        int synEx = 0;
        String tablename = "pgmc";
        description = description.replaceAll("'","''");

        word = word.replaceAll("'","''");
//        System.out.println(description);

        String esquel = "INSERT INTO " + tablename + " ( wiki_word, wiki_description ) "
                + " VALUES ( '" + word +  "','" + description + "');";
//CREATE DATABASE proto CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
//CREATE TABLE wiki_db_29_12 (wiki_word VARCHAR(150), wiki_description TEXT);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto?useUnicode=true&characterEncoding=UTF-8&useSSL=false&" +
                    "user=" + user + "&password=" + pw);
            //ResultSet rs = null;

            PreparedStatement stmt = conn.prepareStatement(esquel, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            conn.close();
        }
        catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
       // catch (IllegalAccessException ex) {System.err.println(ex.getMessage());}
        //catch (InstantiationException ex) {System.err.println(ex.getMessage());}
        //catch (MySQLSyntaxErrorException e) {
          //  System.out.println("SyntaxException: " + synEx++);
        //}
        catch (SQLException ex)           {System.err.println(ex.getMessage());}
        finally {

        }
    }

}
