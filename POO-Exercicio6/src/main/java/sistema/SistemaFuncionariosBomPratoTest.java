package sistema;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFuncionariosBomPratoTest {
    @Test
    public void testaCadastroEPesquisa(){
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        try {
            sistema.cadastrarFuncionario(new Funcionario("333.333.333-33", "Ayla Rebouças", TipoFuncionario.GERENTE, 3000));
            assertTrue(sistema.funcionarioJaExiste("333.333.333-33"));
            Funcionario f1 = sistema.pesquisarFuncionario("333.333.333-33");
            sistema.cadastrarFuncionario(new Funcionario("222.222.222-22", "João Paulo Silva", TipoFuncionario.COZINHEIRO, 5000));
            assertTrue(sistema.funcionarioJaExiste("222.222.222-22"));
            Funcionario f2 = sistema.pesquisarFuncionario("222.222.222-22");

            List<Funcionario> ganhamMaisQue2000 = sistema.pesquisarFuncionariosComSalarioMaiorQue(2000);
            assertEquals(2, ganhamMaisQue2000.size());
            List<Funcionario> cozinheiros = sistema.pesquisarFuncionariosPorTipo(TipoFuncionario.COZINHEIRO);
            assertEquals(1, cozinheiros.size());
        } catch (FuncionarioJaExisteException | FuncionarioInexistenteException e) {
            fail("Não deveria lançar exceção");
        }
    }
}
