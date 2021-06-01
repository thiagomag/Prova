import java.util.ArrayList;
import java.util.Arrays;

public class CadastroUsuariosArray implements CadastroUsuarios {

    private Usuario[] usuarios = new Usuario[10];
    private int qtd = 0;

    @Override
    public Usuario adicionar(Usuario usuario) {
        if (usuario instanceof Admin){
            try{
                if(this.buscar("admin") != 0){
                    System.err.println("Já existe Admin cadastrado");
                    return null;
                }
            }catch (UsuarioNaoEncontradoException ex){
                //faz nada
            }
        }
        if (this.usuarios.length == qtd){
            this.aumentarCapacidade();
        }
        return this.usuarios[qtd++] = usuario;
    }

    private void aumentarCapacidade() {
//        1 - fazer uma cópia do conteudo do  array atual
        final var tempUsuarios = this.usuarios;

//        2 - cria um novo array com o dobro do tamanho do anterior
        this.usuarios = new Usuario[usuarios.length * 2];

//        3 - para o conteudo que está na cópia para o array novo
//        for (int i = 0; i < tempUsuarios.length; i++){
//            this.usuarios[i] = tempUsuarios[i];
//        } Esse for é a mesma coisa que escrever o arraycopy abaixo.
//        System.arraycopy(tempUsuarios, 0, this.usuarios, 0, tempUsuarios.length);

        System.arraycopy(tempUsuarios, 0, this.usuarios, 0, this.qtd);
    }

    @Override
    public Usuario getUsuario(String login) { //nesse método é utilizado o indice i achado no método buscar e retorna o usuário do indice i.
        final var indice = this.buscar(login);
        return this.usuarios[indice];
    }

    @Override
    public int buscar(String login) { //esse método encontra a posição i do usuario no array e retorna esse valor
        for (int i = 0; i < this.qtd; i++){
            Usuario usr = this.usuarios[i];
            if (usr.getLogin().equalsIgnoreCase(login)){
                return i;
            }
        }
        throw new UsuarioNaoEncontradoException();
    }

    @Override
    public void remover(String login) {
        if (this.getUsuario(login) instanceof Admin){
            System.err.println("Nào é possível deixar o cadastro sem Admin");
        }

        final var indice = this.buscar(login); //busca o indice do usuário que quer deletar, sabendo se ele existe ou não.
        this.qtd--;
//        for (int i = 0; i < this.qtd; i++){
//            this.usuarios[i] = this.usuarios[i + 1];
//            this.usuarios[i + 1] = null;
//        }
//        System.arraycopy(this.usuarios, indice + 1, this.usuarios, this.qtd - indice, this.qtd); ---> Outras duas maneiras de remover do Array.
        this.usuarios[indice] = this.usuarios[this.qtd]; //copia o usuário final para o indice do usuario deletado.
        this.usuarios[this.qtd] = null; //coloca o último usuário como nuill.
    }

    @Override
    public void listarTodos(Usuario usuario) {
        if (usuario instanceof Admin){
            String[] nomes = new String[this.qtd];
            for (int i = 0; i < this.qtd; i++){
                nomes[i] = this.usuarios[i].getNome();
            }
            Arrays.sort(nomes);
            for (String nome : nomes){
                System.out.println(nome);
            }
        } else {
            throw new NaoAutorizadoException();
        }
    }
}
