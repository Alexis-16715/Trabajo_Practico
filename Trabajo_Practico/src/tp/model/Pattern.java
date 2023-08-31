package tp.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Pattern {
	private Light_Bulb[][] pattern;
	private Map<Integer, Light_Bulb> allTheLightsHere = new HashMap <Integer, Light_Bulb>();
    private int numberAttempts;
	public Pattern() {
		pattern = new Light_Bulb[4][4];
        Random rand = new Random();

        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length; j++) {
            	pattern[i][j] = new Light_Bulb(rand.nextBoolean());
            }
        }
        numberAttempts = 0;
    }

    public Light_Bulb[][] getStateGame() {
        return pattern;
    }

    public void toggleState(int row, int col) {
    	numberAttempts++;
    	
    	for(int i = 0; i < pattern.length; i++) {
    		pattern[i][col].toggleState();
    	}
    	
    	for(int j = 0; j < pattern.length; j++) {
    		pattern[row][j].toggleState();
    	}
    	
    	pattern[row][col].toggleState();
        // Update neighboring states here
    }

    public int getContIntentos() {
        return numberAttempts;
    }

}
