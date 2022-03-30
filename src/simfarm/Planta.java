package simfarm;

public abstract class Planta implements Administrativo {
	protected Boolean regado = false;
	protected Boolean fumigado = false;
	public abstract boolean regar();
	public abstract boolean fumigar();
	
}
