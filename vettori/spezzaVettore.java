package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class spezzaVettore extends Application{
	int vettore[];
	int vettore1[];
	int vettore2[];
	TextField tNumero = new TextField();
	
Label lRis = new Label();

	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Button pCalcola = new Button("calcola");
		Label lnum = new Label("vettore (solo numeri separati da ',' No spazi in mezzo");
		
		griglia.add(lnum, 1, 0);
		griglia.add(tNumero, 0, 0);
		griglia.add(pCalcola, 0, 2);
		griglia.add(lRis, 0, 3);
		

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
		int i1=0, i2=0;
		Boolean posV = true;
	
		int contatore = 0;
		String s[];
		s = tNumero.getText().split(",");
		vettore = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			vettore[i] = Integer.parseInt(s[i]);
		}
		vettore1[0]=vettore[0];
	
		for (int i=1;i< vettore.length;i++) {
			if(vettore[i]>vettore[i-1]) {
				if(posV == true) {
					i1++;
					vettore1[i1]=vettore[i];
				}else {
					i2++;
					vettore2[i2]= vettore[i];
				}
			}else {
				if(posV == true) {
					i2++;
					vettore2[i2]=vettore[i];
					posV=false;
				}
				
			}
	}
	lRis.setText("il vettore 1 è" + vettore1 + "il vettore 2 è" + vettore2);	
	
	}
	public static void main(String[] args) {
		launch(args);
	}
}
