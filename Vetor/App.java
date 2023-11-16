package ED1.Vetor;

public class App {
        public static void main(String[] args) {
            Vetor<Integer> vet1 = new Vetor<>();
            Vetor<Integer> vet2 = new Vetor<>();
            vet1.adicionar(4);
            vet1.adicionar(5);
            vet1.adicionar(6);
            vet2.adicionar(7);
            vet2.adicionar(4);
            vet2.adicionar(9);
            System.out.println(vet1.toString());
            System.out.println(vet2.toString());
            vet1.inserirPartes(vet2,2);



            System.out.println(vet1.toString());

        }
    }

