package simfarm;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfazGrafica extends JFrame {
	
	Granja granja = new Granja();
	GranjaConsola granjaconsola = new GranjaConsola();
	
	private JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8;
	private JTextField textField1, textField2, textField3, textField4, myOutput;
	private JLabel label1, label2, label3, label4, blank, blank2, blank3;
	
	public InterfazGrafica() {
		// botones para ingresar animales a la granja
		boton1 = new JButton("Vaca");
		boton2 = new JButton("Cerdo");
		boton3 = new JButton("Gallina");
		boton4 = new JButton("Soja");
		boton5 = new JButton("Trigo");
		
		boton6 = new JButton("Acciones Animal");
		boton6.setPreferredSize(new Dimension(350, 24));
		boton7 = new JButton("Acciones Planta");
		boton7.setPreferredSize(new Dimension(350, 24));
		
		boton8 = new JButton("Pasar dia");
		boton8.setPreferredSize(new Dimension(350, 24));
		
		label1 = new JLabel("1: Acciones vaca, 2: Acciones cerdo, 3: Acciones gallina");
		label2 = new JLabel("1: Vender, 2: Alimentar, 3: Dormir, 4: Caminar, 5: Especial*");
		label3 = new JLabel("1: Acciones soja, 2: Acciones trigo");
		label3.setPreferredSize(new Dimension(270, 24));
		label4 = new JLabel("1: Vender, 2: Regar, 3: Fumigar");
		
		blank = new JLabel("");
		blank.setPreferredSize(new Dimension (350, 24));
		blank2 = new JLabel("");
		blank2.setPreferredSize(new Dimension(350, 24));
		blank3 = new JLabel("");
		blank3.setPreferredSize(new Dimension(350, 24));
		
		textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension (80, 24));
		textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension (80, 24));
		textField3 = new JTextField();
		textField3.setPreferredSize(new Dimension (80, 24));
		textField4 = new JTextField();
		textField4.setPreferredSize(new Dimension (80, 24));
		
		myOutput = new JTextField();
		myOutput.setPreferredSize(new Dimension(350, 24));
		
		this.setLayout(new FlowLayout());
		
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(boton4);
		this.add(boton5);
		
		this.add(blank);
		
		this.add(boton6);
		this.add(textField1);
		this.add(label1);
		this.add(textField2);
		this.add(label2);
		
		this.add(blank2);
		
		this.add(boton7);
		this.add(textField3);
		this.add(label3);
		this.add(textField4);
		this.add(label4);
		
		this.add(blank3);
		
		this.add(boton8);
	
		this.add(myOutput);
		myOutput.setText("Output juego (no modificar)");
		
		
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (granja.getCantidadGranja() >= 6) {
					boton1.setEnabled(false);
				} else {
					myOutput.setText("Se creo una vaca");
					granja.seleccionAnimal(1); // si hago esto el output sale por consola
				}
				
			}
		});
		
		boton2.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e) {
				if (granja.getCantidadGranja() >= 6) {
					boton2.setEnabled(false);
				} else {
					myOutput.setText("Se creo un cerdo");
					granja.seleccionAnimal(2);
				}
			}
		});
		
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (granja.getCantidadGranja() >= 6) {
					boton3.setEnabled(false);
				} else {
					myOutput.setText("Se creo una gallina");
					granja.seleccionAnimal(3);
				}
			}
		});
		
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (granja.getCantidadGranja() >= 6) {
					boton4.setEnabled(false);
				} else {
					myOutput.setText("Se creo una soja");
					granja.seleccionPlanta(1);
				}
			}
		});
		
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (granja.getCantidadGranja() >= 6) {
					boton5.setEnabled(false);
				} else {
					myOutput.setText("Se creo un trigo");
					granja.seleccionPlanta(2);
				}
			} 
		});
		
	}
	
	public void interaccionGranja() { // hacer que el output salga por GUI
		
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eleccion = Integer.parseInt(textField1.getText());
				int elecAnimal = Integer.parseInt(textField2.getText());
				
				if (eleccion == 1) {
					myOutput.setText(granja.accionesVaca(elecAnimal));
				}
				if (eleccion == 2) {
					myOutput.setText(granja.accionesCerdo(elecAnimal));
				}
				if (eleccion == 3) {
					myOutput.setText(granja.accionesGallina(elecAnimal));
				}
			}
		});
		
		
		boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eleccion = Integer.parseInt(textField3.getText());
				int elecPlanta = Integer.parseInt(textField4.getText());
				
				if (eleccion == 1) {
					myOutput.setText(granja.accionesSoja(elecPlanta));
				}
				if (eleccion == 2) {
					myOutput.setText(granja.accionesTrigo(elecPlanta));
				}
			}
		});
		
		boton8.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				granja.pasarTurno();
				granja.checkeoGranja();
				
			if (granja.cerdos.isEmpty() == true && granja.gallinas.isEmpty() == true && granja.sojas.isEmpty() == true && granja.trigos.isEmpty() == true && granja.vacas.isEmpty() == true) {
				dispose();
			}
				
			}
		});
		
		
	}
	
}
