package utilidades;

import domínio.Animal;
import domínio.Consulta;
import domínio.Exame;

import static utilidades.Util.sc;

public class UtilidadePagamento {
    public static Double determinaValor(Consulta consulta, Exame exame){
        double valorTotal = new Pagamento().calculaPrecoTotal(consulta, exame) ;
        new Util().print("Definição dos valores:\n");
        System.out.println("Valor da consulta : " + consulta.getValor());
        System.out.println("Valor dos exames : " + new Pagamento().calculaPrecoExames(exame));
        System.out.println("Valor total : " + valorTotal);
        return valorTotal;
    }
    public int acertaContas(Animal animal, Exame exame){
        determinaValor(animal.getConsulta(), exame);
        System.out.println("\n Escolha uma opçao de pagamento.\n" +
                "           1 - Dinheiro\n" +
                "           2 - Cartão\n" +
                "           3 - Pix\n");
        int opcao = sc.nextInt();
        switch (opcao){
            case 1 -> {
                determinaDinheiro(animal.getConsulta(), exame);
            }
            case 2 -> {
                determinaCartao(animal.getConsulta(), exame);
            }
            case 3 -> {
                validaPix(animal.getConsulta(), exame);
            }
            default -> {
                new Util().print("Opção impossível.\n");
            }
        }
        new Comprovação().comprovaPagamento(animal, exame);
        return opcao;
    }
    private double determinaDinheiro(Consulta consulta, Exame exame){
        double troco = 0.0;
        System.out.println("Digite a quantidade de dinheiro do cliente: ");
        double valor = sc.nextDouble();

        if (valor == determinaValor(consulta, exame)){
            new Util().print("Pagamento de R$ " + valor + " realizado com sucesso.\n");
        }
        else if (valor < determinaValor(consulta, exame)){
            new Util().print("Valor insuficiente.\n");
        }
        else{
            troco = valor - determinaValor(consulta, exame);
            new Util().print("Valor com troco igual a R$ " + troco);
        }
        return valor;
    }
    private String determinaCartao(Consulta consulta, Exame exame){
        System.out.println("Digite uma opção de pagamento.\n C/c - Crédito\n D/d - Débito\n");
        String opcao = sc.nextLine();
        switch (opcao){
            case "c" -> {
                new Util().print("Pagamento de R$ " + determinaValor(consulta, exame) + " realizado no\n" +
                        "       crédito com sucesso.\n");
            }
            case "d" -> {
                new Util().print("Pagamento de R$ " + determinaValor(consulta, exame) + " realizado no\n" +
                        "       débito com sucesso.\n");
            }
            default -> {
                new Util().print("Opção impossível.\n");
            }
        }
        return opcao;
    }
    private boolean validaPix(Consulta consulta, Exame exame){
        new Util().print("Pagamento de R$ " + determinaValor(consulta, exame) + " realizado com sucesso.\n");
        return true;
    }
}
