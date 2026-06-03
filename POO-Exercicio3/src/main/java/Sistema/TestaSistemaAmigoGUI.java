package Sistema;

import javax.swing.JOptionPane;

public class TestaSistemaAmigoGUI {
        public static void main(String[] args) {
            SistemaAmigo sistema = new SistemaAmigo();

            int quantidadeAmigos = 0;
            try {
                String qtdAmigos = JOptionPane.showInputDialog("Quantos amigos vão participar do Amigo Secreto?");
                if (qtdAmigos == null) return;
                quantidadeAmigos = Integer.parseInt(qtdAmigos);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para a quantidade de amigos.");
                return;
            }

            for (int i = 0; i < quantidadeAmigos; i++) {
                String nome = JOptionPane.showInputDialog("Digite o nome do amigo " + (i + 1) + ":");
                String email = JOptionPane.showInputDialog("Digite o e-mail de " + nome + ":");
                sistema.cadastraAmigo(nome, email);
            }

            for (int i = 0; i < quantidadeAmigos; i++) {
                String email = JOptionPane.showInputDialog("Digite o e-mail da pessoa que sorteou: ");
                String emailAmigoSorteado = JOptionPane.showInputDialog("Digite o e-mail do amigo sorteado: ");
                try {
                    sistema.configurarAmigoSecreto(email, emailAmigoSorteado);
                } catch (EmailNaoEncontradoException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

            String emailRemetente = JOptionPane.showInputDialog("Digite o e-mail do remetente da mensagem: ");
            String texto = JOptionPane.showInputDialog("Digite o texto da mensagem: ");
            int respostaAnonima = JOptionPane.showConfirmDialog(null, "A mensagem é anônima?", "Mensagem Anônima", JOptionPane.YES_NO_OPTION);
            boolean anonima = respostaAnonima == JOptionPane.YES_OPTION;
            sistema.enviarMensagemParaTodos(texto, emailRemetente, anonima);
        }


}
