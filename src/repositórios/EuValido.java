package repositórios;

public interface EuValido {
    default boolean fazLogin(){
        return true;
    }
}
