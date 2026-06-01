package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFuncionariosBomPrato implements SistemaFuncionarios {
    private Map<String, Funcionario> funcionarios;


    public SistemaFuncionariosBomPrato() {
        this.funcionarios = new HashMap<String, Funcionario>();
    }


    @Override
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException {
        if (this.funcionarios.containsKey(funcionario.getCpf())) {
            throw new FuncionarioJaExisteException(
                    "Já existe funcionário com o cpf " + funcionario.getCpf());
        } else {
            this.funcionarios.put(funcionario.getCpf(), funcionario);
        }

    }

    @Override
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario
            tipo, double salario) throws FuncionarioJaExisteException {
        if (this.funcionarios.containsKey(cpf)) {
            throw new FuncionarioJaExisteException(
                    "Já existe funcionário com o cpf " + cpf);
        } else {
            this.funcionarios.put(cpf, new Funcionario(cpf, nome, tipo,
                    salario));
        }
    }

    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) throws FuncionarioInexistenteException {
        if (this.funcionarios.containsKey(cpfFuncionario)) {
            this.funcionarios.get(cpfFuncionario).setSalario(novoSalario);
        } else {
            throw new FuncionarioInexistenteException(
                    "Não existe funcionário com o cpf " + cpfFuncionario);
        }
    }

    public int contarFuncionariosDoTipo(TipoFuncionario tipo) {
        int contador = 0;
        for (Funcionario funcionario : this.funcionarios.values()) {
            if (funcionario.getTipo() == tipo) {
                contador++;
            }
        }
        return contador;
    }

    public boolean funcionarioJaExiste(String cpfFuncionario) {
        return this.funcionarios.containsKey(cpfFuncionario);
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo) {
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        for (Funcionario funcionario : this.funcionarios.values()) {
            if (funcionario.getTipo() == tipo) {
                resultado.add(funcionario);
            }
        }
        return resultado;
    }

    @Override
    public Funcionario pesquisarFuncionario(String cpfFuncionario) throws FuncionarioInexistenteException {
        if (this.funcionarios.containsKey(cpfFuncionario)) {
            return this.funcionarios.get(cpfFuncionario);
        } else {
            throw new FuncionarioInexistenteException(
                    "Não existe funcionário com o cpf " + cpfFuncionario);
        }
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor) {
        List<Funcionario> resultado = new ArrayList<Funcionario>();
        for (Funcionario funcionario : this.funcionarios.values()) {
            if (funcionario.getSalario() > valor) {
                resultado.add(funcionario);
            }
        }
        return resultado;
    }
}
