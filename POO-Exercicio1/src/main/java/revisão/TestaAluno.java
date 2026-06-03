package revisão;

import java.util.ArrayList;
import java.util.Scanner;

public class TestaAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Aluno " + i );

            System.out.println("Nome: ");
            String nome = scanner.nextLine();

            System.out.println("Matricula: ");
            String matricula = scanner.nextLine();

            System.out.println("Quantidade de notas: ");
            int qtdNotas = Integer.parseInt(scanner.nextLine());

            double[] notas = new double[qtdNotas];
            for (int j = 0; j < qtdNotas; j++) {
                System.out.println("Nota " + (j + 1) + ": ");
                notas[j] = Double.parseDouble(scanner.nextLine());
            }

            Aluno aluno = new Aluno(nome, matricula, notas);
            alunos.add(aluno);
            System.out.println();
        }

        // Médias
        for (Aluno aluno: alunos) {
            System.out.println(aluno);
            try {
                double media = aluno.getMedia();
                System.out.println("Média: " + media);
            } catch (NotasInexistentesException e) {
                System.out.println("Não foi possível calcular a média: " + e.getMessage() );
            }
        }
        scanner.close();
    }
}
