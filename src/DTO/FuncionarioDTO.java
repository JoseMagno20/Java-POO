
package DTO;


public class FuncionarioDTO {
    
    private String nome_funcionario;
    private String endereco_funcionario;
    private int id_funcionario;
    private String telefone_funcionario;

    public String getTelefone_funcionario() {
        return telefone_funcionario;
    }

    public void setTelefone_funcionario(String telefone_funcionario) {
        this.telefone_funcionario = telefone_funcionario;
    }

   

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getEndereco_funcionario() {
        return endereco_funcionario;
    }

    public void setEndereco_funcionario(String endereco_funcionario) {
        this.endereco_funcionario = endereco_funcionario;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

   
    
    
}
