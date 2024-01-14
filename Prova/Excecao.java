package ED1.Prova;

public class Excecao {
    public Exception addPosInexistente() throws IndexOutOfBoundsException{
        throw new IndexOutOfBoundsException("POSIÇÃO INEXISTENTE, NÃO FOI POSSIVEL ADICIONAR A LISTA");
    }
    public Exception removerPosInexistente() throws IndexOutOfBoundsException{
        throw new IndexOutOfBoundsException("POSIÇÃO INEXISTENTE, NÃO FOI POSSIVEL REALIZAR A REMOÇÃO");
    }
    public Exception removerListaVazia() throws Exception {
        throw new Exception("A LISTA ESTAR VAZIA, NÃO É POSSIVEL REMOVER NENHUM ITEM");
    }

    public Exception loppInfinito() throws Exception {
       throw new Exception("NÃO É POSSIVEL PASSAR A PROPRIA LISTA COMO PARAMETRO");
    }

}
