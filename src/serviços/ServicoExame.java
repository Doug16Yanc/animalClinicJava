package serviços;

import domínio.Consulta;
import domínio.Exame;

import java.util.ArrayList;
import java.util.List;

import static serviços.ServicoAnimal.consultas;
import static utilidades.Util.sc;

public class ServicoExame {
    public void descreveExame(Consulta consulta) {
        List<Exame> exames = new ArrayList<>();

        System.out.println("Quantidade de exames pós prognóstico: ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Descreva uma descrição sobre o exame:");
            String descricao = sc.nextLine();
            System.out.println("Valor do exame:");
            double valor = sc.nextDouble();
            Exame exame = new Exame(descricao, valor);
            exame.setDescricaoExame(descricao);
            exame.setValorExame(valor);
        }
        new ServicoTratamento().defineTratamento(consulta);
    }
}
