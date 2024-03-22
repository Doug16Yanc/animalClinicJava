package aplicação;

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