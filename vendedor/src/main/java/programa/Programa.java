package programa;

import entidade.Vendedor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Programa {

    static List<Vendedor> vendedorList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static final int TAM = 3;
    static Vendedor vendedor;

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("""
                    \n--------------------------------------------------
                    1. Cadastrar Vendedor
                    2. Mostrar Vendedor com Maior Tempo de Serviço
                    3. Mostrar Nome e Categoria de Todos os Vendedores
                    4. Imprimir Total de Vendas
                    5. Remover Vendedor
                    6. Fechar Programa""");

            System.out.print("\nQual a opcao: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1 -> cadastrar(vendedorList);
                case 2 -> maiorTempo(vendedorList);
                case 3 -> nomeCategoria(vendedorList);
                case 4 -> System.out.println(totalVendas(vendedorList));
                case 5 -> removerVendedor(vendedorList);
                case 6 -> System.out.println("Finalizando Programa...");
            }
        }
        while (opcao != 6);
    }

    public static void cadastrar(List<Vendedor> lista) {

        for (int i = 0; i < TAM; i++) {
            System.out.print("\nNome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("Tempo de Serviço em Horas: ");
            int tempo = scan.nextInt();
            System.out.print("Total de Vendas: R$");
            double vendas = scan.nextDouble();

            vendedor = new Vendedor(nome, tempo, vendas);
            lista.add(vendedor);
        }
    }

    public static void maiorTempo(List<Vendedor> lista) {

        lista.sort(Comparator.comparingInt(Vendedor :: getTempoDeServico).reversed());

        for (Vendedor ven : lista) {
            System.out.println(ven.getNome() + " - " + ven.getTempoDeServico() + " horas");
        }
    }

    public static void nomeCategoria(List<Vendedor> lista) {

        for (Vendedor ven : lista) {
            System.out.println('\n' + ven.getNome() + " - Categoria: " + ven.getCategoria());
        }
    }

    public static String totalVendas(List<Vendedor> lista) {

        double soma = 0;

        for (Vendedor ven : lista) {
            soma += ven.getTotalVendas();
        }

        return String.format("Total de Vendas R$ %.2f", soma);

    }

    public static void removerVendedor(List<Vendedor> lista) {
        System.out.print("Digite o nome do Vendedor que deseja remover: ");
        scan.nextLine();
        String nome = scan.nextLine();

        lista.removeIf(x -> nome.equalsIgnoreCase(x.getNome()));
    }
}