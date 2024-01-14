package ED1.Prova;

public class Main {
    public static void main(String[] args) throws Exception {
        ListSimpEnc<Integer> lista = new ListSimpEnc<>();
        ListSimpEnc<Integer> lista1 = new ListSimpEnc<>();

        try {
            lista.removerFim();
        }catch (Exception e){
            System.out.println(e.getMessage());// excecao: rempver lista vazia, tbm usada em remover inicio
        }

        try {
            lista.addFim(2);
            lista.addInicio(1);
            lista.addFim(5);
            lista.addPosicao(3,3);
            lista.addPosicao(6, 11);
        }catch (Exception e){
            System.out.println(e.getMessage()); // excecao: adicionar em uma posição inexistente
        }
        System.out.println("Primeira lista: "+ lista.toString() );

        try {
            lista1.limpar();
            System.out.println("teste medodo limpar: "+lista1.getInicio() + " "+ lista1.getFim());
            lista1.addInicio(1);
            lista1.removerFim();
            lista1.addInicio(2);
            lista1.removerInicio();
            lista1.addInicio(4);
            lista1.addFim(8);
            lista1.addFim(9);
            lista1.removerPosicao(11);
        }catch (Exception e){
            System.out.println(e.getMessage());// excecao: remover em uma posicao inexistente
        }
        System.out.println("Segunda lista: "+lista1.toString() );


        try {
            lista.adicionarListaRecursivamente(lista1);
            lista.adicionarListaRecursivamente(lista);
        }catch (Exception e){
            System.out.println(e.getMessage());//excecao: passar a propria lista no metodo recursivo
        }
        System.out.println("Primeira lista: "+ lista.toString() );

    }
}
