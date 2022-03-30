package simfarm;

public abstract class Animal implements Administrativo{
	protected Boolean alimentado = false, caminando = false, durmiendo = false;
	protected int precio;
	
	public abstract boolean alimentar();
	public abstract boolean dormir();
	public abstract boolean caminar();
}
