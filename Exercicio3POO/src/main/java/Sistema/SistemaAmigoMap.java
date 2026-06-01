package Sistema;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SistemaAmigoMap {
    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap() {
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nome, String email) {
        Amigo novoAmigo = new Amigo(nome, email);
        amigos.put(email, novoAmigo);
    }

    public Amigo pesquisaAmigo(String email) {
        if (email == null) return null;
        return amigos.get(email);
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem mensagem = new Mensagem(texto, emailRemetente, ehAnonima);
        mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        Mensagem mensagem = new Mensagem(texto, emailRemetente, emailDestinatario, ehAnonima);
        mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem mensagem: mensagens) {
            if (mensagem.ehAnonima()) {
                anonimas.add(mensagem);
            }
        }
        return anonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecreto(String emailAmigo, String emailAmigoSecreto) {
        Amigo amigo = pesquisaAmigo(emailAmigo);
        if(amigo != null) {
            amigo.setAmigoSorteado(emailAmigoSecreto);
        } else {
            throw new AmigoInexistenteException ("Amigo não encontrado: " + emailAmigo);
        }
    }

}
