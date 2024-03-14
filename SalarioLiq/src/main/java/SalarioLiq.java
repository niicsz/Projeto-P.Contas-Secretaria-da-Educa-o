import javax.swing.*;
import java.awt.event.ActionEvent;

public class SalarioLiq {
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel labelSalarioBase;
    private final JLabel labelDescontoINSS;
    private final JLabel labelDescontoIRPF;
    private final JLabel labelSalarioLiquido;
    private final JTextField campoSalarioBase;
    private final JTextField campoDescontoINSS;
    private final JTextField campoDescontoIRPF;
    private final JTextField campoSalarioLiquido;
    private final JButton btnCalcular;

    public SalarioLiq() {
        frame = new JFrame("Calculadora de Salário Líquido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        labelSalarioBase = new JLabel("Salário Base:");
        labelSalarioBase.setBounds(20, 20, 100, 20);
        campoSalarioBase = new JTextField();
        campoSalarioBase.setBounds(130, 20, 150, 20);

        labelDescontoINSS = new JLabel("Desconto INSS:");
        labelDescontoINSS.setBounds(20, 50, 100, 20);
        campoDescontoINSS = new JTextField();
        campoDescontoINSS.setBounds(130, 50, 150, 20);

        labelDescontoIRPF = new JLabel("Desconto IRPF:");
        labelDescontoIRPF.setBounds(20, 80, 100, 20);
        campoDescontoIRPF = new JTextField();
        campoDescontoIRPF.setBounds(130, 80, 150, 20);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(20, 110, 100, 30);
        btnCalcular.addActionListener((ActionEvent e) -> {
            calcularSalarioLiquido();
        });

        labelSalarioLiquido = new JLabel("Salário Líquido:");
        labelSalarioLiquido.setBounds(20, 150, 100, 20);
        campoSalarioLiquido = new JTextField();
        campoSalarioLiquido.setBounds(130, 150, 150, 20);
        campoSalarioLiquido.setEditable(false);

        panel.add(labelSalarioBase);
        panel.add(campoSalarioBase);
        panel.add(labelDescontoINSS);
        panel.add(campoDescontoINSS);
        panel.add(labelDescontoIRPF);
        panel.add(campoDescontoIRPF);
        panel.add(btnCalcular);
        panel.add(labelSalarioLiquido);
        panel.add(campoSalarioLiquido);

        frame.add(panel);
        frame.setSize(350, 250);
        frame.setVisible(true);
    }

    private void calcularSalarioLiquido() {
        double salarioBase = Double.parseDouble(campoSalarioBase.getText());
        double descontoINSS = Double.parseDouble(campoDescontoINSS.getText());
        double descontoIRPF = Double.parseDouble(campoDescontoIRPF.getText());

        double salarioDescontoINSS = salarioBase - descontoINSS;
        double salarioLiquido = salarioDescontoINSS - descontoIRPF;

        campoSalarioLiquido.setText(Double.toString(salarioLiquido));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SalarioLiq();
            }
        });
    }
}
    
