import javax.swing.*;

public class JanelaAlteracao {
    public void exibir(JFrame frame) {
        String nomeAlteracao = JOptionPane.showInputDialog(frame, "Insira o nome da alteração:");
        if (nomeAlteracao != null) {
            String mensagem = "Alteração Feita com Sucesso: " + nomeAlteracao;
            JOptionPane.showMessageDialog(frame, mensagem);
        }
    }
}
