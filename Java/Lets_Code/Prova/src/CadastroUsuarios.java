public interface CadastroUsuarios {

    Usuario adicionar(Usuario usuario);
    int buscar(String login);
    void remover(String login);
    void listarTodos(Usuario usuario);
    Usuario getUsuario(String login);
}
