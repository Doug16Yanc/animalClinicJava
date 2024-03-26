package utilidades;

import domínio.Animal;
import domínio.Cliente;
import domínio.Consulta;
import domínio.Exame;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.UUID;

public class Comprovação {
    public void comprovaCadastro(Cliente cliente){
        new Util().print("Comprovo que o cliente " + cliente.getNomeCliente() + " de identificador igual a " +
                        cliente.getIdCliente() + " realizou cadastro em nossa plataforma.\n");
    }
    public void comprovaRegistroAnimal(Animal animal){
        new Util().print("Comprovo que o cliente " + animal.getCliente().getNomeCliente() + " de identificador igual a " +
                animal.getCliente().getIdCliente() + " realizou cadastro do seu animal " +  animal.getIdAnimal() +
                " em nossa plataforma.\n");
    }
    public void comprovaPagamento(Animal animal, Exame exame){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        new Util().print("COMPROVANTE DE PAGAMENTO.\n" +
                "\n      Identificador do cliente" + animal.getCliente().getIdCliente() +
                "\n      Nome : " + animal.getCliente().getNomeCliente() +
                "\n      Identificador do animal : " + animal.getIdAnimal() +
                "\n      Valor total : " + UtilidadePagamento.determinaValor(animal.getConsulta(), exame) +
                "\n      Código da operação de pagamento : " + UUID.randomUUID() +
                "\n      Data e hora da operação : " + dateTimeFormatter);
    }
}
