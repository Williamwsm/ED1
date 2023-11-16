package ED1.Vetor;
import  java.util.Iterator;

public interface IVetor <T>{

    //Adiciona o elemento na ultima posição disponivel
    public  void adicionar(T elemento);

    //adicionar na posicao indicada pelo usuario
    //lanca excecao quando foi uma posicao invalida
    public void adicionar(int posicao, T elemento) throws IndexOutOfBoundsException ;

    //adicionar o elemento na primeira posicao
    public  void adcionarIncio(T elemento);

    //remover o elemento na posicao indicada pelo usuario
    //lancar excecao quando for posicao invalida
    public  void remover(int posicao) throws  IndexOutOfBoundsException;

    //buscar o elemento e remove-lo
    public  void removerElemento(T elemento);

    //remover o primeiro elemento do vetor
    public void removerInicio();

    //remover o ultimo elemento do vetor
    public void removerFim();

    //retorna a quantidade de elementos adicionados no vetor
    public  int tamanho();

    //retira todos os elementos do  vetor (restata o vetor)
    public  void limpar();

    //busca o elemento
    public  boolean contem(T elemento);

    public boolean estaVazia();

    //Retorna os elementos entre colchetes e entre vírgulas
    //Por exemplo, se forem adicionados os elementos 1, 2 e 3
    //o toString devolve a string [1,2,3]
    public String toString();

    //retorna o iterator
    public Iterator<T> iterator();

}
