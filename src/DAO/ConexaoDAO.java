package DAO;


import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
   
    private final String url = "jdbc:postgresql://localhost/funcionario";
    private final String user = "postgres";
    private final String password = "1234";
     
        public Connection conectaDB(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conn;
    }
        
        public static void main(String[] args){
            ConexaoDAO pss = new ConexaoDAO();
            pss.conectaDB();
        }
    
}
