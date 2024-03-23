package serviços;

import domínio.Veterinário;
import repositórios.EuValido;
import utilidades.Util;

import static utilidades.Util.sc;

public class ServicoVet implements EuValido {
    public boolean fazLogin(){
        Veterinário veterinário = new Veterinário("Douglas Holanda", "Brasil", "doug@gmail.com", "d", "1609");
        int chances = 3;
        boolean validou = false;
        new Util().print("Faça login com suas credenciais.\n");

        do{
            System.out.println("Usuário : ");
            String usuario = sc.nextLine();
            System.out.println("Senha : ");
            String senha = sc.nextLine();

            if (usuario.equals(veterinário.getUsuario()) && senha.equals(veterinário.getSenha())){
                System.out.println("Login feito com sucesso.\n");
                interageVeterinario(veterinário);
                validou = true;
            }
            else{
                System.out.println("Credenciais inválidas.\n");
                chances--;
            }

            if (chances == 0){
                break;
            }

        } while(chances > 0);

        return validou;
    }
    private int interageVeterinario(Veterinário veterinário) {
        new Util().print("Seja bem-vindo(a), caríssimo(a) " + veterinário.getNomeVet());
        int opcao;
        boolean saiu = false;
        do {
            System.out.println("Selecione uma opção:\n" +
                    "           1 - Realizar consulta.\n" +
                    "           2 - Listar consultas.\n" +
                    "           3 - Sair do sistema.\n");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {
                    new Util().print("Até a próxima!\n");
                    saiu = true;
                    sc.nextLine();
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
    private int realizarConsultas(){

        return 1;
    }
}
