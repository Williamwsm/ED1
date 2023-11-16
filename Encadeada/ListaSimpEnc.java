package ED1.Encadeada;

import java.util.Iterator;
import java.util.Objects;

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
        fim = fim.getProximo();
    }

    @Override
    public void RemoverElemento(T Elemento) {
        NoSimpEnc<T> aux = inicio;
        if (contem(Elemento)){
            for (int i = 0; i < contElementos; i++) {
                if (aux.equals(Elemento)){
                        aux = (aux.getProximo());
                        break;
                    }
                aux = aux.getProximo();
                }

            }

        }

    @Override
    public Iterator iterator() {
        return null;
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