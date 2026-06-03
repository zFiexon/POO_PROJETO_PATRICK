package gerenciador;

import java.util.Objects;

public class Despesa {
    private String codigo;
    private String categoria;
    private double valor;

    public Despesa(String codigo, String categoria, double valor){
        this.codigo = codigo;
        this.categoria = categoria;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return Double.compare(despesa.valor, valor) == 0 &&
                Objects.equals(codigo, despesa.codigo) &&
                Objects.equals(categoria, despesa.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, valor, categoria);
    }

    @Override
    public String toString() {
        return String.format("Despesa: " + categoria + "| Valor: R$ " + valor + "| Código: " + codigo);
    }

}
