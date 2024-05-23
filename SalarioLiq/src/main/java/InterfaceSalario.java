import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceSalario {
    private JFrame frame;
    private JPanel panel;
    private JTextField campoSalarioBase, campoDiasAfastados;
    private JButton btnCalcular, btnAlteracao;
    private JLabel labelResultado;
    private CalculadoraSalario calculadoraSalario;

    public InterfaceSalario() {
        calculadoraSalario = new CalculadoraSalario();

        frame = new JFrame("Calculadora de Salário Líquido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));

        panel.add(new JLabel("Salário Base:"));
        campoSalarioBase = new JTextField();
        panel.add(campoSalarioBase);

        panel.add(new JLabel("Dias Afastados:"));
        campoDiasAfastados = new JTextField();
        panel.add(campoDiasAfastados);

        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSalarioLiquido();
            }
        });
        panel.add(btnCalcular);

        btnAlteracao = new JButton("+ Alteração");
        btnAlteracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTelaAlteracao();
            }
        });
        panel.add(btnAlteracao);

        labelResultado = new JLabel();
        panel.add(labelResultado);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void calcularSalarioLiquido() {
        try {
            double salarioBase = Double.parseDouble(campoSalarioBase.getText());
            int diasAfastados = Integer.parseInt(campoDiasAfastados.getText());

            double salarioLiquido = calculadoraSalario.calcular(salarioBase, diasAfastados);
            labelResultado.setText("Salário Líquido: " + salarioLiquido);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos.");
        }
    }

    private void exibirTelaAlteracao() {
        String nomeAlteracao = JOptionPane.showInputDialog(frame, "Insira o nome da alteração:");
        if (nomeAlteracao != null) {
            String mensagem = "Alteração Feita com Sucesso: " + nomeAlteracao;
            JOptionPane.showMessageDialog(frame, mensagem);
        }
    }
}
