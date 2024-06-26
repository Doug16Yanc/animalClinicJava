package domínio;

import enums.StatusConsulta;

import java.util.UUID;

public class Consulta {

    private UUID codigo;
    private Double valor;
    private StatusConsulta statusConsulta;
    private Tratamento tratamento;


    public Consulta(UUID codigo, Double valor, StatusConsulta statusConsulta, Tratamento tratamento){
        this.codigo = codigo;
        this.valor = valor;
        this.statusConsulta = statusConsulta;
        this.tratamento = tratamento;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
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

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }
}
