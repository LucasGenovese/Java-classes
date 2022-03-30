package simfarm;

import java.util.Scanner;
import javax.swing.JFrame;

public class Test {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Si desde jugar con consola digite 1, si desea jugar con interfaz grafica digite 2: ");
		int seleccion = teclado.nextInt();

		if (seleccion == 1) {
			GranjaConsola granjaconsola = new GranjaConsola();
			granjaconsola.iniciarJuegoConsola(teclado);
		}
		
		if (seleccion == 2) {
			InterfazGrafica p = new InterfazGrafica();
			p.interaccionGranja();
			p.setResizable(false);
			p.setVisible(true);
			p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			p.setSize(450, 400);
			
		}
		
	}
}
