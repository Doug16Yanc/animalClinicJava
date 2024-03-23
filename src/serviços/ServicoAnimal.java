package serviços;

import domínio.Cliente;
import utilidades.Util;

import static utilidades.Util.sc;

public class ServicoAnimal {
    public void iniciaPaginaAnimal(Cliente cliente){
        new Util().print("Página do pet.\n");
        System.out.println("O que desejas?\n");
        System.out.println("1 - Registrar animal.\n" +
                "           2 - Remover animal.\n" +
                "           3 - Listar animais cadastrados.\n" +
                "           4 - Ver situação de algum em específico.\n");
        int opcao = sc.nextInt();

        switch (opcao){
            case 1 -> {

            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            default -> {
                new Util().print("Opção impossível.\n");
            }
        }
    }
}
