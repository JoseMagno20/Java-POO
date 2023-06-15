package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO>lista = new ArrayList<>();
    
    public void cadastrarFuncionario(FuncionarioDTO objfuncionariodto) throws SQLException{
        String sql = "insert into funcionario(nome_funcionario,endereco_funcionario,telefone_funcionario)values(?,?,?)";
        conn = new ConexaoDAO().conectaDB();
        
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, objfuncionariodto.getNome_funcionario());
        pstm.setString(2, objfuncionariodto.getEndereco_funcionario());
        pstm.setString(3, objfuncionariodto.getTelefone_funcionario());
        pstm.execute();
        pstm.close();
    }
    
    public ArrayList<FuncionarioDTO> PesquisarFuncionario(){
        String sql = "select * from funcionario";
        conn = new ConexaoDAO().conectaDB();

        try {
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery();
           while(rs.next()){
               FuncionarioDTO objfuncionariodto = new FuncionarioDTO();
               objfuncionariodto.setId_funcionario(rs.getInt("id_funcionario"));
               objfuncionariodto.setNome_funcionario(rs.getString("nome_funcionario"));
               objfuncionariodto.setEndereco_funcionario(rs.getString("endereco_funcionario"));
               objfuncionariodto.setTelefone_funcionario(rs.getString("telefone_funcionario"));
               
               lista.add(objfuncionariodto);
           }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return lista;
    }
    
    public void AlterarFuncionario(FuncionarioDTO objfuncionariodto) throws SQLException{
         String sql = "update funcionario set nome_funcionario = ?, endereco_funcionario = ?, telefone_funcionario = ? where id_funcionario = ?";
         conn = new ConexaoDAO().conectaDB();
         
         pstm = conn.prepareStatement(sql);
         pstm.setString(1, objfuncionariodto.getNome_funcionario());
         pstm.setString(2, objfuncionariodto.getEndereco_funcionario());
         pstm.setString(3, objfuncionariodto.getTelefone_funcionario());
         pstm.setInt(4,objfuncionariodto.getId_funcionario());
         pstm.execute();
         pstm.close();
         
    }
    
    public void ExcluirFuncionario(FuncionarioDTO objfuncionariodto) throws SQLException{
        String sql = "delete from funcionario where id_funcionario = ?";
        
        conn = new ConexaoDAO().conectaDB();
        
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1,objfuncionariodto.getId_funcionario());
        pstm.execute();
        pstm.close();
       
    }
    
}
