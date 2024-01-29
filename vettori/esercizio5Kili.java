package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class esercizio5Kili extends Application{
	Button bCalcola = new Button("calcola");
	Button bAlloca = new Button("alloca");
	TextField tNumero = new TextField("qunati numeri:");
	TextField tMax = new TextField("numero max:");
	Label lRisultato = new Label("risultato");
	Label lStampa = new Label("elenco");
	int y;
	int vettore[];
	int somma =0;
	String elenco;
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(tNumero, 0, 0);
		griglia.add(tMax, 1, 0);
		griglia.add(bAlloca, 0, 1);
		griglia.add(bCalcola, 0, 2);
		griglia.add(lStampa, 0, 3);
		griglia.add(lRisultato, 0, 4);

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
		for(int i=0; i<vettore.length; i++) {
			if(vettore[i]%3==0 && vettore[i]%2==0) {
				somma = somma +vettore[i];
			}
			elenco = elenco+vettore[i] + "-";
		}
		lRisultato.setText(somma+"");
		lStampa.setText(elenco+"");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

