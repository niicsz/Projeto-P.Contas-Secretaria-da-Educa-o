import javax.swing.*;

public class SalarioLiq {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceSalario();
            }
        });
    }
}
