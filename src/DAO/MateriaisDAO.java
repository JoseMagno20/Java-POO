
package DAO;


import DTO.MateriaisDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MateriaisDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<MateriaisDTO>lista = new ArrayList<>();
    
    public void cadastrarMaterial(MateriaisDTO objmateriaisdto) throws SQLException{
        String sql = "insert into materiais(nome_materiais,descricao_materiais)values(?,?)";
        conn = new ConexaoDAO().conectaDB();
        
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, objmateriaisdto.getNome_materiais());
        pstm.setString(2, objmateriaisdto.getDescricao_materiais());
        pstm.execute();
        pstm.close();
    }
    
     public ArrayList<MateriaisDTO> PesquisarMaterial(){
        String sql = "select * from materiais";
        conn = new ConexaoDAO().conectaDB();

        try {
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery();
           while(rs.next()){
               MateriaisDTO objfuncionariodto = new MateriaisDTO();
               objfuncionariodto.setId_materiais(rs.getInt("id_materiais"));
               objfuncionariodto.setNome_materiais(rs.getString("nome_materiais"));
               objfuncionariodto.setDescricao_materiais(rs.getString("descricao_materiais"));
               
               lista.add(objfuncionariodto);
           }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return lista;
    }
     
      public void AlterarMaterial(MateriaisDTO objmateriaisdto) throws SQLException{
         String sql = "update materiais set nome_materiais = ?, descricao_materiais = ? where id_materiais = ?";
         conn = new ConexaoDAO().conectaDB();
         
         pstm = conn.prepareStatement(sql);
         pstm.setString(1, objmateriaisdto.getNome_materiais());
         pstm.setString(2, objmateriaisdto.getDescricao_materiais());
         pstm.setInt(3,objmateriaisdto.getId_materiais());
         pstm.execute();
         pstm.close();
         
    }
      
       public void ExcluirMaterial(MateriaisDTO objmateriaisdto) throws SQLException{
        String sql = "delete from materiais where id_materiais = ?";
        
        conn = new ConexaoDAO().conectaDB();
        
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1,objmateriaisdto.getId_materiais());
        pstm.execute();
        pstm.close();
       
    }
    
}
