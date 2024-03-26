package utilidades;

import domínio.Consulta;
import domínio.Exame;
import repositórios.EuCalculo;

import static serviços.ServicoExame.exames;

public class Pagamento implements EuCalculo {

    @Override
    public Double calculaPrecoExames(Exame exame) {
        double valor = 0.0;
        for (Exame exame1 : exames){
            valor += exame1.getValorExame();
        }

        return valor;
    }
    @Override
    public Double calculaPrecoTotal(Consulta consulta, Exame exame){
        double valor = 0.0;
        valor += consulta.getValor() + calculaPrecoExames(exame);
        return valor;
    }

}
