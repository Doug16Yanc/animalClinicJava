package aplicação;

/*Desenvolvido por Douglas Holanda, programa Java que realiza o gerenciamento de
* uma clínica veterinária com as entidades principais Veterinário, Cliente e Animal.
* O projeto segue critérios de arquitetura de sistemas e engenharia de software e é
* baseado numa proposta de diagrama de modelo de linguagem unificada (UML) obtida
* a partir do best-seller nacional "UML 2 : Uma abordagem prática", de Guilleanes
* Guedes, professor de ciência da computação da Universidade Federal do Pampa (UniPampa)*/


import utilidades.Util;
import utilidades.Util.*;

import static utilidades.Util.sc;

public class Program {
    public static void main(String[] args) {
        new Util().print("Seja bem-vindo(a) ao nosso sistema!\n");
    }
    private String fazPrimeiraInteracao(){
        System.out.println("Quem é você na plataforma?\n" +
                "           V/v - Veterinário\n" +
                "           C/c - Cliente\n" +
                "           S/s - Sair do sistema");
        String opcao = sc.nextLine();

        switch (opcao.toLowerCase()){
            case "v" -> {

            }
            case "c" -> {

            }
            case "s" -> {
                new Util().print("Sua despedida é extremamente dolorosa, espero te ver logo!\n");
            }
            default -> {
                new Util().print("Opção impossível.\n");
            }
        }

        return opcao;
    }
}