package tp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import tp.model.Pattern;
import tp.model.Light_Bulb;
import tp.view.View;


public class Controller {
    private Pattern pattern;
    private View view;

    public Controller(Pattern pattern, View view) {
        this.pattern = pattern;
        this.view = view;

        initializeView();
        attachListeners();
    }

    private void initializeView() {
    	Light_Bulb[][] stateLightBulb = pattern.getStateGame();
        JButton[][] buttons = view.getButtons();
        
        System.out.print(stateLightBulb[0][0].getLuzAmarilla());

        for (int i = 0; i < stateLightBulb.length; i++) {
            for (int j = 0; j < stateLightBulb[0].length; j++) {
            	buttons[i][j].setIcon(new ImageIcon(   stateLightBulb[i][j].lightOnOff()         )      );
            }
        }
        
    }
    
    private void attachListeners() {
        JButton[][] buttons = view.getButtons();

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pattern.toggleState(row, col);
                        updateView();
                    }
                });
            }
        }
    }

    private void updateView() {
    	Light_Bulb[][] stateLightBulb = pattern.getStateGame();
        JButton[][] buttons = view.getButtons();
        JLabel lblIntentos = view.getLblIntentos();

        for (int i = 0; i < stateLightBulb.length; i++) {
            for (int j = 0; j < stateLightBulb[i].length; j++) {
                buttons[i][j].setIcon(new ImageIcon( stateLightBulb[i][j].lightOnOff() ));
            }
        }

        lblIntentos.setText("Intentos : " + pattern.getContIntentos());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Pattern pattern = new Pattern();
                View view = new View();
                new Controller(pattern, view);
                view.getFrame().setVisible(true);
            }
        });
    }
}
