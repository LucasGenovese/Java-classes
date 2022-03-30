package simfarm;

public class Gallina extends Animal{
	private int precio;
	private boolean vendido = false, desplumado = false;
	
	public Gallina() {
		super();
		System.out.println("Se creo una gallina");
	}
	
	public boolean desplumar() {
		return desplumado = true;
	}
	
	public int ponerPrecio() {
		return precio = 25;
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
