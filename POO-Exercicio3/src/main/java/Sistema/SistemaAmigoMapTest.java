package Sistema;

import java.util.List;

public class SistemaAmigoMapTest {
    public static void main(String[] args) {
        SistemaAmigoMap sistema = new SistemaAmigoMap();

        sistema.cadastraAmigo("Jose", "jose@gmail.com");
        sistema.cadastraAmigo("Maria", "maria@gmail.com");

        Amigo amigoEncontrado = sistema.pesquisaAmigo("maria@gmail.com");
        if (amigoEncontrado != null) {
            System.out.println("Amigo encontrado: " + amigoEncontrado.getNome());
        } else {
            System.out.println("Amigo não encontrado.");
        }

        try {
            sistema.configuraAmigoSecreto("jose@email.com", "maria@email.com");
            sistema.configuraAmigoSecreto("maria@email.com", "jose@email.com");
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }

        sistema.enviarMensagemParaTodos("Olá a todos!", "jose@email.com", false);
        sistema.enviarMensagemParaAlguem("Oi Maria!", "jose@email.com", "maria@email.com", false);

        List<Mensagem> todas = sistema.pesquisaTodasAsMensagens();
        System.out.println("Todas as mensagens:");
        for (Mensagem msg : todas) {
            System.out.println("- " + msg.getTexto() + " (de: " + msg.getEmailRemetente() + ", para: " + msg.getEmailDestinatario() + ", anônima: " + msg.ehAnonima() + ")");
        }

        List<Mensagem> anonimas = sistema.pesquisaMensagensAnonimas();
        System.out.println("Mensagens anônimas:");
        for (Mensagem msg : anonimas) {
            System.out.println("- " + msg.getTexto() + " (de: " + msg.getEmailRemetente() + ", para: " + msg.getEmailDestinatario() + ", anônima: " + msg.ehAnonima() + ")");
        }

    }
}
