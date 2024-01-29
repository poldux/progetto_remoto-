package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sommaConVettori extends Application {

	Button bCalcola = new Button("calcola");
	Button bAlloca = new Button("alloca");
	TextField tNumero = new TextField("qunati numeri:");
	TextField tMax = new TextField("numeri:");
	Label lRisultato = new Label("risultato");
	Label lStampa = new Label("elenco");
	ComboBox<String> combOperazioni = new ComboBox<>();
	int y;
	int vettore[];

	public void start(Stage finestra) {

		combOperazioni.getItems().add("*");
		combOperazioni.getItems().add("+");
		combOperazioni.getItems().add("-");

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(tNumero, 0, 0);
		griglia.add(tMax, 1, 0);
		griglia.add(combOperazioni, 0, 1);
		griglia.add(bAlloca, 0, 2);
		griglia.add(bCalcola, 0, 3);
		griglia.add(lStampa, 0, 4);
		griglia.add(lRisultato, 0, 5);

		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10));

		finestra.setScene(scena);
		finestra.setTitle("somma con vettori");
		finestra.show();

		bCalcola.setOnAction(e -> calcola());
		bAlloca.setOnAction(e -> alloca());

	}

	public void alloca() {
		int dimensione, max;
		dimensione = Integer.parseInt(tNumero.getText());
		max = Integer.parseInt(tMax.getText());
		vettore = new int[dimensione];
		for (int i = 0; i < vettore.length; i++) {
			vettore[i] = (int) (Math.random() * max);
		}

	}

	public void calcola() {

		String x = "";
		String primo = combOperazioni.getValue();
		x = primo;
		int somma = 0;
		int sottrazione =0;
		int moltiplicazione =1;
		String elenco = "";
		
		switch (x) {
		case "+":
			
			for (int i = 0; i < vettore.length; i++) {
				somma = somma + vettore[i];
				elenco = elenco + vettore[i] + "-";
				
			}
			lRisultato.setText("somma:" + somma);
			break;

		case "-":
			for (int i = 0; i < vettore.length; i++) {
				sottrazione = sottrazione - vettore[i];
				elenco = elenco + vettore[i] + "-";
				}
			lRisultato.setText("sottrazione:" + sottrazione);
			break;
			
		case "*":
			for (int i = 0; i < vettore.length; i++) {
				moltiplicazione = moltiplicazione * vettore[i];
				elenco = elenco + vettore[i] + "-";
				}
			lRisultato.setText("moltiplicazione:" + moltiplicazione);
			break;
			
		}
		
		lStampa.setText(elenco);
	

}

	public static void main(String[] args) {
		launch(args);
	}
	}
