package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class numeriOrdineCrescente extends Application {
	int vettore[];
	TextField tNumero = new TextField();
	
Label lRis = new Label();
Label lScritta = new Label("qualora il programma dia come risposta 'true' il vettore è crescente ");	
Label lScritta2 = new Label("seil vettore da come risposta 'false' il vettore non è crescente");
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Button pCalcola = new Button("calcola");
		Label lnum = new Label("vettore (solo numeri separati da ',' No spazi in mezzo");
		
		griglia.add(lnum, 1, 0);
		griglia.add(tNumero, 0, 0);
		griglia.add(pCalcola, 0, 2);
		griglia.add(lScritta, 0, 3);
		griglia.add(lScritta2, 0, 4);
		griglia.add(lRis, 0, 5);

		griglia.setPadding(new Insets(20));
		griglia.setHgap(20);
		griglia.setVgap(20);
		pCalcola.setOnAction(e -> calcola());

		Scene scena = new Scene(griglia, 500,300);
		finestra.setTitle("numeri in ordine crescente e non ");
		finestra.setScene(scena);
		finestra.show();
	}

	public void calcola() {
		Boolean crescente = true;
		int contatore = 0;
		String s[];
		s = tNumero.getText().split(",");
		vettore = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			vettore[i] = Integer.parseInt(s[i]);
		}
		
		for(int i=0; crescente && i<vettore.length-1; i++) {
			if (vettore[i]>=vettore[i+1]) {
				crescente = false; 
			}
		}
		lRis.setText(" " +crescente);	
	}
	public static void main(String[] args) {
		launch(args);
	}
}


