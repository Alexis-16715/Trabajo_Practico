package tp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import tp.model.Model;
import tp.view.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        initializeView();
        attachListeners();
    }

    private void initializeView() {
        boolean[][] estados = model.getEstados();
        JButton[][] buttons = view.getButtons();

        for (int i = 0; i < estados.length; i++) {
            for (int j = 0; j < estados[i].length; j++) {
                buttons[i][j].setIcon(new ImageIcon(estados[i][j] ? "C:\\\\Users\\\\alexi\\\\Desktop\\\\Proyecto\\\\Luz_amarilla38px.png" : "C:\\\\Users\\\\alexi\\\\Desktop\\\\Proyecto\\\\Luzroja38px.png"));
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
                        model.toggleState(row, col);
                        updateView();
                    }
                });
            }
        }
    }

    private void updateView() {
        boolean[][] estados = model.getEstados();
        JButton[][] buttons = view.getButtons();
        JLabel lblIntentos = view.getLblIntentos();

        for (int i = 0; i < estados.length; i++) {
            for (int j = 0; j < estados[i].length; j++) {
                buttons[i][j].setIcon(new ImageIcon(estados[i][j] ? "C:\\\\Users\\\\alexi\\\\Desktop\\\\Proyecto\\\\Luz_amarilla38px.png" : "C:\\\\Users\\\\alexi\\\\Desktop\\\\Proyecto\\\\Luzroja38px.png"));
            }
        }

        lblIntentos.setText("Intentos : " + model.getContIntentos());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Model model = new Model();
                View view = new View();
                new Controller(model, view);
                view.getFrame().setVisible(true);
            }
        });
    }
}
