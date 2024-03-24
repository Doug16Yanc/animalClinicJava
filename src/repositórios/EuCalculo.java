package repositórios;

import domínio.Consulta;
import domínio.Exame;

public interface EuCalculo {
    Double calculaPrecoExames(Exame exame);
    Double calculaPrecoTotal(Consulta consulta, Exame exame);
}
