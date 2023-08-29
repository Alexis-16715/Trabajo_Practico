package tp.view;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JButton[][] buttons;
    private JLabel lblIntentos;

    public View() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 645, 440);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String luzAmarilla = "C:\\Users\\alexi\\Desktop\\Proyecto\\Luz_amarilla38px.png";
        String luzRoja = "C:\\Users\\alexi\\Desktop\\Proyecto\\Luzroja38px.png";

        buttons = new JButton[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton("");
                // Set button properties here
                button.setIcon(new ImageIcon(luzAmarilla));
                button.setBounds(140+j*100, 30+i*90, 38, 41);
                frame.getContentPane().add(button);
                buttons[j][i] = button;
            }
        }
        

        lblIntentos = new JLabel("Intentos : 0");
        lblIntentos.setSize(120, 14);
        lblIntentos.setLocation(513, 361);
        // Set label properties here
        frame.getContentPane().add(lblIntentos);
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public JLabel getLblIntentos() {
        return lblIntentos;
    }

    public JFrame getFrame() {
        return frame;
    }
}
