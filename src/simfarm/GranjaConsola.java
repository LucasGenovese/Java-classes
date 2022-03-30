package simfarm;

import java.util.Scanner;

// interaccion de usuario con granja
public class GranjaConsola {
	
	public void iniciarJuegoConsola(Scanner teclado) {
		int elecAnimal, elecAccionAnimal, elecPlanta, elecAccionPlanta, continuar = 1;
		Granja granja = new Granja();
		
		System.out.println("Agregar hasta un maximo de 6 animales y plantas");
		System.out.println("1: Agregar animales, 2: Agregar plantas");
		int eleccion = teclado.nextInt();
		
		while (eleccion != -1 && granja.getCantidadGranja() < 6) {
			if (eleccion == 1) {
				System.out.println("1: Vaca, 2: Cerdo, 3: Gallina");
				int numAnimal = teclado.nextInt();
				granja.seleccionAnimal(numAnimal);				
			}
			
			if (eleccion == 2) {
				System.out.println("1: Soja, 2, Trigo");
				int numPlanta = teclado.nextInt();
				granja.seleccionPlanta(numPlanta);
			}
			
			if (granja.getCantidadGranja() < 6) {
				System.out.println("1: Agregar animales, 2: Agregar plantas (-1 para salir)");
				eleccion = teclado.nextInt();
			}
			
		}
			
		while (continuar == 1) {
			System.out.println("Introducir accion a realizar 1: Animales, 2: Plantas");
			eleccion = teclado.nextInt();
			while (eleccion != -1) {
				
				if (eleccion == 1) {
					System.out.println("1: Acciones vaca, 2: Acciones cerdo, 3: Acciones gallina");
					elecAnimal = teclado.nextInt();
					if (elecAnimal == 1) {
						System.out.println("1: Vender vaca, 2: Alimentar vaca, 3: Dormir vaca, 4: Caminar vaca, 5: Ordeniar vaca");
						elecAccionAnimal = teclado.nextInt();
						granja.accionesVaca(elecAccionAnimal);
					}
				
					if (elecAnimal == 2) {
						System.out.println("1: Vender cerdo, 2: Alimentar cerdo, 3: Dormir cerdo, 4: Caminar cerdo, 5: Limpiar cerdo");
						elecAccionAnimal = teclado.nextInt();
						granja.accionesCerdo(elecAccionAnimal);
					}
				
					if (elecAnimal == 3) {
						System.out.println("1: Vender gallina, 2: Alimentar gallina, 3: Dormir gallina, 4: Caminar gallina, 5: Deplumar gallina");
						elecAccionAnimal = teclado.nextInt();
						granja.accionesGallina(elecAccionAnimal);
					}
				}
				
				if (eleccion == 2) {
					System.out.println("1: Acciones soja, 2: Acciones trigo");
					elecPlanta= teclado.nextInt();
					if (elecPlanta == 1) {
						System.out.println("1: Vender soja, 2: Regar soja, 3: Fumigar soja");
						elecAccionPlanta = teclado.nextInt();
						granja.accionesSoja(elecAccionPlanta);
					}
					if (elecPlanta == 2) {
						System.out.println("1: Vender trigo, 2: Regar trigo, 3: Fumigar trigo");
						elecAccionPlanta = teclado.nextInt();
						granja.accionesTrigo(elecAccionPlanta);
					}
				}
				
				System.out.println("Introducir accion a realizar 1: Animales, 2: Plantas, -1: Pasar de dia");
				eleccion = teclado.nextInt();
			}
			
			// verifica cada 5 turnos que el animal este alimentado y la planta este regada y fumigada. De lo contrario lo elimina
			granja.checkeoGranja();
			granja.pasarTurno();
			System.out.println("Dia numero: "+ granja.getTurno());
			
			if (granja.cerdos.isEmpty() == false && granja.gallinas.isEmpty() == false && granja.sojas.isEmpty() == false && granja.trigos.isEmpty() == false && granja.vacas.isEmpty() == false) { // si los array de los animales no estan vacios el usuario puede continuar, sino termina el juego
				continuar = -1;
			} else {
				System.out.println("Si desea continuar digite 1, si quiere terminar digite cualquier otro numero");
				continuar = teclado.nextInt();
			}
		}
		
		System.out.println("Fin del juego");
	}
}
