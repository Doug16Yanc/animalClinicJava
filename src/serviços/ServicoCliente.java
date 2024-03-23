package serviços;

import domínio.Cliente;
import enums.StatusCliente;
import repositórios.EuValido;
import utilidades.Comprovação;
import utilidades.Util;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static utilidades.Util.sc;

public class ServicoCliente implements EuValido {

    private static List<Cliente> clientes = new ArrayList<>();

    public String questionaCadastro(){
        System.out.println("Já é cadastrado em nossa plataforma ? \n S/s - Sim \n N/n - Não\n");
        String resposta = sc.nextLine();

        switch (resposta){
            case "s" -> {
                fazLogin();
            }
            case "n" -> {
                realizaRegistro();
            }
            default -> {
                new Util().print("Opção impossível.\n");
            }
        }
        return resposta;
    }
    public boolean fazLogin(){
        boolean validou = false;
        new Util().print("Login do cliente.\n");
        do{
            System.out.println("Digite seu identificador : ");
            int id = sc.nextInt();

            Cliente procurado = clientes.stream().filter(cliente -> cliente.getIdCliente() == id)
                    .findFirst().orElse(null);
            sc.nextLine();
            if (procurado != null) {
                System.out.println("Entre com suas credenciais.\n");
                System.out.println("Usuário : ");
                String usuario = sc.nextLine();
                System.out.println("Senha : ");
                String senha = sc.nextLine();

                if (usuario.equals(procurado.getUsuario()) && senha.equals(procurado.getSenha())) {
                    System.out.println("Login realizado com sucesso.\n");
                    interageCliente(procurado);
                    break;
                } else {
                    new Util().print("Credenciais inválidas.\n");
                }
            } else{
                System.out.println("Cliente não encontrado.\n");
            }
        } while(true);
        return validou;
    }
    public int geraId() {
        int entrada = new Random().nextInt(900000) + 100;
        boolean auxiliar = true;

        while (entrada != 1) {
            for (int i = 0; i < clientes.size(); i++) {
                if (entrada == clientes.get(i).getIdCliente()) {
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
    private void realizaRegistro(){
        int id = geraId();
        new Util().print("Registro de cliente.\n");
        System.out.println("Nome : ");
        String nome = sc.nextLine();
        System.out.println("Endereço : ");
        String endereco = sc.nextLine();
        System.out.println("Email : ");
        String email = sc.nextLine();
        System.out.println("Usuário : ");
        String usuario = sc.nextLine();
        System.out.println("Senha : ");
        String senha = sc.nextLine();

        Cliente cliente = new Cliente(id, nome, endereco, email, usuario, senha, StatusCliente.REGISTRADO);

        clientes.add(cliente);

        new Comprovação().comprovaCadastro(cliente);
    }
    private int interageCliente(Cliente cliente) {
        new Util().print("Seja bem-vindo à sua página, " + cliente.getNomeCliente() + ".\n");
        int opcao;
        boolean saiu = false;
        do {
            System.out.println("Selecione uma opção.\n\n");
            System.out.println("DADOS PESSOAIS\n\n" +
                    "           1 - Visualizar dados\n" +
                    "           2 - Alterar dados\n" +
                    "           3 - Remover cadastro\n\n" +
                    "           CUIDADOS COM O PET\n\n" +
                    "           4 - Ir para a página dos pets\n\n" +
                    "           GESTÃO DO SISTEMA\n\n" +
                    "           5 - Sair\n");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> {
                    visualizarDados(cliente);
                }
                case 2 -> {
                    alterarDados(cliente);
                }
                case 3 -> {
                    removerCadastro(cliente);
                }
                case 4 -> {

                }
                case 5 -> {
                    new Util().print("Sua despedida é desconcertante. Até logo!\n");
                    saiu = true;
                }
                default -> {
                    new Util().print("Opção impossível.\n");
                }
            }
            if (saiu){
                break;
            }
        } while (true);
        return opcao;
    }
    private void visualizarDados(Cliente cliente){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
        new Util().print("DADOS PESSOAIS.\n" +
                "       Nome : " + cliente.getNomeCliente() +
                "\n     Identificador : " + cliente.getIdCliente() +
                "\n     Endereço : " + cliente.getEnderecoCliente() +
                "\n     Email : " + cliente.getEmailCliente() +
                "\n     DADOS DA OPERAÇÃO\n\n" +
                "       Código da consulta : " + UUID.randomUUID() +
                "\n     Data : " + formatter);
    }
    private String alterarDados(Cliente cliente){
        new Util().print("Você só pode modificar endereço, email, usuário e senha.\n");
        System.out.println("E/e - Endereço\n" +
                "           C/c - Correio eletrônico(email)\n" +
                "           U/u - Usuário\n" +
                "           S/s - Senha\n");
        String opcao = sc.nextLine();

        switch (opcao.toLowerCase()){
            case "e" -> {
                System.out.println("Novo endereço: ");
                String novoEndereco = sc.nextLine();
                cliente.setEnderecoCliente(novoEndereco);
            }
            case "c" -> {
                System.out.println("Novo email: ");
                String novoEmail = sc.nextLine();
                cliente.setEmailCliente(novoEmail);
            }
            case "u" -> {
                System.out.println("Digite seu usuário atual : ");
                String usuario = sc.nextLine();

                cliente = clientes.stream().filter(valido -> valido.getUsuario().equals(usuario))
                        .findFirst().orElse(null);
                if(cliente != null){
                    System.out.println("Novo usuário : ");
                    String novoUsuario = sc.nextLine();
                    cliente.setUsuario(novoUsuario);
                }
                else{
                    System.out.println("Usuário não reconhecido.\n");
                }

            }
            case "s" -> {
                System.out.println("Digite sua senha atual : ");
                String senha = sc.nextLine();

                cliente = clientes.stream().filter(valido -> valido.getSenha().equals(senha))
                        .findFirst().orElse(null);
                if(cliente != null){
                    System.out.println("Nova senha : ");
                    String novaSenha = sc.nextLine();
                    cliente.setSenha(novaSenha);
                }
                else{
                    System.out.println("Senha não reconhecida.\n");
                }
            }
            default -> {
                new Util().print("Opção impossível.\n");
            }
        }
        return opcao;
    }
    private boolean removerCadastro(Cliente cliente){
        return true;
    }
}
