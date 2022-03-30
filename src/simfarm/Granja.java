package simfarm;

import java.util.ArrayList;
import java.util.HashMap;

// administra animales, plantas, se encarga de vender y demas
public class Granja {
	private int eleccionAnimal, eleccionPlanta;
	private int cantidadGranja = 0, dinero = 200, turno = 1;
	
	ArrayList<Vaca> vacas = new ArrayList<>();
	ArrayList<Cerdo> cerdos = new ArrayList<>();
	ArrayList<Gallina> gallinas = new ArrayList<>();
	
	ArrayList<Soja> sojas = new ArrayList<>();
	ArrayList<Trigo> trigos = new ArrayList<>();
	
	public int pasarTurno() {
		return turno +=1;
	}

	public String seleccionAnimal(int eleccionAnimal) { //cambiando la funcion a String puedo devolver como string e imprimirlo en la GUI
		String animalSeleccionado = new String();
		if (eleccionAnimal == 1) {
			Vaca v = new Vaca();	
			vacas.add(v);
			cantidadGranja += 1;
			animalSeleccionado = "Se agrego una vaca"; // el texto "Se creo una vaca sale del constructor de vaca y lo mismo para cada animal y planta"
		}
		if (eleccionAnimal == 2) {
			Cerdo c = new Cerdo();
			cerdos.add(c);
			cantidadGranja += 1;
			animalSeleccionado = "Se agrego un cerdo";
		}
		if (eleccionAnimal == 3) {
			Gallina g = new Gallina();
			gallinas.add(g);
			cantidadGranja += 1;
			animalSeleccionado = "Se agrego una gallina";
		} 
		return animalSeleccionado;
	}

	public String accionesVaca(int eleccionAccionAnimal) {
		int precioVaca = vacas.get(0).ponerPrecio();
		String vacaAccion = new String();
		if (vacas.isEmpty() == false) {
			if (eleccionAccionAnimal == 1 && dinero >= precioVaca) {
				dinero += precioVaca;
				vacas.remove(0);
				cantidadGranja -=1;
				System.out.println("Se vendio una vaca");
				System.out.println("Balance: "+ dinero);
				vacaAccion = "Se vendio una vaca";
			}
			if (eleccionAccionAnimal == 2 && dinero >= precioVaca/4) {
				for (Vaca vaca : vacas) {
					vaca.alimentar();
					dinero -= precioVaca/4; // el alimento de vaca sale un cuarto de lo que sale comprar la vaca
					System.out.println("Se alimento una vaca");
					vacaAccion = "Se alimentaron las vacas";
				}
			}
			if (eleccionAccionAnimal == 3) {
				for (Vaca vaca : vacas) {
					vaca.dormir();
					System.out.println("Se durmio una vaca");
					vacaAccion = "Se durmieron las vacas";
				}
			}
			if (eleccionAccionAnimal == 4) {
				for (Vaca vaca : vacas) {
					vaca.caminar();
					System.out.println("Camina una vaca");
					vacaAccion = "Caminaron las vacas";
				}
			}
			if (eleccionAccionAnimal == 5 && turno % 3 != 0) { // se puede llamar a esta funcion todos los turnos salvo aquello multiplo de 3
				for (Vaca vaca : vacas) {
					vaca.ordeniar();
					dinero += 50;
					System.out.println("Se ordenio una vaca");
					vacaAccion = "Se ordeniaron una vaca";
				}
			}
			
		}
		return vacaAccion;
	}
	
	public String accionesCerdo(int eleccionAccionAnimal) {
		String cerdoAccion = new String();
		int precioCerdo = cerdos.get(0).ponerPrecio();
		if (cerdos.isEmpty() == false) {
			if (eleccionAccionAnimal == 1 && dinero >= precioCerdo) {
				dinero += precioCerdo;
				cerdos.remove(0);
				cantidadGranja -=1;
				System.out.println("Se vendio un cerdo");
				System.out.println("Balance: "+ dinero);
				cerdoAccion = "Se vendio un cerdo";
			}
			if (eleccionAccionAnimal == 2 && dinero >= precioCerdo/4) {
				for (Cerdo cerdo : cerdos) {
					cerdo.alimentar();
					dinero -= precioCerdo/4;
					System.out.println("Se alimento un cerdo");
					cerdoAccion = "Se alimentaron a los cerdos";
				}
			}
			if (eleccionAccionAnimal == 3) {
				for (Cerdo cerdo : cerdos) {
					cerdo.dormir();
					System.out.println("Se durmio un cerdo");
					cerdoAccion = "Se durmieron los cerdos";
				}
			}
			if (eleccionAccionAnimal == 4) {
				for (Cerdo cerdo : cerdos) {
					cerdo.caminar();
					System.out.println("Camina un cerdo");
					cerdoAccion = "Se durmieron los cerdos";
				}
			}
			if (eleccionAccionAnimal == 5) {
				for (Cerdo cerdo : cerdos) {
					cerdo.limpiar();
					System.out.println("Se limpio un cerdo");
					cerdoAccion = "Se limpiaron los cerdos";
				}
			}
		}
		return cerdoAccion;
	}
	
	public String accionesGallina(int eleccionAccionAnimal) {
		int precioGallina = gallinas.get(0).ponerPrecio();
		String gallinaAccion = new String();
		if (gallinas.isEmpty() == false) {
			if (eleccionAccionAnimal == 1 && dinero >= precioGallina) {
				dinero += precioGallina;
				gallinas.remove(0);
				cantidadGranja -=1;
				System.out.println("Se vendio una gallina");
				System.out.println("Balance: "+ dinero);
				gallinaAccion = "Se vendio una gallina";
			}
			if (eleccionAccionAnimal == 2 && dinero >= precioGallina/4) {
				for (Gallina gallina : gallinas ) {
					gallina.alimentar();
					dinero -= precioGallina/4;
					System.out.println("Se alimento una gallina");
					gallinaAccion = "Se alimentaron gallinas";
				}
			}
			if (eleccionAccionAnimal == 3) {
				for (Gallina gallina : gallinas) {
					gallina.dormir();
					System.out.println("Se durmio una gallina");
					gallinaAccion = "Se durmieron las gallinas";
				}
			}
			if (eleccionAccionAnimal == 4) {
				for (Gallina gallina : gallinas) {
					gallina.caminar();
					System.out.println("Camina una gallina");
					gallinaAccion = "Caminaron las gallinas";
				}
			}
			if (eleccionAccionAnimal == 5 && turno % 2 == 0) { // se puede llamar a esta funcion solo cada dos turnos
				for (Gallina gallina : gallinas) {
					gallina.desplumar();
					dinero += 25;
					System.out.println("Se desplumo una gallina");
					gallinaAccion = "Se desplumaron las gallinas";
				}
			}
		}
		return gallinaAccion;
	}
	
	public void seleccionPlanta(int eleccionPlanta) {
		if (eleccionPlanta == 1) {
			Soja s = new Soja();
			sojas.add(s);
			cantidadGranja +=1;
		}
		if (eleccionPlanta == 2) {
			Trigo t = new Trigo();
			trigos.add(t);
			cantidadGranja +=1;
		}
	}
	
	public String accionesSoja(int eleccionAccionPlanta) {
		int precioSoja = sojas.get(0).ponerPrecio();
		String sojaAccion = new String();
		if (sojas.isEmpty() == false && dinero >= precioSoja) {
			if (eleccionAccionPlanta == 1) {
				dinero += precioSoja;
				sojas.remove(0);
				cantidadGranja -=1;
				System.out.println("Se vendio soja");
				System.out.println("Balance: "+ dinero);
				sojaAccion = "Se vendio soja";
			}
			if (eleccionAccionPlanta == 2 && dinero >= precioSoja/4) {
				for (Soja soja: sojas) {
					soja.regar();
					dinero -= precioSoja/4;
					System.out.println("Se rego soja");
					sojaAccion = "Se regaron las sojas";
				}
			}
			if (eleccionAccionPlanta == 3 && dinero >= precioSoja/4) {
				for (Soja soja : sojas) {
					soja.fumigar();
					dinero -= precioSoja/4;
					System.out.println("Se fumigo soja");
					sojaAccion = "Se fumigaron las sojas";
				}
			}
		}
		return sojaAccion;
	}
	
	public String accionesTrigo(int eleccionAccionPlanta) {
		int precioTrigo = trigos.get(0).ponerPrecio();
		String trigoAccion = new String();
		if (trigos.isEmpty() == false) {
			if (eleccionAccionPlanta == 1 && dinero >= precioTrigo) {
				dinero += precioTrigo;
				trigos.remove(0);
				cantidadGranja -=1;
				System.out.println("Se vendio trigo");
				System.out.println("Balance: "+ dinero);
				trigoAccion = "Se vendio trigo";
			}
			if (eleccionAccionPlanta == 2 && dinero >= precioTrigo/4) {
				for (Trigo trigo : trigos) {
					trigo.regar();
					dinero -= precioTrigo/4;
					System.out.println("Se rego trigo");
					trigoAccion = "Se regaron los trigos";
				}
			}
			if (eleccionAccionPlanta == 3 && dinero >= precioTrigo/4) {
				for (Trigo trigo : trigos) {
					trigo.fumigar();
					dinero -= precioTrigo/4;
					System.out.println("Se fumigo trigo");
					trigoAccion = "Se fumigaron los trigos";
				}
			}
		}
		return trigoAccion;
	}
	
	public void estadoAnimalComida() {
		if (vacas.isEmpty() == false && vacas.get(0).getAlimentado() == false) {
			System.out.println("Se eliminan las vacas por no estar alimentadas");
			vacas.clear();
		} else {
			for (Vaca vaca : vacas) {
				System.out.println("La vaca vuelve a tener hambre");
				vaca.alimentar();
			}
		}
		if (cerdos.isEmpty() == false && cerdos.get(0).getAlimentado() == false) {
			System.out.println("Se eliminan los cerdos por no estar alimentados");
			cerdos.clear();
		} else {
			for (Cerdo cerdo : cerdos) {
				System.out.println("El cerdo vuelve a tener hambre");
				cerdo.alimentar();
			}
		}
		if (gallinas.isEmpty() == false && gallinas.get(0).getAlimentado() == false) {
			System.out.println("Se eliminan las gallinas por no estar alimentadas");
			gallinas.clear();
		} else {
			for (Gallina gallina : gallinas) {
				System.out.println("La gallina vuelve a tener hambre");
				gallina.alimentar();
			}
		}
	}
	
	public void estadoAnimalSuenio() {
		if (vacas.isEmpty() == false && vacas.get(0).getDormido() == false) {
			System.out.println("Se eliminan las vacas por no haber dormido");
			vacas.clear();
		} else {
			for (Vaca vaca : vacas) {
				System.out.println("La vaca vuelve a tener suenio");
				vaca.alimentar();
			}
		}
		if (cerdos.isEmpty() == false && cerdos.get(0).getDormido() == false) {
			System.out.println("Se eliminan los cerdos por no haber dormido");
			cerdos.clear();
		} else {
			for (Cerdo cerdo : cerdos) {
				System.out.println("El cerdo vuelve a tener suenio");
				cerdo.alimentar();
			}
		}
		if (gallinas.isEmpty() == false && gallinas.get(0).getDormido() == false) {
			System.out.println("Se eliminan las gallinas por no haber dormido ");
			gallinas.clear();
		} else {
			for (Gallina gallina : gallinas) {
				System.out.println("Las gallinas vuelven a tener suenio");
				gallina.alimentar();
			}
		}
	}
	
	public void estadoPlanta() {
		if (sojas.isEmpty() == false && sojas.get(0).getRegado()== false && sojas.get(0).getFumigado() == false) {
			System.out.println("Se eliminan las sojas por no estar ni regadas ni fumigadas");
			sojas.clear();
		} else {
			for (Soja soja : sojas) {
				System.out.println("Hay que volver a regar y fumigar soja");
				soja.regar();
				soja.fumigar();
			}
		}
		
		if (trigos.isEmpty() == false && trigos.get(0).getRegado() == false && trigos.get(0).getFumigado() == false) {
			System.out.println("Se eliminan los trigos por no estar ni regados ni fumigados");
			trigos.clear();
		} else {
			for (Trigo trigo : trigos) {
				System.out.println("Hay que volver a regar y fumigar trigo");
				trigo.regar();
				trigo.fumigar();
			}
		}
	}
	
	public void checkeoGranja() {
		if (getTurno() % 5 == 0){
	 		estadoAnimalComida();
	 		estadoPlanta();
		}
		if (getTurno() % 2 == 0) {
			estadoAnimalSuenio();
		}
	}
	
	public int getCantidadGranja() {
		return cantidadGranja;
	}

	public int getTurno() {
		return turno;
	}

}
