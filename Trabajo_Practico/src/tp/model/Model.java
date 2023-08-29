package tp.model;

import java.util.Random;

public class Model {
    private boolean[][] estados;
    private int contIntentos;

    public Model() {
        estados = new boolean[4][4];
        Random rand = new Random();

        for (int i = 0; i < estados.length; i++) {
            for (int j = 0; j < estados[i].length; j++) {
                estados[i][j] = rand.nextBoolean();
            }
        }

        contIntentos = 0;
    }

    public boolean[][] getEstados() {
        return estados;
    }

    public void toggleState(int row, int col) {
        contIntentos++;
        estados[row][col] = !estados[row][col];
        // Update neighboring states here
    }

    public int getContIntentos() {
        return contIntentos;
    }
}
