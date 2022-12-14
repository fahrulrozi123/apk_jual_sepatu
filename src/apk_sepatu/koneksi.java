package apk_sepatu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class koneksi {
    static final String jdbc_driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/jualsepatu?zeroDateTimeBehavior=convertToNull";
    static final String user = "root";
    static final String pass = "";
    static Connection conn;
    static Statement stat;
    static ResultSet rs;
    
    public static Connection connectDatabase(){
        try{
            Class.forName(jdbc_driver); 
            
        }catch(ClassNotFoundException cnf){
            
        }try{
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null, "Koneksi Database BERHASIL", "SUKSES",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi Database GAGAL","PERHATIAN",JOptionPane.WARNING_MESSAGE);
        }
        return conn;
    }
}
