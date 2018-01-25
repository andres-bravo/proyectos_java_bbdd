package beans;

public class Ciudad {
	private String nombreciudad;
	private Double temperatura;
	public String getNombreciudad() {
		return nombreciudad;
	}
	public void setNombreciudad(String nombreciudad) {
		this.nombreciudad = nombreciudad;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	public Ciudad(String nombreciudad, Double temperatura) {
		super();
		this.nombreciudad = nombreciudad;
		this.temperatura = temperatura;
	}
	
}
