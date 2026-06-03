package gerenciador;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gerenciador gerenciador = new Gerenciador();
        boolean continuar = true;

        while (continuar) {
            System.out.println("1 - Adicionar despesa");
            System.out.println("2 - Listar despesas");
            System.out.println("3 - Calcular total de despesas");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Código da despesa: ");
                        String codigo = scanner.nextLine();
                        System.out.print("Categoria da despesa: ");
                        String categoria = scanner.nextLine();
                        System.out.print("Valor da despesa: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                        Despesa despesa = new Despesa(codigo, categoria, valor);
                        gerenciador.adicionnarDespesa(despesa);
                        break;
                    case 2:
                        gerenciador.listarDespesas();
                        break;
                    case 3:
                        double total = gerenciador.calcularTotalDespesas();
                        System.out.println("Total de despesas: " + total);
                        break;
                    case 4:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
