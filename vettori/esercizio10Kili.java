package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class esercizio10Kili extends Application {

	Label lNum = new Label("i numeri sono divisi dalla ,");
	Label lStampa = new Label("stampa");
	Label lRis = new Label("risultato");

	TextField tNumeri = new TextField();

	Button bCalcola = new Button("calcola");

	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(lNum, 0, 1);
		griglia.add(tNumeri, 0, 2);
		griglia.add(bCalcola, 0, 3);
		griglia.add(lStampa, 0, 4);
		griglia.add(lRis, 0, 5);

		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10));

		finestra.setScene(scena);
		finestra.setTitle("somma con vettori");
		finestra.show();

		bCalcola.setOnAction(e -> calcola());
	}

	public void calcola() {

		int massimo = 0;
		int posizione = 0;

		String elenco = tNumeri.getText();
		String numeri[] = elenco.split(",");
		int numeriN[] = new int[numeri.length];

		for (int i = 0; i < numeri.length; i++) {
			numeriN[i] = Integer.parseInt(numeri[i]);
		}
		for (int i = 0; i < numeriN.length; i++) {
			if (numeriN[i] > massimo) {
				massimo = numeriN[i];
				posizione = i;
			}
		}
		lStampa.setText(""+elenco);
		lRis.setText(" il massimo è "+massimo+" la posizione è "+posizione);
	}
	

	

	public static void main(String[] args) {
		launch(args);
	}
}