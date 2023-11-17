package ED1.Encadeada;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ListaSimpEnc<T> implements IListaSimpEnc<T> {

    private NoSimpEnc<T> inicio;
    private NoSimpEnc<T> fim;
    private int contElementos;


    @Override
    public NoSimpEnc getInicio() {
        return inicio;
    }

    @Override
    public NoSimpEnc getFim() {
        return fim;
    }

    @Override
    public void clear() {
        inicio = fim = null;
        contElementos=0;
    }

    @Override
    public int size() {
        return this.contElementos;
    }

    @Override
    public boolean estaVazia() {
        if (contElementos==0){
            return true;
        }
        return false;
    }

    @Override
    public void InserirInicio(T elemento) {
        NoSimpEnc<T> novoNo = new NoSimpEnc<>(elemento);
        if (inicio==null){
            inicio = fim=novoNo;
        }else{
            novoNo.setProximo(inicio);
            inicio = novoNo;
        }
        contElementos++;

    }

    @Override
    public void InserirFim(T elemento) {
        NoSimpEnc<T> novoNo = new NoSimpEnc<>(elemento);
        if (inicio==null){
            inicio=fim=novoNo;

        }else {
            fim.setProximo(novoNo);
            fim=novoNo;
        }
        contElementos++;

    }

    @Override
    public void Inserir(int pos, T elemento) {
        NoSimpEnc <T> novoNo = new NoSimpEnc<T>(elemento) ;
        NoSimpEnc<T>  aux = inicio;
        if (pos < 0 || pos > contElementos){
            throw new IndexOutOfBoundsException();
        }else if (pos == contElementos ) {
            this.InserirFim(elemento);
        }else  if (pos ==  0){
            this.InserirInicio(elemento);
        }else {
            for (int i = 1; i < contElementos; i++) {
                if (i == pos) {
                    novoNo.setProximo(aux.getProximo());
                    aux.setProximo(novoNo);

                   contElementos++;
                }
            }
            aux = aux.getProximo();

        }

    }

    @Override
    public boolean contem(T elemento) {
        NoSimpEnc<T> aux = inicio;
        for (int i = 0; i < contElementos; i++) {
            if (aux.equals(elemento)){
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    @Override
    public void RemoverInicio() {
        if (!estaVazia()){
            inicio=inicio.getProximo();
            contElementos--;
        }

    }

    @Override
    public void RemoverFim() {
        NoSimpEnc<T> aux = inicio;
        if (!estaVazia()){
            if (contElementos == 1){
                this.clear();
            }else {
                for (int i = 0; i < contElementos-2; i++) {
                    aux = aux.getProximo();
                }
                aux.setProximo(null);
                fim= aux;
                contElementos--;
            }
        }
    }

    @Override
    public void RemoverElemento(T Elemento) {

        if (contem(Elemento)){
            if (this.inicio.getElemento().equals(Elemento)){
                this.RemoverInicio();
            }else if (fim.getElemento().equals(Elemento)){
                this.RemoverFim();
            }else {
                NoSimpEnc<T> aux = inicio;
                for (int j = 0; j < posicao(Elemento)-1; j++) {
                    aux = aux.getProximo();
                }
                aux.setProximo(aux.getProximo().getProximo());
                contElementos--;

            }

        }

    }

    private int posicao(T Elemento){
        NoSimpEnc <T> aux = this.inicio;
       int  pos = -1;
        for (int i = 0; i < contElementos; i++) {
            if (aux.getElemento().equals(Elemento)){
                return i;
            }

            aux = aux.getProximo();
        }
        return pos;
    }

    @Override
    public Iterator iterator() {
        Iterator<T> myIterator = new Iterator<T>() {

            NoSimpEnc posicao = inicio;

            @Override
            public boolean hasNext() {
                if (posicao != null) {
                    return true;
                } else {
                    this.posicao = inicio;
                    return false;
                }
            }

            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    T elemento = (T) posicao.getElemento();
                    posicao = posicao.getProximo();
                    return elemento;
                }
            }
        };
        return myIterator;
    }


    @Override
    public String toString() {
        NoSimpEnc<T> aux = inicio;
        String str ="";
        for (int i = 0; i < contElementos; i++) {
            str += aux + "-> ";
            aux = aux.getProximo();
        }
        return str;
    }
}