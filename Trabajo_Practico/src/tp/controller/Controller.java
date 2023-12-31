package tp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

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
	private URL lightOn = getClass().getResource("/images/Light On.png");
	private URL lighOff = getClass().getResource("/images/Light Off.png");

    public Controller(Pattern pattern, View view) {
        this.pattern = pattern;
        this.view = view;

        initializeView();
        attachListeners();
    }

    private void initializeView() {
    	Light_Bulb[][] stateLightBulb = pattern.getStateGame();
        JButton[][] buttons = view.getButtons();
        

        for (int i = 0; i < stateLightBulb.length; i++) {
            for (int j = 0; j < stateLightBulb[0].length; j++) {
            	buttons[i][j].setIcon(new ImageIcon(   stateLightBulb[i][j].getSwich_On_Or_Off() ? lighOff : lightOn         )      );
            }
        }
        
    }
    
    private void attachListeners() {
        JButton[][] buttons = view.getButtons();

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                final int row = i;
                final int col = j;
                buttons[row][col].addActionListener(new ActionListener() {
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
        JLabel lblIntentos = view.getNumberAttemps();
        JLabel label = view.getlabel();

        for (int column = 0; column < stateLightBulb.length; column++) {
            for (int row = 0; row < stateLightBulb[column].length; row++) {
                buttons[column][row].setIcon(new ImageIcon( stateLightBulb[column][row].getSwich_On_Or_Off() ? lighOff : lightOn  ));
            }
        }
        if(pattern.wonAllLihhtOut()) {
        	label.setText("Ganaste");
        }


        lblIntentos.setText("Intentos : " + pattern.getNumberAttemps());
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
