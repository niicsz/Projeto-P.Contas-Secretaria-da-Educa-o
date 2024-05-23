public class CalculadoraSalario {
    public double calcular(double salarioBase, int diasAfastados) {
        double vencimentos = salarioBase + (diasAfastados * 1/3);
        double descontos = calcularDescontos();
        return vencimentos - descontos;
    }

    private double calcularDescontos() {
        return 100.0;
    }
}
