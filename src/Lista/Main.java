package Lista;
public class Main {
    public static void main(String[] args) {
        Lista<Pessoa> listaDePessoas = new Lista<>();

        Pessoa p = new Pessoa();
        p.nome = "Wagner";
        p.idade = 20;

        Pessoa p2 = new Pessoa();
        p2.nome = "Teste2";
        p2.idade = 50;

        Pessoa p3 = new Pessoa();
        p3.nome = "Pessoa 3";
        p3.idade = 35;

        Pessoa p4 = new Pessoa();
        p4.nome = "Ultima pessoa";
        p4.idade = 100;

        listaDePessoas.addInicio(p);
        listaDePessoas.addInicio(p2);
        listaDePessoas.addInicio(p3);
        listaDePessoas.addFim(p4);
        listaDePessoas.imprimirTodos();

        System.out.println("\n");
        listaDePessoas.addPosicao(p,4);
        listaDePessoas.imprimirTodos();
        System.out.println("\n");

        listaDePessoas.removeFim();
        System.out.println("\n");
        listaDePessoas.imprimirTodos();

        System.out.println("\n");
        System.out.println(listaDePessoas.indexOf(p2));
        System.out.println(listaDePessoas.indexOf(p3));
        System.out.println(listaDePessoas.indexOf(p));

        listaDePessoas.removePosicao(2);
        System.out.println("\n");
        listaDePessoas.imprimirTodos();

        listaDePessoas.removePosicao(0);
        System.out.println("\n");
        listaDePessoas.imprimirTodos();

        System.out.println("\n");
        System.out.println(listaDePessoas.indexOf(p2));
        System.out.println(listaDePessoas.indexOf(p3));
        System.out.println(listaDePessoas.indexOf(p));
    }
}
