package ACT_2;
import javax.swing.*;
import java.awt.*;

public class PanelGrafico extends JPanel{
    private int[] temps;

    public PanelGrafico(int[] temps) {
        this.temps = temps;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawLine(50, 300, 600, 300);
        g.drawLine(50, 50, 50, 300);

        String[] dias = {"L", "M", "Mi", "J", "V", "S", "D"};

        int xBase = 80;
        int prevX = -1, prevY = -1;

        for (int i = 0; i < 7; i++) {
            int temp = temps[i];

            int y = 300 - temp * 5;

            int x = xBase + i * 80;

            g.drawString(dias[i], x - 5, 320);

            g.fillOval(x - 4, y - 4, 8, 8);

            if (prevX != -1) {
                g.drawLine(prevX, prevY, x, y);
            }

            prevX = x;
            prevY = y;
        }
    }
}
