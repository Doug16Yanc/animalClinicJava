package domínio;

import enums.StatusCliente;

public class Cliente {
    private int idCliente;
    private String nomeCliente;
    private String enderecoCliente;
    private String emailCliente;
    private String usuario;
    private String senha;
    private StatusCliente statusCliente;

    public Cliente(int idCliente, String nomeCliente, String enderecoCliente, String emailCliente, String usuario, String senha, StatusCliente statusCliente)
    {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.emailCliente = emailCliente;
        this.usuario = usuario;
        this.senha = senha;
        this.statusCliente = statusCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public StatusCliente getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }
}
