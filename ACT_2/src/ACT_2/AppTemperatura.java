package ACT_2;
import javax.swing.*;
import java.awt.*;

public class AppTemperatura extends JFrame{

    private JTextField[] campos;
    private int[] temperaturas = new int[7];

    private PanelGrafico panelGrafico;

    public AppTemperatura() {
        super("Gráfico de Temperaturas");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(8, 2));

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        campos = new JTextField[7];

        for (int i = 0; i < 7; i++) {
            panelEntrada.add(new JLabel(dias[i] + ":"));
            campos[i] = new JTextField();
            panelEntrada.add(campos[i]);
        }

        JButton btnGraficar = new JButton("Mostrar Gráfico");
        panelEntrada.add(btnGraficar);

        add(panelEntrada, BorderLayout.WEST);

        panelGrafico = new PanelGrafico(temperaturas);
        add(panelGrafico, BorderLayout.CENTER);

        btnGraficar.addActionListener(e -> {
            try {
                for (int i = 0; i < 7; i++) {
                    temperaturas[i] = Integer.parseInt(campos[i].getText());
                }
                panelGrafico.repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingrese solo números válidos.");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AppTemperatura();
    }
}