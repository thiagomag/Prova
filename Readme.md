Prova final do curso inicial de Java U.Code - Let's Code.

1. Crie uma interface chamada CadastroUsuarios para representar o armazenamento contendo o cadastro de usuários. Defina a assinatura dos métodos para adicionar, buscar e remover. Para adicionar é necessário informar um objeto Usuario completo. A busca e a remoção são feitas pelo "login".
2. Crie uma classe CadastroUsuariosArray que implementa a interface anterior. Defina um array de objetos Usuario com capacidade para 10 instâncias. Implemente o método adicionar para que, ao atingir a capacidade máxima atual, seja definido um novo array com o dobro de capacidade.
3. Defina uma classe principal para a aplicação. Inicie o array com algumas instâncias de Usuario. Realize duas chamadas ao método buscar simulando, primeiro uma tentativa de login não encontrado, e na segunda, sucesso no login, ou seja, login encontrado. A aplicação responde "Não autorizado" em caso de falha, e "Seja bem-vindo [nome]" em caso de sucesso.
4. Implemente o método remover na classe CadastroUsuariosArray. Ao remover o objeto do array, tenha o cuidado de não deixar índices vazios. Também verifique os possíveis comportamentos de erro.
5. Crie um subtipo de Usuario chamado Admin. Deve haver exatamente uma instância desse tipo em todo o cadastro (nem mais nem menos - isso deve ser controlado pelos métodos adicionar e remover). Adicione um método listarTodos na interface CadastroUsuarios que recebe como parâmetro um objeto Usuario. Se for o Admin, então liste todos os elementos do cadastro em ordem alfabética de nome. Caso contrário, exiba uma mensagem de erro "Funcionalidade não permitida".