package serviços;

import domínio.Animal;
import domínio.Consulta;
import utilidades.Util;

import static serviços.ServicoAnimal.consultas;
import static utilidades.Util.sc;

public class ServicoConsulta {
    public String processaConsulta(Animal animal){
        sc.nextLine();
        new Util().print("Em processo de consulta veterinária : " + animal.getIdAnimal() + " pertencente ao" +
                "\ncliente " + animal.getCliente().getIdCliente() + " de nome " + animal.getCliente().getNomeCliente());

        System.out.println("Necessidade de exames? \n S/s - Sim \n N/n - Não\n");
        String opcao = sc.nextLine();
        switch (opcao){
            case "s" -> {
                new ServicoExame().descreveExame(animal);
            }
            case "n" -> {

                new ServicoTratamento().defineTratamento(animal, null);
            }
            default -> {
                new Util().print("Opção impossível.\n");
            }
        }
        return opcao;
    }
}
