package domínio;

import enums.SexoAnimal;
import enums.StatusAnimal;

import java.lang.ref.Cleaner;

public class Animal {
    private Cliente cliente;
    private int idAnimal;
    private String nomeAnimal;
    private int idadeAnimal;
    private Espécie especie;
    private SexoAnimal sexoAnimal;
    private StatusAnimal statusAnimal;
    private Consulta consulta;

    public Animal(Cliente cliente, int idAnimal, String nomeAnimal, int idadeAnimal, Espécie especie, SexoAnimal sexoAnimal, StatusAnimal statusAnimal, Consulta consulta){
        this.cliente = cliente;
        this.idAnimal = idAnimal;
        this.nomeAnimal = nomeAnimal;
        this.sexoAnimal = sexoAnimal;
        this.especie = especie;
        this.statusAnimal = statusAnimal;
        this.consulta = consulta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public int getIdadeAnimal() {
        return idadeAnimal;
    }

    public void setIdadeAnimal(int idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public SexoAnimal getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(SexoAnimal sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public Espécie getEspecie() {
        return especie;
    }

    public void setEspecie(Espécie especie) {
        this.especie = especie;
    }

    public StatusAnimal getStatusAnimal() {
        return statusAnimal;
    }

    public void setStatusAnimal(StatusAnimal statusAnimal) {
        this.statusAnimal = statusAnimal;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
