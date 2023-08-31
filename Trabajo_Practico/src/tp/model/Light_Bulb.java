package tp.model;

public class Light_Bulb {
	private String luzRoja = "C:\\\\Users\\\\alexi\\\\Desktop\\\\Proyecto\\\\Luzroja38px.png";
	private String luzAmarilla = "C:\\\\Users\\\\alexi\\\\Desktop\\\\Proyecto\\\\Luz_amarilla38px.png";
	private Boolean stateLight;
	
	
	public Light_Bulb(Boolean swich_On_Or_Off) {
		this.stateLight = swich_On_Or_Off;
	}
	public Boolean getSwich_On_Or_Off() {
		return stateLight;
	}
	public void setSwich_On_Or_Off(Boolean swich_On_Or_Off) {
		this.stateLight = swich_On_Or_Off;
	}
	
	 public void toggleState() {
		 stateLight = !stateLight;
	}
	public String getLuzRoja() {
		return luzRoja;
	}
	public String getLuzAmarilla() {
		return luzAmarilla;
	}
	public String lightOnOff() {
		return stateLight ? luzAmarilla : luzRoja;
	}

}
