
package DAO;

import DTO.TrabalhosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TrabalhosDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<TrabalhosDTO>lista = new ArrayList<>();
   
    public void cadastrarTrabalhos(TrabalhosDTO objtrabalhodto) throws SQLException{
        String sql = "insert into trabalhos(contratante_trabalhos,telefone_trabalho,endereco_trabalho,descricao_trabalho)values(?,?,?,?)";
        conn = new ConexaoDAO().conectaDB();
        
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, objtrabalhodto.getContratante_trabalhos());
        pstm.setString(2, objtrabalhodto.getTelefone_trabalhos());
        pstm.setString(3, objtrabalhodto.getEndereco_trabalhos());
        pstm.setString(4, objtrabalhodto.getDescricao_trabalhos());
        pstm.execute();
        pstm.close();
    }
    
    
 public ArrayList<TrabalhosDTO> PesquisarTrabalhos(){
        String sql = "select * from trabalhos";
        conn = new ConexaoDAO().conectaDB();

        try {
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery();
           while(rs.next()){
               TrabalhosDTO objtrabalhosdto = new TrabalhosDTO();
               objtrabalhosdto.setId_trabalhos(rs.getInt("id_trabalhos"));
               objtrabalhosdto.setContratante_trabalhos(rs.getString("contratante_trabalhos"));
               objtrabalhosdto.setTelefone_trabalhos(rs.getString("telefone_trabalho"));
               objtrabalhosdto.setEndereco_trabalhos(rs.getString("endereco_trabalho"));
               objtrabalhosdto.setDescricao_trabalhos(rs.getString("descricao_trabalho"));
               
               lista.add(objtrabalhosdto);
           }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return lista;
    }
 
 public void AlterarTrabalho(TrabalhosDTO objtrabalhosdto) throws SQLException{
         String sql = "update trabalhos set contratante_trabalhos = ?, telefone_trabalho = ?, endereco_trabalho = ?, descricao_trabalho = ? where id_trabalhos = ?";
         conn = new ConexaoDAO().conectaDB();
         
         pstm = conn.prepareStatement(sql);
         pstm.setString(1, objtrabalhosdto.getContratante_trabalhos());
         pstm.setString(2, objtrabalhosdto.getTelefone_trabalhos());
         pstm.setString(3, objtrabalhosdto.getEndereco_trabalhos());
         pstm.setString(4, objtrabalhosdto.getDescricao_trabalhos());
         pstm.setInt(5, objtrabalhosdto.getId_trabalhos());
         pstm.execute();
         pstm.close();
         
    }
    
public void ExcluirTrabalhos(TrabalhosDTO objtrabalhosdto) throws SQLException{
         
      String sql = "delete from trabalhos where id_trabalhos = ?";
        
        conn = new ConexaoDAO().conectaDB();
         pstm = conn.prepareStatement(sql);
        pstm.setInt(1,objtrabalhosdto.getId_trabalhos());
        pstm.execute();
        pstm.close();
       
    }
}
