package Sistema;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = mensagens;
        this.amigos = amigos;
    }

    public void cadastraAmigo(String nome, String email) {
        Amigo amigo = new Amigo(nome, email);
        amigos.add(amigo);
    }

    public void pesquisaAmigo(String email) {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(email)) {
                System.out.println("Amigo encontrado: " + amigo.getNome() + " - " + amigo.getEmail());
                return;
            }
        }
        System.out.println("Amigo não encontrado com o email: " + email);
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        Mensagem mensagem = new MensagemParaTodos(texto, emailRemetente, anonima);
        mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        Mensagem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima);
        mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisarMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem mensagem : mensagens) {
            if (mensagem.ehAnonima()) {
                mensagensAnonimas.add(mensagem);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configurarAmigoSecreto(String email, String emailAmigoSorteado) {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(email)) {
                amigo.setEmailAmigoSorteado(emailAmigoSorteado);
                System.out.println("Amigo secreto configurado para " + amigo.getNome() + ": " + emailAmigoSorteado);
            } else {
                throw new EmailNaoEncontradoException("Email do amigo não encontrado: " + email);
            }
        }

    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailDaPessoa)) {
                String emailAmigoSorteado = amigo.getEmailAmigoSorteado();
                if (emailAmigoSorteado == null) {
                    throw new AmigoNaoSorteadoException("Amigo não sorteado para o email: " + emailDaPessoa);
                }
                return emailAmigoSorteado;
            }
        }
        throw new AmigoInexistenteException("Email do amigo não encontrado: " + emailDaPessoa);
    }

}
