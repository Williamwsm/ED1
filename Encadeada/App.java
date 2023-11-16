package ED1.Encadeada;

public class App {
    public static void main(String[] args) {
        ListaSimpEnc<Integer>lista = new ListaSimpEnc<>();
        lista.Inserir(0,10);
        lista.Inserir(0,1);
        lista.Inserir(1,2);
        lista.Inserir(0,5);

        System.out.println(lista.toString());
    }
}
