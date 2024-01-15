package ED1.Prova;

public interface IListSimpEnc<T> {
    public No<T> getInicio();

    public No<T> getFim();

    public void limpar();

    public int getTamanho();

    public boolean listVazia();

    public void addInicio(T elemento);

    public void addFim(T elemento);

    public void addPosicao(int posicao, T elemento);

    public void removerInicio() throws Exception;

    public void removerFim() throws Exception;

    public void removerPosicao(int posicao) throws Exception;
    public  void adicionarListaRecursivamente(ListSimpEnc<T> listSimpEnc) throws Exception;
    public String toString();


}
