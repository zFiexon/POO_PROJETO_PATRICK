package Sistema;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        sistema.cadastrarAmigo("José", "jose@gmail.com");
        sistema.cadastrarAmigo("Maria", "maria@gmail.com");

        try {
            sistema.configurarAmigoSecreto("jose@gmail.com", "maria@gmail.com");
            sistema.configurarAmigoSecreto("maria@gmail.com", "jose@gmail.com");
        } catch (EmailNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        sistema.enviarMensagemParaAlguem("Olá José, esta é uma mensagem anônima!", "maria@gmail.com", "jose@gmail.com", true);

        sistema.enviarMensagemParaTodos("Olá a todos, esta é uma mensagem anônima!", "maria@gmail.com", true);

        for (Mensagem mensagem : sistema.pesquisarMensagensAnonimas()) {
            System.out.println(mensagem.getTextoCompletoAExibir());
        }

        String emailAmigoSecretoJose = null;
        for (Amigo amigo : sistema.getAmigos()) {
            if (amigo.getEmail().equals("maria@gmail.com")) {
                emailAmigoSecretoJose = amigo.getEmailAmigoSorteado();
                break;
            }
        }
        if ("maria@gmail.com".equals(emailAmigoSecretoJose)) {
            System.out.println("Ok");
        } else {
            System.out.println("Amigo secreto de José não é Maria.");
        }
    }
}
