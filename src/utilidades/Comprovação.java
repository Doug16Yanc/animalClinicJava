package utilidades;

import domínio.Animal;
import domínio.Cliente;

public class Comprovação {
    public void comprovaCadastro(Cliente cliente){
        new Util().print("Comprovo que o cliente " + cliente.getNomeCliente() + " de identificador igual a " +
                        cliente.getIdCliente() + " realizou cadastro em nossa plataforma.\n");
    }
    public void comprovaRegistroAnimal(Animal animal){
        new Util().print("Comprovo que o cliente " + animal.getCliente().getNomeCliente() + " de identificador igual a " +
                animal.getCliente().getIdCliente() + " realizou cadastro do seu animal " +  animal.getIdAnimal() +
                "em nossa plataforma.\n");
    }
}
