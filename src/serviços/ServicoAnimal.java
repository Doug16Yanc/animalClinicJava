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
    public static List<Animal> consultas = new ArrayList<>();
    public void iniciaPaginaAnimal(Cliente cliente){
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
                removerAnimal(animais);
            }
            case 3 -> {
                listaAnimais();
            }
            case 4 -> {
                visualizarAnimalDados(animais);
            }
            case 5 -> {
                marcaConsulta(animais);
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
        System.out.println("Registro de animal na clínica.\n");
        int idAnimal = geraId();

        sc.nextLine();
        System.out.println("Nome do animal (Campo opcional): ");
        String nome = sc.nextLine();

        System.out.println("Idade: ");
        int idade = sc.nextInt();
        if (idade <= 0) {
            System.out.println("Idade inválida. A idade deve ser um número positivo.");
            return;
        }

        sc.nextLine();
        System.out.println("Espécie (Campo opcional): ");
        String especie = sc.nextLine();

        System.out.println("Sexo (M/m para Macho, F/f para Fêmea): ");
        String sexoInput = sc.nextLine().toUpperCase();
        SexoAnimal sexo;
        switch (sexoInput) {
            case "M":
                sexo = SexoAnimal.MASCULINO;
                break;
            case "F":
                sexo = SexoAnimal.FEMININO;
                break;
            default:
                sexo = SexoAnimal.OUTRO;
                break;
        }

        Animal animal = new Animal(cliente, idAnimal, nome, idade, new Espécie(especie), sexo, StatusAnimal.OBSERVAÇÃO, null);
        animais.add(animal);
        new Comprovação().comprovaRegistroAnimal(animal);
    }

    private void removerAnimal(List<Animal> animal) {
        Animal animalProcurado = procurarAnimal();
        if (animalProcurado != null){
            if (animalProcurado.getStatusAnimal() == StatusAnimal.CURADO || animalProcurado.getStatusAnimal() == StatusAnimal.SAUDÁVEL){
                new Util().print("Cadastro de " + animalProcurado.getIdAnimal() + " realizado com sucesso.\n");
            }
            else{
                new Util().print("O animal " + animalProcurado.getIdAnimal() + " ainda não está em condições apropriadas\n" +
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
                            "\nEspécie : " + animal.getEspecie().getNomeEspecie() +
                            "\nSexo : " + animal.getSexoAnimal() +
                            "\nStatus atual : " + animal.getStatusAnimal());
        }
        return animais;
    }
    private Animal procurarAnimal() {
        System.out.println("Digite o identificador do animal : ");
        int id = sc.nextInt();

        Animal procurado = animais.stream().filter(animal -> animal.getIdAnimal() == id)
                .findFirst().orElse(null);

        if (procurado != null){
            return procurado;
        }
        else{
            return null;
        }
    }
    private void visualizarAnimalDados(List<Animal> animal){
        Animal animalProcurado = procurarAnimal();
        if(animalProcurado != null){
            new Util().print("" +
                    "\nIdentificador : " + animalProcurado.getIdAnimal() +
                    "\nNome : " + animalProcurado.getNomeAnimal() +
                    "\nEspécie : " + animalProcurado.getEspecie().getNomeEspecie() +
                    "\nSexo : " + animalProcurado.getSexoAnimal() +
                    "\nStatus atual : " + animalProcurado.getStatusAnimal());
        }
        else{
            new Util().print("Animal não encontrado.\n");
        }
    }
    private String marcaConsulta(List<Animal> animal){
        UUID codigo = UUID.randomUUID();
        new Util().print("Consultas marcadas como urgentes apresentarão prioridades na lista das chamadas\n" +
                "do profissional veterinário. Ao escolher convencional ou uma opção não existente, a consulta" +
                " será considerada convencional.\n");
        Animal animalProcurado = procurarAnimal();
        if(animalProcurado != null){
            sc.nextLine();
            System.out.println("\nEstado da consulta solicitada? \n C/c - Convencional \n U/u - Urgente \n");
            String opcao = sc.nextLine();
            switch (opcao.toLowerCase()){
                case "c" ->{
                    Consulta consulta = new Consulta(codigo, 70.00, StatusConsulta.CONVENCIONAL, null);
                    animalProcurado.setConsulta(consulta);
                    consultas.add(animalProcurado);
                }
                case "u" -> {
                    Consulta consulta = new Consulta(codigo, 70.00, StatusConsulta.URGENTE, null);
                    animalProcurado.setConsulta(consulta);
                    consultas.add(0, animalProcurado);
                }
                default -> {
                    Consulta consulta = new Consulta(codigo, 70.00, StatusConsulta.CONVENCIONAL, null);
                    animalProcurado.setConsulta(consulta);
                    consultas.add(animalProcurado);
                }
            }
        }
        else {
            new Util().print("Animal não encontrado.\n");
        }

        return String.format("Consulta " + animalProcurado.getConsulta().getCodigo() + " marcada com sucesso.\n");

    }
}
