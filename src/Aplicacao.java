public class Aplicacao {

    public static void main(String[] args) {
        new Aplicacao().executar();
    }

    private void executar() {

        CadastroUsuarios usuarioArray = new CadastroUsuariosArray();
        usuarioArray.adicionar(new Usuario("Jose", "jose", "jose1234"));
        usuarioArray.adicionar(new Usuario("Maria", "maria@maria.com.br", "maria1234"));
        usuarioArray.adicionar(new Usuario("Mario", "mario@mario.com.br", "mario1234"));
        usuarioArray.adicionar(new Admin());
        usuarioArray.adicionar(new Usuario("Thiago", "thiago@thiago.com.br", "thiago123"));

        login(usuarioArray, "login");
        login(usuarioArray, "thiago@thiago.com.br");

        usuarioArray.remover("mario@mario.com.br");
        usuarioArray.listarTodos(new Admin());

    }

    private void login(CadastroUsuarios cadastroUsuarios, String login){
        try{
            final var usuario = cadastroUsuarios.getUsuario(login);
            System.out.println("Seja bem vindo, " + usuario.getNome());
        } catch (UsuarioNaoEncontradoException ex){
            System.err.println("Não autorizado");
        }
    }
}
