import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.sql.*;

public class Database_Writer {

    public static void open_Database(String word, String description) {
        String user = "user_name_here";
        String pw = "password_here";
        int synEx = 0;
        //sql table, where to put data
        String tablename = "pgmc";

        description = description.replaceAll("'","''");

        word = word.replaceAll("'","''");

        String esquel = "INSERT INTO " + tablename + " ( wiki_word, wiki_description ) "
                + " VALUES ( '" + word +  "','" + description + "');";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proto?useUnicode=true&characterEncoding=UTF-8&useSSL=false&" +
                    "user=" + user + "&password=" + pw);
            PreparedStatement stmt = conn.prepareStatement(esquel, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            conn.close();
        }
        catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
        catch (SQLException ex)           {System.err.println(ex.getMessage());}
        finally {
        }
    }
}
