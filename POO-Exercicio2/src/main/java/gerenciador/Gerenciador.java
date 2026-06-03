package gerenciador;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    private List<Despesa> despesas;

    public Gerenciador() {
        this.despesas = new ArrayList<>();
    }

    public void adicionnarDespesa(Despesa despesa) throws ValorInvalidoException {
        if (despesa.getValor() < 0) {
            throw new ValorInvalidoException("Valor da despesa não pode ser negativo.");
        }
        despesas.add(despesa);
    }

    public double calcularTotalDespesas() {
        double total = 0;
        for (Despesa d : despesas) {
            total += d.getValor();
        }
        return total;
    }

    public void listarDespesas() {
        if (despesas.isEmpty()) {
            System.out.println("Nenhuma despesa registrada.");
        } else {
            for (Despesa d : despesas) {
                System.out.println(d.toString());
            }
        }
    }
}
