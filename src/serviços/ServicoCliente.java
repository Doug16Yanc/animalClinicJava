package serviços;

import domínio.Cliente;
import enums.StatusCliente;
import repositórios.EuValido;
import utilidades.Comprovação;
import utilidades.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

                if (usuario.equals(procurado.getUsuario()) && usuario.equals(procurado.getSenha())) {
                    System.out.println("Login realizado com sucesso.\n");
                    validou = true;
                } else {

                }
            } else{
                System.out.println("Cliente não encontrado.\n");
            }
        } while(true);
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

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {
                    new Util().print("Sua despedida é desconcertante. Até logo!\n");
                }
                default -> {
                    new Util().print("Opção impossível.\n");
                }
            }
            if (opcao == 5){
                saiu = true;
                break;
            }
        } while (true);
        return opcao;
    }
}
