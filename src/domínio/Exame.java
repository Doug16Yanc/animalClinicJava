package domínio;

public class Exame {
    private String descricaoExame;
    private Double valorExame;

    public Exame(String descricaoExame, Double valorExame) {
        this.descricaoExame = descricaoExame;
        this.valorExame = valorExame;
    }

    public String getDescricaoExame() {
        return descricaoExame;
    }

    public void setDescricaoExame(String descricaoExame) {
        this.descricaoExame = descricaoExame;
    }

    public Double getValorExame() {
        return valorExame;
    }

    public void setValorExame(Double valorExame) {
        this.valorExame = valorExame;
    }
}
