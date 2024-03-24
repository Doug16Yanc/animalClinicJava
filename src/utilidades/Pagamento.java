package utilidades;

import domínio.Consulta;
import domínio.Exame;
import repositórios.EuCalculo;
import repositórios.EuPago;

public class Pagamento implements EuPago, EuCalculo {

    @Override
    public Double calculaPrecoExames(Exame exame) {
        double valor = 0.0;
        valor += exame.getValorExame();
        return valor;
    }
    @Override
    public Double calculaPrecoTotal(Consulta consulta, Exame exame){
        double valor = 0.0;
        valor += consulta.getValor() + calculaPrecoExames(exame);
        return 0.0;
    }
    @Override
    public Double realizaPagamento() {

        return 0.0;
    }

}
