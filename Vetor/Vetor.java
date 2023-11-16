package ED1.Vetor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Vetor <T> implements IVetor<T>,Iterable<T>{
    private int tamVetor ; //por padrão é 10
    private T elementos[];//como instanciar: (T[]) new  Object[tamVetor]
    private int contElementos; //contador de elementos
    private int vlIncremento; //valor para redimensionar, por padrão o valor é 10

    //implemente os 3 construtores!
    public Vetor( ) {
        this.tamVetor = 10;
        this.elementos = (T[]) new Object[this.tamVetor];
        this.contElementos = 0;
        this.vlIncremento = 10;
    }

    public Vetor(int tamVetor){
        this.tamVetor = tamVetor;
        this.elementos = (T[]) new Object[this.tamVetor];
        this.contElementos = 0;
        this.vlIncremento = 10;
    }

    public Vetor(int tamVetor, int vlIncremento){
        this.tamVetor = tamVetor;
        this.elementos = (T[]) new Object[this.tamVetor];
        this.contElementos = 0;
        this.vlIncremento = vlIncremento;
    }

    private Iterator<T> myInterator = new  Iterator<T>() {
        private  int posicao = 0;
        public  boolean hasNext(){
            if (posicao < contElementos){
                return  true;
            }else {
                return false;
            }
        }

        public T next() throws NoSuchElementException {
            T elemento;
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                elemento = elementos[posicao];
                posicao++;
                return elemento;
            }

        }

    };


    @Override
    public void adicionar(T elemento) {
        this.redirecionar();
        this.elementos[this.contElementos] = elemento;
        this.contElementos++;
    }

    @Override
    public void adicionar(int posicao, T elemento) throws IndexOutOfBoundsException {
        this.redirecionar();
        if (posicao <0 || posicao> this.tamVetor){
            throw  new IndexOutOfBoundsException("posicao invalida");
        }
       for (int x = contElementos; x >posicao; x--){
           this.elementos[x] = elementos[x-1];
       }
       this.elementos[posicao]= elemento;
       contElementos++;

    }

    @Override
    public void adcionarIncio(T elemento) {
            this.adicionar(0,elemento);
    }

    public void adcionarElementoPosRandom(Vetor<T> vetor){
        int quantElementos = this.elementos.length + vetor.tamanho(); // verificando se os elementos cabem no vetor
        if (quantElementos >= tamVetor){
            this.redirecionar();
        }

        if (this.estaVazia()){
            for (T elemento:vetor) {
                this.adicionar(elemento); // adicionando
            }
        }else {
            Random gerador = new Random();
            int[] posicoes = new int[ vetor.tamanho()]; // vetor q informa as posicoes aleatorias
            for (int i = 0; i <posicoes.length; i++) {
                posicoes[i] = gerador.nextInt(this.tamanho());
                while (posicaoRepetida(posicoes)) {
                    posicoes[i] = gerador.nextInt(this.tamanho());
                }
            }
            int contItem = 0;
            for (T item: vetor) {
                this.adicionar(posicoes[contItem], item);
                contItem++;
            }
        }



    }

    public boolean posicaoRepetida(int[] posicao){// verificar se a posicao nao se repete
        for (int i = 0; i< posicao.length ; i++) {
            if (i == posicao.length - 1) {
                for (int j = i-1; j >=0; j--) {
                    if (posicao[i] == posicao[j] && posicao[j]!= 0) {
                        return true;

                    }

                }
            } else {
                for (int j = i + 1; j < posicao.length; j++) {
                    if (posicao[i] == posicao[j] && posicao[j]!= 0) {
                        return true;
                    }
                }
            }
        }
        return  false;
    }

    public  void inserirElementosApos(T elemento, T inserir){
        if (contem(elemento)){
            for (int i = 0; i < this.elementos.length ; i++) {
                if (elementos[i] == elemento){
                    this.adicionar(i+1, inserir);
                    break;
                }
            }
        }else {
            System.out.println("elemento nao encontrado");
        }
    }
    public void mesclarVetores(Vetor<T> vet){
        if (this.estaVazia()){
            for (T elemento: vet) {
                this.adicionar(elemento);

            }
        }else {
            int impar =1;
                for (T elememtos : vet) {
                    if (impar <= this.tamanho()) {
                        this.adicionar(impar, elememtos);
                        impar += 2;
                    }else {
                        this.adicionar(elememtos);
                    }
                }

            }

        }

    public  void adicionarElementosPosPares(Vetor <T> vet){

        if (estaVazia()){
            for (T elemento:vet) {
                this.adicionar(elemento);
            }
        }else {
            int par = 0; // indica as posicoes pares
            for (T elemento: vet) {
                if ( par <= this.tamanho()){  //ver se passou do tamanno do vetor
                    this.adicionar(par, elemento);
                    par += 2;
                }else {
                    this.adicionar(elemento);
                }

            }

        }
    }

    public void inverterVetor(){
        T vetor[] =  (T[]) new Object [this.tamanho()];
        int posicao = 0;
        if (this.estaVazia()){
            System.out.println("O vetor estar vazio");
        }
        for (int i = this.tamanho()-1; i >=0 ; i--) {
            if (posicao< this.tamanho()){
                vetor[posicao] = elementos[i];
                posicao++;
            }

        }
            this.elementos =  vetor;
    }

    public void inserirPartes(Vetor<T> vet, int posicao){
        if (vet.tamanho()< posicao){
            System.out.println("essa posicao nao existe");
        }
            int limite =0;
            for (T elementos: vet) {
                if (limite< posicao){
                    this.adicionar(elementos);
                    limite++;
                }
            }

    }


    @Override
    public void remover(int posicao) throws IndexOutOfBoundsException {
        this.redirecionar();
        if (posicao <0 || posicao> this.tamVetor){
            throw  new IndexOutOfBoundsException("posicao invalida");
        }
        if (this.estaVazia()){
            throw new RuntimeException("lista vazia");
        }else {
            if (posicao == 0){
                this.removerInicio();
            }else {
                this.elementos[posicao] = null;
                this.contElementos--;
            }

        }
    }

    @Override
    public void removerElemento(T elemento)throws RuntimeException {
        if (this.contem(elemento)){ // confere se o elemento estar na lista
           for (int x = 0; x< this.elementos.length; x++){
               if (elementos[x] == elemento) { // encontra o elemento
                        this.remover(x);
                    break;
               }
           }
        }
    }

    @Override
    public void removerInicio()throws RuntimeException{
        if (this.estaVazia()){
            throw new RuntimeException("lista vazia");
        }else {
            for (int x = 0; x< this.elementos.length;x++){
                if (x == elementos.length-1){
                    this.elementos[x] =  null; // a ultima posicao da lista ira ficar nula
                    this.contElementos--;
                }else {
                    this.elementos[x] = this.elementos[x+1]; // passa todos os elementos para uma posicao a menos do vetor
                }
            }

        }

    }

    @Override
    public void removerFim()throws RuntimeException {
        if (this.estaVazia()){
            throw new RuntimeException("lista vazia");
        }else {
            this.elementos[this.contElementos-1] = null;
            this.contElementos--;
        }
    }

    @Override
    public int tamanho() {
        return this.contElementos;
    }

    @Override
    public void limpar() {
       elementos = (T[]) new Object[tamVetor];
        this.contElementos = 0;
    }

    @Override
    public boolean contem(T elemento) {
        for (T e: elementos) {
            if (e  == elemento) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean estaVazia() {
        return this.contElementos == 0;
    }

    public void redirecionar(){
        if (this.tamVetor == this.contElementos) {
            T novoElementos[] = (T[]) new Object[this.tamVetor + this.vlIncremento];
            System.arraycopy(this.elementos,0,novoElementos,0, this.tamanho());
            this.elementos = novoElementos;
            this.tamVetor = elementos.length;
        }
    }
    public String toString() {
        String str = "[";
        if (tamanho() == 1){
            str += elementos[0];
        }else if (estaVazia()){
            return str +="]";
        }else {
            for (int i = 0; i <elementos.length ; i++) {
                if (elementos[i] == null) {
                    str = str;
                }else if (i == this.tamanho()-1){
                    str += elementos[i];
                }else {
                    str += elementos[i]+",";
                }
            }
        }
        return str +="]";
    }

    public Iterator<T> iterator(){
        return myInterator;
    }
}
