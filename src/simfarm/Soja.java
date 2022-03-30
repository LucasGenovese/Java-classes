package simfarm;

public class Soja extends Planta {
	private int precio;
	private boolean vendido = false;
	
	public Soja() {
		super();
		System.out.println("Se creo soja");
	}

	public int ponerPrecio() {
		this.precio = 150;
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
