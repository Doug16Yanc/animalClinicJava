package domínio;

import enums.StatusConsulta;

public class Consulta {
    private Double valor;
    private StatusConsulta statusConsulta;

    public Consulta(Double valor, StatusConsulta statusConsulta){
        this.valor = valor;
        this.statusConsulta = statusConsulta;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }
}
