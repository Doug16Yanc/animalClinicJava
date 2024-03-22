package domínio;

import enums.SexoAnimal;
import enums.StatusAnimal;

import java.lang.ref.Cleaner;

public class Animal {
    private Cliente cliente;
    private int idAnimal;
    private String nomeAnimal;
    private int idadeAnimal;

    private SexoAnimal sexoAnimal;
    private Espécie especie;

    private StatusAnimal statusAnimal;

    public Animal(Cliente cliente, int idAnimal, String nomeAnimal, int idadeAnimal, SexoAnimal sexoAnimal, Espécie especie, StatusAnimal statusAnimal){
        this.cliente = cliente;
        this.idAnimal = idAnimal;
        this.nomeAnimal = nomeAnimal;
        this.sexoAnimal = sexoAnimal;
        this.especie = especie;
        this.statusAnimal = statusAnimal;
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
}
