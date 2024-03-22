package domínio;

import enums.TipoTratamento;

import javax.swing.*;

public class Tratamento {
    private String descricaoTrat;
    private TipoTratamento tipoTratamento;

    public Tratamento(String descricaoTrat, TipoTratamento tipoTratamento){
        this.descricaoTrat = descricaoTrat;
        this.tipoTratamento = tipoTratamento;
    }

    public String getDescricaoTrat() {
        return descricaoTrat;
    }

    public void setDescricaoTrat(String descricaoTrat) {
        this.descricaoTrat = descricaoTrat;
    }

    public TipoTratamento getTipoTratamento() {
        return tipoTratamento;
    }

    public void setTipoTratamento(TipoTratamento tipoTratamento) {
        this.tipoTratamento = tipoTratamento;
    }
}
