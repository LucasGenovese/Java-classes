package simfarm;

public class Cerdo extends Animal {
	private int precio;
	private boolean vendido = false, limpio = false;
	
	public Cerdo () {
		super();
		System.out.println("Se crea un cerdo");
	}
	
	public boolean limpiar() {
		System.out.println("Se limpio el cerdo");
		return limpio = true;
	}
	
	public int ponerPrecio() {
		return precio = 50;
	}

	public boolean alimentar() {
		if (alimentado == false) {
			return alimentado = true;
		} else {
			return alimentado =false;
		}
	}

	public boolean dormir() {
		if (durmiendo == false) {
			return durmiendo = true;
		} else {
			return durmiendo = false;
		}
	}

	public boolean caminar() {
		return caminando = true;
	}
	
	public boolean getAlimentado() {
		return alimentado;
	}
	
	public boolean getDormido() {
		return durmiendo;
	}

}
