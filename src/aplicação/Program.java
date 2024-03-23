package aplicação;

/*Desenvolvido por Douglas Holanda, programa Java que realiza o gerenciamento de
* uma clínica veterinária com as entidades principais Veterinário, Cliente e Animal.
* O projeto segue critérios de arquitetura de sistemas e engenharia de software e é
* baseado numa proposta de diagrama de modelo de linguagem unificada (UML) obtida
* a partir do best-seller nacional "UML 2 : Uma abordagem prática", de Guilleanes
* Guedes, pesquisador de ciência da computação da Universidade Federal do Pampa (UniPampa)*/


import serviços.ServicoCliente;
import serviços.ServicoVet;
import utilidades.Util;
import utilidades.Util.*;

import static utilidades.Util.sc;

public class Program {
    public static void main(String[] args) {
        new Util().print("Seja bem-vindo(a) ao nosso sistema!\n");
        new Program().fazPrimeiraInteracao();
    }
    public String fazPrimeiraInteracao() {
        String opcao;
        do {
            System.out.println("Quem é você na plataforma?\n" +
                    "           V/v - Veterinário\n" +
                    "           C/c - Cliente\n" +
                    "           S/s - Sair do sistema");
            opcao = sc.nextLine();

            switch (opcao.toLowerCase()) {
                case "v" -> {
                    new ServicoVet().fazLogin();
                }
                case "c" -> {
                    new ServicoCliente().questionaCadastro();
                }
                case "s" -> {
                    new Util().print("Sua despedida é extremamente dolorosa, espero te ver logo!\n");
                    System.exit(0);
                }
                default -> {
                    new Util().print("Opção impossível.\n");
                }
            }
        } while (true);

    }
}