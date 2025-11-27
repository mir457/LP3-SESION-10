package ACT_3;
import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.*;

public class ReproductorSonidos extends JFrame{

    public ReproductorSonidos() {
        super("Reproductor de Efectos de Sonido");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnAplausos = new JButton("Aplausos");
        JButton btnCampana = new JButton("Campana");
        JButton btnExplosion = new JButton("Explosión");

        add(btnAplausos);
        add(btnCampana);
        add(btnExplosion);

        btnAplausos.addActionListener(e -> reproducirSonido("src/ACT_3/sonidos/aplausos.wav"));
        btnCampana.addActionListener(e -> reproducirSonido("src/ACT_3/sonidos/campana.wav"));
        btnExplosion.addActionListener(e -> reproducirSonido("src/ACT_3/sonidos/explosion.wav"));

        setVisible(true);
    }

    private void reproducirSonido(String ruta) {
        try {
            File archivo = new File(ruta);
            AudioInputStream audio = AudioSystem.getAudioInputStream(archivo);

            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al reproducir sonido: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new ReproductorSonidos();
    }
}