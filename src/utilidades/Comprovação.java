package utilidades;

import domínio.Cliente;

public class Comprovação {
    public void comprovaCadastro(Cliente cliente){
        new Util().print("Comprovo que o cliente " + cliente.getNomeCliente() + " de identificador igual a " +
                        cliente.getIdCliente() + " realizou cadastro em nossa plataforma.\n");
    }
}
