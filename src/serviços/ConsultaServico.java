package serviços;

import domínio.Animal;
import utilidades.Util;

public class ConsultaServico {
    public void processaConsulta(Animal animal){
        new Util().print("Em processo de consulta veterinária : " + animal.getIdAnimal() + " pertencente ao" +
                "\ncliente " + animal.getCliente().getIdCliente() + " de nome " + animal.getCliente().getNomeCliente());
    }
}
