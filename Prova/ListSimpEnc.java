package ED1.Prova;

import java.util.NoSuchElementException;

public class ListSimpEnc<T> implements IListSimpEnc<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;
    Excecao erro = new Excecao();

    public ListSimpEnc() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public No<T> getInicio() {
        return inicio;
    }

    public void setInicio(No<T> inicio) {
        this.inicio = inicio;
    }

    @Override
    public No<T> getFim() {
        return fim;
    }

    public void setFim(No<T> fim) {
        this.fim = fim;
    }


    @Override
    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public boolean listVazia() {
        return getInicio() == null;
    }

    @Override
    public void limpar() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void addInicio(T elemento) {
        No<T> no = new No<>(elemento);
        if (this.listVazia()) {
            setInicio(no);
            setFim(no);
            setTamanho(getTamanho() + 1);
        } else {
            no.setProximo(getInicio());
            setInicio(no);
            setTamanho(getTamanho() + 1);
        }

    }

    @Override
    public void addFim(T elemento) {
        No<T> no = new No<>(elemento);
        if (this.listVazia()) {
            this.addInicio(elemento);
        } else {
            getFim().setProximo(no);
            setFim(no);
            setTamanho(getTamanho() + 1);
        }


    }

    @Override
    public void addPosicao(int posicao, T elemento) {
        if (posicao <= 0 || posicao > this.getTamanho() + 1) {
            erro.addPosInexistente();
        } else if (posicao == 1) {
            this.addInicio(elemento);
        } else if (posicao == this.getTamanho() + 1) {
            this.addFim(elemento);
        } else {
            No<T> no = new No<>(elemento);
            No<T> novoNo = this.getInicio();
            for (int i = 0; i < posicao - 1; i++) {
                if (i + 1 == posicao - 1) { // se a posicao for uma anterior a que esta sendo buscada
                    no.setProximo(novoNo.getProximo());//o proximo elemento do 'no', sera o que estava na posicao que o 'no' sera inserido
                    novoNo.setProximo(no);// adiciona o 'no' na posicao desejada
                    this.setTamanho(getTamanho() + 1);
                } else {
                    novoNo = novoNo.getProximo(); //'novoNo' é atualizado ate alcancar a posicao anterior que esta sendo buscada
                }
            }

        }


    }

    @Override
    public void adicionarListaRecursivamente(ListSimpEnc<T> listSimpEnc) throws Exception {
        if (listSimpEnc.equals(this)){ // se for passado como parametro a propria lista
            erro.loppInfinito();
        }
        if (listSimpEnc.getTamanho() != 0) {
            this.addFim(listSimpEnc.getInicio().getDado());
            listSimpEnc.removerInicio();
            adicionarListaRecursivamente(listSimpEnc);
        }
    }

    @Override
    public void removerInicio() throws Exception {
        if (this.listVazia()) {
            erro.removerListaVazia();
        } else {
            setInicio(getInicio().getProximo());
            setTamanho(getTamanho() - 1);// ver se n ter erro se for so 1 elemento na lista
        }
    }

    @Override
    public void removerFim() throws Exception {
        if (this.listVazia()) {
            erro.removerListaVazia();
        } else {
            if (getTamanho() == 1) {
                this.limpar();
            } else {
                No<T> novoNo = this.getInicio();
                for (int i = 0; i < this.getTamanho() - 1; i++) {
                    if (i + 1 == getTamanho() - 1) {
                        setFim(novoNo);
                        getFim().setProximo(null);
                        setTamanho(getTamanho() - 1);
                    } else {
                        novoNo = novoNo.getProximo();
                    }
                }
            }
        }

    }

    @Override
    public void removerPosicao(int posicao) throws Exception {
        if (this.listVazia()) {
            erro.removerListaVazia();
        } else if (posicao == 1) {
            this.removerInicio();
        } else if (posicao == this.getTamanho()) {
            this.removerFim();
        } else if (posicao > this.getTamanho()) {
            erro.removerPosInexistente();
        } else {
            No<T> novoNo = this.getInicio();
            for (int i = 0; i < posicao - 1; i++) {
                if (i + 1 == posicao - 1) {
                    novoNo.setProximo(null);
                    this.setFim(novoNo);
                    this.setTamanho(getTamanho() - 1);
                } else {
                    novoNo = novoNo.getProximo();
                }

            }
        }

    }

    @Override
    public String toString() {
        No<T> novoNo = this.getInicio();
        String str ="";
        if (listVazia()){
            str = null;
        }
        for (int i = 0; i < this.getTamanho(); i++) {
            str+= novoNo.getDado() +" ";
            novoNo =  novoNo.getProximo();

        }
        return str;
    }
}
