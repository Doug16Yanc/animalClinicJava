package domínio;

public class Veterinário {
    private String nomeVet;
    private String enderecoVet;
    private String emailVet;
    private String usuario;
    private String senha;

    public Veterinário(String nomeVet, String enderecoVet, String emailVet, String usuario, String senha){
        this.nomeVet = nomeVet;
        this.enderecoVet = enderecoVet;
        this.emailVet = emailVet;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getNomeVet() {
        return nomeVet;
    }

    public void setNomeVet(String nomeVet) {
        this.nomeVet = nomeVet;
    }

    public String getEnderecoVet() {
        return enderecoVet;
    }

    public void setEnderecoVet(String enderecoVet) {
        this.enderecoVet = enderecoVet;
    }

    public String getEmailVet() {
        return emailVet;
    }

    public void setEmailVet(String emailVet) {
        this.emailVet = emailVet;
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
}
