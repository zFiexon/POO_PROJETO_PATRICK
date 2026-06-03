package revisão;

import java.util.Arrays;

public class Aluno {
    private String nome;
    private String matricula;
    private double[] notas;

    public Aluno(String nome, String matricula, double[] notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getMedia() throws NotasInexistentesException {
        if (notas == null || notas.length == 0) {
            throw new NotasInexistentesException("O aluno " + nome + "não possui nota registrada.");
        }
        double soma = 0;
        for (double nota: notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " | Matricula: " + matricula + " | Notas: " + notas;
    }
}
