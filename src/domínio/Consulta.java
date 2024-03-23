package domínio;

import enums.StatusConsulta;

public class Consulta {
    private Animal animal;
    private Double valor;
    private StatusConsulta statusConsulta;

    public Consulta(Animal animal, Double valor, StatusConsulta statusConsulta){
        this.animal = animal;
        this.valor = valor;
        this.statusConsulta = statusConsulta;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
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
