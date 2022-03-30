package simfarm;

public class Vaca extends Animal {
	private int precio;
	private boolean vendido = false, ordeniada = false;
	
	public Vaca () {
		super();
		System.out.println("Se creo una vaca");
	}
	
	public boolean ordeniar() {
		return ordeniada = true;
	}
	
	public int ponerPrecio() {
		this.precio = 100;
		return precio;
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
