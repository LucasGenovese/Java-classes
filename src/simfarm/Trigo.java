package simfarm;

public class Trigo extends Planta {
	private int precio;
	private boolean vendido = false;

	public Trigo() {
		super();
		System.out.println("Se creo trigo");
	}
	
	public int ponerPrecio() {
		this.precio = 80;
		return precio;
	}

	public boolean regar() {
		if (regado == false) {
			return regado = true;
		} else {
			return regado = false;
		}
	}

	public boolean fumigar() {
		if (fumigado == false) {
			return fumigado = true;
		} else {
			return fumigado = false;
		}
	}
	
	public boolean getRegado() {
		return regado;
	}
	
	public boolean getFumigado() {
		return fumigado;
	}
	
	
	
}
