package serviços;

import domínio.Animal;
import domínio.Cliente;
import domínio.Consulta;
import domínio.Espécie;
import enums.SexoAnimal;
import enums.StatusAnimal;
import enums.StatusConsulta;
import utilidades.Comprovação;
import utilidades.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static utilidades.Util.sc;

public class ServicoAnimal {
    private static List<Animal> animais = new ArrayList<>();
    public static List<Consulta> consultas = new ArrayList<>();
    public void iniciaPaginaAnimal(Cliente cliente){
        Animal animal = null;
        new Util().print("Página do pet.\n");
        System.out.println("O que desejas?\n");
        System.out.println("\n" +
                "           1 - Registrar animal.\n" +
                "           2 - Remover animal.\n" +
                "           3 - Listar animais cadastrados.\n" +
                "           4 - Ver situação de algum em específico.\n" +
                "           5 - Marcar consulta.\n");
        int opcao = sc.nextInt();

        switch (opcao){
            case 1 -> {
                registraAnimal(cliente);
            }
            case 2 -> {
                removerAnimal(animal);
            }
            case 3 -> {
                listaAnimais();
            }
            case 4 -> {
                visualizarAnimalDados(animal);
            }
            case 5 -> {
                marcaConsulta(animal);
            }
            default -> {
                new Util().print("Opção impossível.\n");
            }
        }
    }
    public int geraId() {
        int entrada = new Random().nextInt(900000) + 100;
        boolean auxiliar = true;

        while (entrada != 1) {
            for (int i = 0; i < animais.size(); i++) {
                if (entrada == animais.get(i).getIdAnimal()) {
                    auxiliar = false;
                    break;
                }
            }

            if (auxiliar) {
                return entrada;
            } else {
                entrada = new Random().nextInt(900000) + 100;
                auxiliar = true;
            }
        }

        return entrada;
    }
    private void registraAnimal(Cliente cliente) {
        Animal animal = null;
        new Util().print("Registro de animal na clínica.\n");
        int idAnimal = geraId();
        sc.nextLine();
        System.out.println("Nome do animal (Campo opcional) : ");
        String nome = sc.nextLine();
        System.out.println("Idade : ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("Espécie (Campo opcional) : ");
        String especie = sc.nextLine();
        System.out.println("Sexo : \n M/m - Macho \n F/f - Fêmea\n");
        String sexo = sc.nextLine();
        switch (sexo.toLowerCase()){
            case "m" -> {
                animal = new Animal(cliente, idAnimal, nome, idade, new Espécie(especie), SexoAnimal.MASCULINO, StatusAnimal.OBSERVAÇÃO);
            }
            case "f" ->  {
                animal = new Animal(cliente, idAnimal, nome, idade, new Espécie(especie), SexoAnimal.FEMININO, StatusAnimal.OBSERVAÇÃO);
            }
            default -> {
                animal = new Animal(cliente, idAnimal, nome, idade, new Espécie(especie), SexoAnimal.OUTRO, StatusAnimal.OBSERVAÇÃO);
            }
        }
        animais.add(animal);
        new Comprovação().comprovaRegistroAnimal(animal);
    }
    private void removerAnimal(Animal animal) {
        if (procurarAnimal() == true){
            if (animal.getStatusAnimal() == StatusAnimal.CURADO || animal.getStatusAnimal() == StatusAnimal.SAUDÁVEL){
                new Util().print("Cadastro de " + animal.getIdAnimal() + " realizado com sucesso.\n");
            }
            else{
                new Util().print("O animal " + animal.getIdAnimal() + " ainda não está em condições apropriadas\n" +
                        "para você realizar a remoção dele de nossa plataforma.\n");
            }
        }
        else {
            new Util().print("Animal não encontrado.\n");
        }
    }
    private List<Animal> listaAnimais(){
        for (Animal animal : animais){
            new Util().print("\nIdentificador : " + animal.getIdAnimal() +
                            "\nNome : " + animal.getNomeAnimal() +
                            "\nEspécie : " + animal.getEspecie() +
                            "\nSexo : " + animal.getSexoAnimal() +
                            "\nStatus atual : " + animal.getStatusAnimal());
        }
        return animais;
    }
    private boolean procurarAnimal() {
        System.out.println("Digite o identificador do animal : ");
        int id = sc.nextInt();

        Animal procurado = animais.stream().filter(cliente -> cliente.getIdAnimal() == id)
                .findFirst().orElse(null);

        if (procurado != null){
            return true;
        }
        else{
            return false;
        }
    }
    private void visualizarAnimalDados(Animal animal){
        if(procurarAnimal() == true){
            new Util().print("" +
                    "\nIdentificador : " + animal.getIdAnimal() +
                    "\nNome : " + animal.getNomeAnimal() +
                    "\nEspécie : " + animal.getEspecie() +
                    "\nSexo : " + animal.getSexoAnimal() +
                    "\nStatus atual : " + animal.getStatusAnimal());
        }
        else{
            new Util().print("Animal não encontrado.\n");
        }
    }
    private String marcaConsulta(Animal animal){
        Consulta consulta = null;
        UUID codigo = UUID.randomUUID();
        new Util().print("Consultas marcadas como urgentes apresentarão prioridades na lista das chamadas\n" +
                "do profissional veterinário. Ao escolher convencional ou uma opção não existente, a consulta" +
                " será considerada convencional.\n");
        if(procurarAnimal() == true){
            sc.nextLine();
            System.out.println("\nEstado da consulta solicitada? \n C/c - Convencional \n U/u - Urgente \n");
            String opcao = sc.nextLine();
            switch (opcao.toLowerCase()){
                case "c" ->{
                    consulta = new Consulta(codigo, animal, 70.00, StatusConsulta.CONVENCIONAL, null);
                    consultas.add(consulta);
                }
                case "u" -> {
                    consulta = new Consulta(codigo, animal, 70.00, StatusConsulta.URGENTE, null);
                    consultas.add(0, consulta);
                }
                default -> {
                    consulta = new Consulta(codigo, animal, 70.00, StatusConsulta.CONVENCIONAL, null);
                    consultas.add(consulta);
                }
            }
        }
        else {
            new Util().print("Animal não encontrado.\n");
        }

        return String.format("Consulta " + consulta.getCodigo() + " marcada com sucesso.\n");

    }
}
