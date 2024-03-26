package serviços;

import domínio.Animal;
import domínio.Consulta;
import domínio.Exame;
import domínio.Tratamento;
import enums.StatusAnimal;
import enums.TipoTratamento;
import utilidades.Pagamento;
import utilidades.Util;
import utilidades.UtilidadePagamento;

import static utilidades.Util.sc;

public class ServicoTratamento {
    public void defineTratamento(Animal animal, Exame exame){
        sc.nextLine();
        defineEstadoAnimal(animal);
        System.out.println("Escreva uma descrição do tratamento pós diagnóstico:");
        String descricao = sc.nextLine();
        System.out.println("Defina a natureza do tratamento:\n C/c - Clínico \n D/d - Domiciliar\n");
        String natureza = sc.nextLine();
        switch (natureza){
            case "c" -> {
                Tratamento tratamento = new Tratamento(descricao, TipoTratamento.CLÍNICO);
                animal.getConsulta().setTratamento(tratamento);
            }
            case "d" -> {
                Tratamento tratamento = new Tratamento(descricao, TipoTratamento.DOMICILIAR);
                animal.getConsulta().setTratamento(tratamento);

            }
            default -> {
                new Util().print("Opção impossível.\n");
            }
        }
        new UtilidadePagamento().acertaContas(animal, exame);
    }
    private String defineEstadoAnimal(Animal animal){
        System.out.println("Como se encontra o animal?\n " +
                "           E/e - Estável\n" +
                "           G/g - Grave\n" +
                "           C/c - Curado\n" +
                "           O/o - Observação\n" +
                "           S/s - Saudável\n");
        String opcao = sc.nextLine();
        switch (opcao.toLowerCase()){
            case "e" -> {
                animal.setStatusAnimal(StatusAnimal.ESTÁVEL);
            }
            case "g" -> {
                animal.setStatusAnimal(StatusAnimal.SÉRIO);
            }
            case "c" -> {
                animal.setStatusAnimal(StatusAnimal.CURADO);
            }
            case "o" -> {
                animal.setStatusAnimal(StatusAnimal.OBSERVAÇÃO);
            }
            case "s" -> {
                animal.setStatusAnimal(StatusAnimal.SAUDÁVEL);
            }
            default -> {
                new Util().print("Opção impossível.\n");
            }
        }
        return opcao;
    }
}
